package com.example.cms.service.impl;

import com.example.cms.dto.CourseRequestDTO;
import com.example.cms.dto.CourseResponseDTO;
import com.example.cms.entity.Course;
import com.example.cms.exception.ResourceNotFoundException;
import com.example.cms.repository.CourseRepository;
import com.example.cms.service.CourseService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository repository;
    private final ModelMapper mapper;

    public CourseServiceImpl(CourseRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public CourseResponseDTO createCourse(CourseRequestDTO dto) {

        Course course = mapper.map(dto, Course.class);

        Course savedCourse = repository.save(course);

        return mapper.map(savedCourse, CourseResponseDTO.class);
    }

    @Override
    public CourseResponseDTO getCourseById(Long id) {

        Course course = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course","id",id));

        return mapper.map(course, CourseResponseDTO.class);
    }

    @Override
    public List<CourseResponseDTO> getAllCourses() {

        List<Course> courses = repository.findAll();

        return courses.stream()
                .map(course -> mapper.map(course, CourseResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public CourseResponseDTO updateCourse(Long id, CourseRequestDTO dto) {

        Course course = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course","id",id));

        course.setTitle(dto.getTitle());
        course.setDescription(dto.getDescription());
        course.setInstructor(dto.getInstructor());
        course.setDuration(dto.getDuration());
        course.setPrice(dto.getPrice());

        Course updatedCourse = repository.save(course);

        return mapper.map(updatedCourse, CourseResponseDTO.class);
    }

    @Override
    public void deleteCourse(Long id) {

        Course course = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course","id",id));

        repository.delete(course);
    }
}