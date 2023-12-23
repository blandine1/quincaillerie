package com.gestqua.gestqua.handler;

import com.gestqua.gestqua.Exceptions.ErrorCodes;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDto {
    private int httpcode;
    private ErrorCodes codes;
    private String message;

    private List<String> errors= new ArrayList<>();
 }
