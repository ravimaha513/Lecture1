package com.info.lecture1.exception;

public class SampleException extends RuntimeException {


    public SampleException(String cannot_be_zero) {
        super(cannot_be_zero);
    }
}
