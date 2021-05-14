package com.projectBL.employeepayroll.Exception;

import com.projectBL.employeepayroll.dtoModel.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class PayrollExceptionGlobalExceptionHandler {

    @ExceptionHandler(PayrollException.class)
    public ResponseEntity<ResponseDto> handlePayrollException(PayrollException payrollException){
      log.error("Exception Occurred : " +payrollException.exceptionTypes.errorMsg);

      return new ResponseEntity<ResponseDto>(new ResponseDto(payrollException.exceptionTypes.errorMsg,null,null),
                                                              HttpStatus.BAD_REQUEST);
    }
}
