package com.yz.zhxy.controller.admin;

import com.yz.zhxy.service.LoginService;
import com.yz.zhxy.utils.VoResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 曹健
 * @date 2020/10/14 9:57
 * @Description
 */

@RestController
@RequestMapping("/admin/login")
@Api( "后台相关信息接口")
public class LoginController {

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(LoginController.class);

    @Autowired
    LoginService loginService;

    /**
     *  用户后台登录
     * */
    @PostMapping("/userLogin")
    @ApiOperation(value = "用户后台登录",notes = "用户后台登录")
    public VoResult login(String userName, String password,Integer userType, HttpServletRequest request, HttpServletResponse response){
        try {
            VoResult login =  loginService.login(userName, password,userType, request, response);
            return login;
        }catch (Exception e){
            log.debug("错误信息  ==》  ",e);
            System.out.println("错误信息  ==》  "+e);
            return VoResult.fail();
        }
    }

    @PostMapping("/test")
    public String login(){

            return "1";
    }
}
