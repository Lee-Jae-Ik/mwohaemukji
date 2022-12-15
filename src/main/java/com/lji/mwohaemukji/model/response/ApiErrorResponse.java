package com.lji.mwohaemukji.model.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.util.StringUtils;

/**
 * ApiErrorResponse
 *
 * @author Lee-Jae-Ik
 * @version 0.1
 * @see
 * @since 2022/12/15
 */
@Getter @Setter
public class ApiErrorResponse<T> extends ApiResponse {

    private String changeMessage;

    public ApiErrorResponse(ApiResult apiResult) {
        super(apiResult,null);
    }

    public ApiErrorResponse(ApiResult result, T data) {
        super(result,data);
    }

    @Override
    public String getMessage() {
        if (!StringUtils.hasText(this.changeMessage)) return super.getMessage();
        else return this.changeMessage;
    }
}
