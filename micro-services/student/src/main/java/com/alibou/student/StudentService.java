package com.alibou.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudenRepository studenRepository;

    public void saveStudent(Student student) {
        studenRepository.save(student);
    }

    public List<Student> findAllStudents() {
        return studenRepository.findAll();
    }

    public List<Student> findStudentsBySchool(Long schoolId) {
        return studenRepository.findAllBySchoolId(schoolId);
    }
}
