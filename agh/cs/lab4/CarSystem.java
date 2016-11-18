package agh.cs.lab4;

import java.util.List;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab3.OptionsParser;

public class CarSystem {

	public static void main(String[] args) {
		List<MoveDirection> md = new OptionsParser().parse(args);
		MoveDirection[] directions = new MoveDirection[md.size()];
		for(int x = 0; x < directions.length; x++)
			directions[x] = md.get(x);
		IWorldMap map = new RectangularMap(10, 5);
		map.add(new Car(map));
		map.add(new Car(map,3,4));
		System.out.print(map);
		map.run(directions);
		System.out.print(map);

	}
	
}
