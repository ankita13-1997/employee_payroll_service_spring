package com.projectBL.employeepayroll.Exception;

public class PayrollException extends RuntimeException{

    public ExceptionTypes exceptionTypes;

    public PayrollException(ExceptionTypes exceptionTypes){
        this.exceptionTypes=exceptionTypes;
    }



    public enum ExceptionTypes {
        EMPLOYEE_ALREADY_PRESENT("employee Already present"),
        EMPLOYEE_NOT_FOUND("employee not found"),
        INVALID_USER_ID("user id you have given is incorrect"),
        EMPLOYEE_NOT_PRESENT("employee is not present in database")
        ;
        public String errorMsg;
        ExceptionTypes(String errorMsg){
            this.errorMsg =errorMsg;
    }



    }
}
