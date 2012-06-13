package lexer.tokens;

import java.io.BufferedReader;
import java.util.ArrayList;

import lexer.NoTokenFoundException;
import lexer.Token;

public class Keywords extends Token{
	
	private ArrayList<Token> keywordList;
	
	public Keywords(){
		keywordList = new ArrayList<Token>();
		
	}

	@Override
	public String getHtml() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Token findToken(String s, BufferedReader br)
			throws NoTokenFoundException {
		Token token = null;
		for(Token t : keywordList){
			try{
				token = t.findToken(s, br);
			}catch(NoTokenFoundException e){}
		}
		throw new NoTokenFoundException("");
	}

}
