package com.yz.zhxy.utils.enums;

/**
 * 功能描述：返回值的枚举类型
 *
 * @version V1.0.0
 * @Author caojian
 * @Date 2020/10/14
 */
public enum ResultEnums {
    TRUE_200(200, "成功"),  
    FALSE_300(300, "失败"),
    FALSE_400(400, "内部错误"), 
    FALSE_401(401, "需要用户验证"),
    FALSE_403(403, "请求数据时发生异常"),
    FALSE_405(405, "格式不正确"),
    FALSE_408(408, "请求超时"), 
    FALSE_411(411, "删除时参数错误"), 
    FALSE_421(421, "当前账号不能登录信息员客户端"),
    FALSE_422(422, "当前账号不能登录民警客户端"),
    FALSE_423(423, "数据不存在"),
    FALSE_424(424, "数据已存在"),
    FALSE_425(425, "超出限制"),
    FALSE_426(426, "数据不完整"),
    FALSE_427(427, "不允许进行该操作"),
    FALSE_500(500, "超过规定时间"),
    FALSE_600(600, "session超时或未登录"),
    TRUE_10000(10000, "成功!"), 
    FALSE_10001(10001, "参数异常"), 
    FALSE_10002(10002, "接口服务处理异常"),
    FALSE_10003(10003, "访问权限受控");
    
    private int code;
    private String message;

    ResultEnums(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
