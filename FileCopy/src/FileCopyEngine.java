import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.BufferedReader;
import java.io.IOException;

public class FileCopyEngine {

	public static void main(String[] args) throws IOException {
		
		FileReader myFile = new FileReader(args[0]);;
		BufferedReader buff = new BufferedReader(myFile);
		File aFile = new File(args[1]);
		aFile.createNewFile();
		FileWriter myNewFile = new FileWriter(aFile);
		BufferedWriter newBuff = new BufferedWriter(myNewFile);
		
		try {
			
			while(true) {
				String line = buff.readLine();
				
				if (line == null) break;
				
				newBuff.write(line);
				
			}
			System.out.println("File copyed sucsessfully");
		}catch (IOException e) {
			e.printStackTrace();
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

