package scanner;

public class Token {
	private String name;
	private String value;
	private String lexeme;
	private String expectedType;
	private String actualType;
	private String errorMessage;
	
	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Token(String name){
		this(name, "");
	}
	
	public Token(String name, String lexeme){
		this(name,lexeme,"","","");
	}
	public Token(String name, String lexeme, String value, String expectedType, String actualType){
		this.name = name;
		this.lexeme = lexeme;
		this.value = value;
		this.expectedType = expectedType;
		this.actualType = actualType;
		errorMessage ="";
	}
	public String getExpectedType() {
		return expectedType;
	}

	public void setExpectedType(String expectedType) {
		this.expectedType = expectedType;
	}

	public String getActualType() {
		return actualType;
	}

	public void setActualType(String actualType) {
		this.actualType = actualType;
	}

	public String getLexeme() {
		return lexeme;
	}

	public void setLexeme(String lexeme) {
		this.lexeme = lexeme;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public void addNameChar(char c){
		this.name += c;
	}
	public void addValueChar(char c){
		this.value += c;
	}
	public void addLexemeChar(char c){
		this.lexeme += c;
	}
	public String toString(){
		if(lexeme.length() == 0){
			return "["+name+"]";
		}
		else
			return "["+name+", "+lexeme+"]";
	}
}
