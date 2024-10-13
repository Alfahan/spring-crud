package com.rumah.kita.spring_crud.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

public class LearnDTO {
    
    @Data
    public static class RequestLearnDTO {
        private String firstName;
        private String lastName;
    }

    @Data
    @AllArgsConstructor
    @Builder
    public static class ResponseLearnDTO {
        private Long id;
        private String firstName;
        private String lastName;
    }
}
