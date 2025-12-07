package com.pong;

import java.awt.Color;
import java.awt.Graphics;

public class Paddle {
	private int x;
	private int y;
	private int height;
	private int speed;
	private Color color;
	private int width=15;
	
	
	public Paddle (int x, int y, int height, int speed, Color color) {
		this.x = x;
        this.y = y;
        this.height = height;
        this.speed = speed;
        this.color = color;
	}
	
	
	//precondition: g is a non-null value
	//postcondition: draws the paddle on the screen
	public void draw(Graphics g) {
		g.setColor(color);
		
		g.fillRect(x, y, width, height);
		
	}
	
	//precondition: location and yOffset is a non-null value
	//postcondition: moves the paddle in the direction of the location 
	public void moveY(int location, double yOffset) {
	 int yOffsetInt = ((int)yOffset); // adds a slight y offset so the AI bounces are more intresting
	 location = location - yOffsetInt/2;
	 int centerY = y + height / 2;		

	 if (centerY<location) {
		if ((centerY+speed)>location) {
			y += speed - Math.abs(location-(centerY+speed));
		}
		else y+=speed;
	 }
	 
	 else if (centerY>location) {
	      if((centerY-speed)<location) {
	    	  y -= speed - Math.abs(location-(centerY-speed));
	      }
		 
	      else  y-=speed;	 
	 }
	
	}
	//precondition: none
	//postcondition: returns the paddles y
	public int getY() {
		  return y;
	  }
	  
	//precondition: none
	//postcondition: returns the paddles x
	  public int getX() {
		  return x;
	  }
	
	//precondition: none
	//postcondition: returns the paddles x
	  public int getHeight() {
		  return height;
	  }

		//precondition: ball is a non-null value
		//postcondition: returns true if the ball is touching one the paddle this is called on
	 public boolean isTouching(Ball ball) {
		 int rightX= x+width;
		 int bottomY = y+height;
		 int topy = y-ball.getSize(); // if you use the normal y then the ball can clip through the top
		 
		 if(x <= ball.getX() && ball.getX()<=rightX) {
			//  System.out.println("x in bounds");
			 if(bottomY >= ball.getY() && ball.getY()>=topy) {
				 
				return true;
			 }
	 }
		 return false;
	 }
}
