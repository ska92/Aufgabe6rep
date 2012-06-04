
public abstract class Token {
	private String regex;
	private String token;
	
	public abstract boolean checkToken();
	public abstract String getToken();
}
