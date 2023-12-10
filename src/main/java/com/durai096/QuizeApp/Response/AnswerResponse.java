package com.durai096.QuizeApp.Response;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class AnswerResponse {
    private Integer id;
    private String response;
}
