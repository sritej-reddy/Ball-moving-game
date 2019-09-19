package ball_moving;

import java.lang.*;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class Ball extends Thread {
	int x, y, xdir, ydir;
	Start s;
	Obstacles o;

	public Ball() {

		x = 85;
		y = 200;

	}

	public void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillOval(x, y, 20, 20);
	}

	public void move() {

		if ((x > 198 && x + 18 < 380)) {
			y = y + 1;
		} else {
			some();
		}
	}

	public void some() {
		if (x <= 198) {
			if (o.y1 < o.y3) {
				if (y + 20 < o.y1 - 1) {
					// System.out.println("\ni");
					y++;
				} else if (y + 20 == o.y1 - 1 || y + 20 == o.y1 || y + 20 == o.y1 + 1) {
					// System.out.println("\nj");
					y = o.y1 - 20;
				} else if (y + 20 < o.y3 - 1 && y + 20 > o.y1) {
					// System.out.println("\nk");
					y++;
				} else if (y + 20 == o.y3 - 1 || y + 20 == o.y3 || y + 20 == o.y3 + 1) {
					// System.out.println("\nl");
					y = o.y3 - 20;
				} else {
					// System.out.println("\nm");
					y++;
				}

			} else {
				if (y + 20 < o.y3 - 1) {
					// System.out.println("\nn");
					y++;
				} else if (y + 20 == o.y3 - 1 || y + 20 == o.y3 || y + 20 == o.y3 + 1) {
					// System.out.println("\no");
					y = o.y3 - 20;
				} else if (y + 20 < o.y1 - 1 && y + 20 > o.y3) {
					// System.out.println("\np");
					y++;
				} else if (y + 20 == o.y1 - 1 || y + 20 == o.y1 || y + 20 == o.y1 + 1) {
					// System.out.println("\nq");
					y = o.y1 - 20;
				} else {
					// System.out.println("\nr");
					y++;
				}
			}
		} else {
			if (o.y2 < o.y4) {
				if (y + 20 < o.y2 - 1) {
					y++;
				} else if (y + 20 == o.y2 - 1 || y + 20 == o.y2 || y + 20 == o.y2 + 1) {
					y = o.y2 - 20;
				} else if (y + 20 < o.y4 - 1 && y + 20 > o.y2) {
					y++;
				} else if (y + 20 == o.y4 - 1 || y + 20 == o.y4 || y + 20 == o.y4 + 1) {
					y = o.y4 - 20;
				} else {
					y++;
				}
			} else {
				if (y + 20 < o.y4 - 1) {
					y++;
				} else if (y + 20 == o.y4 - 1 || y + 20 == o.y4 || y + 20 == o.y4 + 1) {
					y = o.y4 - 20;
				} else if (y + 20 < o.y2 - 1 && y + 20 > o.y4) {
					y++;
				} else if (y + 20 == o.y2 - 1 || y + 20 == o.y2 || y + 20 == o.y2 + 1) {
					y = o.y2 - 20;
				} else {
					y++;
				}
			}
		}
	}

	public void moveRight() {
		if (x + 5 >= 360 && x + 5 <= 365) {
			if ((y < o.y2 + 50 && y + 20 > o.y2) || (y < o.y4 + 50 && y + 20 > o.y4)) {
				x = 359;
			} else {
				x = x + 5;
			}
		} else if (x < 355 || (x > 363 && x + 5 < 578)) {
			x = x + 5;
		}
	}

	public void moveLeft() {
		if (x - 5 <= 200 && x-5>=205 ) {
			if ((y < o.y1 + 50 && y + 20 > o.y1) || (y < o.y3 + 50 && y + 20 > o.y3)) {
				x = 200;
			} else 
				x = x - 5;
		} else if (x > 205 || (x<205 && x-5>2)) {
			x = x - 5;
		}

		// if(x>4)
		// x=x-5;
	}

	public void run() {
		while (true) {
			try {
				move();
				Thread.sleep(15);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
