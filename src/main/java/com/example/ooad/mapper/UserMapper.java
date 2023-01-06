package com.example.ooad.mapper;

import com.example.ooad.enity.Hotel;
import com.example.ooad.enity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from \"User\"")
    public List<User> find();

    @Insert("INSERT INTO \"User\" (username, password, name, gender, phone, email, address) VALUES ( #{username}, #{password}, #{name}, #{gender}, #{phone}, #{email}, #{address})")
    public int insert(User user);

    @Select("select * from \"User\" where username = #{username} and password = #{password}")
    public List<User> login(String username, String password);

    @Select("select * from \"User\" where username = #{username}")
    public List<User> get(String username);

    @Update("UPDATE \"User\" SET gender = #{gender}, phone = #{phone}, email = #{email}, address = #{address}, \"grant\" = #{grant},age= #{age}, remark = #{remark}, url=#{url} where username = #{username}")
    public Integer updateUser(Integer gender, String phone, String email, String address, String grant, Integer age, String remark, String url, String username);

    @Update("UPDATE \"User\" SET gender = #{gender}, phone = #{phone}, email = #{email}, address = #{address}, \"grant\" = #{grant},age= #{age}, remark = #{remark} where username = #{username}")
    public Integer updateUser1(Integer gender, String phone, String email, String address, String grant, Integer age, String remark, String username);

    @Update("UPDATE \"User\" SET password = #{password} where username = #{username}")
    public Integer updatePassword(String username, String password);

    @Update("UPDATE \"User\" SET points = #{points} where username = #{username}")
    public Integer updatePoints(String username, Integer points);

    @Update("update \"User\" SET points = points + #{points} where username = #{username}")
    public Integer updatePoints1(String username, Integer points);
}
