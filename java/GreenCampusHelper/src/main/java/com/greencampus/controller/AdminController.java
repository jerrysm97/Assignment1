package com.greencampus.controller;

import com.greencampus.model.Admin;
import com.greencampus.model.GreenActivity;
import com.greencampus.model.User;
import com.greencampus.service.ActivityService;
import com.greencampus.service.ReportService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ActivityService activityService;

    @Autowired
    private ReportService reportService;

    @GetMapping("/dashboard")
    public String adminDashboard(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user == null || !"ADMIN".equals(user.getRole())) {
            return "redirect:/login";
        }
        
        // Ensure the user object is cast to Admin to access Admin-specific methods if needed,
        // though for this controller we mainly use services.
        // Demonstration of Object casting and Inheritance checking
        if (user instanceof Admin) {
             Admin adminUser = (Admin) user;
             model.addAttribute("roleDescription", adminUser.displayRole());
             model.addAttribute("reportMessage", adminUser.generateReport());
        }

        List<GreenActivity> allActivities = activityService.getAllActivities();
        Map<String, Object> stats = reportService.generateGlobalReport();
        
        model.addAttribute("user", user);
        model.addAttribute("activities", allActivities);
        model.addAttribute("stats", stats);
        
        return "admin-dashboard";
    }
}
