package org.ksga._10_pon_channarith_pp.service;

import org.ksga._10_pon_channarith_pp.model.Course;
import org.ksga._10_pon_channarith_pp.model.request.CourseCreateRequest;
import org.ksga._10_pon_channarith_pp.model.request.CourseUpdateRequest;

import java.util.List;

public interface CourseService {
    // findAllCourses
    List<Course> findAllCourses(Integer page, Integer size);
    // findCourseById
    Course findCourseById(Integer id);
    Course createCourse(CourseCreateRequest courseCreateRequest);
    void deleteCourseById(Integer id);
    Course updateCourseById(Integer id, CourseUpdateRequest courseUpdateRequest);
}
