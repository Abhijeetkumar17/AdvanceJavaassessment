package com.example.cms.controller;

import com.example.cms.dto.CourseRequestDTO;
import com.example.cms.dto.CourseResponseDTO;
import com.example.cms.payload.ApiResponse;
import com.example.cms.service.CourseService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService service;

    public CourseController(CourseService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<CourseResponseDTO>> createCourse(
            @Valid @RequestBody CourseRequestDTO dto){

        CourseResponseDTO createdCourse = service.createCourse(dto);

        ApiResponse<CourseResponseDTO> response =
                new ApiResponse<>(true, "Course created successfully", createdCourse);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CourseResponseDTO>> getCourseById(@PathVariable Long id){

        CourseResponseDTO course = service.getCourseById(id);

        ApiResponse<CourseResponseDTO> response =
                new ApiResponse<>(true, "Course fetched successfully", course);

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<CourseResponseDTO>>> getAllCourses(){

        List<CourseResponseDTO> courses = service.getAllCourses();

        ApiResponse<List<CourseResponseDTO>> response =
                new ApiResponse<>(true, "Courses fetched successfully", courses);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<CourseResponseDTO>> updateCourse(
            @PathVariable Long id,
            @Valid @RequestBody CourseRequestDTO dto){

        CourseResponseDTO updatedCourse = service.updateCourse(id, dto);

        ApiResponse<CourseResponseDTO> response =
                new ApiResponse<>(true, "Course updated successfully", updatedCourse);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteCourse(@PathVariable Long id){

        service.deleteCourse(id);

        ApiResponse<String> response =
                new ApiResponse<>(true, "Course deleted successfully", null);

        return ResponseEntity.ok(response);
    }
}