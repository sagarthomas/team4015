package org.usfirst.frc.team4015.robot.subsystems;

import org.usfirst.frc.team4015.robot.Robot;
import org.usfirst.frc.team4015.robot.RobotMap;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
//import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Pneumatics extends Subsystem {
    
	Compressor compressor = new Compressor();
	
	Solenoid piston = new Solenoid(0);
	Solenoid piston2 = new Solenoid(1);
	
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
    	piston.set(false);
    	piston2.set(true);
    	
    	
    }
    
    public void resetPosition() {
    	
    	if (magSwitch.get()) {
    		piston.set(false);
    		piston2.set(true);
    	} 
    	else if(!magSwitch.get()){
	    	piston.set(true);
	    	piston2.set(false);
    	}
    }
    
    public void getMagPosition() {
    	SmartDashboard.putBoolean("Mag Switch state", magSwitch.get());
    }
}

