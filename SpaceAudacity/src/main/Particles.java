package main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Particles {

	private List<Particle> objs;

	public Particles() {
		objs = new ArrayList<Particle>();
		int y = 0;
		for (int i = 0; i < 10; i++) {
			Particle particle = new Particle(Particle.getRandomRadius(),
					Particle.getRandomSpeed());
			particle.setY(y);
			objs.add(particle);
			y -= 50;
		}
	}

	public void step() {
		Iterator<Particle> iterator = objs.iterator();
		while (iterator.hasNext()) {
			Particle particle = iterator.next();
			particle.step();
		}
	}

	public List getObjs() {
		return objs;
	}

	public void addParticle(Particle p) {
		objs.add(p);
	}

}
