package com.yz.zhxy.serviceImpl;

import com.alibaba.fastjson.JSONObject;
import com.yz.zhxy.controller.admin.LoginController;
import com.yz.zhxy.entity.User;
import com.yz.zhxy.entity.UserLoginLog;
import com.yz.zhxy.mapper.UserLoginLogMapper;
import com.yz.zhxy.mapper.UserMapper;
import com.yz.zhxy.service.LoginService;
import com.yz.zhxy.utils.CookieUtil;
import com.yz.zhxy.utils.RedisUtil;
import com.yz.zhxy.utils.StringUtils;
import com.yz.zhxy.utils.VoResult;
import nl.bitwalker.useragentutils.Browser;
import nl.bitwalker.useragentutils.OperatingSystem;
import nl.bitwalker.useragentutils.UserAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author 曹健
 * @date 2020/10/14 10:08
 * @Description
 */
@Service
public class LoginServiceImpl implements LoginService {

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(LoginServiceImpl.class);


    @Autowired
    UserMapper userMapper;
    @Autowired
    UserLoginLogMapper userLoginLogMapper;
    @Autowired
    RedisUtil redisUtil;

    private Map<String,String> UserLogin = new HashMap<>();

    /**
     *  用户后台登陆
     * */
    @Override
    public VoResult login(String userName, String password,Integer userType, HttpServletRequest request, HttpServletResponse response) {
        if (StringUtils.isBlank(userName)){
            return VoResult.errorParam("用户名不能为空");
        }
        if (StringUtils.isBlank(password)){
            return VoResult.errorParam("密码不能为空");
        }
        if (userType != 10){
            return VoResult.errorParam("学生家长不能登录后台管理系统");
        }
        User user = userMapper.selectByUserName(userName, userType);
        if (user == null){
            return VoResult.errorParam("用户名或密码错误");
        }
        String salt = user.getSalt();
        String md5Password = DigestUtils.md5DigestAsHex((password + salt).getBytes());
        if (!user.getPassword().equals(md5Password)){
            return VoResult.errorParam("用户名或密码错误");
        }
        String accessToken = UUID.randomUUID().toString().replace("-", "");
        //从map中获得redis中的key
        String oldToken = UserLogin.get(user.getId());
        //判断map中是否存在该id
        if(!StringUtils.isEmpty(oldToken)){
            //删除redis中老的值
            redisUtil.del(oldToken);
        }
        //将新的的key保存到map中
        UserLogin.put(user.getId(),accessToken);
        redisUtil.set(accessToken,user);
        redisUtil.expire(accessToken,24*60*60);
        String userInfo = JSONObject.toJSONString(user);
        CookieUtil.setCookie(response,"accessToken" ,accessToken, 24*60*60);

        //获取浏览器信息
        String ua = request.getHeader("User-Agent");
        //转成UserAgent对象
        UserAgent userAgent = UserAgent.parseUserAgentString(ua);
        //获取浏览器信息
        Browser browser = userAgent.getBrowser();
        //获取系统信息
        OperatingSystem os = userAgent.getOperatingSystem();
        //系统名称
        String system = os.getName();
        //浏览器名称
        String browserName = browser.getName();
        UserLoginLog userLoginLog = new UserLoginLog();
        userLoginLog.setId(UUID.randomUUID().toString().replace("-", ""));
        userLoginLog.setUserId(user.getId());
        userLoginLog.setAccessToken(accessToken);
        userLoginLog.setBrowser(browserName);
        userLoginLog.setBrowsername(browserName);
        userLoginLog.setCreateTs(new Date());
        userLoginLog.setIp(getIpAddr(request));
        userLoginLog.setSystemName(system);
        userLoginLogMapper.insert(userLoginLog);
        return VoResult.success().add("data",user).add("accessToken",accessToken);
    }


    public static String getIpAddr(HttpServletRequest request) {
        String ipAddress = null;
        try {
            ipAddress = request.getHeader("x-forwarded-for");
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("Proxy-Client-IP");
            }
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("WL-Proxy-Client-IP");
            }
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getRemoteAddr();
                if (ipAddress.equals("127.0.0.1")) {
                    // 根据网卡取本机配置的IP
                    try {
                        ipAddress = InetAddress.getLocalHost().getHostAddress();
                    } catch (UnknownHostException e) {
                        e.printStackTrace();
                    }
                }
            }
            // 通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
            if (ipAddress != null) {
                if (ipAddress.contains(",")) {
                    return ipAddress.split(",")[0];
                } else {
                    return ipAddress;
                }
            } else {
                return "";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

}
