
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MyFileReader {

	public static void main(String[] args) {
		File f = new File("output.txt");
		FileReader fr = null;
		BufferedReader br = null;
		String line;
		int lineCount = 0;
		int wordCount = 0;
		int charCount = 0;
		try {
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			while ((line = br.readLine()) != null) {
				lineCount++;
				String[] arr = line.split(" ");
				for (String elem : arr) {
					wordCount++;
				}
				charCount += line.length();
//				System.out.println(line.split(" "));
			}
			
			System.out.println("Char Count : "+charCount);
			System.out.println("Word Count : "+wordCount);
			System.out.println("Line Count : "+lineCount);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
