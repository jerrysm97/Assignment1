package com.greencampus.service;

import com.greencampus.model.GreenActivity;
import com.greencampus.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ReportService {

    @Autowired
    private ActivityRepository activityRepository;

    public Map<String, Object> generateGlobalReport() {
        List<GreenActivity> allActivities = activityRepository.findAll();
        
        Map<String, Object> report = new HashMap<>();
        report.put("totalActivities", allActivities.size());
        report.put("totalPoints", allActivities.stream().mapToInt(GreenActivity::getPoints).sum());
        
        // Count by type
        Map<String, Long> typeCount = allActivities.stream()
                .collect(Collectors.groupingBy(GreenActivity::getActivityType, Collectors.counting()));
        report.put("mostPopularActivity", typeCount.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("None"));
                
        return report;
    }
}
