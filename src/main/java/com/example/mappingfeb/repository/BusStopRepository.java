package com.example.mappingfeb.repository;

import com.example.mappingfeb.entity.BusStop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusStopRepository extends JpaRepository<BusStop, Long> {
}