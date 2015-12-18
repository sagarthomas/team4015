package org.usfirst.frc.team4015.robot.commands.autonomous;

//import org.usfirst.frc.team4015.robot.commands.autonomous.util.Ultrasonic;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class UltrasonicTest extends Command{
	private Ultrasonic ultra = new Ultrasonic(2, 1);
	
	
	public UltrasonicTest() {
		// TODO Auto-generated constructor stub
		
	}
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		ultra.setAutomaticMode(true);
		
		SmartDashboard.putNumber("Distance", ultra.getRangeInches());
		
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	protected void end() {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}
	
	
}
