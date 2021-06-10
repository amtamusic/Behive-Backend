package com.andytech.behive.entities.team;

import com.andytech.behive.entities.common.Skill;
import com.andytech.behive.entities.user.User;
import lombok.Data;

import java.util.Set;

@Data
public class Position {
    private String description;
    private Set<Skill> requiredSkills;
    private boolean isVacant;
    private User assignedEmployee;
}
