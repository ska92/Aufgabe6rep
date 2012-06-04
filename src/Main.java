import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Lexer lex = new Lexer("test.txt");
			lex.read();
			lex.gettokens();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
