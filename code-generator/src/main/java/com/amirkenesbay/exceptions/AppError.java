package com.amirkenesbay.exceptions;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
public class AppError {
    private int statusCode;

    private String message;
}
