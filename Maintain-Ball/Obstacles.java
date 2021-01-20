package ball_moving;

import java.lang.*;
import java.awt.Color;
import java.awt.Graphics;
import java.io.*;
import java.util.*;

public class Obstacles extends Thread {
	int x1, x2, x3, x4;
	int y1, y2, y3, y4;
	Start s;
	Ball b;
	public Obstacles() {
		x1 = x3 = 0;
		y1 = 100;
		x2 = x4 = 380;
		y2 = 250;
		y3 = 400;
		y4 = 550;
	}

	public void draw(Graphics g) {

		g.setColor(Color.BLUE);
		g.fillRect(x1, y1, 200, 50);

		g.setColor(Color.CYAN);
		g.fillRect(x2, y2, 220, 50);

		g.setColor(Color.GREEN);
		g.fillRect(x3, y3, 200, 50);

		g.setColor(Color.YELLOW);
		g.fillRect(x4, y4, 220, 50);

	}

	public void move() {
		y1--;
		y2--;
		y3--;
		y4--;
		if (y1+100 < 0) {
			y1 = 580;
		} else if (y2+100 < 0) {
			y2 = 580;
		} else if (y3+100 < 0) {
			y3 = 580;
		} else if (y4+100 < 0) {
			y4 = 580;
		}
		
	}

	public void run() {
		while (true) {
			try {
				move();
				s.repaint();
				Thread.sleep(20);
			} catch (Exception e) {
				System.out.println("error");
			}
		}
	}

}
