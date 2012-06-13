package lexer;

import java.io.BufferedReader;

public abstract class Token implements HtmlPrintable{
	
	protected String token;
	protected String regex;
	
	public Token(){
		this.token = null;
		this.regex = null;
	}
	
	public Token(String token){
		this.token = token;
	}
	
	public abstract Token findToken(String s, BufferedReader br) throws NoTokenFoundException;
	
	
	public String getToken(){ 
		return this.token;
	}
	
	public String getRegex(){
		return this.regex;
	}
}
