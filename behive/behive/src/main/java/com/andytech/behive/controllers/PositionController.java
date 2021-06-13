package com.andytech.behive.controllers;


import com.andytech.behive.entities.team.Position;
import com.andytech.behive.services.PositionService;
import com.andytech.behive.utils.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/position")
public class PositionController {
    @Autowired
    PositionService positionService;

    LogUtils logUtils;

    public PositionController() {
        this.logUtils = new LogUtils();
        this.logUtils.setLoggerClass(this.getClass());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Position> getPosition(@PathVariable("id") String id) {
        logUtils.logString(String.format("Update Position received: %s", id));
        var position = positionService.getPosition(id);
        logUtils.logObject("Returned position after lookup by id : %s", position);
        return new ResponseEntity<>(position, HttpStatus.OK);
    }

    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<Position> addPosition(@RequestBody Position position) {
        logUtils.logObject("Add Position received: %s", position);
        position = positionService.addPosition(position);
        logUtils.logObject("Add Position result: %s", position);
        return new ResponseEntity<>(position, HttpStatus.OK);
    }

    @PutMapping("/update")
    @ResponseBody
    public ResponseEntity<Position> updatePosition(@RequestBody Position position) {
        logUtils.logObject("Update Position received: %s", position);
        position = positionService.updatePosition(position);
        logUtils.logObject("Update Position result: %s", position);
        return new ResponseEntity<>(position, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public ResponseEntity<Position> deletePosition(@RequestBody Position position) {
        logUtils.logObject("Delete Position received: %s", position);
        positionService.deletePosition(position);
        logUtils.logString("Position " + position.toString() + " deleted");
        return new ResponseEntity<>(position, HttpStatus.OK);
    }
}
