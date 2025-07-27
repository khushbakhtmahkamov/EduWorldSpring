package com.example.eduworldspring.dto.rating;

import lombok.Data;

@Data
public class RatingCreateDto {
    private Long userId;
    private Integer grade;
    private Long progressId;
}
