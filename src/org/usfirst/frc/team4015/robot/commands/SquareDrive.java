package org.usfirst.frc.team4015.robot.commands;

import org.usfirst.frc.team4015.robot.Robot;
import org.usfirst.frc.team4015.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SquareDrive extends Command {
	Timer timer;
	int direction = 1;

    public SquareDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);

    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	timer = new Timer();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	timer.start();
    	while (timer.hasPeriodPassed(3)) {
    		Robot.driveTrain.mecanumDriveAuto(direction);
    	}
    	timer.stop();
    	timer.reset();
    	direction++;
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
