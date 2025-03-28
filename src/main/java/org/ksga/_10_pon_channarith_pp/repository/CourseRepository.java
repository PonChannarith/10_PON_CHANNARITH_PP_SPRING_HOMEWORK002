package org.ksga._10_pon_channarith_pp.repository;

import org.apache.ibatis.annotations.*;
import org.ksga._10_pon_channarith_pp.model.Course;
import org.ksga._10_pon_channarith_pp.model.Instructor;
import org.ksga._10_pon_channarith_pp.model.request.CourseCreateRequest;
import org.ksga._10_pon_channarith_pp.model.request.CourseUpdateRequest;

import java.util.List;

@Mapper
public interface CourseRepository {
    // find all courses
    @Select("""
    SELECT * FROM courses OFFSET (#{size}) * (#{page} - 1) LIMIT #{size}
""")
    @Results(id = "courseMapper", value = {
            @Result(property = "courseId", column = "course_id"),
            @Result(property = "courseName", column = "course_name"),
            @Result(property = "instructor", column = "instructor_id",
                    one = @One(select = "org.ksga._10_pon_channarith_pp.repository.InstructorRepository.findInstructorById")
            )
    })
    List<Course> findAllCourses(Integer page, Integer size);

    // find course by id
    @Select("SELECT * FROM courses WHERE course_id = #{courseId}")
    @ResultMap("courseMapper")
    Course findCourseById(Integer courseId);

    // create course
    @Select("""
    INSERT INTO courses(course_name, description, instructor_id) 
    VALUES (#{course.courseName}, #{course.description}, #{course.instructor}) 
    RETURNING *
""")
    @ResultMap("courseMapper")
    Course createCourse(@Param("course") CourseCreateRequest courseCreateRequest);

    // delete course by id
    @Delete("DELETE FROM courses WHERE course_id = #{courseId}")
    void deleteCourseById(Integer courseId);

    // update course by id
    @Select("""
    UPDATE courses 
    SET course_name = #{course.courseName}, description = #{course.description}, instructor_id = #{course.instructor} 
    WHERE course_id = #{id}
    RETURNING *
""")
    @ResultMap("courseMapper")
    Course updateCourseById(@Param("id") Integer id, @Param("course") CourseUpdateRequest courseUpdateRequest);


}
