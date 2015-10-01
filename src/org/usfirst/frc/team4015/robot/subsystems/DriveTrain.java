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

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
		
		
	}
	
	public void mecanumDrive() {
		chassis.mecanumDrive_Cartesian(Robot.oi.driveStickLeft.getX(), 0 ,0, 0);
		
	}
	
	public void mecanumDriveAuto(String direction) {
		double x;
		double y;
		if (direction == "forward") {
			x = 0;
			y = -0.5;
		}
		else if(direction == "right") {
			x = -0.5;
			y = 0;
		}
		else if(direction == "left") {
			x = 0.5;
			y = 0;
		}
		else if(direction == "backward") {
			x = 0;
			y = 0.5;
		} else {
			x = 0;
			y = 0;
		}
		chassis.mecanumDrive_Cartesian(x, y, 0, 0);
	}
	
	public void tankDrive() {
		chassis.tankDrive(Robot.oi.driveStickLeft,Robot.oi.driveStickRight);
	}
	
	public void stop() {
		chassis.drive(0, 0);
	}

}
