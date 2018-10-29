import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class ScoreWriter {

	public static void main(String[] args) {
		
		FileWriter myFile = null;
		BufferedWriter buff = null;
		
		String[] scores = new String[3];
		
		scores[0] = "Oleg 500";
		scores[1] = "Elena 500";
		scores[2] = "Kseniya 500";
		
		try {
			
			myFile = new FileWriter("C:\\Users\\Alex\\Desktop\\scores.txt");
			
			buff = new BufferedWriter(myFile);
			
			for (int i = 0; i < scores.length; i++) {
				buff.write(scores[i]);
				
				System.out.println("Записывается " + scores[i]);
				
			}
			
			System.out.println("Запись файла завершена");
		}catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				
				buff.flush();
				buff.close();
				myFile.close();
			}catch (IOException e1) {
				e1.printStackTrace();
			}
		}

	}

}
