package agh.cs.lab5;

import java.util.List;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab3.OptionsParser;
import agh.cs.lab4.Car;

public class CarSystem {

	public static void main(String[] args) {
		try {List<MoveDirection> md = new OptionsParser().parse(args);
		MoveDirection[] directions = new MoveDirection[md.size()];
		for(int x = 0; x < directions.length; x++)
			directions[x] = md.get(x);
		UnboundedMap map = new UnboundedMap();
		map.add(new Car(map));
		map.add(new Car(map,3,4));
		System.out.print(map);
		map.addStack(new HayStack(-4,-4));
		map.addStack(new HayStack(7,7));
		map.addStack(new HayStack(3,6));
		map.addStack(new HayStack(7,7));
		map.addStack(new HayStack(2,0));
		System.out.print(map);
		map.run(directions);
		System.out.print(map);
		} catch (IllegalArgumentException ex){
			System.out.println(ex.getMessage());
		}

	}
	
}
