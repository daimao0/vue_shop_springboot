package com.damao.vueshop.common.api;


/**
 * @author tujietg
 * @date 3/31/20 7:11 PM
 */
public enum ResultCode implements IErrorCode {

    /**
     * 成功
     */
    SUCCESS(200, ""),
    /**
     * 操作失败
     */
    FAILED(500, "操作失败"),
    /**
     * 参数检验失败
     */
    VALIDATE_FAILED(400, "参数检验失败"),

    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    
    FORBIDDEN(403, "没有相关权限");

    private long code;

    private String message;

    ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public long getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
