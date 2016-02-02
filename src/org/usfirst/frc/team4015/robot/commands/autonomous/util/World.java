package org.usfirst.frc.team4015.robot.commands.autonomous.util;

import java.util.ArrayList;

import org.usfirst.frc.team4015.robot.RobotMap;

import edu.wpi.first.wpilibj.Servo;
import org.usfirst.frc.team4015.robot.commands.autonomous.util.Ultrasonic;

public class World {
	Servo frontServo = new Servo(RobotMap.Pwm.FrontServo);
	Servo backServo = new Servo(RobotMap.Pwm.BackServo);
	
	//Ultrasonic front = new Ultrasonic(RobotMap.DigitalOut.DO1, RobotMap.DigitalIn.DI2);
	//Ultrasonic back = new Ultrasonic(RobotMap.DigitalOut.DO3, RobotMap.DigitalIn.DI4);
	
	Ultrasonic front = new Ultrasonic(RobotMap.DigitalIn.DI2);
	Ultrasonic back = new Ultrasonic(RobotMap.DigitalIn.DI4);
	
	ArrayList<GameObject> objects;
	
	double distance;
	double threshold = 2.0; // threshold value subject to change

	public World() {
		objects = new ArrayList<GameObject>();
		
	}
	
	public void scan() {
		for (int angle = 0; angle < 180; angle += 10) { // increment every 10 degrees
			frontServo.setAngle(angle);
			front.ping();
			distance = (front.getRangeMM() * 1000); // convert to meters
			if(isObject(distance)) 
				objects.add(new GameObject(angle, distance));
			
			backServo.setAngle(angle);
			//back.ping();
			distance = (back.getRangeMM() * 1000);
			if (isObject(distance))
				objects.add(new GameObject(angle, distance));
		}
		resetPositions();
	}
	
	private boolean isObject(double distance) {
		if (distance < threshold)
			return true;
		else
			return false;
	}
	
	private void resetPositions() {
		frontServo.setAngle(0);
		backServo.setAngle(0);
	}
	
	public void update() {
		
	}

}
