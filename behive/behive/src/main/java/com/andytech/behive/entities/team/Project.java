package com.andytech.behive.entities.team;

import com.andytech.behive.entities.common.Skill;
import com.andytech.behive.entities.user.User;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;
import java.util.Set;

@Data
public class Project {
    @Id
    private String id;
    private User owner;
    private User manager;
    private Set<User> teamMembers;
    private Set<Skill> teamSkills;
    private List<Position> positions;
}
