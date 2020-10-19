package com.yz.zhxy.service;

import com.yz.zhxy.utils.VoResult;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 曹健
 * @date 2020/10/14 10:08
 * @Description
 */

public interface LoginService {

    VoResult login(String userName, String password,Integer userType, HttpServletRequest request, HttpServletResponse response);

}
