package com.example.ooad.controller;

import com.alipay.api.request.AlipayTradePagePayRequest;
//import com.example.ooad.enity.Pay;
import com.example.ooad.enity.order;
import com.example.ooad.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.alipay.api.*;
import com.alipay.*;
import com.example.ooad.mapper.OrderMapper;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class PayController {
    private final String APP_ID = "2021000121696208";
    private final String APP_PRIVATE_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCc0C2pGjY+ZQmdU0RSxEM14ev0M8z0Ve1X5Ip180Ev2VC6T64gzzWMCSL5Mqt0f9vabOpXq1z9b5rDSkBu1cw7r6Gy/xtEOBjdU5hUcw6Jf4Xv+n0ZhjKGtbP4/TfjXywEqZHsRILUJxKB6FR92Zbd7rUs/9lQxeo7Vcp+t2RDr0BnJnPXXDbNKyx5O4tilz3+t3QH+kwLqeVlq/vrkJRzMcroyeVglt32vxftUJB27+Yhe6ww+uPIPaV1KMOIbK04arUkRnOGOXqtnyaHR76Yv5v4Xnb1jBVhIRLY7RF2OHMfbqjY7SnysKmLFwj+3A3l1YIJErlcfRPYF/MDzs7DAgMBAAECggEAT1Q5ZSyveE0g2gf/rmc/IQkTlsyFyK2Xjjk9moHe3lfvsPESQ+LPUfJlUO/DMQJltFAZFRTJzCQjhNwRUICz+xXUlXrczlwaqAzcKQyzs/dhSI/NrZXoBaHyU+m11j6VRB6MhZv7G1xQzos8AxaKbeeOnB8qTuRwpGe4MvaPsHUt5ls66SA1//9uOCWmK4aTLOHLHDIcIC2WAfyrk6vUgvv9N9GMX5jNH8GzD1RKH6H9ZVdGjUT5zq3PE+C6VX0bIZe3qxWdUmiLCRRiLRV8jbGSotRlKV2eLVX2Mp6uBb+mIEh4/iG2Of6Upu0jh+icslmIxz/aHXSQjIAAvCZvoQKBgQD8FwUsC+V0NGHS5gUKTbbRpkhmljuX8NbD3qyRVYXX1UfByXEc7oK/qMoyRkJPkWSqnAxuqS1wF7eyWwqrn5zgDOrK8LJ9p75sn2qiks9X74tSR4L03tFXBBXUkHtD+P7ao23weXHggOvDpPx99nIeWUexLl8qVmc2b8Jt20lEqwKBgQCfPtcoyEYi+bom+KjXpXrdNSt1TJRXNmCeewofLMVhZ1mUV+S6Czf0ygkTK7tzsIbikwD6QZYkVIghBEhUHs4ZETl0Ke58EbzBCzK+yCLFnIJRt9hfj1V8oVzw2My6AxqGbpQBqUNhUloG45qAPtl97UWwG+G9CLiOx1H5YbquSQKBgQC1FUA03LLNn5cprOuv9BVAUict8fsK8QkFGF5z47BKUz3BeZeURcyMKo5cQNX/XByo5YGUuFgYbiEZsIZgtD43P3AlqXM+ChIi6vzpnXXt3/f/ebkbdzd/P0MDN2okcKd5nO4rUMG5mEJDfq+VOEPPgyiZoQrhWcG4e915lozyEwKBgDPrMg0K1ssablW8ZpgATMGIT0XsFMUmZnPlG5S0bRnnry4NRfZeJ/04TaMhc/kxCZkfYoc1EPWBVeylz8sVTA6iLgAwl599zPOHaiEHcUbKUza/YN0vBykeFwYzOPRAhMpljP3JqL03M0DhvgKn+xLyY/EZ9gxCpqFuXMyYz1t5AoGAAwXlKTpgguILUcRAhwtm9pf6g9qVmiUUo3ZK6H49FkrG0MDs4hbDHC7ZUXC9RUwp0V/iVyeMO4Ej892wbOgTxN4EE+mg0tYQ2NknYgP3I6skb7Otn4SHsR/x0cFD3nvhk4YfrorotNIrB7I8Ssx9gYR4asKi5XgCJ/T31cGOIYQ=";
    private final String CHARSET = "UTF-8";
    private final String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAgnzvxSIkZxYAYe/X72yjn2S7AZj5069y7PNbCTDnWdVO4kSO4RZZeDbOKK0eEWCEGZa+J2jxKch/Giikv5OZOXfuVJYyAa1enIx6Ay5GHAFI0St6hhCkm+iaBaSp8ONrwHLbPtVMW/fdquxu3vqVAU5ejWR/Bxd5WWrXzGXbaWIpE9uSgO3fdADsvDyU1X9rwGy0L3STd1oSjWIuh8wHdfHNy2WxUhADYqapNRtao5LlkeNxRXHJRecDe4FDa8rBGT3p6gnk47not5kAZe0WMq8Fbr/xnzDc7CiyU6GxXEo41TMA7crhRs/CGqL9qVPZ8MDbXXOk6A+UsPFyKe1rcQIDAQAB";
    //这是沙箱接口路径,正式路径为https://openapi.alipay.com/gateway.do
    private final String GATEWAY_URL ="https://openapi.alipaydev.com/gateway.do";
    private final String FORMAT = "JSON";
    //签名方式
    private final String SIGN_TYPE = "RSA2";
    //支付宝异步通知路径,付款完毕后会异步调用本项目的方法,必须为公网地址
    private final String NOTIFY_URL = "http://公网地址/notifyUrl";
    //支付宝同步通知路径,也就是当付款完毕后跳转本项目的页面,可以不是公网地址
    private final String RETURN_URL = "http://公网地址/returnUrl";

    @Autowired
    private OrderMapper orderMapper;

    @RequestMapping("/alipay")
    public void alipay(Integer orderId, HttpServletResponse httpResponse) throws IOException {
        AlipayClient alipayClient = new DefaultAlipayClient(GATEWAY_URL, APP_ID, APP_PRIVATE_KEY, FORMAT, CHARSET, ALIPAY_PUBLIC_KEY, SIGN_TYPE);
        System.out.println(alipayClient);
        AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();
        //在公共参数中设置回跳和通知地址
        request.setReturnUrl(RETURN_URL);
        request.setNotifyUrl(NOTIFY_URL);
        //根据订单编号,查询订单相关信息
        order order = orderMapper.findOrderId(orderId).get(0);
        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = order.getId().toString();
        //付款金额，必填
        String total_amount = order.getPrice().toString();
        //订单名称，必填
        String subject = (order.getHotelName() + order.getRoomNumber()).toString();
        //商品描述，可空
        String body = "";
        request.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"total_amount\":\""+ total_amount +"\","
                + "\"subject\":\""+ subject +"\","
                + "\"body\":\""+ body +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        String form = "";
        try {
            form = alipayClient.pageExecute(request).getBody(); // 调用SDK生成表单
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        System.out.println("{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"total_amount\":\""+ total_amount +"\","
                + "\"subject\":\""+ subject +"\","
                + "\"body\":\""+ body +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        httpResponse.setContentType("text/html;charset=" + CHARSET);
        httpResponse.getWriter().write(form);// 直接将完整的表单html输出到页面
        httpResponse.getWriter().flush();
        httpResponse.getWriter().close();
    }


}
