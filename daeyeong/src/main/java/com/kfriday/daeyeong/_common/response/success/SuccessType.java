package com.kfriday.daeyeong._common.response.success;

import lombok.Getter;

@Getter
public enum SuccessType {

    CREATE_BOUND_SUCCESS("입출고 생성에 성공했습니다.")
    ;

    private final String msg;

    SuccessType(String msg) {
        this.msg = msg;
    }
}
