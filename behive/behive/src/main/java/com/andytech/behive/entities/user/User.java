package com.andytech.behive.entities.user;

import com.andytech.behive.entities.common.Skill;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
public class User {
    @Id
    private String id;
    private String name;
    private String lastName;
    private String password;
    private String username;
    private String email;
    private String phone;
    private Set<Skill> skills;
    private Map<String, Double> skillRating;
    private double attendanceRating;
    private List<Review> peerReviews;
    private boolean isAdmin;
    private String accountStatus;
}
