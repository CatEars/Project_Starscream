package dialouge;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.badlogic.gdx.files.FileHandle;

//Unsure wheter this should go into dialouge package or util package
public class TextLoader {
	private String currentFile;
	private String[] dialouge;
	/**
	 * Reads a file and returns the lines as an array of strings
	 * Usefull for reading dialouge in the game
	 * @param filename
	 */
	public TextLoader(String filename){
		currentFile = filename;
		readFile(currentFile);
	}
	
	/**
	 * Reads a new file, specified by the filename
	 * @param filename - The file you want to read
	 */
	public void readFile(String filename){
		try {
			FileHandle fh = new FileHandle("src/dialouge/" + filename + ".txt");
			BufferedReader br = new BufferedReader(new FileReader(fh.file()));
			ArrayList<String> al = new ArrayList<String>();
			String curLine = br.readLine();			
			for (int i = 0;curLine != null; i++) {
				 al.add(curLine);
				curLine = br.readLine();
			}			
			dialouge = al.toArray(new String[al.size()]);
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			dialouge = new String[0];
			dialouge[0] = "";			
		}
	}
	
	/**
	 * returns the lines of a file as an array of strings
	 * @return
	 */
	public String[] getLines(){
		return dialouge;
	}
	
	public static String[] getLines(String filename){
		String[] dia;		
		try {
			FileHandle fh = new FileHandle("src/dialouge/" + filename + ".txt");
			BufferedReader br = new BufferedReader(new FileReader(fh.file()));
			ArrayList<String> al = new ArrayList<String>();
			String curLine = br.readLine();			
			for (int i = 0;curLine != null; i++) {
				 al.add(curLine);
				curLine = br.readLine();
			}			
			dia = al.toArray(new String[al.size()]);
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			dia = new String[1];
			dia[0] = "";
		}
		
		
		return dia;
	}
	
}
