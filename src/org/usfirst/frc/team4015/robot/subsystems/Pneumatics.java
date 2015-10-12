package org.usfirst.frc.team4015.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Pneumatics extends Subsystem {
    
	Compressor compressor = new Compressor();
	DoubleSolenoid pistons = new DoubleSolenoid(0, 1); // first parameter is the forward valve, second backward
	//Solenoid solenoid = new Solenoid(0);
	//Solenoid solenoid2 = new Solenoid(1);
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void toggleCompressor() {
    	if (compressor.enabled()) {
    		compressor.stop();
    	} else {
    		compressor.start();
    	}
    }
    
    public void shoot() {
    	pistons.set(DoubleSolenoid.Value.kForward);
    	Timer.delay(1);
    	pistons.set(DoubleSolenoid.Value.kOff);
    }
    
    public void resetPosition() {
    	pistons.set(DoubleSolenoid.Value.kReverse);
    	Timer.delay(1);
    	pistons.set(DoubleSolenoid.Value.kOff);
    }
}

