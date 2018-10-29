import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;

public class FileCopyFrontEndEvents implements ActionListener {
	FileCopyFrontEnd parent;
	
	
	public FileCopyFrontEndEvents(FileCopyFrontEnd parent){
		this.parent = parent;
		}
	
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if(src == parent.button1) {
			JFileChooser chooser = new JFileChooser();
			int ret = chooser.showDialog(null, "Открыть файл");
			if(ret == JFileChooser.APPROVE_OPTION) {
				File file = chooser.getSelectedFile();
				parent.field1.setText(file.getAbsolutePath());
			}
		}
		if(src == parent.button2) {
			JFileChooser chooser = new JFileChooser();
			int ret = chooser.showDialog(null, "Открыть файл");
			if(ret == JFileChooser.APPROVE_OPTION) {
				File file = chooser.getSelectedFile();
				parent.field2.setText(file.getAbsolutePath());
			}
		}
		if(src == parent.button3) {
			
			FileReader myFile = null;
			
			try {
				myFile = new FileReader(parent.field1.getText());
			} catch (FileNotFoundException e2) {
				
				e2.printStackTrace();
			};
			
			BufferedReader buff = new BufferedReader(myFile);
			File aFile = new File(parent.field2.getText());
			try {
				aFile.createNewFile();
			} catch (IOException e2) {

				e2.printStackTrace();
			}
			FileWriter myNewFile = null;
			try {
				myNewFile = new FileWriter(aFile);
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			BufferedWriter newBuff = new BufferedWriter(myNewFile);
			
			
			try {
				
				while(true) {
					String line = buff.readLine();
					
					if (line == null) break;
					
					newBuff.write(line);
					
				}
			}catch (IOException i) {
				i.printStackTrace();
			} finally {
				try {
					buff.close();
					myFile.close();
					newBuff.flush();
					newBuff.close();
					myNewFile.close();
				}catch(IOException e1) {
					e1.printStackTrace();
				}
			}
		}
		
	}

}
