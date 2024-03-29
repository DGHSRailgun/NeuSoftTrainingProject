package com.neusoft.bsp.common.exception;

public class BusinessException extends RuntimeException {
    public static final BusinessException USERNAME_NOT_EXISTS = new BusinessException(504, "user doesn't exist", new Object[0]);
    public static final BusinessException PASSWORD_ERROR = new BusinessException(504, "password is wrong", new Object[0]);
    public static final BusinessException INSERT_FAIL = new BusinessException(504, "add operation failed", new Object[0]);
    public static final BusinessException UPDATE_FAIL = new BusinessException(504, "update operation failed", new Object[0]);
    public static final BusinessException DELETE_FAIL = new BusinessException(504, "delete operation failed", new Object[0]);
    public static final BusinessException INSERT_OR_UPDATE_FAIL = new BusinessException(504, "delete operation failed", new Object[0]);
    public static final BusinessException USERID_NULL_ERROR = new BusinessException(504, "userid shouln't be null", new Object[0]);
    public static final BusinessException BRDID_NULL_ERROR = new BusinessException(504, "brdid shouln't be null", new Object[0]);
    public static final BusinessException PROID_NULL_ERROR = new BusinessException(504, "brdid shouln't be null", new Object[0]);
    public static final BusinessException SAOID_NULL_ERROR = new BusinessException(504, "brdid shouln't be null", new Object[0]);
<<<<<<< HEAD
=======
    public static final BusinessException BUYERID_NULL_ERROR = new BusinessException(504, "brdid shouln't be null", new Object[0]);
    public static final BusinessException AUDIT_ERROR = new BusinessException(504, "brdid shouln't be null", new Object[0]);
>>>>>>> 147ea4175745faeaf000fa1b320bf55d7a313584
    int code;
    String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public BusinessException() {
    }

    public BusinessException(int code, String msg, Object... args) {
        super(String.format(msg, args));
        this.code = code;
        this.msg = String.format(msg, args);
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException newInstance(String msg, Object... args) {
        return new BusinessException(this.code, msg, args);
    }

}
