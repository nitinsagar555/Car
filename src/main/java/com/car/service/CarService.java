package com.car.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.model.Car;
import com.car.repository.CarRepository;

@Service
public class CarService {

	@Autowired
	private CarRepository carRepository;
}
