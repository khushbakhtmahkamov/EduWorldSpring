package com.example.eduworldspring.repository;

import com.example.eduworldspring.model.Progress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProgressRepository extends JpaRepository<Progress, Long> {
    Optional<Progress> findByUserIdAndSubjectId(Long userId, Long subjectId);
    List<Progress> findAllByUserId(Long userId);
    List<Progress> findAllBySubjectId(Long subjectId);
    boolean existsByUserIdAndSubjectId(Long userId, Long subjectId);
}