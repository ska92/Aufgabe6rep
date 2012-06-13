package lexer.tokens;

import java.io.BufferedReader;
import java.util.ArrayList;

import lexer.NoTokenFoundException;
import lexer.Token;

public class Kommentar extends Token{

	private ArrayList<Token> kommentarListe;
	
	public Kommentar(){
		kommentarListe = new ArrayList<Token>();
		kommentarListe.add(new EinzKommentar());
		kommentarListe.add(new JavaDocToken());
		kommentarListe.add(new MehrzKommentar());
	}
	
	@Override
	public String getHtml() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Token findToken(String s, BufferedReader br)
			throws NoTokenFoundException {
		// TODO Auto-generated method stub
		Token token = null;
		
		for(Token t : kommentarListe){
			try{
				token = t.findToken(s, br);
				return token;
			} catch(NoTokenFoundException e){}
		}
		
		throw new NoTokenFoundException("");
	}

}
