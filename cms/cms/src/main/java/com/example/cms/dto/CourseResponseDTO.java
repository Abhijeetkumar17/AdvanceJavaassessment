package com.example.cms.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class CourseResponseDTO {

    private Long id;

    private String title;

    private String description;

    private String instructor;

    private int duration;

    private Double price;

    private LocalDateTime createdAt;
}