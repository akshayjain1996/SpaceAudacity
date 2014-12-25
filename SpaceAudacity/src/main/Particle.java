package main;

import java.util.Random;

public class Particle {

	private static final int[] SPEED = { 2, 3, 4, 5 };
	private static final int[] RADIUS = { 25, 20, 30, 35 };

	private final int WIDTH = 600;
	private final int HEIGTH = 400;

	private int x;
	private int y;
	private int speed;
	private int radius;

	public Particle(int r, int s) {
		setX();
		y = -30;
		speed = s;
		radius = r;
	}

	public int getX() {
		return x;
	}

	public void setX() {
		Random random = new Random();
		x = random.nextInt(WIDTH + 1);
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getRadius() {
		return radius;
	}

	public static int getRandomRadius() {
		return RADIUS[getRandomNumber(3)];
	}

	public static int getRandomSpeed() {
		return SPEED[getRandomNumber(3)];
	}

	public void step() {
		y += speed;
		if (y > HEIGTH) {
			respan();
		}
	}

	private static int getRandomNumber(int i) {
		Random random = new Random();
		return random.nextInt(i);
	}

	public void respan() {
		y = -30;
		setX();
		radius = getRandomRadius();
		speed = getRandomSpeed();
	}
}
