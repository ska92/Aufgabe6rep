package lexer;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import lexer.tokens.AnnotationToken;
import lexer.tokens.Kommentar;
import lexer.tokens.Zeilenumbruch;

public class Lexer {
	
	public ArrayList<Token> parseToken(BufferedReader br) throws IOException{
		ArrayList<Token> tokenList = new ArrayList<Token>();
		
		Kommentar kommentar = new Kommentar();
		AnnotationToken annotation = new AnnotationToken();
		
		String zeile = null;
		while((zeile = br.readLine()) != null){
			Token token = null;
			
			//Kommentare
			try {
				token = kommentar.findToken(zeile, br);
				tokenList.add(token);
				tokenList.add(new Zeilenumbruch());
				continue;
			} catch (NoTokenFoundException e1) {}
			
			//Annotationen
			try {
				token = annotation.findToken(zeile, br);
				tokenList.add(token);
				tokenList.add(new Zeilenumbruch());
				continue;
			} catch (NoTokenFoundException e) {}
			
			//Splitten
			String[] teile = zeile.split(" ");
			for(String t : teile){
				//Keywords prüfen
				
				//Strings prüfen
				
				//Andere 
				
				
			}
			
			//Zeilenumbruch einfügen 
			tokenList.add(new Zeilenumbruch());
		}
		
		return tokenList;
	}

}
