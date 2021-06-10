package com.andytech.behive.entities.team;

import lombok.Data;

import java.util.List;

@Data
public class Job {
    private String description;
    private List<Position> positions;
}
