package lexer.tokens;

import java.io.BufferedReader;

import lexer.NoTokenFoundException;
import lexer.Token;

public class Zeilenumbruch extends Token{

	public Zeilenumbruch(){
		this.token = "\n";
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
		return null;
	}

}
