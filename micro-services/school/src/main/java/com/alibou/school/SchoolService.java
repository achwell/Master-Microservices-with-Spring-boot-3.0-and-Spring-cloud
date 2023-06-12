package com.alibou.school;

import com.alibou.school.client.StudentClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {

    private final SchoolRepository schoolRepository;
    private final StudentClient studentClient;

    public void saveSchool(School school) {
        schoolRepository.save(school);
    }

    public List<School> findAllSchools() {
        return schoolRepository.findAll();
    }

    public FullSchoolResponse findSchoolsWithStudents(Long schoolId) {
        var school = schoolRepository.findById(schoolId).orElse(School
                .builder()
                .name("NOT FOUND")
                .email("NOT FOUND")
                .build());
        return new FullSchoolResponse(school.getName(), school.getEmail(), studentClient.findAllStudentsBySchool(schoolId));
    }
}
