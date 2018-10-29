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
	
	// Этот метод устанавливает размер
	// Вызывается виртуальной Java машиной
	
	public Dimension getPreferredSize() {
		
		return preferredSize;
	}
	
	// Конструктор. Создает обработчик событий мыши.
	
	PingPongGreenTable() {
		PingPongGameEngine gameEngine = new PingPongGameEngine(this);
		
		//обрабатывает клики мыши для отображения ее координат
		
		addMouseListener(gameEngine);
		
		// обрабатывает движения мыши для передвижения ракеток
		
		addMouseMotionListener(gameEngine);
	}
	
	// Добавить панель с JLabel в окно
	void addPaneltoFrame(Container container) {
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		
		container.add(this);
		
		label = new JLabel("Click to see coordinates");
		container.add(label);
	}
	
	// Перерисовать окно. Этот метод вызывается виртуальной машиной,
	// когда нужно обновить экран или вызывается метод repaint() из PingPointGameEngine
	
	public void paintComponent (Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.GREEN);
		
		// Нарисовать стол
		g.fillRect(0, 0, TABLE_WIDTH, TABLE_HEIGHT);
		g.setColor(Color.yellow);
		
		// Нарисовать правую ракетку
		g.fillRect(KID_RACKET_X_START, kidRacket_Y, 5, 30);
		g.setColor(Color.blue);
		
		// Нарисовать левую ракетку
		g.fillRect(ComputerRacket_X, 100, 5, 30);
		g.setColor(Color.red);
		
		// Нарисовать мяч
		g.fillOval(25, 110, 10, 10);
		g.setColor(Color.white);
		
		g.drawRect(10, 10, 300, 200);
		g.drawLine(160,10,160,210);
		
		// Отобразить точку как маленький квадрат 2х2 пикселей
		if (point != null) {
			
			label.setText("Coordinates (x,y): " + point.x + ", " + point.y);
			
			g.fillRect(point.x, point.y, 2, 2);
		}
	 }
}
