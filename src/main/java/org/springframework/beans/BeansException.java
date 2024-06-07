package org.springframework.beans;

/**
 * <big>异常类</big>
 * <p></p>
 *
 * @author 13684
 * @data 2024/6/7 下午4:48
 */
public class BeansException extends RuntimeException{
    public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
