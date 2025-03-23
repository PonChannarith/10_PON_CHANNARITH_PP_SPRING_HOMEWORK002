package org.ksga._10_pon_channarith_pp.controller;

import org.ksga._10_pon_channarith_pp.model.Student;
import org.ksga._10_pon_channarith_pp.model.request.StudentCreateRequest;
import org.ksga._10_pon_channarith_pp.model.request.StudentUpdateRequest;
import org.ksga._10_pon_channarith_pp.model.response.ApiResponse;
import org.ksga._10_pon_channarith_pp.model.response.ErrorResponse;
import org.ksga._10_pon_channarith_pp.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Find all students with pagination
    @GetMapping
    public ResponseEntity<ApiResponse<List<Student>>> findAllStudents(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size) {

        ApiResponse<List<Student>> response = ApiResponse.<List<Student>>builder()
                .message("Find all students successfully")
                .payload(studentService.findAllStudents(page, size))
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();

        return ResponseEntity.ok(response);
    }

    // Find Student By ID
    @GetMapping("/{id}")
    public ResponseEntity<?> findStudentById(@PathVariable Integer id) {
        Student student = studentService.findStudentById(id);

        if (student != null) {
            ApiResponse<Student> response = ApiResponse.<Student>builder()
                    .message("Student found successfully")
                    .payload(student)
                    .status(HttpStatus.OK)
                    .timestamp(LocalDateTime.now())
                    .build();
            return ResponseEntity.ok(response);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(
                        "about:blank",
                        "Not Found",
                        HttpStatus.NOT_FOUND.value(),
                        "Student with ID " + id + " not found.",
                        "/api/v1/students/" + id,
                        LocalDateTime.now()
                ));
    }

    // Create Student
    @PostMapping
    public ResponseEntity<ApiResponse<Student>> createStudent(@RequestBody StudentCreateRequest studentCreateRequest) {
        Student newStudent = studentService.createStudent(studentCreateRequest);

        ApiResponse<Student> response = ApiResponse.<Student>builder()
                .message("Student created successfully")
                .payload(newStudent)
                .status(HttpStatus.CREATED)
                .timestamp(LocalDateTime.now())
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // Delete Student By ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudentById(@PathVariable Integer id) {
        Student existingStudent = studentService.findStudentById(id);

        if (existingStudent == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ErrorResponse(
                            "about:blank",
                            "Not Found",
                            HttpStatus.NOT_FOUND.value(),
                            "Student with ID " + id + " not found.",
                            "/api/v1/students/" + id,
                            LocalDateTime.now()
                    ));
        }

        studentService.deleteStudentById(id);

        return ResponseEntity.ok(ApiResponse.<Student>builder()
                .message("Student deleted successfully")
                .status(HttpStatus.NO_CONTENT)
                .timestamp(LocalDateTime.now())
                .build());
    }

    // Update Student By ID
    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudentById(@PathVariable Integer id, @RequestBody StudentUpdateRequest studentUpdateRequest) {
        Student existingStudent = studentService.findStudentById(id);

        if (existingStudent == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ErrorResponse(
                            "about:blank",
                            "Not Found",
                            HttpStatus.NOT_FOUND.value(),
                            "Student with ID " + id + " not found.",
                            "/api/v1/students/" + id,
                            LocalDateTime.now()
                    ));
        }

        Student updatedStudent = studentService.updateStudentById(id, studentUpdateRequest);

        return ResponseEntity.ok(ApiResponse.<Student>builder()
                .message("Student updated successfully")
                .payload(updatedStudent)
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build());
    }
}
