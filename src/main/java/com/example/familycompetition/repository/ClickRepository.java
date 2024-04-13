package com.example.familycompetition.repository;

import com.example.familycompetition.model.Click;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClickRepository extends JpaRepository<Click, Long> {
    List<Click> findAllByOrderByTimeClickedAsc();
}
