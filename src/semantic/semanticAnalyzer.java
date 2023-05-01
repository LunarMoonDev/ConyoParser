package semantic;

import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

import parser.Operations;
import scanner.SymbolTable;
import scanner.Token;
import tree.SLLNode;

public class semanticAnalyzer {
	private Stack<SymbolTable> stackSymbol;
	private Operations calculator;
	public semanticAnalyzer(){
		calculator = new Operations();
		stackSymbol = new Stack<SymbolTable>();
		calculator.setStack(stackSymbol);
	}
	public void Semantic(SLLNode<String> p){
		if(p.info.equals("program")){
		stackSymbol.push(p.getSymbolTable());
		for(SLLNode<String> k = p.firstChild; k!=null; k=k.nextBrother){
			switch(k.info){
			case "declarationStatement":{
				evalDeclaration(k);
				break;
			}
			case "assignmentStatement":{
				evalAssignment(k);
				break;
			}
			case "inputStatement":{
				inputStatement(k);
				break;
			}
			case "outputStatement":{
				outputStatement(k);
				break;
			}
			case "switchStatement":{
				evalSwitch(k);
				break;
			}
			case "ifStatement":{
				ifStatement(k);
				break;
			}
			case "forStatement":{
				forStatement(k);
				break;
			}
			case "doStatement":{
				evalDoWhile(k);
				break;
			}
			case "whileStatement":{
				whileStatement(k);
				break;
			}
			}
		}
		if(p.info.equals("program")){
			stackSymbol.pop();
		}
		}
		else{
			switch(p.info){
			case "declarationStatement":{
				evalDeclaration(p);
				break;
			}
			case "assignmentStatement":{
				evalAssignment(p);
				break;
			}
			case "inputStatement":{
				inputStatement(p);
				break;
			}
			case "outputStatement":{
				outputStatement(p);
				break;
			}
			case "switchStatement":{
				evalSwitch(p);
				break;
			}
			case "ifStatement":{
				ifStatement(p);
				break;
			}
			case "forStatement":{
				forStatement(p);
				break;
			}
			case "doStatement":{
				evalDoWhile(p);
				break;
			}
			case "whileStatement":{
				whileStatement(p);
				break;
			}
			}
		}
	}	
	public Token getTokenSymbol(String lexeme, String parentInfo){
			Stack<SymbolTable> usedSymbolTables = new Stack<SymbolTable>();
			if(parentInfo.equals("forStatement")){
				usedSymbolTables.push(stackSymbol.pop());
			}
			while(!stackSymbol.isEmpty()){
				SymbolTable table = stackSymbol.pop();
				Token token = table.get(lexeme);
				usedSymbolTables.push(table);
				if(token != null){
					while(!usedSymbolTables.isEmpty()){
						stackSymbol.push(usedSymbolTables.pop());
					}
					return token;
				}
			}
			while(!usedSymbolTables.isEmpty()){
				stackSymbol.push(usedSymbolTables.pop());
			}
			return null;
		}
	public void updateTokenSymbol(String lexeme, String parentInfo, String attribute, String updatedValue){
			Stack<SymbolTable> usedSymbolTables = new Stack<SymbolTable>();
			if(parentInfo.equals("forStatement")){
				usedSymbolTables.push(stackSymbol.pop());
			}
			while(!stackSymbol.isEmpty()){
				SymbolTable table = stackSymbol.pop();
				Token token = table.get(lexeme);
				usedSymbolTables.push(table);
				if(token != null){
					if(attribute.equals("value")){
						token.setValue(updatedValue);
					}
					else if(attribute.equals("actualType")){
						token.setActualType(updatedValue);
					}
					else if(attribute.equals("expectedType")){
						token.setExpectedType(updatedValue);
					}
					while(!usedSymbolTables.isEmpty()){
						stackSymbol.push(usedSymbolTables.pop());
					}
					break;
				}
				else{
					
				}
			}
			while(!usedSymbolTables.isEmpty()){
				stackSymbol.push(usedSymbolTables.pop());
			}
		}
	//Banting's work
	public void forStatement(SLLNode<String> parent) {
		stackSymbol.push(parent.getSymbolTable());
		SLLNode<String> firstchild = parent.firstChild;
		SLLNode<String> pointer = null;
		SLLNode<String> p = firstchild.nextBrother;
		if (p.info.equals("declarationStatement")) {
			evalDeclaration(p);
			pointer = p;
		} else if (p.info.equals("assignmentStatement")) {
			evalAssignment(p);
			pointer = p;
		}
		for (p = pointer.nextBrother; p != null; p = p.nextBrother) {
			SLLNode<String> cond = p;
			cond = calculator.evaluate(cond);
			Token stringOP = cond.getToken();
			if (stringOP.getErrorMessage().length() == 0) {
				if (stringOP.getValue().equals("true")) {
					for (SLLNode<String> stmts = p.nextBrother.nextBrother; stmts != null; stmts = stmts.nextBrother) {
						 Semantic(stmts);
					}
				} else {
					break;
				}
			} else {
				// error mismatched type
				System.out.println(stringOP.getErrorMessage());
			}
			SLLNode<String> increment = pointer.nextBrother.nextBrother;
			evalAssignment(increment);
			p = pointer;
		}
		stackSymbol.pop();
	}
	public void whileStatement(SLLNode<String> parent) {
		stackSymbol.push(parent.getSymbolTable());
		SLLNode<String> firstchild = parent.firstChild;
		SLLNode<String> pointer = null;
		SLLNode<String> p = firstchild;
		if (p.info.equals("while_true")) {
			pointer = p;
		}
		for (p = pointer.nextBrother; p != null; p = p.nextBrother) {
			SLLNode<String> cond = p;
			cond = calculator.evaluate(cond);
			Token stringOP = cond.getToken();
			if (stringOP.getErrorMessage().length() == 0) {
				if (stringOP.getValue().equals("true")) {
					for (SLLNode<String> stmts = p.nextBrother; stmts != null; stmts = stmts.nextBrother) {
						Semantic(stmts);
					}
				} else {
					break;
				}
			} else {
				// error mismatch
				System.out.print(stringOP.getErrorMessage());
			}
			p = pointer;
		}
	}
	// start of if statement
	public void ifStatement(SLLNode<String> parent) {
		stackSymbol.push(parent.getSymbolTable());
		SLLNode<String> firstchild = parent.firstChild;
		SLLNode<String> cond = firstchild.nextBrother;
		cond = calculator.evaluate(cond);
		Token stringOP = cond.getToken();
		if (stringOP.getErrorMessage().length() == 0) {
			if (stringOP.getValue().equals("true")) {
				for (SLLNode<String> stmts = firstchild.nextBrother.nextBrother; stmts != null; stmts = stmts.nextBrother) {
					if ((stmts.info.equals("elseIfStatement")) || (stmts.info.equals("elseStatement"))) {
						break;
					} else {
						Semantic(stmts);
					}
				}
			} else {
				stackSymbol.pop();
				for (SLLNode<String> elseIf = firstchild.nextBrother.nextBrother; elseIf != null; elseIf = elseIf.nextBrother) {
					if (elseIf.info.equals("elseIfStatement")) {
						boolean check = elseIfStatement(elseIf);
						if (check) {
							break;
						} else {
							if(elseIf.nextBrother!=null)
							elseStatement(elseIf.nextBrother);
							break;
						}
					}
							// if no elseIf statement
					if (elseIf.info.equals("elseStatement")) {
						elseStatement(elseIf);
						break;
					}
				}
			}
		} else {
					// error mismatch
			System.out.print(stringOP.getErrorMessage());
		}
	}
	public boolean elseIfStatement(SLLNode<String> parent) {
		stackSymbol.push(parent.getSymbolTable());
		SLLNode<String> firstchild = parent.firstChild;
		SLLNode<String> cond = firstchild.nextBrother;
		cond = calculator.evaluate(cond);
		Token stringOP = cond.getToken();
		if (stringOP.getErrorMessage().length() == 0) {
			if (stringOP.getValue().equals("true")) {
				for (SLLNode<String> stmts = firstchild.nextBrother.nextBrother; stmts != null; stmts = stmts.nextBrother) {
					if (stmts.info.equals("elseIfStatement")) {
						break;
					} else {
						Semantic(stmts);
					}
				}
				return true;
			} else {
				stackSymbol.pop();
				for (SLLNode<String> elseIf = firstchild.nextBrother.nextBrother; elseIf != null; elseIf = elseIf.nextBrother) {
					if (elseIf.info.equals("elseIfStatement")) {
						return elseIfStatement(elseIf);
					}
				}
			}
		} else {
				// error mismatch
				System.out.print(stringOP.getErrorMessage());
		}
	return false;
	}
	public void elseStatement(SLLNode<String> parent) {
		stackSymbol.push(parent.getSymbolTable());
		//SymbolTable g = parent.getSymbolTable();
		//debugSymbolTable(g);
		SLLNode<String> firstchild = parent.firstChild;
		for (SLLNode<String> p = firstchild; p != null; p = p.nextBrother) {
			if (p.info.equals("kung_not")) {
				// do nothing
			} else {
				Semantic(p);
			}
		}
		stackSymbol.pop();
	}
	public void debugSymbolTable(SymbolTable table){
		Set<String> keys = table.getTable().keySet();
		System.out.print("\nKey set: ");
		for(String key: keys){
            System.out.print(key+" ");
        }
		System.out.println("\n");
	}
	// end of if statement
	public void outputStatement(SLLNode<String> parent) {
		SLLNode<String> firstchild = parent.firstChild;
		SLLNode<String> output = firstchild.nextBrother;
		String operations = "dugtong hanapin kunin_part haba ARITH_OP_HIGHP ARITH_OP_LOWP REL_OP EQU_OP LOG_XNOR LOG_XOR LOG_NOTANDOR LOG_AND LOG_OR";
		String constantToken = "C_INT C_FLOAT C_DOUBLE C_CHAR C_STR";
		String type = "s_var c_var i_var d_var f_var b_var";
		if (operations.indexOf(output.info) >= 0) {
			output = calculator.evaluate(output);
			Token stringOP = output.getToken();
			if (stringOP.getErrorMessage().length() == 0) {
					if(stringOP.getExpectedType().equals("s_var")){
						if(stringOP.getValue().contains("\\")){
							String[] stringArray = stringOP.getValue().split("\\\\n");
								if(stringArray.length > 0)
								for (int i = 0; i < stringArray.length; i++) {
									System.out.println(stringArray[i].substring(0, stringArray[i].length() - 1));
								}
								else
									System.out.println();
						}
						else{
							System.out.print(stringOP.getValue());
						}
					}
					else{
						System.out.print(stringOP.getValue());
					}
			} else {
				// error mismatch
				System.out.print(stringOP.getErrorMessage());
			}
		}
		else if (constantToken.indexOf(output.info) >= 0) {
				if(output.getToken().getExpectedType().equals("s_var")){ 
					if(calculator.evaluate(output).getToken().getValue().contains("\\")){
						String[] stringArray = calculator.evaluate(output).getToken().getValue().split("\\\\n");
							if(stringArray.length > 0)
							for (int i = 0; i < stringArray.length; i++) {
								System.out.println(stringArray[i].substring(0, stringArray[i].length() - 1));
							}
							else
								System.out.println();
						}
					else{
						calculator.evaluate(output);
						System.out.print(output.getToken().getValue());
					}
				}
				else{
					
				}
		}
		else if(output.info.equals("IDENT")){
			Token ident = getTokenSymbol(output.getToken().getLexeme(), parent.info);
			if(ident != null){
				if(type.indexOf(ident.getActualType()) > -1 ){
					if(ident.getActualType().equals("s_var")){
						if(calculator.evaluate(output).getToken().getValue().contains("\\")){
							String[] stringArray = calculator.evaluate(output).getToken().getValue().split("\\\\n");
								if(stringArray.length > 0)
									for (int i = 0; i < stringArray.length; i++) {
										System.out.println(stringArray[i].substring(0, stringArray[i].length() - 1));
									}
								else
									System.out.println();
						}
						else{
							System.out.print(ident.getValue());
						}
					}
					else{
						System.out.print(ident.getValue());
					}
				}
			}
			else{
				System.out.println("ERROR! missing identifier.");
			}
		}
	}
	public void inputStatement(SLLNode<String> parent) {
		Scanner scan = new Scanner(System.in);
		String value = null;
		SLLNode<String> firstchild = parent.firstChild;
		SLLNode<String> input = firstchild.nextBrother;
		Token ident = getTokenSymbol(input.getToken().getLexeme(), parent.info);
		String type = ident.getActualType();
		if(type.equals("i_var")){
			value = Integer.toString(scan.nextInt());
		}
		else if(type.equals("f_var")){
			value = Float.toString(scan.nextFloat()) + "f";
		}
		else if(type.equals("d_var")){
			value = Double.toString(scan.nextDouble());
		}
		else if(type.equals("s_var")){
			value = scan.nextLine();
		}
		else if(type.equals("c_char")){
			value = Character.toString(scan.next().charAt(0));
		}
		else{
			//error boolean
			System.out.print("ERROR! we cannot output a boolean");
		}
		updateTokenSymbol(ident.getLexeme(), parent.info, "value", value);
		scan.close();
	}	
	//Renzo's work
	public void evalDoWhile(SLLNode<String> parent){
		stackSymbol.push(parent.getSymbolTable());
		SLLNode<String> p = parent.firstChild; 							//make_pasok child
		for(SLLNode<String> o = p.nextBrother; o != null; o = o.nextBrother){
			if(!o.info.equals("then_ikot")){ 							//not yet then_ikot
				Semantic(o);
			} else {													//then_ikot node
				SLLNode<String> eval = calculator.evaluate(o.nextBrother);
				String value = eval.getToken().getValue();
				if(eval.getToken().getErrorMessage().length() == 0){
					if(value.equals("true")){
						o = p;											//this will now point at the make_pasok's sibling
					} else {
						while(!o.info.equals("whileCatchStatement")){	//find whileCatchStatement
							o = o.nextBrother;	
						}
						stackSymbol.push(o.getSymbolTable());
						o = o.firstChild;								//get child of whileCatchStatement
						while(o != null){
							Semantic(o);
							o = o.nextBrother;
						}
						stackSymbol.pop();
						break;
					}
				} else {
					//throw an error
					System.out.print(eval.getToken().getErrorMessage());
				}
			}
			
		}
		stackSymbol.pop();
	}
	//start of Switch
	public void evalSwitch(SLLNode<String> parent) {
		stackSymbol.push(parent.getSymbolTable());
		SLLNode<String> c = parent.firstChild;
		SLLNode<String> strOp = c.nextBrother;
		SLLNode<String> evalStrOp = calculator.evaluate(c.nextBrother);
		if(evalStrOp.getToken().getErrorMessage().length() == 0) {
			String switchVal = evalStrOp.getToken().getValue();
			evalCase(strOp.nextBrother, switchVal);
		}
		
	}
	public void evalCase(SLLNode<String> parent, String switchVal) {
		/*
		stackSymbol.push(parent.getSymbolTable());
		SLLNode<String> p = parent.firstChild;
		SLLNode<String> expr = calculator.evaluate(p.nextBrother);
		if(expr.getToken().getErrorMessage().length() == 0){
			String val = expr.getToken().getValue();
			if(p.info.equals("no_choice_me")){
				Semantic(p.nextBrother.nextBrother);
			} else if(val.equals(switchVal)){
				Semantic(p.nextBrother.nextBrother);
			} else {
				while(p != null){
					if(p.info.equals("caseStatement")){
						evalCase(p, switchVal);
					}
					p = p.nextBrother;
				}
			}
		} else {
			//throw error
		}
		stackSymbol.pop();
		*/
		stackSymbol.push(parent.getSymbolTable());
		if(parent.firstChild.info.equals("no_choice_me")){
			SLLNode<String> p = parent.firstChild.nextBrother;
			while(p != null){
				Semantic(p);
				p = p.nextBrother;
			}
			stackSymbol.pop();
		}
		else if(parent.firstChild.nextBrother.getToken().getLexeme().equals(switchVal)){
			SLLNode<String> p = parent.firstChild.nextBrother.nextBrother;
			while(p != null){
				Semantic(p);
				p = p.nextBrother;
			}
			stackSymbol.pop();
		}
		else{
			stackSymbol.pop();
			SLLNode<String> p = parent.firstChild;
			while(p != null){
				if(p.info.equals("caseStatement")){
					evalCase(p,switchVal);
				}
				p =p.nextBrother;
			}
		}
	}
	//end of Case
	public void evalDeclaration(SLLNode<String> parent) {
		String dataType = null;
		for(SLLNode<String> o = parent.firstChild; o != null; o = o.nextBrother){
			if(o.info.equals("DATA_TYPE")){
				dataType = o.getToken().getLexeme();
			} else if(o.info.equals("COMMA")) {
				// do nothing
			} else if(o.info.equals("IDENT") && o.nextBrother != null) {
				Token token = o.getToken(); 												//get ident token
				String key  = token.getLexeme();
				updateTokenSymbol(key, parent.info, "actualType", dataType); 	//update actualttype for token
				if(o.nextBrother.info.equals("ASS_OP")) { 									//if ident is next to assop
					SLLNode<String> expr = o.nextBrother.nextBrother; 						//get token after assop
					expr = calculator.evaluate(expr);
					if(expr.getToken().getErrorMessage().length() == 0){
						Token tokenFromSymbol = getTokenSymbol(key, parent.info);
						if(tokenFromSymbol != null){
							if(tokenFromSymbol.getActualType().equals(expr.getToken().getExpectedType())){
								updateTokenSymbol(key, parent.info, "value", expr.getToken().getValue());
							} else {
								System.out.println("ERROR! Value does not match with data_type lexeme:"+expr.getToken().getLexeme()+" "+expr.getToken().getName());
							}
						} else {
							//throw error, missing identifier
							System.out.println("ERROR! missing identifier.");
						}
					}
					else{
						System.out.println(expr.getToken().getErrorMessage());
					}
				}
			}
			else if(o.info.equals("IDENT") && o.nextBrother == null){
				Token token = o.getToken(); 												//get ident token
				String key  = token.getLexeme();
				updateTokenSymbol(key, parent.info, "actualType", dataType); 	//update actualttype for token
			}
			else if(o.info.equals("DELIM")) {
				break;
			}
		}
	}
	public void evalAssignment(SLLNode<String> parent){
		String key = null;
		Token tokenFrmSymb = null;
		for(SLLNode<String> o = parent.firstChild; o != null; o = o.nextBrother){ //traverse
			if(o.info.equals("IDENT")){
				tokenFrmSymb = getTokenSymbol(o.getToken().getLexeme(), parent.info);
				key = tokenFrmSymb.getLexeme();
			} else if (o.info.equals("ASS_OP")) {
				SLLNode<String> expr = calculator.evaluate(o.nextBrother); 					//calculator.evaluate next sibling of assop, store val
				if(expr.getToken().getErrorMessage().length() == 0){
					if(tokenFrmSymb != null) {
						if(tokenFrmSymb.getActualType().equals(expr.getToken().getExpectedType()))
							updateTokenSymbol(key, parent.info, "value", expr.getToken().getValue());
						else{
							//throw error, invalid ident data type
							updateTokenSymbol(key, parent.info, "value", expr.getToken().getValue());
						}
					} else {
						//throw error, not yet declared!
						System.out.println("ERROR! missing identifier.");
					}
				} else {
					//throw error, error message in eval
					System.out.println(expr.getToken().getErrorMessage());
				}
			}
		}
	}	

}
