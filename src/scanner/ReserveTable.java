package scanner;
import java.util.HashMap;

public class ReserveTable {
	private static HashMap<String,Token> table;

	public static HashMap<String, Token> getTable() {
		return table;
	}

	public static void setTable(HashMap<String, Token> value) {
		table = value;
	}
	
	public static void put(String key, Token value){
		table.put(key, value);
	}
	
	public static Token get(String key){
		return (Token)table.get(key);
	}
}
