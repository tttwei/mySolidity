package com.example.f3.exception;

import com.example.f3.entity.R;
import lombok.extern.slf4j.Slf4j;
import org.fisco.bcos.sdk.transaction.model.exception.ContractException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public R exception(ContractException ex){
        String message = ex.getMessage();
        log.info("合约异常:{}",message);
        return R.error(message);
    }
}
