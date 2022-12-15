package com.lji.mwohaemukji.model.response;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * ApiSucessResponse
 *
 * @author Lee-Jae-Ik
 * @version 0.1
 * @see
 * @since 2022/12/15
 */
@Getter @NoArgsConstructor
public class ApiSucessResponse<T> extends ApiResponse{
    public ApiSucessResponse(T data) {
        super(ApiResult.SUCCESS, data);
    }
}
