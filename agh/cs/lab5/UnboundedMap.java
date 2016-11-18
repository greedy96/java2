package agh.cs.lab5;


import java.util.ArrayList;
import java.util.List;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Position;
import agh.cs.lab4.Car;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab4.MapVisualizer;

public class UnboundedMap extends AbstractWorldMap implements IWorldMap  {

	private List<HayStack> stacks = new ArrayList<>();
	
	private int S,W,E,N;
    
	
	public void addStack(HayStack stack){
		if(this.canMoveTo(stack.getPosition())){
			this.stacks.add(stack);
			
		}
		else throw new IllegalArgumentException("cant add new object: " + stack.getPosition());
	}
	
	public void bound(){
		for(Car c: cars)
			saveBound(c.getPosition());
		
		for(HayStack s: stacks)
			saveBound(s.getPosition());
	}
	
	public void saveBound(Position posit){
		if(posit.x<this.S)
			this.S=posit.x;
		
		if(posit.y<this.W)
			this.W=posit.y;
		
		if(posit.x>this.N)
			this.N=posit.x;
		
		if(posit.y>this.E)
			this.E=posit.y;
		}
		
	@Override
	public boolean canMoveTo(Position position) {
		return (!isOccupied(position));
	}

	@Override
	public boolean add(Car car) {
		if(this.canMoveTo(car.getPosition())){
			this.cars.add(car);
			return true;
		}
		throw new IllegalArgumentException("cant add new object: " + car.getPosition());
	}

	@Override
	public boolean isOccupied(Position position) {
		boolean c = super.isOccupied(position);
		if (c != false)
			return true;
		for(HayStack s: stacks){
			if(s.getPosition().equals(position))
				return true;
		}
		return false;
	}

	@Override
	public Object objectAt(Position position) {
		Object c = super.objectAt(position);
		if (c != null) 
			return c;
		
		for(HayStack s: stacks){
			if(s.getPosition().equals(position))
				return s;
		}
		return null;
	}
	
	@Override
	public String toString(){
		MapVisualizer mv = new MapVisualizer();
		this.S=Integer.MAX_VALUE;this.W=Integer.MAX_VALUE;this.E=Integer.MIN_VALUE;this.N=Integer.MIN_VALUE;
		bound();
		return mv.dump(this, new Position (S,W), new Position (N,E));
	}
	
}

