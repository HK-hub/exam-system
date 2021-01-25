package cn.exam.util;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * DESCRIPTION:
 * @author ys
 * @create 2018-06-27 17:10
 **/
@Component
@ControllerAdvice
public class LoginErrorException extends RuntimeException{


	private static final long serialVersionUID = 1619608851116846459L;

	private String errorCode;
    private String errorMsg;

    public LoginErrorException() {
    }

    public LoginErrorException(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

}
