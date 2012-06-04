import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;


public class Lexer {
	
	private BufferedReader reader;
	private ArrayList<String[]> token;
	private ArrayList<String> regex;
	private ArrayList<String> regexsplit;
	
	public Lexer (String datei) throws FileNotFoundException{
		reader = new BufferedReader(new FileReader(datei));
		token = new ArrayList<String[]>();
		regex = new ArrayList<String>();
		regexsplit = new ArrayList<String>();
		regex.add("^//.*");
		regexsplit.add("^//");
	}
	  
	
	public void read() throws IOException{
		String line;
		String[] array ;
		int counter = 0;
		
			while(reader.ready()){
				line = reader.readLine();
				for(String s : regex){
					if(line.matches(s)){
						System.out.println("Matches");
						array = line.split(regexsplit.get(0));
						token.add(array);
					}
				counter++;
				}
			}
		}
	
	public void gettokens(){
		for(String[] s : token){
			for(int i = 0; i< s.length;i++){
				System.out.println(s[i]);
			}
		}
	}
	}


