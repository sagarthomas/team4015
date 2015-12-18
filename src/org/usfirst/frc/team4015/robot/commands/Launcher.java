package org.usfirst.frc.team4015.robot.commands;

import org.usfirst.frc.team4015.robot.Robot;








import org.usfirst.frc.team4015.robot.subsystems.Pneumatics;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Launcher extends Command {

    public Launcher() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.pneumatics.getMagPosition(); // Displays Mag Switch state
    	SmartDashboard.putBoolean("Is Stopped", Robot.pneumatics.isStopped);
    	if(Robot.oi.driveStickLeft.getRawButton(1)) {
    		Robot.pneumatics.shoot();
    	}
    	else if(Robot.oi.driveStickLeft.getRawButton(3)){ // pick appropriate buttons needed
    		Robot.pneumatics.toggleCompressor();
    	}
    	else if(Robot.oi.driveStickLeft.getRawButton(2)) {
    		Timer.delay(0.1);
    		Robot.pneumatics.resetPosition();
    		
    	}
    	else {
    		Robot.pneumatics.stop();
    	}
    	
    	
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	//if(!Robot.pneumatics.getMagPosition())
    		//return true;
    	//else
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
