package com.stackroute.userservice.service;

import com.stackroute.exception.TrackAlreadyExistException;
import com.stackroute.exception.TrackNotFoundException;
import com.stackroute.userservice.domain.Track;

import java.util.List;

public interface TrackService {
    public Track saveTrack(Track track) throws TrackAlreadyExistException;

    public List<Track> getAllTracks();

    //public Track addNewTrack(Track track);

    public Track updateTrack(Track track) throws TrackNotFoundException;

    public void deleteTrackById(int id);

}
