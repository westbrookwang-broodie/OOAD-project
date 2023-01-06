package com.example.ooad.controller;

import com.example.ooad.enity.User;
import com.example.ooad.enity.evaluation;
import com.example.ooad.mapper.evaluationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;

@RestController
public class evaluationController {

    @Autowired
    private evaluationMapper evaluationMapper;

    @PostMapping("/fileUp")
    //@RequestParam的参数值为前端FormData对象的存储内容的key值
    //多文件上传时，用MultipartFile[]数组进行接收，单文件也可以这样接收
    public int fileup(@RequestParam("currentFile") MultipartFile[] files, HttpServletRequest req, @RequestParam("review") String[] review) {
        System.out.println("接收到的文件有"+files.length+"个");
        for(MultipartFile f:files){
            System.out.println("正在存储"+f.getOriginalFilename()+"文件");
            String path = "C:\\Users\\86177\\Desktop\\files";
            String name=f.getOriginalFilename();
            File floder=new File(path);
            if(!floder.isDirectory())
                floder.mkdirs();
            try{
                f.transferTo(new File(floder,name));
            } catch (Exception e) {
                e.printStackTrace();
            }
            evaluation evaluation = new evaluation();
            evaluation.setUsername(review[0]);
            evaluation.setOverallRate(Integer.parseInt(review[1]));
            evaluation.setEnRate(Integer.parseInt(review[2]));
            evaluation.setNoRate(Integer.parseInt(review[3]));
            evaluation.setServeRate(Integer.parseInt(review[4]));
            evaluation.setRemark(review[5]);
            evaluation.setOrderId(Integer.parseInt(review[6]));
//            evaluation.setUrl(path+name);

            evaluation.setUrl(path+ "\\" +name);
            int e = evaluationMapper.insert(evaluation);
            if(e!=0){
                System.out.println("插入成功");
            }

        }
        return 200;
    }

    @PostMapping("/fileUp1")
    public int fileup1(HttpServletRequest req, @RequestParam("review") String[] review) {
        evaluation evaluation = new evaluation();
        System.out.println(Arrays.toString(review));
        evaluation.setUsername(review[0]);
        evaluation.setOverallRate(Integer.parseInt(review[1]));
        evaluation.setEnRate(Integer.parseInt(review[2]));
        evaluation.setNoRate(Integer.parseInt(review[3]));
        evaluation.setServeRate(Integer.parseInt(review[4]));
        evaluation.setRemark(review[5]);
        evaluation.setOrderId(Integer.parseInt(review[6]));
//            evaluation.setUrl(path+name);
        int e = evaluationMapper.insert(evaluation);
        if(e!=0){
            System.out.println("插入成功");
            return 200;
        }
        return 403;
    }

    @RequestMapping("/findByHotel")
    public List<evaluation> find(Integer h_id){
        List<evaluation> evaluations=evaluationMapper.find(h_id);
        return evaluations;
    }

    @RequestMapping(value = "/getEva")
    public void GetUser(HttpServletRequest request, HttpServletResponse response, String url) throws IOException {
            String path = url;
            if (path != null) {
                File file = new File(path);
                FileInputStream inputStream = new FileInputStream(file);
                if(path.endsWith(".mp4")) {

                    byte[] data = new byte[inputStream.available()];
                    inputStream.read(data);
                    String diskfilename = "final.mp4";
                    response.setContentType("video/mp4");
                    response.setHeader("Content-Disposition", "attachment; filename=\"" + diskfilename + "\"");
                    System.out.println("data.length " + data.length);
                    response.setContentLength(data.length);
                    response.setHeader("Content-Range", "" + Integer.valueOf(data.length - 1));
                    response.setHeader("Accept-Ranges", "bytes");
                    response.setHeader("Etag", "W/\"9767057-1323779115364\"");
                    OutputStream os = response.getOutputStream();

                    os.write(data);
                    //先声明的流后关掉！
                    os.flush();
                    os.close();
                    inputStream.close();
                }

//        for(evaluation evaluation: evaluations) {
//            System.out.println(evaluation);
//            String path = evaluation.getUrl();
//            if (path!= null) {
//                System.out.println(path);
//
//                File file = new File(path);
                else {
                    FileInputStream fis;
                    fis = new FileInputStream(file);

                    long size = file.length();
                    byte[] data = new byte[(int) size];
                    fis.read(data, 0, (int) size);
                    fis.close();
                    response.setContentType("image/png");
                    OutputStream out = response.getOutputStream();
                    out.write(data);
                    out.flush();
                    out.close();
                }
            }
        }


}
