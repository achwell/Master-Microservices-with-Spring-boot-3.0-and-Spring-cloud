package com.alibou.student;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudenRepository extends JpaRepository<Student, Long> {
    List<Student> findAllBySchoolId(Long schoolId);
}
