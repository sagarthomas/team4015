package org.usfirst.frc.team4015.robot.subsystems;

import org.usfirst.frc.team4015.robot.Robot;
import org.usfirst.frc.team4015.robot.RobotMap;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Timer;

//import edu.wpi.first.wpilibj.DoubleSolenoid;
//import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import org.usfirst.frc.team4015.robot.DoubleSolenoid;
import org.usfirst.frc.team4015.robot.DoubleSolenoid.Value;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Pneumatics extends Subsystem {
    
	Compressor compressor = new Compressor();
	
	//Solenoid piston = new Solenoid(0);
	//Solenoid piston2 = new Solenoid(1);
	
	DoubleSolenoid solenoid = new DoubleSolenoid(0, 1);
	
	int count = 0;
	public boolean isStopped = false;
	
	DigitalInput magSwitch = new DigitalInput(RobotMap.DigitalIn.ReedSwitch0);
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	//SmartDashboard.putBoolean("Mag Switch state", magSwitch.get());
    }
    
    public void toggleCompressor() {
    	if (compressor.enabled()) {
    		compressor.stop();
    	} else {
    		compressor.start();
    	}
    }
    
    public void shoot() {
    	//piston.set(true);
    	//piston2.set(false);
    	solenoid.set(Value.kForward);
    	 
    	
    }
    
    public void resetPosition() {
    	
    	count++;
    	//piston.set(false);
		//piston2.set(true);
		
    	if (magSwitch.get() == true) {
    		//piston.set(false);
    		//piston2.set(true);
    		solenoid.set(Value.kReverse);
    	} 
    	else {
	    	//solenoid.set(Value.kOff);
    		SmartDashboard.getBoolean("Else", true);
	    	solenoid.set(Value.kOff);
	    	//solenoid.set(Value.kOff);
    	}
    	
    }
    
    public void stop(){
    	solenoid.set(Value.kOff);
    	while(!Robot.oi.driveStickLeft.getRawButton(1) && !Robot.oi.driveStickLeft.getRawButton(2)){
    		solenoid.set(Value.kForward);
    		solenoid.set(Value.kReverse);
    	}
    	
    }
    
   
	public boolean getMagPosition() {
    	SmartDashboard.putBoolean("Mag Switch state", magSwitch.get());
    	SmartDashboard.putNumber("Cycle number", count);
    	return magSwitch.get();
    }
}

