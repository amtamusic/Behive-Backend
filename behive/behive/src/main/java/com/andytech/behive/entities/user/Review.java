package com.andytech.behive.entities.user;

import com.andytech.behive.entities.common.Skill;
import lombok.Data;

import java.util.Map;

@Data
public class Review {
    private double overallRating;
    private User peer;
    private Map<Skill, Double> skillRating;
}
