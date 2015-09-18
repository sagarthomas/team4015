package org.usfirst.frc.team4015.robot.commands;

import org.usfirst.frc.team4015.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class Drive extends Command{

	public Drive() {
		// TODO Auto-generated constructor stub
		requires(Robot.driveTrain);
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void execute() {
		Robot.driveTrain.tankDrive();
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
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
