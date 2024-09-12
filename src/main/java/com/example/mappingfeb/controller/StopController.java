package com.example.mappingfeb.controller;

import com.example.mappingfeb.entity.Bus;


import com.example.mappingfeb.entity.Stop;
import com.example.mappingfeb.repository.PostRepository;
import com.example.mappingfeb.repository.StopRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/stops")
public class StopController {

    private StopRepository stopRepository;

    public StopController(PostRepository postRepository, StopRepository stopRepository) {
        this.stopRepository = stopRepository;
    }

    //http://localhost:8080/api/v1/stops

    @PostMapping("/create")
    public ResponseEntity<Stop> createStop(@RequestBody  Stop stop) {
        Stop savedStop = stopRepository.save(stop);
        return new ResponseEntity<>(savedStop, HttpStatus.CREATED);
    }
}
