package org.ksga._10_pon_channarith_pp.service;

import org.ksga._10_pon_channarith_pp.model.Instructor;
import org.ksga._10_pon_channarith_pp.model.request.InstructorCreateRequest;
import org.ksga._10_pon_channarith_pp.model.request.InstructorUpdateRequest;

import java.util.List;

public interface InstructorService {
    List<Instructor> findAllInstructors(Integer page, Integer size);
    Instructor createInstructor(InstructorCreateRequest instructorCreateRequest);
    Instructor findInstructorById(Integer id);
    void deleteInstructorById(Integer id);
    Instructor updateInstructorById(Integer id, InstructorUpdateRequest instructorUpdateRequest);
}
