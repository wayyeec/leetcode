package com.cwy.exception;

/**
 * @author: wayyee
 * @Date: 2020/8/8 15:50
 * Describe:
 */
public class MyException extends Exception {

    private static final long serialVersionUID = -5519743897907627214L;

    public MyException(String message){
        super(message);
    }
}
