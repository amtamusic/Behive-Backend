package com.andytech.behive.services;

import com.andytech.behive.entities.team.Position;

public interface PositionService {

    Position getPosition(String id);

    Position addPosition(Position position);

    Position updatePosition(Position position);

    boolean deletePosition(Position position);
}
