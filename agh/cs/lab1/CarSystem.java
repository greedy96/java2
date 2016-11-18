package agh.cs.lab1;

public class CarSystem {

	public static void main(String[] args) {
		System.out.println("start");
		run(conwent(args));
		System.out.println("stop");
	}

	private static Direction[] conwent(String[] args) {
		Direction[] result=new Direction[args.length];
		for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "f":
                   result[i] = Direction.Forward;
                    break;
                case "b":
                    result[i] = Direction.Backward;
                    break;
                case "r":
                    result[i] = Direction.Right;
                    break;
                case "l":
                    result[i] = Direction.Left;
                    break;
            }
		}
		return result;
	}

	private static void run(Direction[] directions) {
		for (Direction direct : directions){
			switch (direct){
			case Forward:
				System.out.println("Jedzie do przodu");
				break;
			case Backward:
				System.out.println("Jedzie do tylu");
				break;
			case Right:
				System.out.println("Jedzie w lewo");
				break;
			case Left:
				System.out.println("Jedzie w prawo");
				break;
			}
			
		}
		
	}

}
