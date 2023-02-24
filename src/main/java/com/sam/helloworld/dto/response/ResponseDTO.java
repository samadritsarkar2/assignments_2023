package com.sam.helloworld.dto.response;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class ResponseDTO<T> {

    @NonNull
    private Boolean success;

    @NonNull
    private Integer statusCode;
    @NonNull
    private Boolean error;

    private String errMsg;

    private T data;

    public void setSuccessObj() {
        this.success = true;
        this.statusCode = 200;
        this.error = false;
        this.errMsg = "";

    }

}
