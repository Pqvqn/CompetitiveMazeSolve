package engine;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;

import javax.swing.*;
public class Settings extends JFrame implements ActionListener, MouseListener {

	private MazeFrame parent;
	private JPanel UIPanel;
	private JButton[] buttons = { new JButton("Exit") };
	private JTextArea[] descriptions = { new JTextArea("Test") };
	private JTextArea[] fields = { new JTextArea("Test") };
	private Color buttonBackground;
	private Mode mode;
	private double mazeFidelity;
	private int aispeed;
	private int stagePreset;
	private String matchName;
	private int rows;
	private int cols;

	public Settings(MazeFrame parent, Mode mode, double mazeFidelity, int aispeed, String matchName,
			int rows, int cols) {
		super("Settings");
		UIPanel = new JPanel();
		this.parent = parent;
		Color parentBackground = parent.getBackground();
		this.buttonBackground = new Color(Math.max(parentBackground.getRed() - 100, 0),
				Math.max(parentBackground.getGreen() - 100, 0), Math.max(parentBackground.getBlue() - 100, 0), 220);
		this.mode = mode;
		this.mazeFidelity = mazeFidelity;
		this.aispeed = aispeed;
		this.stagePreset = stagePreset;
		this.matchName = matchName;
		this.rows = rows;
		this.cols = cols;

		setLayout(null);
		setSize(new Dimension(parent.getWidth() / 2, parent.getHeight() / 2));
		setLocationRelativeTo(parent);
		UIPanel.setLayout(null);
		UIPanel.setSize(getSize());
		UIPanel.setBackground(parent.getBackground());
		add(UIPanel);
		for (JButton b : buttons) {
			b.setSize(WIDTH / 5, HEIGHT / 5);
			b.setForeground(Color.WHITE);
			b.setBackground(buttonBackground);
			b.addActionListener(this);
			UIPanel.add(b);
		}
		buttons[0].setLocation(600, -600);
		buttons[0].setVisible(true);
		setVisible(true);
		setFocusable(true);
		requestFocus();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttons[0]) {
			new MazeFrame(mode, mazeFidelity, aispeed, matchName, rows, cols);
			parent.setVisible(false);
			Thread t = parent.getThread();
			if (t != null)
				t.interrupt();
			System.gc();
		}

	}
}
