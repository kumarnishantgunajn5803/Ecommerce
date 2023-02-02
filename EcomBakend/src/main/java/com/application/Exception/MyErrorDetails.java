package com.application.Exception;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MyErrorDetails {

    private LocalDateTime timeStamp;
    private String message;
    private String errorDetails;

}
