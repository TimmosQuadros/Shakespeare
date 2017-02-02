import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;



public class FileHandler {

	public static void main(String[] args) {
		FileHandler fh = new FileHandler();

		fh.loadTextFromFile("C:/temp/test.txt");
	}

	public ArrayList<String> loadTextFromFile(String filename)
	{
		ArrayList<String> words = new ArrayList<>();
		String NewLine;

		FileReader TheFileReader;
		BufferedReader TheBufferedReader;

		try {
			TheFileReader = new FileReader(new File(filename));
			TheBufferedReader = new BufferedReader(TheFileReader);

			while((NewLine = TheBufferedReader.readLine()) != null){
				String[] cleanLine = NewLine.replaceAll("[^a-zA-Z ]", "").toLowerCase().split(" "); //removes all non characters
				for (String word : cleanLine) {
					if(!word.equalsIgnoreCase("")){
						//System.out.print(string+" ");
						words.add(word);
					}
				}
			}

			TheBufferedReader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return words;
	}

}
