import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FileCopyFrontEnd {
	
	//������� ������
			JPanel windowContent = new JPanel();
			
			//������� ���������� � ������
			
			JLabel label1 = new JLabel("Copy from:");
			JTextField field1 = new JTextField();
			JFileChooser chooser1 = new JFileChooser();
			JButton button1 = new JButton("Browse");
			JLabel label2 = new JLabel("Copy to:");
			JTextField field2 = new JTextField();
			JFileChooser chooser2 = new JFileChooser();
			JButton button2 = new JButton("Browse");
			JButton button3 = new JButton("Copy");

	FileCopyFrontEnd() {
		
		
		//������ �������� ����������� ��� ���� ������
		GridLayout fl = new GridLayout(3,3,5,5);
		windowContent.setLayout(fl);
		
		
		
		//��������� ���������� �� ������
		
		windowContent.add(label1);
		windowContent.add(field1);
		windowContent.add(button1);
		windowContent.add(label2);
		windowContent.add(field2);
		windowContent.add(button2);
		windowContent.add(button3);
		
		//������� ����� � ������ ��� ���� ������
		
		JFrame frame = new JFrame("File Copy");
		frame.setContentPane(windowContent);
		
		//������ ������ � ������ ����� �������
		
		frame.setSize(500,200);
		frame.setVisible(true);
	
		FileCopyFrontEndEvents evnt = new FileCopyFrontEndEvents(this);
		button1.addActionListener(evnt);
		button2.addActionListener(evnt);
		button3.addActionListener(evnt);
		
	}
	public static void main(String[] args) {
		FileCopyFrontEnd exp = new FileCopyFrontEnd();
	}
}
