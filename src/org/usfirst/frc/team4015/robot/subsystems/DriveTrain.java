package org.usfirst.frc.team4015.robot.subsystems;

import org.usfirst.frc.team4015.robot.Robot;
import org.usfirst.frc.team4015.robot.RobotMap;


import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem {
	
	Talon frontLeft = new Talon(RobotMap.Pwm.FrontLeftDrive);
	Talon frontRight = new Talon(RobotMap.Pwm.FrontRightDrive);
	Talon rearLeft = new Talon(RobotMap.Pwm.RearLeftDrive);
	Talon rearRight = new Talon(RobotMap.Pwm.RearRightDrive);
	RobotDrive chassis = new RobotDrive(frontLeft, rearLeft, frontRight, rearRight);
	private double threshold = 0.24;

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
		
		
		
	}
	
	public void mecanumDrive() {
		
		chassis.mecanumDrive_Cartesian(checkThreshold(Robot.oi.driveStickLeft.getX()),checkThreshold(Robot.oi.driveStickLeft.getY()) ,0, 0);
		
		
	}
	
	private double checkThreshold(double value) {
		if (value < threshold && value > (-1.0 * threshold)) {
		return 0.0;
		} else {
			return value;
		}
	}
	
	public void mecanumDriveAuto(int direction) {
		double x;
		double y;
		if (direction == 1) { // forward
			x = 0;
			y = -0.5;
		}
		else if(direction == 2) { // right
			x = -0.5;
			y = 0;
		}
		else if(direction == 4) { // left
			x = 0.5;
			y = 0;
		}
		else if(direction == 3) { // backward
			x = 0;
			y = 0.5;
		} else {
			x = 0;
			y = 0;
		}
		chassis.mecanumDrive_Cartesian(x, y, 0, 0);
	}
	
	public void tankDrive() {
		chassis.mecanumDrive_Cartesian(0, checkThreshold(Robot.oi.driveStickLeft.getY()), checkThreshold(Robot.oi.driveStickLeft.getX()), 0);
	}
	
	public void stop() {
		chassis.drive(0, 0);
	}

}
