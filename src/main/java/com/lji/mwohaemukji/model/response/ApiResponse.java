package com.lji.mwohaemukji.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * ApiResponse
 *
 * @author Lee-Jae-Ik
 * @version 0.1
 * @see
 * @since 2022/12/15
 */
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class ApiResponse<T> {

    private ApiResult apiResult;
    private T data;

    public String getMessage() {
        return apiResult.getMessage();
    }
}
