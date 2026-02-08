package com.greencampus.controller;

import com.greencampus.model.GreenActivity;
import com.greencampus.model.User;
import com.greencampus.service.ActivityService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/user")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @GetMapping("/dashboard")
    public String userDashboard(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user == null || !"STUDENT".equals(user.getRole())) {
            return "redirect:/login";
        }
        
        List<GreenActivity> activities = activityService.getUserActivities(user);
        int totalPoints = activityService.calculateTotalPoints(activities);
        
        model.addAttribute("user", user);
        model.addAttribute("activities", activities);
        model.addAttribute("totalPoints", totalPoints);
        
        return "user-dashboard";
    }

    @PostMapping("/log-activity")
    public String logActivity(@RequestParam String activityType,
                              @RequestParam int points,
                              HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user != null) {
            activityService.logActivity(user, activityType, points);
        }
        return "redirect:/user/dashboard";
    }
}
