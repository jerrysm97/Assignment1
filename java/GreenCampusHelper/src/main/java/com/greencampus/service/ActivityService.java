package com.greencampus.service;

import com.greencampus.model.GreenActivity;
import com.greencampus.model.User;
import com.greencampus.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    public GreenActivity logActivity(User user, String type, int points) {
        GreenActivity activity = new GreenActivity(type, LocalDate.now().toString(), points, user);
        return activityRepository.save(activity);
    }

    public List<GreenActivity> getUserActivities(User user) {
        return activityRepository.findByUser(user);
    }

    public List<GreenActivity> getAllActivities() {
        return activityRepository.findAll();
    }
    
    public int calculateTotalPoints(List<GreenActivity> activities) {
        return activities.stream().mapToInt(GreenActivity::getPoints).sum();
    }
}
