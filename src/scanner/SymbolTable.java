package scanner;
import java.util.HashMap;

public class SymbolTable {
	private HashMap<String,Token> table;
	public SymbolTable(){
		table = new HashMap<String,Token>();
	}
	public  HashMap<String, Token> getTable() {
		return table;
	}

	public  void setTable(HashMap<String, Token> value) {
		table = value;
	}
	
	public  void put(String key, Token value){
		table.put(key, value);
	}
	
	public  Token get(String key){
		return (Token)table.get(key);
	}
}
