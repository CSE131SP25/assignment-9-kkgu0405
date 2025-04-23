package assignment9;

import java.util.LinkedList;

public class Snake {

	private static final double SEGMENT_SIZE = 0.02;
	private static final double MOVEMENT_SIZE = SEGMENT_SIZE * 1.5;
	private LinkedList<BodySegment> segments;
	private double deltaX;
	private double deltaY;
	
	public Snake() {
		//FIXME - set up the segments instance variable
		segments = new LinkedList<>();
		segments.add(new BodySegment(0.5, 0.5, SEGMENT_SIZE));
		deltaX = 0;
		deltaY = 0;
	}
	
	public void changeDirection(int direction) {
		if(direction == 1) { //up
			deltaY = MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 2) { //down
			deltaY = -MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 3) { //left
			deltaY = 0;
			deltaX = -MOVEMENT_SIZE;
		} else if (direction == 4) { //right
			deltaY = 0;
			deltaX = MOVEMENT_SIZE;
		}
	}
	
	/**
	 * Moves the snake by updating the position of each of the segments
	 * based on the current direction of travel
	 */
	public void move() {
		//FIXME
		double prevX = segments.getFirst().getX();
		double prevY = segments.getFirst().getY();
		segments.getFirst().setX(prevX + deltaX);
		segments.getFirst().setY(prevY + deltaY);

		for (int i = 1; i < segments.size(); i++) {
			double tempX = segments.get(i).getX();
			double tempY = segments.get(i).getY();
			segments.get(i).setX(prevX);
			segments.get(i).setY(prevY);
			prevX = tempX;
			prevY = tempY;
		}
	}
	/**
	 * Draws the snake by drawing each segment
	 */
	public void draw() {
		//FIXME
		for (BodySegment s : segments) {
			s.draw();
	}
	}
	
	/**
	 * The snake attempts to eat the given food, growing if it does so successfully
	 * @param f the food to be eaten
	 * @return true if the snake successfully ate the food
	 */
	public boolean eatFood(Food f) {
		//FIXME
		BodySegment head = segments.getFirst();
		double dx = head.getX() - f.getX();
		double dy = head.getY() - f.getY();
		double distance = Math.sqrt(dx * dx + dy * dy);
		if (distance < SEGMENT_SIZE + Food.FOOD_SIZE) {
			BodySegment last = segments.getLast();
			segments.add(new BodySegment(last.getX(), last.getY(), SEGMENT_SIZE));
			return true;
		}
		return false;
	}
	
	/**
	 * Returns true if the head of the snake is in bounds
	 * @return whether or not the head is in the bounds of the window
	 */
	public boolean isInbounds() {
		//FIXME
		double x = segments.getFirst().getX();
		double y = segments.getFirst().getY();
		return x >= 0 && x <= 1 && y >= 0 && y <= 1;
	}
}
