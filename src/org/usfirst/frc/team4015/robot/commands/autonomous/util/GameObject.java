package org.usfirst.frc.team4015.robot.commands.autonomous.util;


public class GameObject {
	private Position position;
	ObjectType type;

	// Constructors
	public GameObject() {
		
	}
	public GameObject(double angle, double hypotenuse) {
		position = new Position(angle, hypotenuse);
	}
	public GameObject(Position position) {
		this.position = position;
	}

	
}
