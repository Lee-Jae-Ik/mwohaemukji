package com.lji.mwohaemukji.controller.base;

import com.lji.mwohaemukji.model.response.ApiErrorResponse;
import com.lji.mwohaemukji.model.response.ApiResponse;
import com.lji.mwohaemukji.model.response.ApiResult;
import com.lji.mwohaemukji.model.response.ApiSucessResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * BaseAbstractController
 *
 * @author Lee-Jae-Ik
 * @version 0.1
 * @see
 * @since 2022/12/15
 */
public abstract class BaseAbstractController {

    protected <T>ResponseEntity<ApiResponse> responseApi(T body) {
        ApiResponse apiResponse = new ApiSucessResponse(body);
        return response(apiResponse);
    }

    protected ResponseEntity<ApiErrorResponse> responseError(ApiResult apiResult) {
        ApiErrorResponse response = new ApiErrorResponse(apiResult);
        return responseError(response);
    }

    private <T> ResponseEntity<T> response(T body) {
        return ResponseEntity.status(HttpStatus.OK).headers(getCommonHttpHeaders()).body(body);
    }

    private <T> ResponseEntity<T> responseError(T body) {
        return ResponseEntity.status(HttpStatus.OK).headers(getCommonHttpHeaders()).body(body);
    }

    protected abstract HttpHeaders getCommonHttpHeaders();
}
