package com.car.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.car.model.Car;
import com.car.repository.CarRepository;

@Component
@RestController
@EnableAutoConfiguration
public class CarController {

	@Autowired
	private CarRepository carRepository;

	public CarController(CarRepository carRepository) {
		this.carRepository = carRepository;
	}

	@GetMapping("/cars")
	public CollectionModel<Car> getAllCarDetails() {
		List<Car> carList = carRepository.findAll();
		for (Car car : carList) {

			Link link = new Link("http://localhost:8080/cars");
			car.add(link);
		}
		Link link = new Link("http://localhost:8080/cars");
		CollectionModel<Car> result = new CollectionModel<>(carList, link);
		return result;

	}

	@GetMapping("/car/{carName}")
	public CollectionModel<Car> getCarById(@PathVariable("carName") String carName) {
		List<Car> carList = carRepository.getCarName(carName);
		for (Car car : carList) {
			Link link = new Link("http://localhost:8080/car/" + carName);
			car.add(link);
		}
		Link link = new Link("http://localhost:8080/cars");
		CollectionModel<Car> result = new CollectionModel<>(carList, link);
		return result;
		/* return carRepository.getCarName(carName); */
	}

	@PostMapping("/post-car")
	public CollectionModel<Car> postCarDetails(@RequestBody Car car) {
		carRepository.insert(car);
		List<Car> carList = carRepository.findAll();
		for (Car cars : carList) {
			Link link = new Link("http://localhost:8080/cars/" + cars.getCarId());
			cars.add(link);
		}
		Link link = new Link("http://localhost:8080/cars");
		CollectionModel<Car> result = new CollectionModel<>(carList, link);
		return result;

	}

	@DeleteMapping("delete-car/{carId}")
	public ResponseEntity<Object> deleteCarById(@PathVariable("carId") int carId) {
		carRepository.deleteCarById(carId);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping("/update-car/{carId}")
	public void updateCarDetails(@RequestBody Car car,@PathVariable ("carId") int carId ) {
		carRepository.updateCar(car,carId);
	}

}
