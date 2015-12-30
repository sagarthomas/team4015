package org.usfirst.frc.team4015.robot.commands.autonomous.util;

import java.nio.channels.Channel;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.Timer;

public class Ultrasonic {

	private DigitalInput echo;
	private DigitalOutput ping;
	private int channel;
	private static final double kPingTime = 5 * 1e-6;
	
	
	public Ultrasonic() {
		
	}
	public Ultrasonic(int channel) {
		this.channel = channel;
		ping = new DigitalOutput(channel);
		echo = new DigitalInput(channel);
	}
	
	public void ping() {
		ping.pulse(channel, (float) kPingTime);
		
	}

}
