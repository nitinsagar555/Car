package com.car.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.PropertySource;
import org.springframework.hateoas.RepresentationModel;

@PropertySource(value = "classpath:configprops.json")
@Entity
@Table(name = "car")
public class Car extends RepresentationModel<Car> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "carId")
	int carId;
	@Column(name = "carName", nullable = false)
	String carName;
	@Column(name = "carManufactureName", nullable = false)
	String carManufactureName;
	@Column(name = "carModel", nullable = false)
	String carModel;
	@Column(name = "carManufactoringYear", nullable = false)
	Date carManufactoringYear;
	@Column(name = "carColor", nullable = false)
	String carColor;

	public Car(int carId, String carName, String carManufactureName, String carModel, Date carManufactoringYear,
			String carColor) {
		this.carId = carId;
		this.carName = carName;
		this.carManufactureName = carManufactureName;
		this.carModel = carModel;
		this.carManufactoringYear = carManufactoringYear;
		this.carColor = carColor;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getCarManufactureName() {
		return carManufactureName;
	}

	public void setCarManufactureName(String carManufactureName) {
		this.carManufactureName = carManufactureName;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public Date getCarManufactoringYear() {
		return carManufactoringYear;
	}

	public void setCarManufactoringYear(Date carManufactoringYear) {
		this.carManufactoringYear = carManufactoringYear;
	}

	public String getCarColor() {
		return carColor;
	}

	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}

	public Car() {
		super();
	}

}
