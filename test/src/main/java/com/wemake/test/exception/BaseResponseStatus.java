package com.wemake.test.exception;

import lombok.Getter;

@Getter
public enum BaseResponseStatus {
    /**
     * 성공
     */
    SUCCESS(true, 1000, "요청에 성공하였습니다."),

    /**
     *  Request 오류
     */
    REQUEST_ERROR(false, 2000, "요청을 확인해주세요."),

    /**
     *  Parse 오류
     */
    PARSE_ERROR(false, 3000, "Parsing에 실패하였습니다."),

    /**
     *  Response 오류
     */

    RESPONSE_ERROR(false, 4000, "응답값을 불러오는데 실패하였습니다."),
    ;

    private final boolean isSuccess;
    private final int code;
    private final String message;

    private BaseResponseStatus(boolean isSuccess, int code, String message) { //BaseResponseStatus 에서 각 해당하는 코드를 생성자로 맵핑
        this.isSuccess = isSuccess;
        this.code = code;
        this.message = message;
    }
}
