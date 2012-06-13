package lexer.tokens;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.regex.Pattern;

import lexer.NoTokenFoundException;
import lexer.Token;

public class MehrzKommentar extends Token{
	
	public MehrzKommentar(String s){
		super(s);
	}
	
	public MehrzKommentar(){}

	@Override
	public String getHtml() {
		return null;
	}
	
	/*
	 * (non-Javadoc)
	 * @see lexer.Token#findToken(java.lang.String, java.io.BufferedReader)
	 */

	@Override
	public Token findToken(String s, BufferedReader br)
			throws NoTokenFoundException {
		if(Pattern.matches("\\p{Blank}*\\/\\*", s)){
			String kommentar = s + "\n";
			String neueZeile = null;
			
			System.out.println("alter mehrz: " +kommentar);
			
			try {
				while((neueZeile = br.readLine()) != null){
					kommentar = kommentar + neueZeile + "\n";
					if(Pattern.matches("\\p{Blank}*\\*\\/", neueZeile)){
						break;
					}
				}
				System.out.println("mehrz: " +kommentar);
				return new MehrzKommentar(kommentar);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				throw new NoTokenFoundException("");
			}
			
		}
		
		throw new NoTokenFoundException("");
	}

}
