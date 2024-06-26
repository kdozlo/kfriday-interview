package com.kfriday.daeyeong._common.response.success;

import lombok.Getter;

@Getter
public enum SuccessType {

    CREATE_BOUND_SUCCESS("입출고 생성에 성공했습니다."),
    READ_BOUND_SUCCESS("입출고 단건 조회에 성공했습니다."),
    DELETE_BOUND_SUCCESS("입출고 삭제에 성공했습니다."),
    ;

    private final String msg;

    SuccessType(String msg) {
        this.msg = msg;
    }
}
