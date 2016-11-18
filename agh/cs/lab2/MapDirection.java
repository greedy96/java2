package agh.cs.lab2;

public enum MapDirection {
	North, South, West, East;
	
public MapDirection next(){
	switch (this){
	case North:
		return MapDirection.East;
	case East:
		return MapDirection.South;
	case South:
		return MapDirection.West;
	case West:
		return MapDirection.North;
	}
	return null;
}

public MapDirection previous(){
	switch (this){
	case North:
		return MapDirection.West;
	case East:
		return MapDirection.North;
	case South:
		return MapDirection.East;
	case West:
		return MapDirection.South;
	}
	return null;
}
	
public String toString(){
	switch(this){
	case North:
		return "P�noc";
	case South:
		return "Po��dnie";
	case West:
		return "Zach�d";
	case East:
		return "Wsch�d";
	}
	return null;
}

}

