package org.usfirst.frc.team4015.robot.commands;

import org.usfirst.frc.team4015.robot.Robot;
//import org.usfirst.frc.team4015.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;

public class Drive extends Command{

	public Drive() {
		
	}

	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {
		Robot.driveTrain.tankDrive();
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		Robot.driveTrain.stop();
	}

	@Override
	protected void interrupted() {		
		Robot.driveTrain.stop();
	}

}
