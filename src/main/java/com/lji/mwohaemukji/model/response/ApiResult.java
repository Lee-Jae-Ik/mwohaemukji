package com.lji.mwohaemukji.model.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * ApiResult
 *
 * @author Lee-Jae-Ik
 * @version 0.1
 * @see
 * @since 2022/12/15
 */
@Getter
public enum ApiResult {

    SUCCESS(200, "success"),
    SERVER_ERROR(500, "server error")
    ;
    private int resultCode;
    @Setter
    private String message;

    ApiResult(int resultCode, String message) {
        this.resultCode = resultCode;
        this.message = message;
    }
}
