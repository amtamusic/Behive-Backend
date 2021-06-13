package com.andytech.behive.entities.user;

import com.andytech.behive.entities.common.Skill;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Map;

@Data
public class Review {
    @Id
    private String id;
    private double overallRating;
    private User peer;
    private Map<Skill, Double> skillRating;
    private String reviewText;
}
