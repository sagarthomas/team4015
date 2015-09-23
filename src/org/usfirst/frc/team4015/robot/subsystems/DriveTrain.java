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
		chassis.mecanumDrive_Cartesian(Robot.oi.driveStickLeft.getX(), Robot.oi.driveStickLeft.getY(), Robot.oi.driveStickLeft.getZ(), 0);
		
	}
	
	public void tankDrive() {
		chassis.tankDrive(Robot.oi.driveStickLeft,Robot.oi.driveStickRight);
	}
	
	public void stop() {
		chassis.drive(0, 0);
	}

}
