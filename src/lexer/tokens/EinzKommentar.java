package lexer.tokens;

import java.io.BufferedReader;
import java.util.regex.Pattern;

import lexer.NoTokenFoundException;
import lexer.Token;

public class EinzKommentar extends Token{

	public EinzKommentar(String s){
		super(s);
	}
	
	public EinzKommentar(){}
	
	@Override
	public String getHtml() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Token findToken(String s, BufferedReader br)
			throws NoTokenFoundException {
		// TODO Auto-generated method stub
		if(Pattern.matches("\\p{Blank}*//.*", s)){
			return new EinzKommentar(s);
		}
		throw new NoTokenFoundException("");
	}

}
