package org.usfirst.frc.team4015.robot.commands.autonomous.util;

public class Position {
	private double angle, hypotenuse, adj, opp, x, y;

	// Constructors
	public Position() {
		
	}
	public Position(double angle, double hypotenuse) {
		this.angle = (angle * (Math.PI/180)); // Convert angle measure to radians 
		this.hypotenuse = hypotenuse;
		adj = (hypotenuse * (Math.cos(angle)));
		opp = (hypotenuse * (Math.sin(angle)));
		x = calculateXPosition();
		y = calculateYPosition();
	}
	public Position(Position position) {
		this.angle = position.angle;
		this.hypotenuse = position.hypotenuse;
		this.adj = position.adj;
		this.opp = position.opp;
		this.x = position.x;
		this.y = position.y;
	}
	
	// TODO Make calculations after robot class is made.
	private double calculateXPosition() {
		return 0;
	}
	
	private double calculateYPosition() {
		return 0;
	}
	
	// Getters and Setters
	public double getAdjSide() {return adj;}
	public void setAdjSide(double adj) {this.adj = adj;}
	public double getOppSide() {return opp;}
	public void setOppSide(double opp) {this.opp = opp;}
	public double getAngle() {return angle;}
	public void setAngle(double angle) {this.angle = angle;}
	public double getHypotenuse() {return hypotenuse;}
	public void setHypotenuse(double hypotenuse) {this.hypotenuse = hypotenuse;}
	public double getX() {return x;}
	public void setX(double x) {this.x = x;}
	public double getY() {return y;}
	public void setY(double y) {this.y = y;}

}
