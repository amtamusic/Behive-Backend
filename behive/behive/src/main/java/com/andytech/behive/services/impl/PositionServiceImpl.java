package com.andytech.behive.services.impl;

import com.andytech.behive.entities.team.Position;
import com.andytech.behive.repositories.PositionRepo;
import com.andytech.behive.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    private PositionRepo positionRepo;

    @Override
    public Position getPosition(String id) {
        Optional<Position> position = positionRepo.findById(id);
        if (position.isPresent()) {
            return position.get();
        }
        return null;
    }

    @Override
    public Position addPosition(Position position) {
        return positionRepo.save(position);
    }

    @Override
    public Position updatePosition(Position position) {
        return positionRepo.save(position);
    }

    @Override
    public boolean deletePosition(Position position) {
        positionRepo.delete(position);
        return true;
    }
}
