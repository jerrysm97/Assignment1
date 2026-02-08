package com.greencampus.repository;

import com.greencampus.model.GreenActivity;
import com.greencampus.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<GreenActivity, Long> {
    List<GreenActivity> findByUser(User user);
}
