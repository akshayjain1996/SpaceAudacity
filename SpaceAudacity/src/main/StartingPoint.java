package main;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;

import main.Particle;

public class StartingPoint extends Applet implements Runnable, KeyListener {

	Particles particles;
	private final int FPS = 17;
	private final int WIDTH = 600;
	private final int HEIGTH = 400;
	private Image background;
	private Graphics graphics;
	Spaceship spaceship;
	private Image ship;
	private boolean gameOn = true;

	URL url = null;

	@Override
	public void init() {
		spaceship = new Spaceship();
		particles = new Particles();
		setSize(WIDTH, HEIGTH);
		addKeyListener(this);
		url = getDocumentBase();
		background = getImage(url, "images/background.jpg");
		ship = getImage(url, "images/spaceship.png");
		System.out.println(ship.getHeight(this));
	}

	@Override
	public void start() {
		Thread thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run() {
		while (gameOn) {
			repaint();
			particles.step();
			try {
				Thread.sleep(FPS);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void paint(Graphics g) {
		if (spaceship.checkCrash(particles) == false) {
			g.setColor(Color.RED);
			g.fillRect(0, 0, getWidth(), getHeight());
			g.drawImage(background, 0, 0, this);
			g.drawImage(ship, spaceship.getX(), spaceship.getY(), this);
			g.setColor(Color.BLACK);
			List<Particle> list = particles.getObjs();
			Iterator<Particle> iterator = list.iterator();
			while (iterator.hasNext()) {
				Particle p1 = iterator.next();
				g.fillOval(p1.getX(), p1.getY(), p1.getRadius(), p1.getRadius());
			}
		} else {
			gameOn = false;
		}
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		super.stop();
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			spaceship.moveLeft();
			break;
		case KeyEvent.VK_RIGHT:
			spaceship.moveRight();
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
