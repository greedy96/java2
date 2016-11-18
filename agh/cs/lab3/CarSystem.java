package agh.cs.lab3;

import java.util.List;

import agh.cs.lab2.MoveDirection;

public class CarSystem {

	public static void main(String[] args) {
			OptionsParser parser = new OptionsParser();
			Car car = new Car();
			List<MoveDirection> directions = parser.parse(args);
	        for(MoveDirection direction : directions) {
	            car.move(direction);
	            System.out.println(car);
	        }	
	}
}
