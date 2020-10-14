package com.opengeode.dev.glb_service.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.bind.annotation.ResponseStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ResponseStatus
public class NoSuchColumnException extends RuntimeException{
    private String columnName;

    @Override
    public String getMessage() {
        String message = String.format("Expecting column definition :: %s",columnName);
        return message;
    }
}
