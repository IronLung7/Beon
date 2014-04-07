package com.beon.data.pojo;

/**
 * Created by leo on 14-4-6.
 */
public class ErrorMessage {
    int errorcode;
    String errorMessage;

    public ErrorMessage() {
    }

    public ErrorMessage(int errorcode, String errorMessage) {
        this.errorcode = errorcode;
        this.errorMessage = errorMessage;
    }

    public int getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(int errorcode) {
        this.errorcode = errorcode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
