package org.ksga._10_pon_channarith_pp.service.serviceImpl;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.ksga._10_pon_channarith_pp.model.Instructor;
import org.ksga._10_pon_channarith_pp.model.request.InstructorCreateRequest;
import org.ksga._10_pon_channarith_pp.model.request.InstructorUpdateRequest;
import org.ksga._10_pon_channarith_pp.repository.InstructorRepository;
import org.ksga._10_pon_channarith_pp.service.InstructorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorServiceImpl implements InstructorService {
    private final InstructorRepository instructorRepository;

    public InstructorServiceImpl(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    @Override
    public List<Instructor> findAllInstructors(Integer page, Integer size) {
        return instructorRepository.findAllInstructors(page, size);
    }

    @Override
    public Instructor createInstructor(InstructorCreateRequest instructorCreateRequest) {
        return instructorRepository.createInstructor(instructorCreateRequest);
    }

    @Override
    public Instructor findInstructorById(Integer id) {
        return instructorRepository.findInstructorById(id);
    }

    @Override
    public void deleteInstructorById(Integer id) {
        instructorRepository.deleteInstructorById(id);
    }

    @Override
    public Instructor updateInstructorById(Integer id, InstructorUpdateRequest instructorUpdateRequest) {
        return instructorRepository.updateInstructorById(id, instructorUpdateRequest);
    }

}
