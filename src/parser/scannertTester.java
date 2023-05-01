package parser;

import java.io.FileNotFoundException;

import scanner.MgaDFA;
import scanner.ReserveTable;
import scanner.Token;
import scanner.fileIO;

public class scannertTester {
	public static void main(String[] args) throws FileNotFoundException {
		MgaDFA scanner = new MgaDFA();
		ReserveTable.put("SIMULA", new Token("SIMULA"));
		ReserveTable.put("Sgreater", new Token("REL_OP","Sgreater"));
		ReserveTable.put("Slesser", new Token("REL_OP","Slesser"));
		ReserveTable.put(">=", new Token("REL_OP",">="));
		ReserveTable.put(">", new Token("REL_OP",">"));
		ReserveTable.put("<=", new Token("REL_OP","<="));
		ReserveTable.put("<", new Token("REL_OP","<"));
		ReserveTable.put("(", new Token("OP_PARENTHESIS"));
		ReserveTable.put("[", new Token("OP_BRACKET"));
		ReserveTable.put("{", new Token("OP_BRACE"));
		ReserveTable.put("@", new Token("LOG_XOR"));
		ReserveTable.put("!@", new Token("LOG_XNOR"));
		ReserveTable.put("||", new Token("LOG_OR"));
		ReserveTable.put("!&", new Token("LOG_NOTANDOR","!&"));
		ReserveTable.put("!|", new Token("LOG_NOTANDOR","!|"));
		ReserveTable.put("&&", new Token("LOG_AND"));
		ReserveTable.put(";", new Token("DELIM"));
		ReserveTable.put("==", new Token("EQU_OP","=="));
		ReserveTable.put("!=", new Token("EQU_OP","!="));
		ReserveTable.put(",", new Token("COMMA"));
		ReserveTable.put(")", new Token("CL_PARENTHESIS"));
		ReserveTable.put("]", new Token("CL_BREACKET"));
		ReserveTable.put(":=", new Token("ASS_OP"));
		ReserveTable.put("+", new Token("ARITH_OP_LOWP","+"));
		ReserveTable.put("-", new Token("ARITH_OP_LOWP","-"));
		ReserveTable.put("*", new Token("ARITH_OP_HIGHP","*"));
		ReserveTable.put("/", new Token("ARITH_OP_HIGHP","/"));
		ReserveTable.put("TAPOS", new Token("TAPOS"));
		ReserveTable.put("make_pasok", new Token("make_pasok"));
		ReserveTable.put("then_ikot", new Token("then_ikot"));
		ReserveTable.put("while_true", new Token("while_true"));
		ReserveTable.put("ipakita_this", new Token("ipakita_this"));
		ReserveTable.put("basahin_this", new Token("basahin_this"));
		
		ReserveTable.put("kung_true", new Token("kung_true"));
		ReserveTable.put("kung_not", new Token("kung_not"));
		ReserveTable.put("last_na", new Token("last_na"));
		ReserveTable.put("ipilit", new Token("ipilit"));
		ReserveTable.put("make_pili", new Token("make_pili"));
		ReserveTable.put("case", new Token("case"));
		ReserveTable.put("no_choice_me", new Token("no_choice_me"));
		ReserveTable.put("dugtong", new Token("dugtong"));
		ReserveTable.put("kunin_part", new Token("kunin_part"));
		ReserveTable.put("hanapin", new Token("hanapin"));
		ReserveTable.put("haba", new Token("haba"));
		ReserveTable.put("punta", new Token("punta"));
		ReserveTable.put("putol", new Token("putol"));
		ReserveTable.put("Sequal", new Token("Sequal"));
		ReserveTable.put("edi_kung", new Token("edi_kung"));
		ReserveTable.put(":", new Token("COLON"));
		
		
		fileIO file = new fileIO("test2.txt");
		file.read();
		scanner.setFile(file);
		while(file.canIncrement()) {
			Token currentToken = scanner.getToken();
			switch(currentToken.getName()){
				case "SKIP":{
					break;
				}
				case "EOL":{
					System.out.print("\n");
					break;
				}
				case "EOF":{
					System.out.print("\nScanning complete....");
					break;
				}
				default:{
					System.out.print(currentToken);
					break;
				}
			}
		}
	}
	
	
}
