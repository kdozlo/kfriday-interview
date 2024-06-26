package com.kfriday.daeyeong.common.response.error.exception;

import com.kfriday.daeyeong.common.response.error.ErrorType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class BusinessException extends RuntimeException{

    private final ErrorType errorType;

}
