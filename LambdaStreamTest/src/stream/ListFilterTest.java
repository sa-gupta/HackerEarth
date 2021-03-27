package com.cg.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import com.cg.bean.Car;

public class ListFilterTest {

	public static void main(String[] args) {
		List<Car> carList = new ArrayList<>();
		carList.add(new Car("BMW","red"));
		carList.add(new Car("Audi","silver"));
		carList.add(new Car("Ferrari","white"));
		carList.add(new Car("Maruti","silver"));
		carList.add(new Car("Tata","black"));
		carList.add(new Car("Volkswagen","yellow"));
		carList.add(new Car("Mustang","white"));
		
		List<Car> silverList = getSilverCars(carList);
		
//		The above expression can also be written as
//		In below method calling, we are passing lambda expression as a argument only in JDK1.8
		
		List<Car> whiteList = getWhiteCars(carList,car -> "white".equals(car.getColor()));
		 
		System.out.println(silverList);
		System.out.println(whiteList);
	}

	private static List<Car> getWhiteCars(List<Car> carList, Predicate<Car> p) {
		List<Car> whiteCars = new ArrayList<>();
		for (Car car : carList) {
			if(p.test(car)) {
				whiteCars.add(car);
			}
		}
		return whiteCars;
	}

	private static List<Car> getSilverCars(List<Car> carList) {
		List<Car> silverCars = new ArrayList<>();
		Predicate<Car> p = car -> "silver".equals(car.getColor());
		for (Car car : carList) {
			if(p.test(car)){
				silverCars.add(car);
			}
		}
		return silverCars;
	}

}
