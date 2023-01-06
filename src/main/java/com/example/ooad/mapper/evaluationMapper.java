package com.example.ooad.mapper;
import com.example.ooad.enity.Hotel;
import com.example.ooad.enity.evaluation;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface evaluationMapper {
    @Insert("INSERT INTO evaluation (id, username, \"overallRate\", url, remark, \"enRate\", \"noRate\", \"serveRate\", \"orderId\") VALUES (DEFAULT, #{username}, #{overallRate}, #{url}, #{remark}, #{enRate}, #{noRate}, #{serveRate}, #{orderId})")
    public int insert(evaluation evaluation);

    @Select("select  a.id, a.username, \"overallRate\", url, a.remark, \"enRate\", \"noRate\", \"serveRate\", \"orderId\", h_id from (select evaluation.id, evaluation.username, \"overallRate\", url, evaluation.remark, \"enRate\", \"noRate\", \"serveRate\", \"orderId\", h_id from evaluation left join \"order\" on evaluation.\"orderId\" =\"order\".id) as a where h_id=#{h_id}")
    public List<evaluation> find(Integer h_id);
}
