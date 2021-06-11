package me.joy.examplespring.config.http;

public enum BaseResponseCode {
    SUCCESS, // 성공
    EXCEPTION,
    HANDLER_METHOD_NOT_FOUND,
    HEADER_AUTH_VALUE_IS_EMPTY,
    HEADER_AUTH_VALUE_NOT_EQUALS,
    DATABASE_EXCEPTION,
    HTTP_MESSAGE_NOT_READABLE_EXCEPTION,
    HTTP_MEDIA_TYPE_NOT_SUPPORTED_EXCEPTION,
    ERROR, // 에러
    LOGIN_REQUIRED, // 로그인 필수
    DATA_IS_NULL,  // NULL
    UPLOAD_FILE_IS_NULL,
    PERMISSION,

    VALIDATE_DEFAULT,
    VALIDATE_REQUIRED,
    VALIDATE_CHECKED,
    VALIDATE_SIZE,
    VALIDATE_ARRAY_SIZE,
    VALIDATE_MINSIZE,
    VALIDATE_MAXSIZE,
    VALIDATE_PATTERN,
    VALIDATE_DATE,
    VALIDATE_TIME,
    VALIDATE_AUTH,
    VALIDATE_DATE_BEFORE,
    VALIDATE_DATE_BEFORE_START_END,
    VALIDATE_CODE,
    VALIDATE_INDEX,
    VALIDATE_REMOTE,
    VALIDATE_DUPLICATE,
    ;
}
