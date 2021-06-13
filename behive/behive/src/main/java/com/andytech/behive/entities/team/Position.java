package com.andytech.behive.entities.team;

import com.andytech.behive.entities.common.Skill;
import com.andytech.behive.entities.user.User;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Set;

@Data
public class Position {
    @Id
    private String description;
    private User manager;
    private Set<Skill> requiredSkills;
    private boolean isVacant;
    private User assignedEmployee;
}
