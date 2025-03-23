package org.ksga._10_pon_channarith_pp.service;

import org.ksga._10_pon_channarith_pp.model.Course;
import org.ksga._10_pon_channarith_pp.model.Student;
import org.ksga._10_pon_channarith_pp.model.request.CourseCreateRequest;
import org.ksga._10_pon_channarith_pp.model.request.StudentCreateRequest;
import org.ksga._10_pon_channarith_pp.model.request.StudentUpdateRequest;

import java.util.List;

public interface StudentService {
    // Find all students with pagination
    List<Student> findAllStudents(Integer page, Integer size);

    // findStudentById
    Student findStudentById(Integer id);

    Student createStudent(StudentCreateRequest studentCreateRequest);

    // deleteStudentById
    void deleteStudentById(Integer id);

    // updateStudentById
    Student updateStudentById(Integer id, StudentUpdateRequest studentUpdateRequest);
}
