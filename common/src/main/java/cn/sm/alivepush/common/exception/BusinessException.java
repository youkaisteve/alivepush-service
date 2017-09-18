package cn.sm.alivepush.common.exception;

/**
 * Created by youkai on 2017/8/21.
 */
public class BusinessException extends RuntimeException {
    public BusinessException(String messge) {
        super(messge);
    }
}
