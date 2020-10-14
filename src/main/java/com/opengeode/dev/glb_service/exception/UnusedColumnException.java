package com.opengeode.dev.glb_service.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnusedColumnException extends RuntimeException{

    private List<String> untouched;

    @Override
    public String getMessage() {
        String message = String.format("Some previous columns were not used and may lead to mistakes : %s",untouched);
        return message;
    }

}
