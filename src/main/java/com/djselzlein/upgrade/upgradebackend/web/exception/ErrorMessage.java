package com.djselzlein.upgrade.upgradebackend.web.exception;

public class ErrorMessage {

    private String constraint;

    private String message;

    public ErrorMessage(String constraint, String message) {
        this.constraint = constraint;
        this.message = message;
    }

    public String getConstraint() {
        return constraint;
    }

    public void setConstraint(String constraint) {
        this.constraint = constraint;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
