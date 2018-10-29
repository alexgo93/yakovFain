package screens;

import javax.swing.*;
import java.awt.*;
import engine.PingPongGameEngine;

public class PingPongGreenTable extends JPanel implements GameConstants {
	
	JLabel label;
	
	public Point point = new Point();
	public int ComputerRacket_X = 15;
	private int kidRacket_Y = KID_RACKET_Y_START;
	
	Dimension preferredSize = new Dimension(TABLE_WIDTH,TABLE_HEIGHT);
	
	// ���� ����� ������������� ������
	// ���������� ����������� Java �������
	
	public Dimension getPreferredSize() {
		
		return preferredSize;
	}
	
	// �����������. ������� ���������� ������� ����.
	
	PingPongGreenTable() {
		PingPongGameEngine gameEngine = new PingPongGameEngine(this);
		
		//������������ ����� ���� ��� ����������� �� ���������
		
		addMouseListener(gameEngine);
		
		// ������������ �������� ���� ��� ������������ �������
		
		addMouseMotionListener(gameEngine);
	}
	
	// �������� ������ � JLabel � ����
	void addPaneltoFrame(Container container) {
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		
		container.add(this);
		
		label = new JLabel("Click to see coordinates");
		container.add(label);
	}
	
	// ������������ ����. ���� ����� ���������� ����������� �������,
	// ����� ����� �������� ����� ��� ���������� ����� repaint() �� PingPointGameEngine
	
	public void paintComponent (Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.GREEN);
		
		// ���������� ����
		g.fillRect(0, 0, TABLE_WIDTH, TABLE_HEIGHT);
		g.setColor(Color.yellow);
		
		// ���������� ������ �������
		g.fillRect(KID_RACKET_X_START, kidRacket_Y, 5, 30);
		g.setColor(Color.blue);
		
		// ���������� ����� �������
		g.fillRect(ComputerRacket_X, 100, 5, 30);
		g.setColor(Color.red);
		
		// ���������� ���
		g.fillOval(25, 110, 10, 10);
		g.setColor(Color.white);
		
		g.drawRect(10, 10, 300, 200);
		g.drawLine(160,10,160,210);
		
		// ���������� ����� ��� ��������� ������� 2�2 ��������
		if (point != null) {
			
			label.setText("Coordinates (x,y): " + point.x + ", " + point.y);
			
			g.fillRect(point.x, point.y, 2, 2);
		}
	 }
}
