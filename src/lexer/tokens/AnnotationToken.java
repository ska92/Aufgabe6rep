package lexer.tokens;

import java.io.BufferedReader;
import java.util.regex.Pattern;

import lexer.NoTokenFoundException;
import lexer.Token;

public class AnnotationToken extends Token{
	
	public AnnotationToken(){}
	
	public AnnotationToken(String s){
		super(s);
	}
	
	public Token findToken(String s, BufferedReader br) throws NoTokenFoundException{
		if(Pattern.matches( "\\p{Blank}*@.+", s)){
			return new AnnotationToken(s);
		}
		throw new NoTokenFoundException("");
	}

	@Override
	public String getHtml() {
		// TODO Auto-generated method stub
		return null;
	}

}
