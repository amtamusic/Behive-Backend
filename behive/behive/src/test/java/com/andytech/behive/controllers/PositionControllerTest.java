package com.andytech.behive.controllers;

import com.andytech.behive.entities.team.Position;
import com.andytech.behive.services.PositionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class PositionControllerTest {
    @InjectMocks
    @Autowired
    PositionController positionController = new PositionController();

    @Mock
    PositionService positionService;

    @Test
    void addPositionTest() {
        Position position = new Position();
        when(positionService.addPosition(any())).thenReturn(position);
        ResponseEntity<Position> responseEntity = positionController.addPosition(position);
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }

    @Test
    void deletePositionTest() {
        Position position = new Position();
        when(positionService.deletePosition(any())).thenReturn(true);
        ResponseEntity<Position> responseEntity = positionController.deletePosition(position);
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }

    @Test
    void updatePositionTest() {
        Position position = new Position();
        when(positionService.updatePosition(any())).thenReturn(position);
        ResponseEntity<Position> responseEntity = positionController.updatePosition(position);
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }

    @Test
    void getPositionTest() {
        Position position = new Position();
        when(positionService.getPosition(any())).thenReturn(position);
        ResponseEntity<Position> responseEntity = positionController.getPosition("1");
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }

    @Test
    void getPositionTestFail() {
        Position position = new Position();
        when(positionService.getPosition(any())).thenReturn(position);
        ResponseEntity<Position> responseEntity = positionController.getPosition("a");
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }
}