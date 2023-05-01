package scanner;
import java.util.HashMap;

public class MgaDFA {
	
	private Token token;
	private fileIO file;
	private String error;
	private int line;
	
	public MgaDFA(){
		line = 1;
		error = "";
		HashMap<String, Token> reserve = new HashMap<String, Token>();
		HashMap<String, Token> symbol = new HashMap<String, Token>();
		ReserveTable.setTable(reserve);
		//SymbolTable.setTable(symbol);
	}
	public fileIO getFile() {
		return file;
	}
	public void setFile(fileIO file) {
		this.file = file;
	}
	public void setToken(Token token) {
		this.token = token;
	}
	
	public int getLine() {
		return line;
	}
	public void setLine(int line) {
		this.line = line;
	}
	public Token getToken(){
		error = "";
		token  = new Token("");
		if(isWhiteSpace(file)){
			token.setName("SKIP");
		}
		else if(isSLINE_COMMENT(file)){
			
		}
		else if(isWHT_SPAC_TAB(file)){
			
		}
		else if(isSIMULA(file)){
			
		}
		else if(isREL_OP(file)){
			
		}
		else if(isEQU_OP(file)){
			
		}
		else if(isSequal(file)){
			
		}
		else if(isOP_PARENTHESIS(file)){
			
		}
		else if(isOP_BRACKET(file)){
			
		}
		else if(isOP_BRACE(file)){
			
		}
		else if(isMLINE_COMMENT(file)){
			
		}
		else if(isLOG_XOR(file)){
			
		}
		else if(isLOG_XNOR(file)){
			
		}
		else if(isLOG_OR(file)){
			
		}
		else if(isLOG_NOTANDOR(file)){
			
		}
		else if(isLOG_AND(file)){
			
		}
		else if(isLOG_NOT(file)){
			
		}
		else if(isDELIM(file)){
			
		}
		else if(isCOMMA(file)){
			
		}
		else if(isCL_PARENTHESIS(file)){
			
		}
		else if(isCL_BRACKET(file)){
			
		}
		else if(isCL_BRACE(file)){
			
		}
		else if(isASS_OP(file)){
			
		}
		else if(isARITH_OP_HIGHP(file)){
			
		}
		else if(isARITH_OP_LOWP(file)){
			
		}
		else if(isTAPOS(file)){
			
		}
		else if(isMake_pasok(file)){
			
		}
		else if(ismake_pili(file)){
			
		}
		else if(isThen_ikot(file)){
			
		}
		else if(isWhile_true(file)){
			
		}
		else if(isUmikot_until(file)){
			
		}
		else if(isIpakita_this(file)){
			
		}
		else if(isipilit(file)){
			
		}
		else if(isBasahin_this(file)){
			
		}
		else if(iskunin_part(file)){
			
		}
		else if(iskung_true(file)){
			
		}
		else if(iskung_not(file)){
			
		}
		else if(islast_na(file)){
			
		}
		else if(iscase(file)){
			
		}
		else if(isno_choice_me(file)){
			
		}
		else if(isDATA_TYPE(file)){
			
		}
		else if(isdugtong(file)){
			
		}
		else if(isedi_kung(file)){
			
		}
		else if(ishanapin(file)){
			
		}
		else if(ishaba(file)){
			
		}
		else if(ispunta(file)){
			
		}
		else if(isputol(file)){
			
		}
		else if(isC_BOOLEAN(file)){
			
		}
		else if(isIDENT(file)){
			
		}
		else if(isCOLON(file)){
			
		}
		else if(isC_INT(file)){
			
		}
		else if(isC_Char(file)){
			
		}

		else if(isC_FLOAT(file)){
			
		}

		else if(isC_STR(file)){
			
		}

		else if(isC_DOUBLE(file)){
			
		}
		else if(isEOF(file)){
			if(token.getName().equalsIgnoreCase("eol"))
				line++;
		}
		else{
			token.setName("UNDEFINED, Line: "+line);
			token.setLexeme(error);
			file.setEnd(file.getEnd() + error.length());
			file.finalize();
		}
		
		return token;
	}
	public boolean isWhiteSpace(fileIO file){
		char c = file.getChar();
		file.increment();
		if(c == ' '){
			file.finalize();
			return true;
		}
		else{
			file.reset();
			return false;
		}
	}
	public boolean isWHT_SPC_LINEBRK(fileIO file) { //image 3 NOT USED
		String state = "start";
		char c;
		while(true) {
			switch(state) {
				case "start":
					c = file.getChar();
					file.increment();
					if(c == '\\')
						state = "1";
					else {
						state = "fail";
					}
					break;
				case "1":
					c = file.getChar();
					if(c == 'n')
						state = "success";
					else
						state = "fail";
					break;
				case "success":
					token = new Token("SKIP");
					state = "end";
					file.finalize();
					return true;
				case "fail":
					state = "end";
					file.reset();
					return false;
			}
		}
	}
	public boolean isWHT_SPAC_TAB(fileIO file) { //image 3
		String state = "start";
		char c;
		while(true) {
			switch(state) {
				case "start":
					c = file.getChar();
					file.increment();
					if(c == '\t')
						state = "success";
					else {
						state = "fail";
					}
					break;
				case "success":
					token = new Token("SKIP");
					file.finalize();
					return true;
				case "fail":
					file.reset();
					return false;
			}
		}
	}
	public boolean isSLINE_COMMENT(fileIO file) { //image 4
		String state = "start";
		char c;
		while(true) {
			switch(state) {
				case "start":
					c = file.getChar();
					file.increment();
					if(c == '/')
						state = "1";
					else {
						state = "fail";
					}
					break;
				case "1":
					c = file.getChar();
					file.increment();
					if(c == '/')
						state = "2";
					else
						state = "fail";
					break;
				case "2":
					c = file.getChar();
					file.increment();
					if(c == '`'){
						file.pushBack();
						
						state = "success";
					}
					else
						state = "2";
					break;
				case "success":
					token = new Token("SKIP");
					file.finalize();
					return true;
				case "fail":
					file.reset();
					return false;
			}
			if(state.equals("end"))
				break;
			
		}
		return state.equals("success") ? true : false;
	}
	public boolean isSIMULA(fileIO file) {// 6.png checked
		String state = "start";
		char c;
		while(true) {
			switch(state) {
				case "start":
					c = file.getChar();
					file.increment();
					if(c == 'S')
						state = "1";
					else {
						state = "fail";
					}
					break;
				case "1":
					c = file.getChar();
					file.increment();
					if(c == 'I')
						state = "2";
					else 
						state = "fail";
					break;
				case "2":
					c = file.getChar();
					file.increment();
					if(c == 'M')
						state = "3";
					else 
						state = "fail";
					break;
				case "3":
					c = file.getChar();
					file.increment();
					if(c == 'U')
						state = "4";
					else 
						state = "fail";
					break;
				case "4":
					c = file.getChar();
					file.increment();
					if(c == 'L')
						state = "5";
					else
						state = "fail";
					break;
				case "5":
					c = file.getChar();
					file.increment();
					if(c == 'A')
						state = "success";
					else
						state = "fail";
				case "success":
					token = new Token("SIMULA");
					file.finalize();
					return true;
				case "fail":
					setError(file.getError());
					file.reset();
					return false;
			}
			
			if(state.equals("end"))
				break;
		}
		return state.equals("success") ? true : false;
	}
	public boolean isREL_OP(fileIO file) { // 2.png checked
		String state = "start";
		char c;
		while(true) {
			switch(state) {
				case "start":
					c = file.getChar();
					file.increment();
					if(c == 'S')
						state = "1";
					else if(c == '<')
						state = "13";
					else if(c == '>')
						state = "14";
					else
						state = "fail";
					break;
				case "1":
					c = file.getChar();
					file.increment();
					if(c == 'g')
						state = "2";
					else if(c == 'l')
						state = "8";
					else
						state = "fail";
					break;
				case "2":
					c = file.getChar();
					file.increment();
					if(c == 'r')
						state = "3";
					else {
						state = "fail";
					}
					break;
				case "3":
					c = file.getChar();
					file.increment();
					if(c == 'e')
						state = "4";
					else {
						state = "fail";
					}
					break;
				case "4":
					c = file.getChar();
					file.increment();
					if(c == 'a')
						state = "5";
					else {
						state = "fail";
					}
					break;
				case "5":
					c = file.getChar();
					file.increment();
					if(c == 't')
						state = "6";
					else {
						state = "fail";
					}
					break;
				case "6":
					c = file.getChar();
					file.increment();
					if(c == 'e')
						state = "7";
					else {
						state = "fail";
					}
					break;
				case "7":
					c = file.getChar();
					file.increment();
					if(c == 'r'){
						state = "success";
						token = new Token("REL_OP", "Sgreater");
					} else {
						state = "fail";
					}
					break;
				case "8":
					c = file.getChar();
					file.increment();
					if(c == 'e')
						state = "9";
					else {
						state = "fail";
					}
					break;
				case "9":
					c = file.getChar();
					file.increment();
					if(c == 's')
						state = "10";
					else {
						state = "fail";
					}
					break;
				case "10":
					c = file.getChar();
					file.increment();
					if(c == 's')
						state = "11";
					else {
						state = "fail";
					}
					break;
				case "11":
					c = file.getChar();
					file.increment();
					if(c == 'e')
						state = "12";
					else {
						state = "fail";
					}
					break;
				case "12":
					c = file.getChar();
					file.increment();
					if(c == 'r'){
						state = "success";
						token = new Token("REL_OP", "Slesser");
					} else {
						state = "fail";
					}
					break;
				case "success":
					file.finalize();
					return true;
				case "fail":
					setError(file.getError());
					file.reset();
					return false;
				case "13":
					c = file.getChar();
					file.increment();
					if(c == '='){
						token = new Token("REL_OP", "<=");
						state = "success";
					}else {
						token = new Token("REL_OP", "<");
						file.pushBack();
						state = "success";
					}
					break;
				case "14":
					c = file.getChar();
					file.increment();
					if(c == '='){
						token = new Token("REL_OP", ">=");
						state = "success";
					} else {
						token = new Token("REL_OP", ">");
						file.pushBack();
						state = "success";
					}
					break;
			}
		}
	}
	public boolean isOP_PARENTHESIS(fileIO file) { // 4.png checked
		String state = "start";
		char c;
		while(true) {
			switch(state) {
				case "start":
					c = file.getChar();
					file.increment();
					if(c == '(')
						state = "success";
					else {
						state = "fail";
					}
					break;
				case "success":
					token = new Token("OP_PARENTHESIS", "(");
					file.finalize();
					return true;
				case "fail":
					setError(file.getError());
					file.reset();
					return false;
			}
		}
		
	}
	public boolean isOP_BRACKET(fileIO file) { // 5.png checked
		String state = "start";
		char c;
		while(true) {
			switch(state) {
				case "start":
					c = file.getChar();
					file.increment();
					if(c == '[')
						state = "success";
					else {
						state = "fail";
					}
					break;
				case "success":
					token = new Token("OP_BRACKET", "[");
					file.finalize();
					return true;
				case "fail":
					setError(file.getError());
					file.reset();
					return false;
			}
		}
	}
	public boolean isOP_BRACE(fileIO file) { // 5.png
		String state = "start";
		char c;
		while(true) {
			switch(state) {
				case "start":
					c = file.getChar();
					file.increment();
					if(c == '{')
						state = "success";
					else {
						state = "fail";
					}
					break;
				case "success":
					token = new Token("OP_BRACE", "{");
					file.finalize();
					return true;
				case "fail":
					setError(file.getError());
					file.reset();
					return false;
			}
		}
	}
	public boolean isMLINE_COMMENT(fileIO file) { // 4.png
		String state = "start";
		char c;
		while(true) {
			switch(state) {
				case "start":
					c = file.getChar();
					file.increment();
					if(c == '/')
						state = "1";
					else {
						state = "fail";
					}
					break;
				case "1":
					c = file.getChar();
					file.increment();
					if(c == '*')
						state = "2";
					else 
						state = "fail";
					break;
				case "2":
					c = file.getChar();
					file.increment();
					if(c == '*')
						state = "3";
					else 
						state = "2";
					break;
				case "3":
					c = file.getChar();
					file.increment();
					if(c == '/')
						state = "success";
					else
						state = "fail";
					break;
				case "success":
					token = new Token("SKIP"); 
					file.finalize();
					return true;
				case "fail":
					setError(file.getError());
					file.reset();
					return false;
			}
			if(state.equals("end"))
				break;
			
		}
		return state.equals("success") ? true : false;
	}
	public boolean isLOG_XOR(fileIO file) {
		String state = "start";
		char c;
		while (true) {
			switch(state) {
				case "start":
					c = file.getChar();
					file.increment();
					if(c == '@')
						state = "success";
					else {
						state = "fail";
					}
					break;
				case "success":
					token = new Token("LOG_XOR");
					token.setLexeme("@");
					file.finalize();
					return true;
				case "fail":
					setError(file.getError());
					file.reset();
					return false;
			}
			if(state.equals("end"))
				break;
		}
		return state.equals("success") ? true : false;
	}
	public boolean isLOG_XNOR(fileIO file) {
		String state = "start";
		char c;
		while (true) {
			switch(state) {
				case "start":
					c = file.getChar();
					file.increment();
					if(c == '!')
						state = "1";
					else {
						state = "fail";
					}
					break;
				case "1":
					c = file.getChar();
					file.increment();
					if(c == '@')
						state = "success";
					else
						state = "fail";
					break;
				case "success":
					token = new Token("LOG_XNOR");
					token.setLexeme("!@");
					file.finalize();
					return true;
				case "fail":
					setError(file.getError());
					file.reset();
					return false;
			}
		}
	}
	public boolean isLOG_OR(fileIO file) { // 3.png
		String state = "start";
		char c;
		while(true) {
			switch(state) {
				case "start":
					c = file.getChar();
					file.increment();
					if(c == '|')
						state = "1";
					else {
						state = "fail";
					}
					break;
				case "1":
					c = file.getChar();
					file.increment();
					if(c == '|')
						state = "success";
					else
						state = "fail";
					break;
				case "success":
					token = new Token("LOG_OR");
					token.setLexeme("||");
					file.finalize();
					return true;
				case "fail":
					setError(file.getError());
					file.reset();
					return false;
			}
		}
	}
	public boolean isLOG_NOTANDOR(fileIO file) {
		String state = "start";
		char c;
		while(true) {
			switch(state) {
				case "start":
					c = file.getChar();
					file.increment();
					if(c == '!')
						state = "1";
					else {
						state = "fail";
					}
					break;
				case "1":
					c = file.getChar();
					file.increment();
					if(c == '&'){
						token = new Token("LOG_NOTANDOR", "!&");
						state = "success";
					}else if(c == '|'){
						token = new Token("LOG_NOTANDOR", "!|");
						state = "success";
					}else
						state = "fail";
					break;
				case "success":
					file.finalize();
					return true;
				case "fail":
					setError(file.getError());
					file.reset();
					return false;
			}
		}
	}
	public boolean isLOG_AND(fileIO file) {
		String state = "start";
		char c;
		while(true) {
			switch(state) {
				case "start":
					c = file.getChar();
					file.increment();
					if(c == '&')
						state = "1";
					else {
						state = "fail";
					}
					break;
				case "1":
					c = file.getChar();
					file.increment();
					if(c == '&')
						state = "success";
					else
						state = "fail";
					break;
				case "success":
					token = new Token("LOG_AND", "&&");
					file.finalize();
					return true;
				case "fail":
					setError(file.getError());
					file.reset();
					return false;
			}
			if(state.equals("end"))
				break;
			
		}
		return state.equals("success") ? true : false;
	}
	public boolean isDELIM(fileIO file) {
		String state = "start";
		char c;
		while(true) {
			switch(state) {
				case "start":
					c = file.getChar();
					file.increment();
					if(c == ';')
						state = "success";
					else {
						state = "fail";
					}
					break;
				case "success":
					token = new Token("DELIM", ";");
					file.finalize();
					return true;
				case "fail":
					setError(file.getError());
					file.reset();
					return false;
			}
			if(state.equals("end"))
				break;
		}
		return state.equals("success") ? true : false;
	}
	public boolean isEQU_OP(fileIO file) {
		String state = "start";
		char c;
		while(true) {
			switch(state) {
				case "start":
					c = file.getChar();
					file.increment();
					if(c == '=')
						state = "1";
					else if(c == '!')
						state = "2";
					else 
						state = "fail";
					break;
				case "1":
					c = file.getChar();
					file.increment();
					if(c == '='){
						state = "success";
						token = new Token("EQU_OP", "==");
					} else
						state = "fail";
					break;
				case "2":
					c = file.getChar();
					file.increment();
					if(c == '='){
						state = "success";
						token = new Token("EQU_OP", "!=");
					} else
						state = "fail";
					break;
				case "success":
					file.finalize();
					return true;
				case "fail":
					setError(file.getError());
					file.reset();
					return false;
			}
			if(state.equals("end"))
				break;
			
		}
		return state.equals("success") ? true : false;
	}
	public boolean isCOMMA(fileIO file) { // 5.png
		String state = "start";
		char c;
		while(true) {
			switch(state) {
				case "start":
					c = file.getChar();
					file.increment();
					if(c == ',')
						state = "success";
					else {
						state = "fail";
					}
					break;
				case "success":
					token = new Token("COMMA", ",");
					file.finalize();
					return true;
				case "fail":
					setError(file.getError());
					file.reset();
					return false;
			}
			if(state.equals("end"))
				break;
		}
		return state.equals("success") ? true : false;
	}
	public boolean isCL_PARENTHESIS(fileIO file) { // 4.png
		String state = "start";
		char c;
		while(true) {
			switch(state) {
				case "start":{
					c = file.getChar();
					file.increment();
					if(c == ')')
						state = "success";
					else {
						state = "fail";
					}
					break;
				}
				case "success":{
					token = new Token("CL_PARENTHESIS", "(");
					file.finalize();
					return true;
				}
				case "fail":{
					setError(file.getError());
					file.reset();
					return false;
				}
			}
		}
	}
	public boolean isCL_BRACKET(fileIO file) { // 5.png
		String state = "start";
		char c;
		while(true) {
			switch(state) {
				case "start":
					c = file.getChar();
					file.increment();
					if(c == ']')
						state = "sucess";
					else {
						state = "fail";
					}
					break;
				case "success":
					token = new Token("CL_BRACKET", "]");
					file.finalize();
					return true;
				case "fail":
					setError(file.getError());
					file.reset();
					return false;
			}
			if(state.equals("end"))
				break;
		}
		return state.equals("success") ? true : false;
	}
	public boolean isCL_BRACE(fileIO file) { // 5.png
		String state = "start";
		char c;
		while(true) {
			switch(state) {
				case "start":
					c = file.getChar();
					file.increment();
					if(c == '}')
						state = "success";
					else {
						state = "fail";
					}
					break;
				case "success":
					token = new Token("CL_BRACE", "}");
					file.finalize();
					return true;
				case "fail":
					setError(file.getError());
					file.reset();
					return false;
			}
		}
	}
	public boolean isASS_OP(fileIO file) { // 3.png
		String state = "start";
		char c;
		while(true) {
			switch(state) {
				case "start":
					c = file.getChar();
					file.increment();
					if(c == ':')
						state = "1";
					else {
						state = "fail";
					}
					break;
				case "1":
					c = file.getChar();
					file.increment();
					if(c == '=')
						state = "success";
					else
						state = "fail";
					break;
				case "success":
					token = new Token("ASS_OP", ":=");
					file.finalize();
					return true;
				case "fail":
					setError(file.getError());
					file.reset();
					return false;
			}
		}
	}
	public boolean isARITH_OP_LOWP(fileIO file) {
		String state = "start";
		char c;
		while (true) {
			switch(state) {
				case "start":
					c = file.getChar();
					file.increment();
					if(c == '+'){
						token = new Token("ARITH_OP_LOWP", "+");
						state = "success";
					} else if(c == '-'){
						token = new Token("ARITH_OP_LOWP", "-");
						state = "success";
					} else 
						state = "fail";
					break;
				case "success":
					file.finalize();
					return true;
				case "fail":
					setError(file.getError());
					file.reset();
					return false;
			}
		}
	}
	public boolean isARITH_OP_HIGHP(fileIO file) {
		String state = "start";
		char c;
		while (true) {
			switch(state) {
				case "start":
					c = file.getChar();
					file.increment();
					if(c == '*'){
						token = new Token("ARITH_OP_HIGHP", "*");
						state = "success";
					} else if(c == '/') {
						token = new Token("ARITH_OP_HIGHP", "/");
						state = "success";
					} else 
						state = "fail";
					break;
				case "success":
					file.finalize();
					return true;
				case "fail":
					setError(file.getError());
					file.reset();
					return false;
			}
		}
	}
	public boolean isTAPOS(fileIO file) { //image 6
		String state = "start";
		char c;
		while(true) {
			switch(state) {
				case "start":
					c = file.getChar();
					file.increment();
					if(c == 'T')
						state = "1";
					else {
						state = "fail";
					}
					break;
				case "1":
					c = file.getChar();
					file.increment();
					if(c == 'A')
						state = "2";
					else 
						state = "fail";
					break;
				case "2":
					c = file.getChar();
					file.increment();
					if(c == 'P')
						state = "3";
					else
						state = "fail";
					break;
				case "3":
					c = file.getChar();
					file.increment();
					if(c == 'O')
						state = "4";
					else
						state = "fail";
					break;
				case "4":
					c = file.getChar();
					file.increment();
					if(c == 'S')
						state = "success";
					else
						state = "fail";
				case "success":
					token = new Token("TAPOS");
					file.finalize();
					return true;
				case "fail":
					setError(file.getError());
					file.reset();
					return false;
			}
			if(state.equals("end"))
				break;
		}
		return state.equals("success") ? true : false;
	}
	public boolean isMake_pasok(fileIO file) { //image 7
		String state = "start";
		char c;
		while(true) {
			switch(state) {
				case "start":
					c = file.getChar();
					file.increment();
					if(c == 'm')
						state = "1";
					else {
						state = "fail";
					}
					break;
				case "1":
					c = file.getChar();
					file.increment();
					if(c == 'a')
						state = "2";
					else 
						state = "fail";
					break;
				case "2":
					c = file.getChar();
					file.increment();
					if(c == 'k')
						state = "3";
					else {
						state = "fail";
					}
					break;
				case "3":
					c = file.getChar();
					file.increment();
					if(c == 'e')
						state = "4";
					else {
						state = "fail";
					}
					break;
				case "4": 
					c = file.getChar();
					file.increment();
					if(c == '_')
						state = "5";
					else {
						state = "fail";
					}
					break;
				case "5":
					c = file.getChar();
					file.increment();
					if(c == 'p')
						state = "6";
					else {
						state = "fail";
					}
					break;
				case "6":
					c = file.getChar();
					file.increment();
					if(c == 'a')
						state = "7";
					else {
						state = "fail";
					}
					break;
				case "7":
					c = file.getChar();
					file.increment();
					if(c == 's')
						state = "8";
					else {
						state = "fail";
					}
					break;
				case "8":
					c = file.getChar();
					file.increment();
					if(c == 'o')
						state = "9";
					else {
						state = "fail";
					}
					break;
				case "9":
					c = file.getChar();
					file.increment();
					if(c == 'k')
						state = "success";
					else {
						state = "fail";
					}
					break;
				case "success":
					token = new Token("make_pasok");
					file.finalize();
					return true;
				case "fail":
					setError(file.getError());
					file.reset();
					return false;
			}
			
			if(state.equals("end"))
				break;
		}
		return state.equals("success") ? true : false;
	}
	public boolean isThen_ikot(fileIO file) { //image 7
		String state = "start";
		char c;
		while(true) {
			switch(state) {
				case "start":
					c = file.getChar();
					file.increment();
					if(c == 't')
						state = "1";
					else {
						state = "fail";
					}
					break;
				case "1":
					c = file.getChar();
					file.increment();
					if(c == 'h')
						state = "2";
					else 
						state = "fail";
					break;
				case "2":
					c = file.getChar();
					file.increment();
					if(c == 'e')
						state = "3";
					else {
						state = "fail";
					}
					break;
				case "3":
					c = file.getChar();
					file.increment();
					if(c == 'n')
						state = "4";
					else {
						state = "fail";
					}
					break;
				case "4": 
					c = file.getChar();
					file.increment();
					if(c == '_')
						state = "5";
					else {
						state = "fail";
					}
					break;
				case "5":
					c = file.getChar();
					file.increment();
					if(c == 'i')
						state = "6";
					else {
						state = "fail";
					}
					break;
				case "6":
					c = file.getChar();
					file.increment();
					if(c == 'k')
						state = "7";
					else {
						state = "fail";
					}
					break;
				case "7":
					c = file.getChar();
					file.increment();
					if(c == 'o')
						state = "8";
					else {
						state = "fail";
					}
					break;
				case "8":
					c = file.getChar();
					file.increment();
					if(c == 't')
						state = "success";
					else {
						state = "fail";
					}
					break;
				case "success":
//					ReserveTable.put("then_ikot", token = new Token("then_ikot"));
					token = new Token("then_ikot");
					file.finalize();
					return true;
				case "fail":
					setError(file.getError());
					file.reset();
					return false;
			}
			
			if(state.equals("end"))
				break;
			
		}
		return state.equals("success") ? true : false;
	}
	public boolean isWhile_true(fileIO file) { //image 8
		String state = "start";
		char c;
		while(true) {
			switch(state) {
				case "start":
					c = file.getChar();
					file.increment();
					if(c == 'w')
						state = "1";
					else {
						state = "fail";
					}
					break;
				case "1":
					c = file.getChar();
					file.increment();
					if(c == 'h')
						state = "2";
					else 
						state = "fail";
					break;
				case "2":
					c = file.getChar();
					file.increment();
					if(c == 'i')
						state = "3";
					else {
						state = "fail";
					}
					break;
				case "3":
					c = file.getChar();
					file.increment();
					if(c == 'l')
						state = "4";
					else {
						state = "fail";
					}
					break;
				case "4": 
					c = file.getChar();
					file.increment();
					if(c == 'e')
						state = "5";
					else {
						state = "fail";
					}
					break;
				case "5":
					c = file.getChar();
					file.increment();
					if(c == '_')
						state = "6";
					else {
						state = "fail";
					}
					break;
				case "6":
					c = file.getChar();
					file.increment();
					if(c == 't')
						state = "7";
					else {
						state = "fail";
					}
					break;
				case "7":
					c = file.getChar();
					file.increment();
					if(c == 'r')
						state = "8";
					else {
						state = "fail";
					}
					break;
				case "8":
					c = file.getChar();
					file.increment();
					if(c == 'u')
						state = "9";
					else {
						state = "fail";
					}
					break;
				case "9":
					c = file.getChar();
					file.increment();
					if(c == 'e')
						state = "success";
					else {
						state = "fail";
					}
					break;
				case "success":
					token = new Token("while_true");
					file.finalize();
					return true;
				case "fail":
					setError(file.getError());
					file.reset();
					return false;
			}
			
			if(state.equals("end"))
				break;
		}
		return state.equals("success") ? true : false;
	}
	public boolean isUmikot_until(fileIO file) { //image 9
		String state = "start";
		char c;
		while(true) {
			switch(state) {
				case "start":
					c = file.getChar();
					file.increment();
					if(c == 'u')
						state = "1";
					else {
						state = "fail";
					}
					break;
				case "1":
					c = file.getChar();
					file.increment();
					if(c == 'm')
						state = "2";
					else 
						state = "fail";
					break;
				case "2":
					c = file.getChar();
					file.increment();
					if(c == 'i')
						state = "3";
					else {
						state = "fail";
					}
					break;
				case "3":
					c = file.getChar();
					file.increment();
					if(c == 'k')
						state = "4";
					else {
						state = "fail";
					}
					break;
				case "4": 
					c = file.getChar();
					file.increment();
					if(c == 'o')
						state = "5";
					else {
						state = "fail";
					}
					break;
				case "5":
					c = file.getChar();
					file.increment();
					if(c == 't')
						state = "6";
					else {
						state = "fail";
					}
					break;
				case "6":
					c = file.getChar();
					file.increment();
					if(c == '_')
						state = "7";
					else {
						state = "fail";
					}
					break;
				case "7":
					c = file.getChar();
					file.increment();
					if(c == 'u')
						state = "8";
					else {
						state = "fail";
					}
					break;
				case "8":
					c = file.getChar();
					file.increment();
					if(c == 'n')
						state = "9";
					else {
						state = "fail";
					}
					break;
				case "9":
					c = file.getChar();
					file.increment();
					if(c == 't')
						state = "10";
					else {
						state = "fail";
					}
					break;
				case "10":
					c = file.getChar();
					file.increment();
					if(c == 'i')
						state = "11";
					else
						state = "fail";
					break;
				case "11":
					c = file.getChar();
					file.increment();
					if(c == 'l')
						state = "success";
					else
						state = "fail";
				case "success":
//					ReserveTable.put("umikot_until", token = new Token("umikot_until"));
					token = new Token("umikot_until");
					file.finalize();
					return true;
				case "fail":
					setError(file.getError());
					file.reset();
					return false;
			}
			
			if(state.equals("end"))
				break;
			
		}
		return state.equals("success") ? true : false;
	}
	public boolean isIpakita_this(fileIO file) { //image 10
		String state = "start";
		char c;
		while(true) {
			switch(state) {
				case "start":
					c = file.getChar();
					file.increment();
					if(c == 'i')
						state = "1";
					else {
						state = "fail";
					}
					break;
				case "1":
					c = file.getChar();
					file.increment();
					if(c == 'p')
						state = "2";
					else 
						state = "fail";
					break;
				case "2":
					c = file.getChar();
					file.increment();
					if(c == 'a')
						state = "3";
					else {
						state = "fail";
					}
					break;
				case "3":
					c = file.getChar();
					file.increment();
					if(c == 'k')
						state = "4";
					else {
						state = "fail";
					}
					break;
				case "4": 
					c = file.getChar();
					file.increment();
					if(c == 'i')
						state = "5";
					else {
						state = "fail";
					}
					break;
				case "5":
					c = file.getChar();
					file.increment();
					if(c == 't')
						state = "6";
					else {
						state = "fail";
					}
					break;
				case "6":
					c = file.getChar();
					file.increment();
					if(c == 'a')
						state = "7";
					else {
						state = "fail";
					}
					break;
				case "7":
					c = file.getChar();
					file.increment();
					if(c == '_')
						state = "8";
					else {
						state = "fail";
					}
					break;
				case "8":
					c = file.getChar();
					file.increment();
					if(c == 't')
						state = "9";
					else {
						state = "fail";
					}
					break;
				case "9":
					c = file.getChar();
					file.increment();
					if(c == 'h')
						state = "10";
					else {
						state = "fail";
					}
					break;
				case "10":
					c = file.getChar();
					file.increment();
					if(c == 'i')
						state = "11";
					else
						state = "fail";
					break;
				case "11":
					c = file.getChar();
					file.increment();
					if(c == 's')
						state = "success";
					else
						state = "fail";
				case "success":
					token = new Token("ipakita_this");
					file.finalize();
					return true;
				case "fail":
					setError(file.getError());
					file.reset();
					return false;
			}
			
			if(state.equals("end"))
				break;
			
		}
		return state.equals("success") ? true : false;
	}
	public boolean isBasahin_this(fileIO file) { //image 11
		String state = "start";
		char c;
		while(true) {
			switch(state) {
				case "start":
					c = file.getChar();
					file.increment();
					if(c == 'b')
						state = "1";
					else {
						state = "fail";
					}
					break;
				case "1":
					c = file.getChar();
					file.increment();
					if(c == 'a')
						state = "2";
					else 
						state = "fail";
					break;
				case "2":
					c = file.getChar();
					file.increment();
					if(c == 's')
						state = "3";
					else {
						state = "fail";
					}
					break;
				case "3":
					c = file.getChar();
					file.increment();
					if(c == 'a')
						state = "4";
					else {
						state = "fail";
					}
					break;
				case "4": 
					c = file.getChar();
					file.increment();
					if(c == 'h')
						state = "5";
					else {
						state = "fail";
					}
					break;
				case "5":
					c = file.getChar();
					file.increment();
					if(c == 'i')
						state = "6";
					else {
						state = "fail";
					}
					break;
				case "6":
					c = file.getChar();
					file.increment();
					if(c == 'n')
						state = "7";
					else {
						state = "fail";
					}
					break;
				case "7":
					c = file.getChar();
					file.increment();
					if(c == '_')
						state = "8";
					else {
						state = "fail";
					}
					break;
				case "8":
					c = file.getChar();
					file.increment();
					if(c == 't')
						state = "9";
					else {
						state = "fail";
					}
					break;
				case "9":
					c = file.getChar();
					file.increment();
					if(c == 'h')
						state = "10";
					else {
						state = "fail";
					}
					break;
				case "10":
					c = file.getChar();
					file.increment();
					if(c == 'i')
						state = "11";
					else
						state = "fail";
					break;
				case "11":
					c = file.getChar();
					file.increment();
					if(c == 's')
						state = "success";
					else
						state = "fail";
				case "success":
//					ReserveTable.put("basahin_this", token = new Token("basahin_this"));
					token = new Token("basahin_this");
					file.finalize();
					return true;
				case "fail":
					setError(file.getError());
					file.reset();
					return false;
			}
			
			if(state.equals("end"))
				break;
			
		}
		return state.equals("success") ? true : false;
	}
	public boolean isC_BOOLEAN(fileIO file) {
		String state = "start";
		char c;
		while(true) {
			switch(state) {
				case "start":
					c = file.getChar();
					file.increment();
					if(c == 'T')
						state = "1";
					else if(c == 'M')
						state = "5";
					else {
						state = "fail";
					}
					break;
				case "1":
					c = file.getChar();
					file.increment();
					if(c == 'A')
						state = "2";
					else
						state = "fail";
					break;
				case "2":
					c = file.getChar();
					file.increment();
					if(c == 'M')
						state = "3";
					else
						state = "fail";
					break;
				case "3":
					c = file.getChar();
					file.increment();
					if(c == 'A'){
						state = "success";
//						SymbolTable.put("TAMA", token = new Token("C_BOOLEAN", "TAMA")); 
						token = new Token("C_BOOLEAN", "TAMA");
						token.setExpectedType("b_var");
						token.setValue(token.getLexeme());
					} else
						state = "fail";
					break;
				case "5":
					c = file.getChar();
					file.increment();
					if(c == 'A')
						state = "6";
					else
						state = "fail";
					break;
				case "6":
					c = file.getChar();
					file.increment();
					if(c == 'L')
						state = "7";
					else
						state = "fail";
					break;
				case "7":
					c = file.getChar();
					file.increment();
					if(c == 'I') {
//						SymbolTable.put("MALI", token = new Token("C_BOOLEAN", "MALI"));
						token = new Token("C_BOOLEAN", "MALI");
						token.setExpectedType("b_var");
						token.setValue(token.getLexeme());
						state = "success";
					} else
						state = "fail";
					break;
				case "success":
					state = "end";
					file.finalize();
					return true;
				case "fail":
					setError(file.getError());
					state = "end";
					file.reset();
					return false;
			}
			
			if(state.equals("end"))
				break;
			
		}
		return state.equals("success") ? true : false;
	}
	
	//AKIN TO RENZO UNG UPPER PART SAYO
	public boolean isedi_kung(fileIO file){
		Token edi_kung = new Token("");
		String state = "Start";
		char c;
		while(true){
			switch(state){
				case "Start":{
					c = file.getChar();
					file.increment();
					if(c=='e'){
						state = "1";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "1":{
					c = file.getChar();
					file.increment();
					if(c=='d'){
						state = "2";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "2":{
					c = file.getChar();
					file.increment();
					if(c=='i'){
						state = "3";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "3":{
					c = file.getChar();
					file.increment();
					if(c=='_'){
						state = "4";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "4":{
					c = file.getChar();
					file.increment();
					if(c=='k'){
						state = "5";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "5":{
					c = file.getChar();
					file.increment();
					if(c=='u'){
						state = "6";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "6":{
					c = file.getChar();
					file.increment();
					if(c=='n'){
						state = "7";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "7":{
					c = file.getChar();
					file.increment();
					if(c=='g'){
						state = "Success";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "Success":{
					edi_kung.setName("edi_kung");
					token = edi_kung;
					file.finalize();
					return true;
				}
				case "Fail":{
					setError(file.getError());
					file.reset();
					return false;
				}
			}
		}	
	}
	public boolean isIDENT(fileIO file){
		Token IDENT = new Token("");
		String state = "Start";
		char c;
		while(true){
			switch(state){
				case "Start":{
					c = file.getChar();
					file.increment();
					if(Character.isLetter(c)){
						IDENT.addLexemeChar(c);
						state = "1";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "1":{
					c = file.getChar();
					file.increment();
					if(Character.isLetter(c) || Character.isDigit(c) || c == '_'){
						IDENT.addLexemeChar(c);
						state = "1";
					}
					else{
						state = "Success";
					}
					break;
				}
				case "Success":{
					if((ReserveTable.get(IDENT.getLexeme()) == null)){
							IDENT.setName("IDENT");
							token = IDENT;
							//SymbolTable.put(IDENT.getLexeme(), IDENT);
							file.pushBack();
							file.finalize();
							return true;
					}
					else{
						token = (Token)ReserveTable.get(IDENT.getLexeme());
						file.pushBack();
						file.finalize();
						return true;
					}
				}
				case "Fail":{
					IDENT.setLexeme("");
					setError(file.getError());
					file.reset();
					return false;
				}
			}
		}
	}
	public boolean iskung_true(fileIO file){
		Token kung_true = new Token("");
		String state = "Start";
		char c;
		while(true){
			switch(state){
				case "Start":{
					c = file.getChar();
					file.increment();
					if(c=='k'){
						state = "1";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "1":{
					c = file.getChar();
					file.increment();
					if(c=='u'){
						state = "2";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "2":{
					c = file.getChar();
					file.increment();
					if(c=='n'){
						state = "3";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "3":{
					c = file.getChar();
					file.increment();
					if(c=='g'){
						state = "4";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "4":{
					c = file.getChar();
					file.increment();
					if(c=='_'){
						state = "5";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "5":{
					c = file.getChar();
					file.increment();
					if(c=='t'){
						state = "6";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "6":{
					c = file.getChar();
					file.increment();
					if(c=='r'){
						state = "7";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "7":{
					c = file.getChar();
					file.increment();
					if(c=='u'){
						state = "8";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "8":{
					c = file.getChar();
					file.increment();
					if(c=='e'){
						state = "Success";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "Success":{
					kung_true.setName("kung_true");
					token = kung_true;
					file.finalize();
					return true;
				}
				case "Fail":{
					setError(file.getError());
					file.reset();
					return false;
				}
			}
		}
	}
	public boolean iskung_not(fileIO file){
		Token kung_not = new Token("");
		String state = "Start";
		char c;
		while(true){
			switch(state){
				case "Start":{
					c = file.getChar();
					file.increment();
					if(c=='k'){
						state = "1";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "1":{
					c = file.getChar();
					file.increment();
					if(c=='u'){
						state = "2";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "2":{
					c = file.getChar();
					file.increment();
					if(c=='n'){
						state = "3";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "3":{
					c = file.getChar();
					file.increment();
					if(c=='g'){
						state = "4";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "4":{
					c = file.getChar();
					file.increment();
					if(c=='_'){
						state = "5";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "5":{
					c = file.getChar();
					file.increment();
					if(c=='n'){
						state = "6";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "6":{
					c = file.getChar();
					file.increment();
					if(c=='o'){
						state = "7";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "7":{
					c = file.getChar();
					file.increment();
					if(c=='t'){
						state = "Success";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "Success":{
					kung_not.setName("kung_not");
					token = kung_not;
					file.finalize();
					return true;
				}
				case "Fail":{
					setError(file.getError());
					file.reset();
					return false;
				}
			}
		}	
	}
	public boolean islast_na(fileIO file){
		Token last_na = new Token("");
		String state = "Start";
		char c;
		while(true){
			switch(state){
				case "Start":{
					c = file.getChar();
					file.increment();
					if(c == 'l'){
						state = "2";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "2":{
					c = file.getChar();
					file.increment();
					if(c == 'a'){
						state = "3";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "3":{
					c = file.getChar();
					file.increment();
					if(c == 's'){
						state = "4";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "4":{
					c = file.getChar();
					file.increment();
					if(c == 't'){
						state = "5";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "5":{
					c = file.getChar();
					file.increment();
					if(c == '_'){
						state = "6";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "6":{
					c = file.getChar();
					file.increment();
					if(c == 'n'){
						state = "7";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "7":{
					c = file.getChar();
					file.increment();
					if(c == 'a'){
						state = "Success";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "Success":{
					last_na.setName("last_na");
					token = last_na;
					file.finalize();
					return true;
				}
				case "Fail":{
					setError(file.getError());
					file.reset();
					return false;
				}
			}
		}
	}
	public boolean isipilit(fileIO file){
		Token ipilit = new Token("");
		String state = "Start";
		char c;
		while(true){
			switch(state){
				case "Start":{
					c = file.getChar();
					file.increment();
					if(c == 'i'){
						state = "2";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "2":{
					c = file.getChar();
					file.increment();
					if(c == 'p'){
						state = "3";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "3":{
					c = file.getChar();
					file.increment();
					if(c == 'i'){
						state = "4";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "4":{
					c = file.getChar();
					file.increment();
					if(c == 'l'){
						state = "5";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "5":{
					c = file.getChar();
					file.increment();
					if(c == 'i'){
						state = "6";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "6":{
					c = file.getChar();
					file.increment();
					if(c == 't'){
						state = "Success";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "Success":{
					ipilit.setName("ipilit");
					token = ipilit;
					file.finalize();
					return true;
				}
				case "Fail":{
					setError(file.getError());
					file.reset();
					return false;
				}
			}
		}
	}
	public boolean ismake_pili(fileIO file){
		Token make_pili = new Token("");
		String state = "Start";
		char c;
		while(true){
			switch(state){
				case "Start":{
					c = file.getChar();
					file.increment();
					if(c=='m'){
						state = "1";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "1":{
					c = file.getChar();
					file.increment();
					if(c=='a'){
						state = "2";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "2":{
					c = file.getChar();
					file.increment();
					if(c=='k'){
						state = "3";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "3":{
					c = file.getChar();
					file.increment();
					if(c=='e'){
						state = "4";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "4":{
					c = file.getChar();
					file.increment();
					if(c=='_'){
						state = "5";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "5":{
					c = file.getChar();
					file.increment();
					if(c=='p'){
						state = "6";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "6":{
					c = file.getChar();
					file.increment();
					if(c=='i'){
						state = "7";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "7":{
					c = file.getChar();
					file.increment();
					if(c=='l'){
						state = "8";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "8":{
					c = file.getChar();
					file.increment();
					if(c=='i'){
						state = "Success";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "Success":{
					make_pili.setName("make_pili");
					token = make_pili;
					file.finalize();
					return true;
				}
				case "Fail":{
					setError(file.getError());
					file.reset();
					return false;
				}
			}
		}
	}
	public boolean iscase(fileIO file){
		Token Case = new Token("");
		String state = "Start";
		char c;
		while(true){
			switch(state){
				case "Start":{
					c = file.getChar();
					file.increment();
					if(c=='c'){
						state = "1";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "1":{
					c = file.getChar();
					file.increment();
					if(c=='a'){
						state = "2";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "2":{
					c = file.getChar();
					file.increment();
					if(c=='s'){
						state = "3";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "3":{
					c = file.getChar();
					file.increment();
					if(c=='e'){
						state = "Success";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "Success":{
					Case.setName("case");
					token = Case;
					file.finalize();
					return true;
				}
				case "Fail":{
					setError(file.getError());
					file.reset();
					return false;
				}
			}
		}
	}
	public boolean isno_choice_me(fileIO file){
		Token no_choice_me = new Token("");
		String state = "Start";
		char c;
		while(true){
			switch(state){
				case "Start":{
					c = file.getChar();
					file.increment();
					if(c=='n'){
						state = "1";
					}
					else{
						state = "Fail";
					}
					break;
					
				}
				case "1":{
					c = file.getChar();
					file.increment();
					if(c=='o'){
						state = "2";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "2":{
					c = file.getChar();
					file.increment();
					if(c=='_'){
						state = "3";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "3":{
					c = file.getChar();
					file.increment();
					if(c=='c'){
						state = "4";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "4":{
					c = file.getChar();
					file.increment();
					if(c=='h'){
						state = "5";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "5":{
					c = file.getChar();
					file.increment();
					if(c=='o'){
						state = "6";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "6":{
					c = file.getChar();
					file.increment();
					if(c=='i'){
						state = "7";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "7":{
					c = file.getChar();
					file.increment();
					if(c=='c'){
						state = "8";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "8":{
					c = file.getChar();
					file.increment();
					if(c=='e'){
						state = "9";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "9":{
					c = file.getChar();
					file.increment();
					if(c=='_'){
						state = "10";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "10":{
					c = file.getChar();
					file.increment();
					if(c=='m'){
						state = "11";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "11":{
					c = file.getChar();
					file.increment();
					if(c=='e'){
						state = "Success";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "Success":{
					no_choice_me.setName("no_choice_me");
					token = no_choice_me;
					file.finalize();
					return true;
				}
				case "Fail":{
					setError(file.getError());
					file.reset();
					return false;
				}
			}
		}
	}
	public boolean isDATA_TYPE(fileIO file){
		Token DATA_TYPE = new Token("");
		String state = "Start";
		char c;
		while(true){
			switch(state){
				case "Start":{
					c = file.getChar();
					file.increment();
					if(c == 'i'){
						state = "1";
					}
					else if(c == 'b'){
						state = "5";
					}
					else if(c == 'f'){
						state = "9";
					}
					else if (c == 'd'){
						state = "13";
					}
					else if (c == 's'){
						state = "17";
					}
					else if(c == 'c'){
						state = "21";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "1":{
					c = file.getChar();
					file.increment();
					if(c == '_'){
						state = "2"; 
					}
					else{
						state = "Fail";
					}
				}
				case "2":{
					c = file.getChar();
					file.increment();
					if(c=='v'){
						state = "3";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "3":{
					c = file.getChar();
					file.increment();
					if(c=='a'){
						state = "4";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "4":{
					c = file.getChar();
					file.increment();
					if(c=='r'){
						state = "25";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "5":{
					c = file.getChar();
					file.increment();
					if(c=='_'){
						state = "6";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "6":{
					c = file.getChar();
					file.increment();
					if(c=='v'){
						state = "7";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "7":{
					c = file.getChar();
					file.increment();
					if(c=='a'){
						state = "8";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "8":{
					c = file.getChar();
					file.increment();
					if(c=='r'){
						state = "26";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "9":{
					c = file.getChar();
					file.increment();
					if(c=='_'){
						state = "10";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "10":{
					c = file.getChar();
					file.increment();
					if(c=='v'){
						state = "11";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "11":{
					c = file.getChar();
					file.increment();
					if(c=='a'){
						state = "12";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "12":{
					c = file.getChar();
					file.increment();
					if(c=='r'){
						state = "27";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "13":{
					c = file.getChar();
					file.increment();
					if(c=='_'){
						state = "14";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "14":{
					c = file.getChar();
					file.increment();
					if(c=='v'){
						state = "15";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "15":{
					c = file.getChar();
					file.increment();
					if(c=='a'){
						state = "16";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "16":{
					c = file.getChar();
					file.increment();
					if(c=='r'){
						state = "28";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "17":{
					c = file.getChar();
					file.increment();
					if(c=='_'){
						state = "18";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "18":{
					c = file.getChar();
					file.increment();
					if(c=='v'){
						state = "19";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "19":{
					c = file.getChar();
					file.increment();
					if(c=='a'){
						state = "20";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "20":{
					c = file.getChar();
					file.increment();
					if(c=='r'){
						state = "29";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "21":{
					c = file.getChar();
					file.increment();
					if(c=='_'){
						state = "22";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "22":{
					c = file.getChar();
					file.increment();
					if(c=='v'){
						state = "23";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "23":{
					c = file.getChar();
					file.increment();
					if(c=='a'){
						state = "24";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "24":{
					c = file.getChar();
					file.increment();
					if(c=='r'){
						state = "30";
					}
					else{
						state = "Fail";
					}
					break;
				}
				
				case "25":{
					DATA_TYPE.setName("DATA_TYPE");
					DATA_TYPE.setLexeme("i_var");
						token = DATA_TYPE;
						//SymbolTable.put(DATA_TYPE.getLexeme(), token);
						file.finalize();
						return true;
				}
				case "26":{
					DATA_TYPE.setName("DATA_TYPE");
					DATA_TYPE.setLexeme("b_var");
						token = DATA_TYPE;
						//SymbolTable.put(DATA_TYPE.getLexeme(), token);
						file.finalize();
						return true;

				}
				case "27":{
					DATA_TYPE.setName("DATA_TYPE");
					DATA_TYPE.setLexeme("f_var");
						token = DATA_TYPE;
						//SymbolTable.put(DATA_TYPE.getLexeme(), token);
						file.finalize();
						return true;
				}
				case "28":{
					DATA_TYPE.setName("DATA_TYPE");
					DATA_TYPE.setLexeme("d_var");
						token = DATA_TYPE;
						//SymbolTable.put(DATA_TYPE.getLexeme(), token);
						file.finalize();
						return true;
				}
				case "29":{
					DATA_TYPE.setName("DATA_TYPE");
					DATA_TYPE.setLexeme("s_var");
						token = DATA_TYPE;
						//SymbolTable.put(DATA_TYPE.getLexeme(), token);
						file.finalize();
						return true;
				}
				case "30":{
					DATA_TYPE.setName("DATA_TYPE");
					DATA_TYPE.setLexeme("c_var");
						token = DATA_TYPE;
						//SymbolTable.put(DATA_TYPE.getLexeme(), token);
						file.finalize();
						return true;
				}
				case "Fail":{
					setError(file.getError());
					file.reset();
					return false;
				}
			}
		}
	}
	public boolean isdugtong(fileIO file){
		Token dugtong = new Token("");
		String state = "Start";
		char c;
		while(true){
			switch(state){
				case "Start":{
					c = file.getChar();
					file.increment();
					if(c=='d'){
						state = "1";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "1":{
					c = file.getChar();
					file.increment();
					if(c=='u'){
						state = "2";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "2":{
					c = file.getChar();
					file.increment();
					if(c=='g'){
						state = "3";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "3":{
					c = file.getChar();
					file.increment();
					if(c=='t'){
						state = "4";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "4":{
					c = file.getChar();
					file.increment();
					if(c=='o'){
						state = "5";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "5":{
					c = file.getChar();
					file.increment();
					if(c=='n'){
						state = "6";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "6":{
					c = file.getChar();
					file.increment();
					if(c=='g'){
						state = "Success";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "Success":{
					dugtong.setName("dugtong");
					dugtong.setLexeme("dugtong");
					token = dugtong;
					file.finalize();
					return true;
				}
				case "Fail":{
					setError(file.getError());
					file.reset();
					return false;
				}
			}
		}
	}
	public boolean iskunin_part(fileIO file){
		Token kunin_part = new Token("");
		String state = "Start";
		char c;
		while(true){
			switch(state){
				case "Start":{
					c = file.getChar();
					file.increment();
					if(c=='k'){
						state = "1";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "1":{
					c = file.getChar();
					file.increment();
					if(c=='u'){
						state = "2";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "2":{
					c = file.getChar();
					file.increment();
					if(c=='n'){
						state = "3";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "3":{
					c = file.getChar();
					file.increment();
					if(c=='i'){
						state = "4";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "4":{
					c = file.getChar();
					file.increment();
					if(c=='n'){
						state = "5";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "5":{
					c = file.getChar();
					file.increment();
					if(c=='_'){
						state = "6";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "6":{
					c = file.getChar();
					file.increment();
					if(c=='p'){
						state = "7";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "7":{
					c = file.getChar();
					file.increment();
					if(c=='a'){
						state = "8";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "8":{
					c = file.getChar();
					file.increment();
					if(c=='r'){
						state = "9";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "9":{
					c = file.getChar();
					file.increment();
					if(c=='t'){
						state = "Success";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "Success":{
					kunin_part.setName("kunin_part");
					kunin_part.setLexeme("kunin_part");
					token = kunin_part;
					file.finalize();
					return true;
				}
				case "Fail":{
					setError(file.getError());
					file.reset();
					return false;
				}
			}
		}		
	}
	public boolean ishanapin(fileIO file){
		Token hanapin = new Token("");
		String state = "Start";
		char c;
		while(true){
			switch(state){
				case "Start":{
					c = file.getChar();
					file.increment();
					if(c=='h'){
						state = "1";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "1":{
					c = file.getChar();
					file.increment();
					if(c=='a'){
						state = "2";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "2":{
					c = file.getChar();
					file.increment();
					if(c=='n'){
						state = "3";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "3":{
					c = file.getChar();
					file.increment();
					if(c=='a'){
						state = "4";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "4":{
					c = file.getChar();
					file.increment();
					if(c=='p'){
						state = "5";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "5":{
					c = file.getChar();
					file.increment();
					if(c=='i'){
						state = "6";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "6":{
					c = file.getChar();
					file.increment();
					if(c=='n'){
						state = "Success";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "Success":{
					hanapin.setName("hanapin");
					hanapin.setLexeme("hanapin");
					token = hanapin;
					file.finalize();
					return true;
				}
				case "Fail":{
					setError(file.getError());
					file.reset();
					return false;
				}
			}
		}		
	}
	public boolean ishaba(fileIO file){
		Token haba = new Token("");
		String state = "Start";
		char c;
		while(true){
			switch(state){
				case "Start":{
					c = file.getChar();
					file.increment();
					if(c=='h'){
						state = "1";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "1":{
					c = file.getChar();
					file.increment();
					if(c=='a'){
						state = "2";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "2":{
					c = file.getChar();
					file.increment();
					if(c=='b'){
						state = "3";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "3":{
					c = file.getChar();
					file.increment();
					if(c=='a'){
						state = "Success";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "Success":{
					haba.setName("haba");
					haba.setLexeme("haba");
					token = haba;
					file.finalize();
					return true;
				}
				case "Fail":{
					setError(file.getError());
					file.reset();
					return false;
				}
			}
		}
	}
	public boolean ispunta(fileIO file){
		Token punta = new Token("punta");
		String state = "Start";
		char c;
		while(true){
			switch(state){
				case "Start":{
					c = file.getChar();
					file.increment();
					if(c=='p'){
						state = "1";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "1":{
					c = file.getChar();
					file.increment();
					if(c=='u'){
						state = "2";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "2":{
					c = file.getChar();
					file.increment();
					if(c=='n'){
						state = "3";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "3":{
					c = file.getChar();
					file.increment();
					if(c=='t'){
						state = "4";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "4":{
					c = file.getChar();
					file.increment();
					if(c=='a'){
						state = "Success";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "Success":{
					punta.setName("punta");
					token = punta;
					file.finalize();
					return true;
				}
				case "Fail":{
					setError(file.getError());
					file.reset();
					return false;
				}
			}
		}
	}
	public boolean isputol(fileIO file){
		Token putol = new Token("");
		String state = "Start";
		char c;
		while(true){
			switch(state){
				case "Start":{
					c = file.getChar();
					file.increment();
					if(c=='p'){
						state = "1";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "1":{
					c = file.getChar();
					file.increment();
					if(c=='u'){
						state = "2";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "2":{
					c = file.getChar();
					file.increment();
					if(c=='t'){
						state = "3";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "3":{
					c = file.getChar();
					file.increment();
					if(c=='o'){
						state = "4";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "4":{
					c = file.getChar();
					file.increment();
					if(c=='l'){
						state = "Success";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "Success":{
					putol.setName("putol");
					token = putol;
					file.finalize();
					return true;
				}
				case "Fail":{
					setError(file.getError());
					file.reset();
					return false;
				}
			}
		}
	}
	public boolean isSequal(fileIO file){
		Token Sequal = new Token("");
		String state = "Start";
		char c;
		while(true){
			switch(state){
				case "Start":{
					c = file.getChar();
					file.increment();
					if(c == 'S'){
						state = "2";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "2":{
					c = file.getChar();
					file.increment();
					if(c == 'e'){
						state = "3";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "3":{
					c = file.getChar();
					file.increment();
					if(c == 'q'){
						state = "4";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "4":{
					c = file.getChar();
					file.increment();
					if(c == 'u'){
						state = "5";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "5":{
					c = file.getChar();
					file.increment();
					if(c == 'a'){
						state = "6";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "6":{
					c = file.getChar();
					file.increment();
					if(c == 'l'){
						state = "Success";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "Success":{
					Sequal.setName("Sequal");
					token = Sequal;
					file.finalize();
					return true;
				}
				case "Fail":{
					setError(file.getError());
					file.reset();
					return false;
				}
			}
		}	
	}
	public boolean isCOLON(fileIO file){
		Token COLON = new Token("");
		String state = "Start";
		char c;
		while(true){
			switch(state){
				case "Start":{
					c = file.getChar();
					file.increment();
					if(c == ':'){
						state = "Success";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "Success":{
					COLON.setName("COLON");
					token = COLON;
					file.finalize();
					return true;
				}
				case "Fail":{
					setError(file.getError());
					file.reset();
					return false;
				}
			}
		}		
	}
	public boolean isC_INT(fileIO file){
		Token C_INT = new Token("");
		String state = "Start";
		char c;
		String numbers = "0123456789";
		while(true){
			switch(state){
				case "Start":{
					c = file.getChar();
					file.increment();
					if(numbers.indexOf(c) > -1){
						C_INT.addLexemeChar(c);
						state = "1";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "1":{
					c = file.getChar();
					file.increment();
					if(numbers.indexOf(c) > -1){
						C_INT.addLexemeChar(c);
						state = "1";
					}
					else{
						state = "Success";
					}
					break;
				}
				case "Success":{
						C_INT.setName("C_INT");
						token = C_INT;
						token.setExpectedType("i_var");
						token.setValue(token.getLexeme());
						//SymbolTable.put(C_INT.getLexeme(), token);
						file.pushBack();
						file.finalize();
						return true;
				}
				case "Fail":{
					C_INT.setLexeme("");
					setError(file.getError());
					file.reset();
					return false;
				}
			}
		}
	}
	public boolean isC_Char(fileIO file){
		Token C_CHAR = new Token("");
		String state = "Start";
		char c;
		String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String smallLetters = letters.toLowerCase();
		String numbers = "0123456789";
		String specialChar = "! @ # $ % ^ & * ( ) _ , : ; + - { } ] [ | > < = _ ?".trim();
		while(true){
			switch(state){
				case "Start":{
					c = file.getChar();
					file.increment();
					if(c == (char) 39){
						state = "1";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "1":{
					c = file.getChar();
					file.increment();
					if(numbers.indexOf(c) > -1 || letters.indexOf(c) > -1 || specialChar.indexOf(c) > -1 || smallLetters.indexOf(c) > -1){
						C_CHAR.addLexemeChar(c);
						state = "2";
					}
					break;
				}
				case "2":{
					c = file.getChar();
					file.increment();
					if(c== (char) 39){
						state = "Success";
					}
					break;
				}
				case "Success":{
						C_CHAR.setName("C_CHAR");
						token = C_CHAR;
						token.setExpectedType("c_var");
						token.setValue(token.getLexeme());
						//SymbolTable(C_CHAR.getLexeme(), token);
						file.finalize();
						return true;
				}
				case "Fail":{
					setError(file.getError());
					file.reset();
					return false;
				}
			}
		}
	}
	
	public boolean isC_FLOAT(fileIO file){
		Token C_FLOAT = new Token("");
		String state = "Start";
		String number = "0123456789";
		char c;
		while(true){
			switch(state){
				case "Start":{
					c = file.getChar();
					file.increment();
					if(number.indexOf(c) > -1){
						C_FLOAT.addLexemeChar(c);
						state = "1";
					}
					else
						state = "Fail";
					break;
				}
				case "1":{
					c = file.getChar();
					file.increment();
					if(number.indexOf(c) > -1){
						C_FLOAT.addLexemeChar(c);
						state = "1";
					}
					else if(c == '.'){
						C_FLOAT.addLexemeChar(c);
						state = "2";
					}
					else if(c == 'F'){
						C_FLOAT.addLexemeChar(c);
						state = "Success";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "2":{
					c = file.getChar();
					file.increment();
					if(number.indexOf(c) > -1){
						C_FLOAT.addLexemeChar(c);
						state = "3";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "3":{
					c = file.getChar();
					file.increment();
					if(number.indexOf(c) > -1){
						C_FLOAT.addLexemeChar(c);
						state = "3";
					}
					else if(c == 'F'){
						C_FLOAT.addLexemeChar(c);
						state = "Success";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "Success":{
						C_FLOAT.setName("C_FLOAT");
						token = C_FLOAT;
						token.setExpectedType("f_var");
						token.setValue(token.getLexeme());
						//SymbolTable(C_FLOAT.getLexeme(), token);
						file.finalize();
						return true;
				}
				case "Fail":{
					C_FLOAT.setLexeme("");
					setError(file.getError());
					file.reset();
					return false;
				}
			}
		}
	}
	public boolean isC_STR(fileIO file){
		Token C_STR = new Token("");
		String state = "Start";
		char c;
		String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String numbers = "0123456789";
		String smallLetters = letters.toLowerCase();
		String specialChar = ("! @ # $ % ^ & * ( ) _ , : ; + - { } ] [ | > < = _ ? / \\").trim();
		while(true){
			switch(state){
				case "Start":{
					c = file.getChar();
					file.increment();
					if(c == (char)34 ){
						state = "1";
					}
					else
						state ="Fail";
					break;
				}
				case "1":{
					c = file.getChar();
					file.increment();
					if(numbers.indexOf(c) > -1 || letters.indexOf(c) > -1 || specialChar.indexOf(c) > -1 || smallLetters.indexOf(c) > -1){
						if(c == '\\'){
							file.increment();
						}
						C_STR.addLexemeChar(c);
						state = "1";
					}
					else if(c == (char)34 ){
						state = "Success";
					}
					break;
				}
				case "Success":{
						C_STR.setName("C_STR");
						token = C_STR;
						token.setExpectedType("s_var");
						token.setValue(token.getLexeme());
						//SymbolTable(C_STR.getLexeme(), token);
						file.finalize();
						return true;
				}
				case "Fail":{
					C_STR.setLexeme("");
					setError(file.getError());
					file.reset();
					return false;
				}
			}
		}
	}
	public boolean isC_DOUBLE(fileIO file){
		Token C_DOUBLE = new Token("");
		String state = "Start";
		String number = "0123456789";
		char c;
		while(true){
			switch(state){
				case "Start":{
					c = file.getChar();
					file.increment();
					if(number.indexOf(c) > -1){
						C_DOUBLE.addLexemeChar(c);
						state = "1";
					}
					else
						state = "Fail";
					break;
				}
				case "1":{
					c = file.getChar();
					file.increment();
					if(number.indexOf(c) > -1){
						C_DOUBLE.addLexemeChar(c);
						state = "1";
					}
					else if(c == '.'){
						C_DOUBLE.addLexemeChar(c);
						state = "2";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "2":{
					c = file.getChar();
					file.increment();
					if(number.indexOf(c) > -1){
						C_DOUBLE.addLexemeChar(c);
						state = "3";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "3":{
					c = file.getChar();
					file.increment();
					if(number.indexOf(c) > -1){
						C_DOUBLE.addLexemeChar(c);
						state = "3";
					}
					else{
						state = "Success";
					}
					break;
				}
				case "Success":{
						C_DOUBLE.setName("C_DOUBLE");
						token = C_DOUBLE;
						token.setExpectedType("d_var");
						token.setValue(token.getLexeme());
						//SymbolTable.put(C_DOUBLE.getLexeme(), token);
						file.pushBack();
						file.finalize();
						return true;
				}
				case "Fail":{
					C_DOUBLE.setLexeme("");
					setError(file.getError());
					file.reset();
					return false;
				}
			}
		}
	}
	
	public boolean isEOF(fileIO file){
		/*if(file.getEnd() >= file.getLength()){
			return true;
		}
		else
			return false;
			*/
		Token EOF = new Token("");
		String state = "Start";
		char c;
		while(true){
			switch(state){
				case "Start":{
					c = file.getChar();
					file.increment();
					if(c=='`'){
						state = "1";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "1":{
					c = file.getChar();
					file.increment();
					if(c=='E'){
						state = "2";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "2":{
					c = file.getChar();
					file.increment();
					if(c=='O'){
						state = "3";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "3":{
					c = file.getChar();
					file.increment();
					if(c=='F'){
						state = "4";
					}
					else if(c == 'L') {
						state = "5";
					}else{
						state = "Fail";
					}
					break;
				}
				case "4":{
					EOF.setName("EOF");
					token = EOF;
					file.finalize();
					return true;
				}
				case "5":{
					EOF.setName("EOL");
					token = EOF;
					file.finalize();
					return true;
				}
				case "Fail":{
					file.reset();
					return false;
				}
			}
		}
	}
	public boolean isLOG_NOT (fileIO file){
		Token LOG_NOT = new Token("");
		String state = "Start";
		char c;
		while(true){
			switch(state){
				case "Start":{
					c = file.getChar();
					file.increment();
					if(c == '!'){
						state = "1";
					}
					else{
						state = "Fail";
					}
					break;
				}
				case "1":{
					LOG_NOT.setName("LOG_NOT");
					LOG_NOT.setLexeme("!");
					token = LOG_NOT;
					file.finalize();
					return true;
				}
				case "Fail":{
					setError(file.getError());
					file.reset();
					return false;
				}
			}
		}
	}
	public void setError(String s){
		if(error.length() <= s.length()){
			error = s;
		}
	}
}



