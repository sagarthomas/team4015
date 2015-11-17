package org.usfirst.frc.team4015.robot.commands;

import org.usfirst.frc.team4015.robot.Robot;
import org.usfirst.frc.team4015.robot.RobotMap;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LauncherArm extends Command {
	private VictorSP armMotor;

    public LauncherArm() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	 armMotor = new VictorSP(RobotMap.Pwm.LauncherArm);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (Robot.oi.driveStickLeft.getRawButton(6)){ 
    		//Robot.driveTrain.armMovement(1);
    		armMotor.set(1.0);
    	}
    	else if(Robot.oi.driveStickLeft.getRawButton(7)){
    		//Robot.driveTrain.armMovement(-1);
    		armMotor.set(-1.0);
    	}
    	else {
    		armMotor.set(0);
    	}
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
