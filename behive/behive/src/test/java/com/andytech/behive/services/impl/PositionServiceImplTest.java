package com.andytech.behive.services.impl;

import com.andytech.behive.entities.team.Position;
import com.andytech.behive.repositories.PositionRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
class PositionServiceImplTest {

    @Autowired
    @InjectMocks
    PositionServiceImpl positionService = new PositionServiceImpl();

    @Mock
    PositionRepo positionRepo;

    @Test
    void addPositionTest() {
        Position position = new Position();
        position.setDescription("test");
        when(positionRepo.save(any())).thenReturn(position);
        Position response = positionService.addPosition(position);
        assertThat(response).isNotNull();
    }

    @Test
    void deletePositionTest() throws Exception {
        Position position = new Position();
        position.setDescription("test");
        assertThat(positionService.deletePosition(position)).isTrue();
    }

    @Test
    void updatePositionTest() throws Exception {
        Position position = new Position();
        position.setDescription("test");
        when(positionRepo.save(any())).thenReturn(position);
        Position responseEntity = positionService.updatePosition(position);
        assertThat(responseEntity).isNotNull();
    }

    @Test
    void getPositionTest() throws Exception {
        Position position = new Position();
        position.setDescription("test");
        when(positionRepo.findById(any())).thenReturn(Optional.of(position));
        Position responseEntity = positionService.getPosition("1");
        assertThat(responseEntity).isNotNull();
    }

    @Test
    void getPositionTestNotPresent() throws Exception {
        when(positionRepo.findById(any())).thenReturn(Optional.empty());
        Position responseEntity = positionService.getPosition("1");
        assertThat(responseEntity).isNull();
    }
}