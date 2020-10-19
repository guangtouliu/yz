package com.yz.zhxy.intercept;

import com.alibaba.fastjson.JSONObject;
import com.yz.zhxy.utils.RedisUtil;
import com.yz.zhxy.utils.StringUtils;
import com.yz.zhxy.utils.VoResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 曹健
 * @date 2020/10/14 8:20
 * @Description
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    RedisUtil redisUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        // 处理OPTIONS请求(预检请求)，具体看参阅“参考链接>>>http的协议的跨域cors 和 options请求的一些理解”
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, PATCH, DELETE, OPTIONS");
        response.setHeader("Access-Control-Max-Age", "86400");
        response.setHeader("Access-Control-Allow-Headers", "*");
        response.setHeader("Content-Type", "text/html;charset=utf-8");
        if (request.getMethod().equals("OPTIONS")) {
            response.setStatus(HttpServletResponse.SC_OK);
            return false;
        }
        // accessToken 信息校验
        String accessToken = request.getHeader("accessToken");
        if (StringUtils.isNotBlank(accessToken)) {
            // redis校验token信息
            if (null != redisUtil.get(accessToken)) {
                return true;
            } else {
                returnJson(response, "用户不存在");
            }
        } else {
            returnJson(response, "登录超时");
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {

    }

    /**
     * @Description: 拦截回执数据
     * @Author: caojian
     * @date: 2020/10/14 13:46
     */
    private void returnJson(HttpServletResponse response, String msgData) {
        PrintWriter writer = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        try {
            writer = response.getWriter();
            String res = "";
            if (msgData.equals("用户不存在")) {
                Map<String,Object> ret = new HashMap<>();
                ret.put("state","undefind");
                ret.put("data",msgData);
                res = JSONObject.toJSONString(ret);
            }
            if (msgData.equals("登录超时")) {
                Map<String,Object> ret = new HashMap<>();
                ret.put("state","over");
                ret.put("data",msgData);
                res = JSONObject.toJSONString(ret);
            }
            writer.print(res);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

}
