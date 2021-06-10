package com.andytech.behive.entities.team;

import com.andytech.behive.entities.common.Skill;
import com.andytech.behive.entities.user.User;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class Team {
    private long id;
    private User owner;
    private Set<User> teamMembers;
    private Set<Skill> teamSkills;
    private List<Job> jobs;
}
