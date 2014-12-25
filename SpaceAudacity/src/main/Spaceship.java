package main;

import java.util.Iterator;
import java.util.List;

public class Spaceship {
	private int stepSize = 10;
	private int x, y;

	public Spaceship() {
		x = 0;
		y = 360;
	}

	public void step(int posX, int posY) {
		x = posX;
		y = posY;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int posX) {
		x = posX;
	}

	public void moveRight() {
		if (x < 540) {
			x += stepSize;
		}
	}

	public void moveLeft() {
		if (x > 0) {
			x -= stepSize;
		}
	}

	public boolean checkCrash(Particles particles) {
		boolean result = false;
		List<Particle> list = particles.getObjs();
		Iterator<Particle> iterator = list.iterator();
		while (iterator.hasNext()) {
			Particle particle = iterator.next();
			if ((particle.getY() > 370) && (particle.getX() > x)
					&& (particle.getX() < x + 60)) {
				return true;
			}
		}
		return result;
	}
}
