package ball_moving;

import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class Start extends Frame implements KeyListener {
	static Obstacles o;
	static Ball b;
	Image i1, i2;
	Graphics gra1, gra2;

	public Start() {
		setSize(600, 600);
		setTitle("ball moving game");
		setBackground(Color.BLACK);
		setVisible(true);
		setResizable(false);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		this.addKeyListener(this);
	}

	public void paint(Graphics g) {
		if (b != null && (b.y <= 25 || b.y > 590)) {
			this.dispose();
			System.exit(0);
		} else {

			if (i1 == null) {
				i1 = createImage(600, 600);
				gra1 = i1.getGraphics();
			}
			gra1.setColor(this.getBackground());
			gra1.fillRect(0, 0, 600, 600);
			gra1.setColor(this.getForeground());
			o.draw(gra1);
			b.draw(gra1);
			g.drawImage(i1, 0, 0, this);

		}

	}

	public static void main(String[] args) {
		Start s = new Start();
		o = new Obstacles();
		b = new Ball();
		b.s = s;
		o.s = s;
		b.o = o;
		o.b = b;
		o.start();
		b.start();

	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		if (arg0.getKeyCode() == arg0.VK_RIGHT) {
			b.moveRight();
		} else if (arg0.getKeyCode() == arg0.VK_LEFT) {
			b.moveLeft();
		}

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
}
