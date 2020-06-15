package com.car.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.car.model.Car;

@Mapper
@Repository
public interface CarRepository {

	@Select("select * from car")
	List<Car> findAll();

	@Select("SELECT * from car WHERE carName = #{carName}")
	List<Car> getCarName(@Param("carName") String carName);

	@Insert("insert into car(carId,carName,carManufactureName,carModel,carManufactoringYear,carColor) values(#{carId},#{carName},#{carManufactureName},#{carModel},#{carManufactoringYear},#{carColor})")
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "carId", before = false, resultType = Integer.class)
	void insert(Car car);

	@Delete("DELETE FROM car WHERE carId = #{carId}")
	public void deleteCarById(int carId);

	@Update("UPDATE car SET carName=#{carName}, carManufactureName=#{carManufactureName}, carModel=#{carModel},carManufactoringYear=#{carManufactoringYear},carColor=#{carColor}  where carId=#{carId}")
	public void updateCar(Car car,@Param("carId") int carId);
}
