package com.stackroute.userservice.controller;

import com.stackroute.exception.TrackAlreadyExistException;
import com.stackroute.exception.TrackNotFoundException;
import com.stackroute.userservice.domain.Track;
import com.stackroute.userservice.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="api/v1")
public class TrackController {
    //autowired the trackservice and errorcontroller
    @Autowired
    TrackService trackService;
    @Autowired
    ErrorController errorController;


    public TrackController(TrackService trackService) {

        this.trackService = trackService;
    }
//method for insert the track
    @PostMapping(value = "/save")
    public ResponseEntity<?> saveTrack(@RequestBody Track track) {
        ResponseEntity responseEntity;
        try {
            trackService.saveTrack(track);
            responseEntity = new ResponseEntity<String>("sucessfully created", HttpStatus.CREATED);
        } catch (TrackAlreadyExistException ex) {
            //responseEntity = errorController.exception1();
            responseEntity = new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

//method for get all tracks
    @GetMapping(value = "/track")
    public ResponseEntity<?> getAllTracks() {
        return new ResponseEntity<List<Track>>(trackService.getAllTracks(), HttpStatus.OK);
    }

//method for update the track
    @PostMapping(value = "/update")
    public ResponseEntity<?> updateTrack(@RequestBody Track track) {
        ResponseEntity responseEntity;
        try {
            trackService.updateTrack(track);
            responseEntity = new ResponseEntity<String>("sucessfully updated", HttpStatus.CREATED);
        } catch (TrackNotFoundException ex) {
            responseEntity = errorController.exception2();
        }
        return responseEntity;
    }

//method for delete the track and use id as PathVariable
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteTrackById(@PathVariable("id") int id) {
        ResponseEntity responseEntity;
        try {
            trackService.deleteTrackById(id);
            responseEntity = new ResponseEntity<String>("sucessfully deleted", HttpStatus.CREATED);
        } catch (Exception ex) {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
}