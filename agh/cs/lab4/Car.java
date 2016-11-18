package agh.cs.lab4;

import agh.cs.lab2.MapDirection;
import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Position;

public class Car {
	private MapDirection kierunek=MapDirection.North;
	private Position pozycja = new Position(0,0);
	private IWorldMap map;
	
    @Override
	public String toString(){
		return this.kierunek.name().substring(0, 1);
	}
	
	public void move(MoveDirection direction){
		switch (direction){
		case Forward:
			run(1);
			break;
		case Backward:
			run(-1);
			break;
		case Right:
			this.kierunek=kierunek.next();
			break;
		case Left:
			this.kierunek=kierunek.previous();
			break;
		}
	}

	private void run(int i) {
		Position newpozycja = new Position(0,0);
		switch(this.kierunek){
		case North:
			newpozycja=pozycja.add(new Position(0,i));
			break;
		case East:
			newpozycja=pozycja.add(new Position(i,0));
			break;
		case South:
			newpozycja=pozycja.add(new Position(0,-i));
			break;
		case West:
			newpozycja=pozycja.add(new Position(-i,0));
			break;
		}
		if (map.canMoveTo(newpozycja)) 
			pozycja=newpozycja;
	}
	
	public Car(IWorldMap map){
		this.map=map;
	}
	
	public Car(IWorldMap map, int x, int y)
	{
		this.map=map;
		pozycja = new Position (x,y);
	}
	
	public Position getPosition(){
		return this.pozycja;
}
}
