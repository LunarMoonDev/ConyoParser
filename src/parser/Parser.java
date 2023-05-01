package parser;

import tree.SLLNode;
import tree.SLLTree;
import scanner.fileIO;
import java.util.HashMap;
import java.util.Set;
import java.util.Stack;



import java.io.FileNotFoundException;

import scanner.SymbolTable;
import scanner.MgaDFA;
import scanner.ReserveTable;
import scanner.Token;
public class Parser {
	private SLLTree<String> parseTree;
	private String sourceCode;
	private Stack<SLLNode<String>> stack;
	private HashMap<Integer, Rule> ruleMap;
	private MgaDFA scanner;
	private fileIO file;
	private String value;
	public Parser(){
		parseTree = new SLLTree<String>();
		stack = new Stack<SLLNode<String>>();
		stack.setSize(10000);
		scanner = new MgaDFA();
		SLLNode<String> initial = new SLLNode<String>("EOF");
		initial.setState(0);
		stack.add(initial);
		ruleMap = new HashMap<Integer, Rule>();
		value = " ";
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
 
		Rule r1 = new Rule("<PROGRAM>","SIMULA <STMTS> TAPOS", 3);
		Rule r2 = new Rule("<STMTS>","ε",0);
		Rule r3 = new Rule("<STMTS>","<STMTS> <STMT>", 2);
		Rule r4 = new Rule("<STMT>","<DECLR> DELIM",2);
		Rule r5 = new Rule("<STMT>","<C_ASSN> DELIM",2); 
		Rule r6 = new Rule("<STMT>","<EXPR>",1);
		Rule r7 = new Rule("<STMT>","<CNTRL> DELIM",2);
		Rule r8 = new Rule("<STMT>","<INPUT_EXPR> DELIM",2);
		Rule r9 = new Rule("<STMT>","<OUTPUT_EXPR> DELIM",2);
		Rule r10= new Rule("<FINAL>","last_na",1);
		Rule r11= new Rule("<FINAL>","ε",0);
		Rule r12= new Rule("<DECLR>","<FINAL> DATA_TYPE IDENT <MULTI_IDENT>",4);
		Rule r13= new Rule("<DECLR>","<FINAL> DATA_TYPE IDENT <H_ASSN> <MULTI_IDENT>",5);
		Rule r14= new Rule("<MULTI_IDENT>","COMMA IDENT <MULTI_IDENT>",3);
		Rule r15= new Rule("<MULTI_IDENT>","ε",0);
		Rule r16= new Rule("<MULTI_IDENT>","COMMA IDENT <H_ASSN> <MULTI_IDENT>",4);
		Rule r17= new Rule("<H_ASSN>","ASS_OP <STRING_OP>",2);
		Rule r18= new Rule("<C_ASSN>","IDENT <H_ASSN>",2);
		Rule r19= new Rule("<STRING_OP>","<STRING_OP> dugtong <ARITHOP>",3);
		Rule r20= new Rule("<STRING_OP>","<STRING_OP> kunin_part <ARITHOP>",3);
		Rule r21= new Rule("<STRING_OP>","<STRING_OP> hanapin <ARITHOP>",3);
		Rule r22= new Rule("<STRING_OP>","<STRING_OP> haba <ARITHOP>",3);
		Rule r23= new Rule("<STRING_OP>","<ARITHOP>",1);
		Rule r24= new Rule("<ARITHOP>","<ARITHOP> ARITH_OP_LOWP <ARITHOP_TWO>",3);
		Rule r25= new Rule("<ARITHOP>","<ARITHOP_TWO>",1);
		Rule r26= new Rule("<ARITHOP_TWO>","<ARITHOP_TWO> ARITH_OP_HIGHP <LOGOP>",3);
		Rule r27= new Rule("<ARITHOP_TWO>","<LOGOP>",1);
		Rule r28= new Rule("<LOGOP>","<LOGOP> LOG_XNOR <LOGOP_TWO>",3);
		Rule r29= new Rule("<LOGOP>","<LOGOP_TWO>",1);
		Rule r30= new Rule("<LOGOP_TWO>","<LOGOP_TWO> LOG_XOR <LOGOP_THREE>",3);
		Rule r31= new Rule("<LOGOP_TWO>","<LOGOP_THREE>",1);
		Rule r32= new Rule("<LOGOP_THREE>","<LOGOP_THREE> LOG_NOTANDOR <LOGOP_FOUR>",3);
		Rule r33= new Rule("<LOGOP_THREE>","<LOGOP_FOUR>",1);
		Rule r34= new Rule("<LOGOP_FOUR>","LOG_NOT <LOGOP_FOUR>",2);
		Rule r35= new Rule("<LOGOP_FOUR>","<LOGOP_FIVE>",1);
		Rule r36= new Rule("<LOGOP_FIVE>","<LOGOP_FIVE> LOG_AND <LOGOP_SIX>",3);
		Rule r37= new Rule("<LOGOP_FIVE>","<LOGOP_SIX>",1);
		Rule r38= new Rule("<LOGOP_SIX>","<LOGOP_SIX> LOG_OR <RELOP>",3);
		Rule r39= new Rule("<LOGOP_SIX>","<RELOP>",1);
		Rule r40= new Rule("<RELOP>","<RELOP> REL_OP <RELOP_TWO>",3);
		Rule r41= new Rule("<RELOP>","<RELOP_TWO>",1);
		Rule r42= new Rule("<RELOP_TWO>","<RELOP_TWO> EQU_OP <RELOP_THREE>",3);
		Rule r43= new Rule("<RELOP_TWO>","<RELOP_TWO> Sequal <RELOP_THREE>",3);
		Rule r44= new Rule("<RELOP_TWO>","<RELOP_THREE>",1);
		Rule r45= new Rule("<RELOP_THREE>","IDENT",1);
		Rule r46= new Rule("<RELOP_THREE>","C_INT",1);
		Rule r47= new Rule("<RELOP_THREE>","C_CHAR",1);
		Rule r48= new Rule("<RELOP_THREE>","C_DOUBLE",1);
		Rule r49= new Rule("<RELOP_THREE>","C_FLOAT",1);
		Rule r50= new Rule("<RELOP_THREE>","C_BOOLEAN",1);
		Rule r51= new Rule("<RELOP_THREE>","OP_PARENTHESIS <STRING_OP> CL_PARENTHESIS",3);
		Rule r52= new Rule("<EXPR>","<SWITCH_EXPR>",1);
		Rule r53= new Rule("<EXPR>","<COND_EXPR>",1);
		Rule r54= new Rule("<EXPR>","<LOOP_EXPR>",1);
		Rule r55= new Rule("<COND_EXPR>","kung_true OP_PARENTHESIS <STRING_OP> CL_PARENTHESIS OP_BRACE <STMTS> CL_BRACE <MULTI_CON> <ELSE_EXPR>",9);
		Rule r56= new Rule("<COND_EXPR>","kung_true OP_PARENTHESIS <STRING_OP> CL_PARENTHESIS OP_BRACE <STMTS> CL_BRACE <MULTI_CON>",8);
		Rule r57= new Rule("<MULTI_CON>","edi_kung OP_PARENTHESIS <STRING_OP> CL_PARENTHESIS OP_BRACE <STMTS> CL_BRACE <MULTI_CON> ",8);
		Rule r58= new Rule("<MULTI_CON>","ε",0);
		Rule r59= new Rule("<LOOP_EXPR>","<FOR_LOOP>",1);
		Rule r60= new Rule("<LOOP_EXPR>","<DO_LOOP>",1);
		Rule r61= new Rule("<LOOP_EXPR>","<WHILE_LOOP>",1);
		Rule r62= new Rule("<FOR_LOOP>","umikot_until OP_PARENTHESIS <FOR_EXPR> CL_PARENTHESIS OP_BRACE <STMTS> CL_BRACE",7);
		Rule r63= new Rule("<FOR_EXPR>","<INITIALIZE> DELIM <STRING_OP> DELIM <INCREMENT>", 5);
		Rule r64= new Rule("<FOR_EXPR>","<STRING_OP> DELIM <INCREMENT>",3);
		Rule r65= new Rule("<FOR_EXPR>","<INITIALIZE> DELIM <STRING_OP> DELIM",4);
		Rule r66= new Rule("<FOR_EXPR>","<STRING_OP> DELIM",2);
		Rule r67= new Rule("<INITIALIZE>","<DECLR>",1);
		Rule r68= new Rule("<INITIALIZE>","<C_ASSN> <MULTI_IDENT>",2);
		Rule r69= new Rule("<DO_EXPR>","make_pasok OP_BRACE <STMTS> CL_BRACE then_ikot OP_PARENTHESIS <STRING_OP> CL_PARENTHESIS <WHILE_CATCH>",9);
		Rule r70= new Rule("<WHILE_EXPR>","while_true OP_PARENTHESIS <STRING_OP> CL_PARENTHESIS OP_BRACE <STMTS> CL_BRACE",7);
		Rule r71= new Rule("<INPUT_EXPR>","basahin_this OP_PARENTHESIS IDENT CL_PARENTHESIS",4);
		Rule r72= new Rule("<OUTPUT_EXPR>","ipakita_this OP_PARENTHESIS <STRING_OP> CL_PARENTHESIS",4);
		Rule r73= new Rule("<SWITCH_EXPR>","make_pili OP_PARENTHESIS <STRING_OP> CL_PARENTHESIS OP_BRACE <CASES> CL_BRACE", 7);
		Rule r74= new Rule("<CASES>","case <VALUE> COLON OP_BRACE <STMTS> CL_BRACE <CASES>",7);
		Rule r75= new Rule("<CASES>","No_choice_me COLON OP_BRACE <STMTS> CL_BRACE", 5);
		Rule r76= new Rule("<CASES>","ε",0);
		Rule r77= new Rule("<VALUE>","C_STR",1);
		Rule r78= new Rule("<VALUE>","C_CHAR",1);
		Rule r79= new Rule("<VALUE>","C_INT",1);
		Rule r80= new Rule("<CNTRL>","punta IDENT",2);
		Rule r81= new Rule("<CNTRL>","putol",1);
		Rule r82= new Rule("<CNTRL>","ipilit",1);
		Rule r83= new Rule("<RELOP_THREE>","C_STR",1);
		Rule r84= new Rule("<MULTI_CASSN>","COMMA <C_ASSN> <MULTI_CASSN>",3);
		Rule r85= new Rule("<MULTI_CASSN>","ε",0);
		Rule r86= new Rule("<ELSE_EXPR>","kung_not OP_BRACE <STMTS> CL_BRACE",4);
		Rule r87= new Rule("<WHILE_CATCH>","OP_BRACE <STMTS> CL_BRACE",3);
		Rule r88= new Rule("<INCREMENT>","<C_ASSN> <MULTI_CASSN>", 2);
		ruleMap.put(1, r1);
		ruleMap.put(2, r2);
		ruleMap.put(3, r3);
		ruleMap.put(4, r4);
		ruleMap.put(5, r5);
		ruleMap.put(6, r6);
		ruleMap.put(7, r7);
		ruleMap.put(8, r8);
		ruleMap.put(9, r9);
		ruleMap.put(10, r10);
		ruleMap.put(11, r11);
		ruleMap.put(12, r12);
		ruleMap.put(13, r13);
		ruleMap.put(14, r14);
		ruleMap.put(15, r15);
		ruleMap.put(16, r16);
		ruleMap.put(17, r17);
		ruleMap.put(18, r18);
		ruleMap.put(19, r19);
		ruleMap.put(20, r20);
		ruleMap.put(21, r21);
		ruleMap.put(22, r22);
		ruleMap.put(23, r23);
		ruleMap.put(24, r24);
		ruleMap.put(25, r25);
		ruleMap.put(26, r26);
		ruleMap.put(27, r27);
		ruleMap.put(28, r28);
		ruleMap.put(29, r29);
		ruleMap.put(30, r30);
		ruleMap.put(31, r31);
		ruleMap.put(32, r32);
		ruleMap.put(33, r33);
		ruleMap.put(34, r34);
		ruleMap.put(35, r35);
		ruleMap.put(36, r36);
		ruleMap.put(37, r37);
		ruleMap.put(38, r38);
		ruleMap.put(39, r39);
		ruleMap.put(40, r40);
		ruleMap.put(41, r41);
		ruleMap.put(42, r42);
		ruleMap.put(43, r43);
		ruleMap.put(44, r44);
		ruleMap.put(45, r45);
		ruleMap.put(46, r46);
		ruleMap.put(47, r47);
		ruleMap.put(48, r48);
		ruleMap.put(49, r49);
		ruleMap.put(50, r50);
		ruleMap.put(51, r51);
		ruleMap.put(52, r52);
		ruleMap.put(53, r53);
		ruleMap.put(54, r54);
		ruleMap.put(55, r55);
		ruleMap.put(56, r56);
		ruleMap.put(57, r57);
		ruleMap.put(58, r58);
		ruleMap.put(59, r59);
		ruleMap.put(60, r60);
		ruleMap.put(61, r61);
		ruleMap.put(62, r62);
		ruleMap.put(63, r63);
		ruleMap.put(64, r64);
		ruleMap.put(65, r65);
		ruleMap.put(66, r66);
		ruleMap.put(67, r67);
		ruleMap.put(68, r68);
		ruleMap.put(69, r69);
		ruleMap.put(70, r70);
		ruleMap.put(71, r71);
		ruleMap.put(72, r72);
		ruleMap.put(73, r73);
		ruleMap.put(74, r74);
		ruleMap.put(75, r75);
		ruleMap.put(76, r76);
		ruleMap.put(77, r77);
		ruleMap.put(78, r78);
		ruleMap.put(79, r79);
		ruleMap.put(80, r80);
		ruleMap.put(81, r81);
		ruleMap.put(82, r82);
		ruleMap.put(83, r83);
		ruleMap.put(84, r84);
		ruleMap.put(85, r85);
		ruleMap.put(86, r86);
		ruleMap.put(87, r87);
		ruleMap.put(88, r88);
	}
	public SLLTree<String> getParseTree() {
		return parseTree;
	}
	public void setParseTree(SLLTree<String> parseTree) {
		this.parseTree = parseTree;
	}
	public SLLTree<String> parse() throws FileNotFoundException{
		file = new fileIO(sourceCode);
		file.read();
		scanner.setFile(file);
		while(file.canIncrement()){
			Token currentToken = scanner.getToken();
			value = " ";
			switch(currentToken.getName()){
				case "SKIP":{
					break;
				}
				case "EOL":{
					break;
				}
				default:{
					try{
					while(value.length() == 0 || !(value.charAt(0) == 'S')){
					SLLNode<String> currentNode = stack.peek();
					value = ActionTable.consultACTION(currentNode.getState(), currentToken.getName());
					//System.out.println("value: "+value+" State: "+currentNode.getState()+" Token "+currentToken.getName()+" lexeme: "+currentToken.getLexeme()+"line: "+scanner.getLine());
					if(value.charAt(0) == 'S'){
						SLLNode<String> newNode = new SLLNode<String>(currentToken.getName());
						newNode.setToken(currentToken);
						newNode.setState(Integer.parseInt(value.substring(1, value.length())));
						stack.add(newNode);
					}
					else if(value.charAt(0) == 'R'){
						int rule = Integer.parseInt(value.substring(1, value.length()));
						Rule currentRule = ruleMap.get(rule);
						System.out.println(currentRule);
						int popNumber = currentRule.getGrammarSymbolsNumber();
						int iterator = popNumber;
						SLLNode<String> newNode = new SLLNode<String>(currentRule.getLeftHandSide());
						//every time there is a IDENT, DATA_TYPE, or C_BOOLEAN
						// add them in the symbol table
						// add them only if they are not in the symbol table also if there are not in the reserve table
						/*
						 * if the current rule has a block statement then the symbol table must be placed in the head( fix this in dissolve )
						 *		and create a new symboltable
						 *		semantic analyzer will arrange those symbol table don't worry 	
						 */
						//if(currentRule == ruleMap.get)
						while(iterator > 0){
							SLLNode<String> Node = parseTree.setChild(newNode, stack.pop());
							iterator--;	
						}
						//System.out.println("R: "+stack.peek().getState()+" Variable: "+currentRule.getLeftHandSide());
						newNode.setState(Integer.parseInt(GotoTable.consultGOTO(stack.peek().getState(), currentRule.getLeftHandSide() )));
						newNode = parseTree.dissolve(newNode);
						parseTree.storeSymbolTable(newNode);
						if(newNode.getSymbolTable() != null)
							debugSymbolTable(newNode.getSymbolTable());
						//System.out.println(newNode+"\n");
						stack.add(newNode);
					}
					else if(value.equals("accept")){
						Rule currentRule = ruleMap.get(1);
						System.out.println(currentRule);
						int popNumber = 3;
						int iterator = popNumber;
						SLLNode<String> newNode = new SLLNode<String>("program");
						while(iterator > 0){
							SLLNode<String> Node = parseTree.setChild(newNode, stack.pop());	
							iterator--;
						}
						newNode.setState(Integer.parseInt(GotoTable.consultGOTO(stack.peek().getState(), "<PROGRAM>")));
						newNode = parseTree.dissolve(newNode);
						//parseTree.storeSymbolTable(newNode);
						parseTree.createSymbolTable(newNode);
						/*
						if(newNode.getSymbolTable() != null){
							System.out.print("\nparent: "+newNode.info);
							debugSymbolTable(newNode.getSymbolTable());
						}
						*/
						parseTree.setRoot(newNode);
						break;
					}
					}
					break;
				}
				catch(NumberFormatException e){
					System.out.print("GOTO not found!");
					break;
				}
				}
			}
		}
		return parseTree;
	}
	public String getSourceCode() {
		return sourceCode;
	}
	public Rule getRule(String variables, String yield){
		String[] var = variables.split(" ");
		Rule rule = null;
		for(int i = 1; i <= 86; i++){
			for(int j = 0; j < var.length; j++){
				if(ruleMap.get(i).getLeftHandSide().equals(var[j])){
					if(ruleMap.get(i).getRightHandSide().contains(yield)){
						return ruleMap.get(i);
					}
				}
			}
		}
		return rule;
	}
	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}
	public void debugSymbolTable(SymbolTable table){
		Set<String> keys = table.getTable().keySet();
		System.out.print("\nKey set: ");
		for(String key: keys){
            System.out.print(key+" ");
        }
		System.out.println("\n");
	}
}
