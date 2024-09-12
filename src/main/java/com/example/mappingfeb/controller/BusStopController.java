package com.example.mappingfeb.controller;

import com.example.mappingfeb.entity.Bus;
import com.example.mappingfeb.entity.BusStop;
import com.example.mappingfeb.entity.Stop;
import com.example.mappingfeb.repository.BusRepository;
import com.example.mappingfeb.repository.BusStopRepository;
import com.example.mappingfeb.repository.StopRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/bus")
public class BusStopController {

    private BusRepository busRepository;

    private StopRepository stopRepository;

    private BusStopRepository busStopRepository;

    public BusStopController(BusRepository busRepository, StopRepository stopRepository, BusStopRepository busStopRepository, BusRepository busRepository1, StopRepository stopRepository1, BusStopRepository busStopRepository1){
        this.busRepository = busRepository1;
        this.stopRepository = stopRepository1;
        this.busStopRepository = busStopRepository1;
    }
    @PostMapping
    public ResponseEntity<BusStop> allocateBusRoute(
          @RequestParam long busId,
          @RequestParam long stopId,
          @RequestBody BusStop busStop
    ){
        Bus bus = busRepository.findById(busId).get();
        Stop stop = stopRepository.findById(stopId).get();

        busStop.setBus(bus);
        busStop.setStop(stop);
        BusStop savedEntity=busStopRepository.save(busStop);

        return new ResponseEntity<>(savedEntity, HttpStatus.CREATED);
    }

}
