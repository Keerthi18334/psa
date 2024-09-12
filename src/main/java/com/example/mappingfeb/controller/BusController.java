package com.example.mappingfeb.controller;

import com.example.mappingfeb.entity.Bus;
import com.example.mappingfeb.repository.BusRepository;
import com.example.mappingfeb.repository.PostRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/buses")
public class BusController {

    private BusRepository busRepository;

    public BusController(PostRepository postRepository, BusRepository busRepository) {
        this.busRepository = busRepository;
    }

    //http://localhost:8080/api/v1/buses

    @PostMapping("/create")
    public ResponseEntity<Bus> createBus(@RequestBody Bus bus) {
        Bus savedBus = busRepository.save(bus);
        return new ResponseEntity<>(savedBus, HttpStatus.CREATED);
    }
}

