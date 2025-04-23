package assignment9;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;

public class Food {

	public static final double FOOD_SIZE = 0.02;
	private double x, y;
	
	/**
	 * Creates a new Food at a random location
	 */
	public Food() {
		//FIXME
		this.x = Math.random() * (1 - 2 * FOOD_SIZE) + FOOD_SIZE;
		this.y = Math.random() * (1 - 2 * FOOD_SIZE) + FOOD_SIZE;
	}
	
	/**
	 * Draws the Food
	 */
	public void draw() {
		//FIXME
		StdDraw.setPenColor(Color.RED);
		StdDraw.filledCircle(x, y, FOOD_SIZE);
	}
	public double getX() { return x; }
	public double getY() { return y; }
}
