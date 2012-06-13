package lexer.tokens;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.regex.Pattern;

import lexer.NoTokenFoundException;
import lexer.Token;

public class JavaDocToken extends Token{

	@Override
	public String getHtml() {
		// TODO Auto-generated method stub
		return null;
	}

	
	/**
	 * 
	 */
	@Override
	public Token findToken(String s, BufferedReader br)
			throws NoTokenFoundException {
		if(Pattern.matches("\\p{Blank}*\\/\\*\\*", s)){
			String kommentar = s + "\n";
			String neueZeile = null;
			System.out.println("javadoc");
			try {
				while((neueZeile = br.readLine()) != null){
					kommentar = kommentar + neueZeile + "\n";
					if(Pattern.matches("\\p{Blank}*\\*\\/", neueZeile)){
						break;
					}
				}
				return new MehrzKommentar(kommentar);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				throw new NoTokenFoundException("");
			}
			
		}
		
		throw new NoTokenFoundException("");
	}

}
