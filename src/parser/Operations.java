package parser;

import java.util.Stack;

import scanner.SymbolTable;
import scanner.Token;
import tree.SLLNode;

public class Operations {
	private Stack<SymbolTable> stack = new Stack<SymbolTable>();
	public Stack<SymbolTable> getStack() {
		return stack;
	}
	public void setStack(Stack<SymbolTable> stack) {
		this.stack = stack;
	}
	public static <T extends Number> double add(T one, T two){
		return one.doubleValue() + two.doubleValue();
	}
	public static <T extends Number> double mult(T one, T two){
		return one.doubleValue() * two.doubleValue();
	}
	public static <T extends Number> double subt(T one, T two){
		return one.doubleValue() - two.doubleValue();
	}
	public static <T extends Number> double div(T one, T two){
		return one.doubleValue() / two.doubleValue();
	}
	public static boolean greater(String one, String two, String oneType, String twoType){
		float onef =0F, twof=0F;
		double oned =0, twod=0;
		int onei=0, twoi=0;
		switch(oneType){
			case "i_var":{
				onei = Integer.parseInt(one);
				break;
			}
			case "f_var":{
				onef = Float.parseFloat(one);
				break;
			}
			case "d_var":{
				oned = Double.parseDouble(one);
				break;
			}
		}
		switch(twoType){
		case "i_var":{
			twoi = Integer.parseInt(two);
			break;
		}
		case "f_var":{
			twof = Float.parseFloat(two);
			break;
		}
		case "d_var":{
			twod = Double.parseDouble(two);
			break;
		}
		}
		if(oneType.equals("i_var") && twoType.equals("i_var")){
			return onei > twoi;	
		}
		else if(oneType.equals("d_var") && twoType.equals("d_var")){
			return oned > twod;
		}
		else if(oneType.equals("f_var") && twoType.equals("f_var")){
			return onef > twof;
		}
		else if(oneType.equals("d_var") && twoType.equals("i_var")){
			return oned > twoi;
		}
		else if(oneType.equals("i_var") && twoType.equals("d_var")){
			return onei > twod;
		}
		else if(oneType.equals("d_var") && twoType.equals("f_var")){
			return oned > twof;
		}
		else if(oneType.equals("f_var") && twoType.equals("d_var")){
			return onef > twod;
		}
		else if(oneType.equals("f_var") && twoType.equals("i_var")){
			return onef > twoi;
		}
		else if(oneType.equals("i_var") && twoType.equals("f_var")){
			return onei > twof;
		}
		return one.compareTo(two) > 0;
	}
	public static boolean greater(String one, String two){
		return one.compareTo(two) > 0;
	}
	public static  boolean lesser(String one, String two, String oneType, String twoType){
		float onef =0F, twof=0F;
		double oned =0, twod=0;
		int onei=0, twoi=0;
		switch(oneType){
			case "i_var":{
				onei = Integer.parseInt(one);
				break;
			}
			case "f_var":{
				onef = Float.parseFloat(one);
				break;
			}
			case "d_var":{
				oned = Double.parseDouble(one);
				break;
			}
		}
		switch(twoType){
		case "i_var":{
			twoi = Integer.parseInt(two);
			break;
		}
		case "f_var":{
			twof = Float.parseFloat(two);
			break;
		}
		case "d_var":{
			twod = Double.parseDouble(two);
			break;
		}
		}
		if(oneType.equals("i_var") && twoType.equals("i_var")){
			return onei < twoi;	
		}
		else if(oneType.equals("d_var") && twoType.equals("d_var")){
			return oned < twod;
		}
		else if(oneType.equals("f_var") && twoType.equals("f_var")){
			return onef < twof;
		}
		else if(oneType.equals("d_var") && twoType.equals("i_var")){
			return oned < twoi;
		}
		else if(oneType.equals("i_var") && twoType.equals("d_var")){
			return onei < twod;
		}
		else if(oneType.equals("d_var") && twoType.equals("f_var")){
			return oned < twof;
		}
		else if(oneType.equals("f_var") && twoType.equals("d_var")){
			return onef < twod;
		}
		else if(oneType.equals("f_var") && twoType.equals("i_var")){
			return onef < twoi;
		}
		else if(oneType.equals("i_var") && twoType.equals("f_var")){
			return onei < twof;
		}
		return one.compareTo(two) < 0;
	}
	public static  boolean lesser(String one, String two){
		return one.compareTo(two) < 0;
	}
	public static  boolean greaterEqual(String one, String two, String oneType, String twoType){
		float onef =0F, twof=0F;
		double oned =0, twod=0;
		int onei=0, twoi=0;
		switch(oneType){
			case "i_var":{
				onei = Integer.parseInt(one);
				break;
			}
			case "f_var":{
				onef = Float.parseFloat(one);
				break;
			}
			case "d_var":{
				oned = Double.parseDouble(one);
				break;
			}
		}
		switch(twoType){
		case "i_var":{
			twoi = Integer.parseInt(two);
			break;
		}
		case "f_var":{
			twof = Float.parseFloat(two);
			break;
		}
		case "d_var":{
			twod = Double.parseDouble(two);
			break;
		}
		}
		if(oneType.equals("i_var") && twoType.equals("i_var")){
			return onei >= twoi;	
		}
		else if(oneType.equals("d_var") && twoType.equals("d_var")){
			return oned >= twod;
		}
		else if(oneType.equals("f_var") && twoType.equals("f_var")){
			return onef >= twof;
		}
		else if(oneType.equals("d_var") && twoType.equals("i_var")){
			return oned >= twoi;
		}
		else if(oneType.equals("i_var") && twoType.equals("d_var")){
			return onei >= twod;
		}
		else if(oneType.equals("d_var") && twoType.equals("f_var")){
			return oned >= twof;
		}
		else if(oneType.equals("f_var") && twoType.equals("d_var")){
			return onef >= twod;
		}
		else if(oneType.equals("f_var") && twoType.equals("i_var")){
			return onef >= twoi;
		}
		else if(oneType.equals("i_var") && twoType.equals("f_var")){
			return onei >= twof;
		}
		return one.compareTo(two) >= 0;
	}
	public static  boolean greaterEqual(String one, String two){
		return one.compareTo(two) >= 0;
	}
	public static boolean lesserEqual(String one, String two, String oneType, String twoType){
		float onef =0F, twof=0F;
		double oned =0, twod=0;
		int onei=0, twoi=0;
		switch(oneType){
			case "i_var":{
				onei = Integer.parseInt(one);
				break;
			}
			case "f_var":{
				onef = Float.parseFloat(one);
				break;
			}
			case "d_var":{
				oned = Double.parseDouble(one);
				break;
			}
		}
		switch(twoType){
		case "i_var":{
			twoi = Integer.parseInt(two);
			break;
		}
		case "f_var":{
			twof = Float.parseFloat(two);
			break;
		}
		case "d_var":{
			twod = Double.parseDouble(two);
			break;
		}
		}
		if(oneType.equals("i_var") && twoType.equals("i_var")){
			return onei <= twoi;	
		}
		else if(oneType.equals("d_var") && twoType.equals("d_var")){
			return oned <= twod;
		}
		else if(oneType.equals("f_var") && twoType.equals("f_var")){
			return onef <= twof;
		}
		else if(oneType.equals("d_var") && twoType.equals("i_var")){
			return oned <= twoi;
		}
		else if(oneType.equals("i_var") && twoType.equals("d_var")){
			return onei <= twod;
		}
		else if(oneType.equals("d_var") && twoType.equals("f_var")){
			return oned <= twof;
		}
		else if(oneType.equals("f_var") && twoType.equals("d_var")){
			return onef <= twod;
		}
		else if(oneType.equals("f_var") && twoType.equals("i_var")){
			return onef <= twoi;
		}
		else if(oneType.equals("i_var") && twoType.equals("f_var")){
			return onei <= twof;
		}
		return one.compareTo(two) <= 0;
	}
	public static boolean lesserEqual(String one, String two){
		return one.compareTo(two) <= 0;
	}
	public static  boolean equal(String one, String two, String oneType, String twoType){
		float onef =0F, twof=0F;
		double oned =0, twod=0;
		int onei=0, twoi=0;
		switch(oneType){
			case "i_var":{
				onei = Integer.parseInt(one);
				break;
			}
			case "f_var":{
				onef = Float.parseFloat(one);
				break;
			}
			case "d_var":{
				oned = Double.parseDouble(one);
				break;
			}
		}
		switch(twoType){
		case "i_var":{
			twoi = Integer.parseInt(two);
			break;
		}
		case "f_var":{
			twof = Float.parseFloat(two);
			break;
		}
		case "d_var":{
			twod = Double.parseDouble(two);
			break;
		}
		}
		if(oneType.equals("i_var") && twoType.equals("i_var")){
			return onei == twoi;	
		}
		else if(oneType.equals("d_var") && twoType.equals("d_var")){
			return oned == twod;
		}
		else if(oneType.equals("f_var") && twoType.equals("f_var")){
			return onef == twof;
		}
		else if(oneType.equals("d_var") && twoType.equals("i_var")){
			return oned == twoi;
		}
		else if(oneType.equals("i_var") && twoType.equals("d_var")){
			return onei == twod;
		}
		else if(oneType.equals("d_var") && twoType.equals("f_var")){
			return oned == twof;
		}
		else if(oneType.equals("f_var") && twoType.equals("d_var")){
			return onef == twod;
		}
		else if(oneType.equals("f_var") && twoType.equals("i_var")){
			return onef == twoi;
		}
		else if(oneType.equals("i_var") && twoType.equals("f_var")){
			return onei == twof;
		}
		return one.compareTo(two) == 0;
	}
	public static  boolean equal(String one, String two){
		return one.compareTo(two) == 0;
	}
	public static  boolean notEqual(String one, String two, String oneType, String twoType){
		float onef =0F, twof=0F;
		double oned =0, twod=0;
		int onei=0, twoi=0;
		switch(oneType){
			case "i_var":{
				onei = Integer.parseInt(one);
				break;
			}
			case "f_var":{
				onef = Float.parseFloat(one);
				break;
			}
			case "d_var":{
				oned = Double.parseDouble(one);
				break;
			}
		}
		switch(twoType){
		case "i_var":{
			twoi = Integer.parseInt(two);
			break;
		}
		case "f_var":{
			twof = Float.parseFloat(two);
			break;
		}
		case "d_var":{
			twod = Double.parseDouble(two);
			break;
		}
		}
		if(oneType.equals("i_var") && twoType.equals("i_var")){
			return onei != twoi;	
		}
		else if(oneType.equals("d_var") && twoType.equals("d_var")){
			return oned != twod;
		}
		else if(oneType.equals("f_var") && twoType.equals("f_var")){
			return onef != twof;
		}
		else if(oneType.equals("d_var") && twoType.equals("i_var")){
			return oned != twoi;
		}
		else if(oneType.equals("i_var") && twoType.equals("d_var")){
			return onei != twod;
		}
		else if(oneType.equals("d_var") && twoType.equals("f_var")){
			return oned != twof;
		}
		else if(oneType.equals("f_var") && twoType.equals("d_var")){
			return onef != twod;
		}
		else if(oneType.equals("f_var") && twoType.equals("i_var")){
			return onef != twoi;
		}
		else if(oneType.equals("i_var") && twoType.equals("f_var")){
			return onei != twof;
		}
		return one.compareTo(two) != 0;
	}
	public static  boolean notEqual(String one, String two){
		return one.compareTo(two) != 0;
	}
	public static boolean xnor(boolean one, boolean two){
		return !xor(one,two);
	}
	public static boolean xor(boolean one, boolean two){
		return (one || two) && (!one || !two);
	}
	public static  boolean or(boolean one, boolean two){
		return one || two;
	}
	public static boolean and(boolean one, boolean two){
		return one && two;
	}
	public static boolean not(boolean one){
		return !one;
	}
	public static  boolean nand(boolean one, boolean two){
		return !and(one,two);
	}
	public static  boolean nor(boolean one, boolean two){
		return !or(one,two);
	}
	public static boolean Sgreater(String one, String two){
		return one.compareToIgnoreCase(two) > 0;
	}
	public static boolean Slesser(String one, String two){
		return one.compareToIgnoreCase(two) < 0;
	}
	public static boolean Sequal(String one, String two){
		return one.compareTo(two) == 0;
	}
	public static String dugtong(String one, String two){
		return one.concat(two);
	}
	public  static String kunin_part(String one, String two){
		// wlang kwentang operation
		int start = one.indexOf(two.charAt(0));
		int end = one.indexOf(two.charAt(two.length()));
		return one.substring(start, end);
	}
	public  static int hanapin (String one, String two){
		return one.indexOf(two);
	}
	public static int haba (String one, String two){
		// ex. a haba b results to the length of a concat b
		return (one.concat(two)).length();
	}
	public SLLNode<String> evaluate (SLLNode<String> parent){
		if(parent.info.equals("LOG_NOT")){
			SLLNode<String> firstChild = evaluate(parent.firstChild);
			SLLNode<String> secondChild = new SLLNode<String>("");
			Token token = new Token("","");
			secondChild.setToken(token);
			calculateValue(firstChild,secondChild,parent);
		}
		else {
			if (parent.firstChild == null){
			switch(parent.info){
				case "C_INT":{
					parent.getToken().setValue(parent.getToken().getLexeme());
					break;
				}
				case "C_CHAR":{
					parent.getToken().setValue(parent.getToken().getLexeme());
					break;
				}
				case "C_DOUBLE":{
					parent.getToken().setValue(parent.getToken().getLexeme());
					break;
				}
				case "C_FLOAT":{
					parent.getToken().setValue(parent.getToken().getLexeme());
					break;
				}
				case "C_BOOLEAN":{
					parent.getToken().setValue(""+convertToBoolean(parent.getToken().getLexeme()));
					break;
				}
				case "C_STR":{
					parent.getToken().setValue(parent.getToken().getLexeme());
					break;
				}
				case "IDENT":{
					parent.setToken(getTokenSymbol(parent.getToken().getLexeme(), parent.info));
					break;
				}
			}
			return parent;
		}
		SLLNode<String> firstChild = evaluate(parent.firstChild);
		SLLNode<String> secondChild = evaluate(parent.firstChild.nextBrother);
		calculateValue(firstChild,secondChild,parent);
		}
		return parent;
	}
				
	public void calculateValue(SLLNode<String> firstChild, SLLNode<String> secondChild, SLLNode<String> parent){
			if(firstChild.getToken().getErrorMessage().equals("") && secondChild.getToken().getErrorMessage().equals("")){
				switch(parent.getToken().getLexeme()){
					case "+":{
						String fData ="", SData="";
						String fValue="", SValue="";
						if(firstChild.getToken().getName().equals("IDENT")){
							Token fToken = getTokenSymbol(firstChild.getToken().getLexeme(), parent.info);
							if(fToken!=null){
								fData =  fToken.getActualType();
								fValue = fToken.getValue();
							}
							else{
								parent.getToken().setErrorMessage("ERROR! missing identifier.");
								break;
							}
						}
						else{
							fData = firstChild.getToken().getExpectedType();
							fValue = firstChild.getToken().getValue();
						}
						if(secondChild.getToken().getName().equals("IDENT")){
							Token sToken = getTokenSymbol(secondChild.getToken().getLexeme(), parent.info);
							if(sToken!=null){
								SData =  sToken.getActualType();
								SValue = sToken.getValue();
							}
							else{
								parent.getToken().setErrorMessage("ERROR! missing identifier.");
								break;
							}
						}
						else{
							SData = secondChild.getToken().getExpectedType();
							SValue = secondChild.getToken().getValue();
						}
						if(fData.equals("i_var") && SData.equals("i_var")){
							parent.getToken().setExpectedType("i_var");
							parent.getToken().setValue(((int)Operations.add(Integer.parseInt(fValue),Integer.parseInt(SValue)))+"");
						}
						else if(fData.equals("d_var") && SData.equals("i_var")){
							parent.getToken().setExpectedType("d_var");
							parent.getToken().setValue(Operations.add(Double.parseDouble(fValue),Integer.parseInt(SValue)) +"");
						}
						else if(fData.equals("i_var") && SData.equals("d_var")){
							parent.getToken().setExpectedType("d_var");
							parent.getToken().setValue(Operations.add(Integer.parseInt(fValue),Double.parseDouble(SValue)) +"");
						}
						else if(fData.equals("d_var") && SData.equals("d_var")){
							parent.getToken().setExpectedType("d_var");
							parent.getToken().setValue(Operations.add(Double.parseDouble(fValue),Double.parseDouble(SValue)) +"");
						}
						else if(fData.equals("i_var") && SData.equals("f_var")){
							SValue = SValue.replaceAll("F", "");
							parent.getToken().setExpectedType("d_var");
							parent.getToken().setValue(Operations.add(Integer.parseInt(fValue),Float.parseFloat(SValue)) +"");
						}
						else if(fData.equals("f_var") && SData.equals("i_var")){
							fValue = fValue.replaceAll("F", "");
							parent.getToken().setExpectedType("d_var");
							parent.getToken().setValue(Operations.add(Float.parseFloat(fValue),Integer.parseInt(SValue)) +"");
						}
						else if(fData.equals("f_var") && SData.equals("f_var")){
							fValue = fValue.replaceAll("F", "");
							SValue = SValue.replaceAll("F", "");
							parent.getToken().setExpectedType("f_var");
							parent.getToken().setValue(Operations.add(Float.parseFloat(fValue),Float.parseFloat(SValue)) +"");
						}
						else{
							parent.getToken().setErrorMessage("ERROR! data type mismatch.");
							
						}
						break;	
					}
					case "/":{
						String fData ="", SData="";
						String fValue="", SValue="";
						if(firstChild.getToken().getName().equals("IDENT")){
							Token fToken = getTokenSymbol(firstChild.getToken().getLexeme(), parent.info);
							if(fToken!=null){
								fData =  fToken.getActualType();
								fValue = fToken.getValue();
							}
							else{
								parent.getToken().setErrorMessage("ERROR! missing identifier.");
								
								break;
							}
						}
						else{
							fData = firstChild.getToken().getExpectedType();
							fValue = firstChild.getToken().getValue();
						}
						if(secondChild.getToken().getName().equals("IDENT")){
							Token sToken = getTokenSymbol(secondChild.getToken().getLexeme(), parent.info);
							if(sToken!=null){
								SData =  sToken.getActualType();
								SValue = sToken.getValue();
							}
							else{
								parent.getToken().setErrorMessage("ERROR! missing identifier.");
								
								break;
							}
						}
						else{
							SData = secondChild.getToken().getExpectedType();
							SValue = secondChild.getToken().getValue();
						}
						if(SValue.equals("0") || SValue.equals("0F") || SValue.equals("0.0") || SValue.equals("0.00")){
							parent.getToken().setErrorMessage("ERROR! Math error.");
						}
						else if(fData.equals("i_var") && SData.equals("i_var")){
							parent.getToken().setExpectedType("i_var");
							parent.getToken().setValue(((int)Operations.div(Integer.parseInt(fValue),Integer.parseInt(SValue)))+"");
						}
						else if(fData.equals("d_var") && SData.equals("i_var")){
							parent.getToken().setExpectedType("d_var");
							parent.getToken().setValue(Operations.div(Double.parseDouble(fValue),Integer.parseInt(SValue)) +"");
						}
						else if(fData.equals("i_var") && SData.equals("d_var")){
							parent.getToken().setExpectedType("d_var");
							parent.getToken().setValue(Operations.div(Integer.parseInt(fValue),Double.parseDouble(SValue)) +"");
						}
						else if(fData.equals("d_var") && SData.equals("d_var")){
							parent.getToken().setExpectedType("d_var");
							parent.getToken().setValue(Operations.div(Double.parseDouble(fValue),Double.parseDouble(SValue)) +"");
						}
						else if(fData.equals("i_var") && SData.equals("f_var")){
							SValue = SValue.replaceAll("F", "");
							parent.getToken().setExpectedType("d_var");
							parent.getToken().setValue(Operations.div(Integer.parseInt(fValue),Float.parseFloat(SValue)) +"");
						}
						else if(fData.equals("f_var") && SData.equals("i_var")){
							fValue = fValue.replaceAll("F", "");
							parent.getToken().setExpectedType("d_var");
							parent.getToken().setValue(Operations.div(Float.parseFloat(fValue),Integer.parseInt(SValue)) +"");
						}
						else if(fData.equals("f_var") && SData.equals("f_var")){
							fValue = fValue.replaceAll("F", "");
							SValue = SValue.replaceAll("F", "");
							parent.getToken().setExpectedType("f_var");
							parent.getToken().setValue(Operations.div(Float.parseFloat(fValue),Float.parseFloat(SValue)) +"");
						}
						else{
							parent.getToken().setErrorMessage("ERROR! data type mismatch.");
							
						}
						break;	
					}
					case "*":{
						String fData ="", SData="";
						String fValue="", SValue="";
						if(firstChild.getToken().getName().equals("IDENT")){
							Token fToken = getTokenSymbol(firstChild.getToken().getLexeme(), parent.info);
							if(fToken!=null){
								fData =  fToken.getActualType();
								fValue = fToken.getValue();
							}
							else{
								parent.getToken().setErrorMessage("ERROR! missing identifier.");
								
								break;
							}
						}
						else{
							fData = firstChild.getToken().getExpectedType();
							fValue = firstChild.getToken().getValue();
						}
						if(secondChild.getToken().getName().equals("IDENT")){
							Token sToken = getTokenSymbol(secondChild.getToken().getLexeme(), parent.info);
							if(sToken!=null){
								SData =  sToken.getActualType();
								SValue = sToken.getValue();
							}
							else{
								parent.getToken().setErrorMessage("ERROR! missing identifier.");
								
								break;
							}
						}
						else{
							SData = secondChild.getToken().getExpectedType();
							SValue = secondChild.getToken().getValue();
						}
						if(fData.equals("i_var") && SData.equals("i_var")){
							parent.getToken().setExpectedType("i_var");
							parent.getToken().setValue(((int)Operations.mult(Integer.parseInt(fValue),Integer.parseInt(SValue)))+"");
						}
						else if(fData.equals("d_var") && SData.equals("i_var")){
							parent.getToken().setExpectedType("d_var");
							parent.getToken().setValue(Operations.mult(Double.parseDouble(fValue),Integer.parseInt(SValue)) +"");
						}
						else if(fData.equals("i_var") && SData.equals("d_var")){
							parent.getToken().setExpectedType("d_var");
							parent.getToken().setValue(Operations.mult(Integer.parseInt(fValue),Double.parseDouble(SValue)) +"");
						}
						else if(fData.equals("d_var") && SData.equals("d_var")){
							parent.getToken().setExpectedType("d_var");
							parent.getToken().setValue(Operations.mult(Double.parseDouble(fValue),Double.parseDouble(SValue)) +"");
						}
						else if(fData.equals("i_var") && SData.equals("f_var")){
							SValue = SValue.replaceAll("F", "");
							parent.getToken().setExpectedType("d_var");
							parent.getToken().setValue(Operations.mult(Integer.parseInt(fValue),Float.parseFloat(SValue)) +"");
						}
						else if(fData.equals("f_var") && SData.equals("i_var")){
							fValue = fValue.replaceAll("F", "");
							parent.getToken().setExpectedType("d_var");
							parent.getToken().setValue(Operations.mult(Float.parseFloat(fValue),Integer.parseInt(SValue)) +"");
						}
						else if(fData.equals("f_var") && SData.equals("f_var")){
							fValue = fValue.replaceAll("F", "");
							SValue = SValue.replaceAll("F", "");
							parent.getToken().setExpectedType("f_var");
							parent.getToken().setValue(Operations.mult(Float.parseFloat(fValue),Float.parseFloat(SValue)) +"");
						}
						else{
							parent.getToken().setErrorMessage("ERROR! data type mismatch.");
							
						}
						break;		
					}
					case "-":{
						String fData ="", SData="";
						String fValue="", SValue="";
						if(firstChild.getToken().getName().equals("IDENT")){
							Token fToken = getTokenSymbol(firstChild.getToken().getLexeme(), parent.info);
							if(fToken!=null){
								fData =  fToken.getActualType();
								fValue = fToken.getValue();
							}
							else{
								parent.getToken().setErrorMessage("ERROR! missing identifier.");
								
								break;
							}
						}
						else{
							fData = firstChild.getToken().getExpectedType();
							fValue = firstChild.getToken().getValue();
						}
						if(secondChild.getToken().getName().equals("IDENT")){
							Token sToken = getTokenSymbol(secondChild.getToken().getLexeme(), parent.info);
							if(sToken!=null){
								SData =  sToken.getActualType();
								SValue = sToken.getValue();
							}
							else{
								parent.getToken().setErrorMessage("ERROR! missing identifier.");
								
								break;
							}
						}
						else{
							SData = secondChild.getToken().getExpectedType();
							SValue = secondChild.getToken().getValue();
						}
						if(fData.equals("i_var") && SData.equals("i_var")){
							parent.getToken().setExpectedType("i_var");
							parent.getToken().setValue(((int)Operations.subt(Integer.parseInt(fValue),Integer.parseInt(SValue)))+"");
						}
						else if(fData.equals("d_var") && SData.equals("i_var")){
							parent.getToken().setExpectedType("d_var");
							parent.getToken().setValue(Operations.subt(Double.parseDouble(fValue),Integer.parseInt(SValue)) +"");
						}
						else if(fData.equals("i_var") && SData.equals("d_var")){
							parent.getToken().setExpectedType("d_var");
							parent.getToken().setValue(Operations.subt(Integer.parseInt(fValue),Double.parseDouble(SValue)) +"");
						}
						else if(fData.equals("d_var") && SData.equals("d_var")){
							parent.getToken().setExpectedType("d_var");
							parent.getToken().setValue(Operations.subt(Double.parseDouble(fValue),Double.parseDouble(SValue)) +"");
						}
						else if(fData.equals("i_var") && SData.equals("f_var")){
							SValue = SValue.replaceAll("F", "");
							parent.getToken().setExpectedType("d_var");
							parent.getToken().setValue(Operations.subt(Integer.parseInt(fValue),Float.parseFloat(SValue)) +"");
						}
						else if(fData.equals("f_var") && SData.equals("i_var")){
							fValue = fValue.replaceAll("F", "");
							parent.getToken().setExpectedType("d_var");
							parent.getToken().setValue(Operations.subt(Float.parseFloat(fValue),Integer.parseInt(SValue)) +"");
						}
						else if(fData.equals("f_var") && SData.equals("f_var")){
							fValue = fValue.replaceAll("F", "");
							SValue = SValue.replaceAll("F", "");
							parent.getToken().setExpectedType("f_var");
							parent.getToken().setValue(Operations.subt(Float.parseFloat(fValue),Float.parseFloat(SValue)) +"");
						}
						else{
							parent.getToken().setErrorMessage("ERROR! data type mismatch.");
							
						}
						break;		
					}
					case "Sequal":{
						String fData ="", SData="";
						String fValue="", SValue="";
						if(firstChild.getToken().getName().equals("IDENT")){
							Token fToken = getTokenSymbol(firstChild.getToken().getLexeme(), parent.info);
							if(fToken!=null){
								fData =  fToken.getActualType();
								fValue = fToken.getValue();
							}
							else{
								parent.getToken().setErrorMessage("ERROR! missing identifier.");
								
								break;
							}
						}
						else{
							fData = firstChild.getToken().getExpectedType();
							fValue = firstChild.getToken().getValue();
						}
						if(secondChild.getToken().getName().equals("IDENT")){
							Token sToken = getTokenSymbol(secondChild.getToken().getLexeme(), parent.info);
							if(sToken!=null){
								SData =  sToken.getActualType();
								SValue = sToken.getValue();
							}
							else{
								parent.getToken().setErrorMessage("ERROR! missing identifier.");
								
								break;
							}
						}
						else{
							SData = secondChild.getToken().getExpectedType();
							SValue = secondChild.getToken().getValue();
						}
						if(fData.equals("s_var") && SData.equals("s_var")){
							parent.getToken().setExpectedType("b_var");
							parent.getToken().setValue(Operations.equal(fValue,SValue) +"");
						}
						else{
							parent.getToken().setErrorMessage("ERROR! data type mismatch.");
							
						}
					break;	
					}
					case "Slesser":{
						String fData ="", SData="";
						String fValue="", SValue="";
						if(firstChild.getToken().getName().equals("IDENT")){
							Token fToken = getTokenSymbol(firstChild.getToken().getLexeme(), parent.info);
							if(fToken!=null){
								fData =  fToken.getActualType();
								fValue = fToken.getValue();
							}
							else{
								parent.getToken().setErrorMessage("ERROR! missing identifier.");
								
								break;
							}
						}
						else{
							fData = firstChild.getToken().getExpectedType();
							fValue = firstChild.getToken().getValue();
						}
						if(secondChild.getToken().getName().equals("IDENT")){
							Token sToken = getTokenSymbol(secondChild.getToken().getLexeme(), parent.info);
							if(sToken!=null){
								SData =  sToken.getActualType();
								SValue = sToken.getValue();
							}
							else{
								parent.getToken().setErrorMessage("ERROR! missing identifier.");
								
								break;
							}
						}
						else{
							SData = secondChild.getToken().getExpectedType();
							SValue = secondChild.getToken().getValue();
						}
						if(fData.equals("s_var") && SData.equals("s_var")){
							parent.getToken().setExpectedType("b_var");
							parent.getToken().setValue(Operations.lesser(fValue,SValue) +"");
						}
						else{
							parent.getToken().setErrorMessage("ERROR! data type mismatch.");
							
						}
					break;	
					}
					case "Sgreater":{
						String fData ="", SData="";
						String fValue="", SValue="";
						if(firstChild.getToken().getName().equals("IDENT")){
							Token fToken = getTokenSymbol(firstChild.getToken().getLexeme(), parent.info);
							if(fToken!=null){
								fData =  fToken.getActualType();
								fValue = fToken.getValue();
							}
							else{
								parent.getToken().setErrorMessage("ERROR! missing identifier.");
								
								break;
							}
						}
						else{
							fData = firstChild.getToken().getExpectedType();
							fValue = firstChild.getToken().getValue();
						}
						if(secondChild.getToken().getName().equals("IDENT")){
							Token sToken = getTokenSymbol(secondChild.getToken().getLexeme(), parent.info);
							if(sToken!=null){
								SData =  sToken.getActualType();
								SValue = sToken.getValue();
							}
							else{
								parent.getToken().setErrorMessage("ERROR! missing identifier.");
								
								break;
							}
						}
						else{
							SData = secondChild.getToken().getExpectedType();
							SValue = secondChild.getToken().getValue();
						}
						if(fData.equals("s_var") && SData.equals("s_var")){
							parent.getToken().setExpectedType("b_var");
							parent.getToken().setValue(Operations.greater(fValue,SValue) +"");
						}
						else{
							parent.getToken().setErrorMessage("ERROR! data type mismatch.");
							
						}
					break;	
					}
					case ">":{
						String fData ="", SData="";
						String fValue="", SValue="";
						if(firstChild.getToken().getName().equals("IDENT")){
							Token fToken = getTokenSymbol(firstChild.getToken().getLexeme(), parent.info);
							if(fToken!=null){
								fData =  fToken.getActualType();
								fValue = fToken.getValue();
							}
							else{
								parent.getToken().setErrorMessage("ERROR! missing identifier.");
								
								break;
							}
						}
						else{
							fData = firstChild.getToken().getExpectedType();
							fValue = firstChild.getToken().getValue();
						}
						if(secondChild.getToken().getName().equals("IDENT")){
							Token sToken = getTokenSymbol(secondChild.getToken().getLexeme(), parent.info);
							if(sToken!=null){
								SData =  sToken.getActualType();
								SValue = sToken.getValue();
							}
							else{
								parent.getToken().setErrorMessage("ERROR! missing identifier.");
								
								break;
							}
						}
						else{
							SData = secondChild.getToken().getExpectedType();
							SValue = secondChild.getToken().getValue();
						}
						if(fData.equals("i_var") && SData.equals("i_var")){
							parent.getToken().setExpectedType("b_var");
							parent.getToken().setValue(Operations.greater(fValue,SValue,fData,SData) +"");
						}
						else if(fData.equals("d_var") && SData.equals("d_var")){
							parent.getToken().setExpectedType("b_var");
							parent.getToken().setValue(Operations.greater(fValue,SValue,fData,SData) +"");
						}
						else if(fData.equals("f_var") && SData.equals("f_var")){
							fData = fData.replace("F", "");
							SData = SData.replace("F", "");
							parent.getToken().setExpectedType("b_var");
							parent.getToken().setValue(Operations.greater(fValue,SValue,fData,SData) +"");
						}
						else if(fData.equals("c_var") && SData.equals("c_var")){
							parent.getToken().setExpectedType("b_var");
							parent.getToken().setValue(Operations.greater(fValue,SValue,fData,SData) +"");
						}
						else if(fData.equals("s_var") && SData.equals("s_var")){
							parent.getToken().setExpectedType("b_var");
							parent.getToken().setValue(Operations.greater(fValue,SValue,fData,SData) +"");
						}
						else if(fData.equals("d_var") && SData.equals("i_var")){
							parent.getToken().setExpectedType("b_var");
							parent.getToken().setValue(Operations.greater(fValue,SValue,fData,SData) +"");
						}
						else if(fData.equals("i_var") && SData.equals("d_var")){
							parent.getToken().setExpectedType("b_var");
							parent.getToken().setValue(Operations.greater(fValue,SValue,fData,SData) +"");
						}
						else if(fData.equals("d_var") && SData.equals("f_var")){
							SData = SData.replace("F", "");
							parent.getToken().setExpectedType("b_var");
							parent.getToken().setValue(Operations.greater(fValue,SValue,fData,SData) +"");
						}
						else if(fData.equals("f_var") && SData.equals("d_var")){
							fData = fData.replace("F", "");
							parent.getToken().setExpectedType("b_var");
							parent.getToken().setValue(Operations.greater(fValue,SValue,fData,SData) +"");
						}
						else if(fData.equals("f_var") && SData.equals("i_var")){
							fData = fData.replace("F", "");
							parent.getToken().setExpectedType("b_var");
							parent.getToken().setValue(Operations.greater(fValue,SValue,fData,SData) +"");
						}
						else if(fData.equals("i_var") && SData.equals("f_var")){
							SData = SData.replace("F", "");
							parent.getToken().setExpectedType("b_var");
							parent.getToken().setValue(Operations.greater(fValue,SValue,fData,SData) +"");
						}
						else{
							parent.getToken().setErrorMessage("ERROR! data type mismatch.");
							
						}
					break;	
					}
					case "<":{
						String fData ="", SData="";
						String fValue="", SValue="";
						if(firstChild.getToken().getName().equals("IDENT")){
							Token fToken = getTokenSymbol(firstChild.getToken().getLexeme(), parent.info);
							if(fToken!=null){
								fData =  fToken.getActualType();
								fValue = fToken.getValue();
							}
							else{
								parent.getToken().setErrorMessage("ERROR! missing identifier.");
								
								break;
							}
						}
						else{
							fData = firstChild.getToken().getExpectedType();
							fValue = firstChild.getToken().getValue();
						}
						if(secondChild.getToken().getName().equals("IDENT")){
							Token sToken = getTokenSymbol(secondChild.getToken().getLexeme(), parent.info);
							if(sToken!=null){
								SData =  sToken.getActualType();
								SValue = sToken.getValue();
							}
							else{
								parent.getToken().setErrorMessage("ERROR! missing identifier.");
								
								break;
							}
						}
						else{
							SData = secondChild.getToken().getExpectedType();
							SValue = secondChild.getToken().getValue();
						}
						if(fData.equals("i_var") && SData.equals("i_var")){
							parent.getToken().setExpectedType("b_var");
							parent.getToken().setValue(Operations.lesser(fValue,SValue,fData, SData) +"");
						}
						else if(fData.equals("d_var") && SData.equals("d_var")){
							parent.getToken().setExpectedType("b_var");
							parent.getToken().setValue(Operations.lesser(fValue,SValue,fData, SData) +"");
						}
						else if(fData.equals("f_var") && SData.equals("f_var")){
							fData = fData.replace("F", "");
							SData = SData.replace("F", "");
							parent.getToken().setExpectedType("b_var");
							parent.getToken().setValue(Operations.lesser(fValue,SValue,fData, SData) +"");
						}
						else if(fData.equals("c_var") && SData.equals("c_var")){
							parent.getToken().setExpectedType("b_var");
							parent.getToken().setValue(Operations.lesser(fValue,SValue,fData, SData) +"");
						}
						else if(fData.equals("s_var") && SData.equals("s_var")){
							parent.getToken().setExpectedType("b_var");
							parent.getToken().setValue(Operations.lesser(fValue,SValue,fData, SData) +"");
						}
						else if(fData.equals("d_var") && SData.equals("i_var")){
							parent.getToken().setExpectedType("b_var");
							parent.getToken().setValue(Operations.lesser(fValue,SValue,fData, SData) +"");
						}
						else if(fData.equals("i_var") && SData.equals("d_var")){
							parent.getToken().setExpectedType("b_var");
							parent.getToken().setValue(Operations.lesser(fValue,SValue,fData, SData) +"");
						}
						else if(fData.equals("d_var") && SData.equals("f_var")){
							SData = SData.replace("F", "");
							parent.getToken().setExpectedType("b_var");
							parent.getToken().setValue(Operations.lesser(fValue,SValue,fData, SData) +"");
						}
						else if(fData.equals("f_var") && SData.equals("d_var")){
							fData = fData.replace("F", "");
							parent.getToken().setExpectedType("b_var");
							parent.getToken().setValue(Operations.lesser(fValue,SValue,fData, SData) +"");
						}
						else if(fData.equals("f_var") && SData.equals("i_var")){
							fData = fData.replace("F", "");
							parent.getToken().setExpectedType("b_var");
							parent.getToken().setValue(Operations.lesser(fValue,SValue,fData, SData) +"");
						}
						else if(fData.equals("i_var") && SData.equals("f_var")){
							SData = SData.replace("F", "");
							parent.getToken().setExpectedType("b_var");
							parent.getToken().setValue(Operations.lesser(fValue,SValue,fData, SData) +"");
						}
						else{
							parent.getToken().setErrorMessage("ERROR! data type mismatch.");
							
						}
					break;	
					}
					case ">=":{
						String fData ="", SData="";
						String fValue="", SValue="";
						if(firstChild.getToken().getName().equals("IDENT")){
							Token fToken = getTokenSymbol(firstChild.getToken().getLexeme(), parent.info);
							if(fToken!=null){
								fData =  fToken.getActualType();
								fValue = fToken.getValue();
							}
							else{
								parent.getToken().setErrorMessage("ERROR! missing identifier.");
								
								break;
							}
						}
						else{
							fData = firstChild.getToken().getExpectedType();
							fValue = firstChild.getToken().getValue();
						}
						if(secondChild.getToken().getName().equals("IDENT")){
							Token sToken = getTokenSymbol(secondChild.getToken().getLexeme(), parent.info);
							if(sToken!=null){
								SData =  sToken.getActualType();
								SValue = sToken.getValue();
							}
							else{
								parent.getToken().setErrorMessage("ERROR! missing identifier.");
								
								break;
							}
						}
						else{
							SData = secondChild.getToken().getExpectedType();
							SValue = secondChild.getToken().getValue();
						}
						if(fData.equals("i_var") && SData.equals("i_var")){
							parent.getToken().setExpectedType("b_var");
							parent.getToken().setValue(Operations.greaterEqual(fValue,SValue,fData,SData) +"");
						}
						else if(fData.equals("d_var") && SData.equals("d_var")){
							parent.getToken().setExpectedType("b_var");
							parent.getToken().setValue(Operations.greaterEqual(fValue,SValue,fData,SData) +"");
						}
						else if(fData.equals("f_var") && SData.equals("f_var")){
							fData = fData.replace("F", "");
							SData = SData.replace("F", "");
							parent.getToken().setExpectedType("b_var");
							parent.getToken().setValue(Operations.greaterEqual(fValue,SValue,fData,SData) +"");
						}
						else if(fData.equals("c_var") && SData.equals("c_var")){
							parent.getToken().setExpectedType("b_var");
							parent.getToken().setValue(Operations.greaterEqual(fValue,SValue,fData,SData) +"");
						}
						else if(fData.equals("s_var") && SData.equals("s_var")){
							parent.getToken().setExpectedType("b_var");
							parent.getToken().setValue(Operations.greaterEqual(fValue,SValue,fData,SData) +"");
						}
						else if(fData.equals("d_var") && SData.equals("i_var")){
							parent.getToken().setExpectedType("b_var");
							parent.getToken().setValue(Operations.greaterEqual(fValue,SValue,fData,SData) +"");
						}
						else if(fData.equals("i_var") && SData.equals("d_var")){
							parent.getToken().setExpectedType("b_var");
							parent.getToken().setValue(Operations.greaterEqual(fValue,SValue,fData,SData) +"");
						}
						else if(fData.equals("d_var") && SData.equals("f_var")){
							SData = SData.replace("F", "");
							parent.getToken().setExpectedType("b_var");
							parent.getToken().setValue(Operations.greaterEqual(fValue,SValue,fData,SData) +"");
						}
						else if(fData.equals("f_var") && SData.equals("d_var")){
							fData = fData.replace("F", "");
							parent.getToken().setExpectedType("b_var");
							parent.getToken().setValue(Operations.greaterEqual(fValue,SValue,fData,SData) +"");
						}
						else if(fData.equals("f_var") && SData.equals("i_var")){
							fData = fData.replace("F", "");
							parent.getToken().setExpectedType("b_var");
							parent.getToken().setValue(Operations.greaterEqual(fValue,SValue,fData,SData) +"");
						}
						else if(fData.equals("i_var") && SData.equals("f_var")){
							SData = SData.replace("F", "");
							parent.getToken().setExpectedType("b_var");
							parent.getToken().setValue(Operations.greaterEqual(fValue,SValue,fData,SData) +"");
						}
						else{
							parent.getToken().setErrorMessage("ERROR! data type mismatch.");
							
						}
					break;	
					}
					case "<=":{
						String fData ="", SData="";
						String fValue="", SValue="";
						if(firstChild.getToken().getName().equals("IDENT")){
							Token fToken = getTokenSymbol(firstChild.getToken().getLexeme(), parent.info);
							if(fToken!=null){
								fData =  fToken.getActualType();
								fValue = fToken.getValue();
							}
							else{
								parent.getToken().setErrorMessage("ERROR! missing identifier.");
								
								break;
							}
						}
						else{
							fData = firstChild.getToken().getExpectedType();
							fValue = firstChild.getToken().getValue();
						}
						if(secondChild.getToken().getName().equals("IDENT")){
							Token sToken = getTokenSymbol(secondChild.getToken().getLexeme(), parent.info);
							if(sToken!=null){
								SData =  sToken.getActualType();
								SValue = sToken.getValue();
							}
							else{
								parent.getToken().setErrorMessage("ERROR! missing identifier.");
								
								break;
							}
						}
						else{
							SData = secondChild.getToken().getExpectedType();
							SValue = secondChild.getToken().getValue();
						}
						if(fData.equals("i_var") && SData.equals("i_var")){
							parent.getToken().setExpectedType("b_var");
							parent.getToken().setValue(Operations.lesserEqual(fValue,SValue,fData,SData) +"");
						}
						else if(fData.equals("d_var") && SData.equals("d_var")){
							parent.getToken().setExpectedType("b_var");
							parent.getToken().setValue(Operations.lesserEqual(fValue,SValue,fData,SData) +"");
						}
						else if(fData.equals("f_var") && SData.equals("f_var")){
							fData = fData.replace("F", "");
							SData = SData.replace("F", "");
							parent.getToken().setExpectedType("b_var");
							parent.getToken().setValue(Operations.lesserEqual(fValue,SValue,fData,SData) +"");
						}
						else if(fData.equals("c_var") && SData.equals("c_var")){
							parent.getToken().setExpectedType("b_var");
							parent.getToken().setValue(Operations.lesserEqual(fValue,SValue,fData,SData) +"");
						}
						else if(fData.equals("s_var") && SData.equals("s_var")){
							parent.getToken().setExpectedType("b_var");
							parent.getToken().setValue(Operations.lesserEqual(fValue,SValue,fData,SData) +"");
						}
						else if(fData.equals("d_var") && SData.equals("i_var")){
							parent.getToken().setExpectedType("b_var");
							parent.getToken().setValue(Operations.lesserEqual(fValue,SValue,fData,SData) +"");
						}
						else if(fData.equals("i_var") && SData.equals("d_var")){
							parent.getToken().setExpectedType("b_var");
							parent.getToken().setValue(Operations.lesserEqual(fValue,SValue,fData,SData) +"");
						}
						else if(fData.equals("d_var") && SData.equals("f_var")){
							SData = SData.replace("F", "");
							parent.getToken().setExpectedType("b_var");
							parent.getToken().setValue(Operations.lesserEqual(fValue,SValue,fData,SData) +"");
						}
						else if(fData.equals("f_var") && SData.equals("d_var")){
							fData = fData.replace("F", "");
							parent.getToken().setExpectedType("b_var");
							parent.getToken().setValue(Operations.lesserEqual(fValue,SValue,fData,SData) +"");
						}
						else if(fData.equals("f_var") && SData.equals("i_var")){
							fData = fData.replace("F", "");
							parent.getToken().setExpectedType("b_var");
							parent.getToken().setValue(Operations.lesserEqual(fValue,SValue,fData,SData) +"");
						}
						else if(fData.equals("i_var") && SData.equals("f_var")){
							SData = SData.replace("F", "");
							parent.getToken().setExpectedType("b_var");
							parent.getToken().setValue(Operations.lesserEqual(fValue,SValue,fData,SData) +"");
						}
						else{
							parent.getToken().setErrorMessage("ERROR! data type mismatch.");
							
						}
					break;	
					}
					case "==":{
						String fData ="", SData="";
						String fValue="", SValue="";
						if(firstChild.getToken().getName().equals("IDENT")){
							Token fToken = getTokenSymbol(firstChild.getToken().getLexeme(), parent.info);
							if(fToken!=null){
								fData =  fToken.getActualType();
								fValue = fToken.getValue();
							}
							else{
								parent.getToken().setErrorMessage("ERROR! missing identifier.");
								
								break;
							}
						}
						else{
							fData = firstChild.getToken().getExpectedType();
							fValue = firstChild.getToken().getValue();
						}
						if(secondChild.getToken().getName().equals("IDENT")){
							Token sToken = getTokenSymbol(secondChild.getToken().getLexeme(), parent.info);
							if(sToken!=null){
								SData =  sToken.getActualType();
								SValue = sToken.getValue();
							}
							else{
								parent.getToken().setErrorMessage("ERROR! missing identifier.");
								
								break;
							}
						}
						else{
							SData = secondChild.getToken().getExpectedType();
							SValue = secondChild.getToken().getValue();
						}
						if(fData.equals("i_var") && SData.equals("i_var")){
							parent.getToken().setExpectedType("b_var");
							parent.getToken().setValue(Operations.equal(fValue,SValue,fData,SData) +"");
						}
						else if(fData.equals("d_var") && SData.equals("d_var")){
							parent.getToken().setExpectedType("b_var");
							parent.getToken().setValue(Operations.equal(fValue,SValue,fData,SData) +"");
						}
						else if(fData.equals("f_var") && SData.equals("f_var")){
							fData = fData.replace("F", "");
							SData = SData.replace("F", "");
							parent.getToken().setExpectedType("b_var");
							parent.getToken().setValue(Operations.equal(fValue,SValue,fData,SData) +"");
						}
						else if(fData.equals("c_var") && SData.equals("c_var")){
							parent.getToken().setExpectedType("b_var");
							parent.getToken().setValue(Operations.equal(fValue,SValue,fData,SData) +"");
						}
						else if(fData.equals("s_var") && SData.equals("s_var")){
							parent.getToken().setExpectedType("b_var");
							parent.getToken().setValue(Operations.equal(fValue,SValue,fData,SData) +"");
						}
						else if(fData.equals("d_var") && SData.equals("i_var")){
							parent.getToken().setExpectedType("b_var");
							parent.getToken().setValue(Operations.equal(fValue,SValue,fData,SData) +"");
						}
						else if(fData.equals("i_var") && SData.equals("d_var")){
							parent.getToken().setExpectedType("b_var");
							parent.getToken().setValue(Operations.equal(fValue,SValue,fData,SData) +"");
						}
						else if(fData.equals("d_var") && SData.equals("f_var")){
							SData = SData.replace("F", "");
							parent.getToken().setExpectedType("b_var");
							parent.getToken().setValue(Operations.equal(fValue,SValue,fData,SData) +"");
						}
						else if(fData.equals("f_var") && SData.equals("d_var")){
							fData = fData.replace("F", "");
							parent.getToken().setExpectedType("b_var");
							parent.getToken().setValue(Operations.equal(fValue,SValue,fData,SData) +"");
						}
						else if(fData.equals("f_var") && SData.equals("i_var")){
							fData = fData.replace("F", "");
							parent.getToken().setExpectedType("b_var");
							parent.getToken().setValue(Operations.equal(fValue,SValue,fData,SData) +"");
						}
						else if(fData.equals("i_var") && SData.equals("f_var")){
							SData = SData.replace("F", "");
							parent.getToken().setExpectedType("b_var");
							parent.getToken().setValue(Operations.equal(fValue,SValue,fData,SData) +"");
						}
						else{
							parent.getToken().setErrorMessage("ERROR! data type mismatch.");
							
						}
					break;	
					}
					case "!=":{
						String fData ="", SData="";
						String fValue="", SValue="";
						if(firstChild.getToken().getName().equals("IDENT")){
							Token fToken = getTokenSymbol(firstChild.getToken().getLexeme(), parent.info);
							if(fToken!=null){
								fData =  fToken.getActualType();
								fValue = fToken.getValue();
							}
							else{
								parent.getToken().setErrorMessage("ERROR! missing identifier.");
								
								break;
							}
						}
						else{
							fData = firstChild.getToken().getExpectedType();
							fValue = firstChild.getToken().getValue();
						}
						if(secondChild.getToken().getName().equals("IDENT")){
							Token sToken = getTokenSymbol(secondChild.getToken().getLexeme(), parent.info);
							if(sToken!=null){
								SData =  sToken.getActualType();
								SValue = sToken.getValue();
							}
							else{
								parent.getToken().setErrorMessage("ERROR! missing identifier.");
								
								break;
							}
						}
						else{
							SData = secondChild.getToken().getExpectedType();
							SValue = secondChild.getToken().getValue();
						}
						if(fData.equals("i_var") && SData.equals("i_var")){
							parent.getToken().setExpectedType("b_var");
							parent.getToken().setValue(Operations.notEqual(fValue,SValue,fData,SData) +"");
						}
						else if(fData.equals("d_var") && SData.equals("d_var")){
							parent.getToken().setExpectedType("b_var");
							parent.getToken().setValue(Operations.notEqual(fValue,SValue,fData,SData) +"");
						}
						else if(fData.equals("f_var") && SData.equals("f_var")){
							fData = fData.replace("F", "");
							SData = SData.replace("F", "");
							parent.getToken().setExpectedType("b_var");
							parent.getToken().setValue(Operations.notEqual(fValue,SValue,fData,SData) +"");
						}
						else if(fData.equals("c_var") && SData.equals("c_var")){
							parent.getToken().setExpectedType("b_var");
							parent.getToken().setValue(Operations.notEqual(fValue,SValue,fData,SData) +"");
						}
						else if(fData.equals("s_var") && SData.equals("s_var")){
							parent.getToken().setExpectedType("b_var");
							parent.getToken().setValue(Operations.notEqual(fValue,SValue,fData,SData) +"");
						}
						else if(fData.equals("d_var") && SData.equals("i_var")){
							parent.getToken().setExpectedType("b_var");
							parent.getToken().setValue(Operations.notEqual(fValue,SValue,fData,SData) +"");
						}
						else if(fData.equals("i_var") && SData.equals("d_var")){
							parent.getToken().setExpectedType("b_var");
							parent.getToken().setValue(Operations.notEqual(fValue,SValue,fData,SData) +"");
						}
						else if(fData.equals("d_var") && SData.equals("f_var")){
							SData = SData.replace("F", "");
							parent.getToken().setExpectedType("b_var");
							parent.getToken().setValue(Operations.notEqual(fValue,SValue,fData,SData) +"");
						}
						else if(fData.equals("f_var") && SData.equals("d_var")){
							fData = fData.replace("F", "");
							parent.getToken().setExpectedType("b_var");
							parent.getToken().setValue(Operations.notEqual(fValue,SValue,fData,SData) +"");
						}
						else if(fData.equals("f_var") && SData.equals("i_var")){
							fData = fData.replace("F", "");
							parent.getToken().setExpectedType("b_var");
							parent.getToken().setValue(Operations.notEqual(fValue,SValue,fData,SData) +"");
						}
						else if(fData.equals("i_var") && SData.equals("f_var")){
							SData = SData.replace("F", "");
							parent.getToken().setExpectedType("b_var");
							parent.getToken().setValue(Operations.notEqual(fValue,SValue,fData,SData) +"");
						}
						else{
							parent.getToken().setErrorMessage("ERROR! data type mismatch.");
							
						}
					break;	
					}
					case "!@":{
						String fData ="", SData="";
						String fValue="", SValue="";
						if(firstChild.getToken().getName().equals("IDENT")){
							Token fToken = getTokenSymbol(firstChild.getToken().getLexeme(), parent.info);
							if(fToken!=null){
								fData =  fToken.getActualType();
								fValue = fToken.getValue();
							}
							else{
								parent.getToken().setErrorMessage("ERROR! missing identifier.");
								
								break;
							}
						}
						else{
							fData = firstChild.getToken().getExpectedType();
							fValue = firstChild.getToken().getValue();
						}
						if(secondChild.getToken().getName().equals("IDENT")){
							Token sToken = getTokenSymbol(secondChild.getToken().getLexeme(), parent.info);
							if(sToken!=null){
								SData =  sToken.getActualType();
								SValue = sToken.getValue();
							}
							else{
								parent.getToken().setErrorMessage("ERROR! missing identifier.");
								
								break;
							}
						}
						else{
							SData = secondChild.getToken().getExpectedType();
							SValue = secondChild.getToken().getValue();
						}
						if(fData.endsWith("b_var") && fData.equals("b_var")){
							parent.getToken().setExpectedType("b_var");
							parent.getToken().setValue(Operations.xnor(convertToBoolean(fValue),convertToBoolean(SValue)) +"");
						}
						else{
							parent.getToken().setErrorMessage("ERROR! data type mismatch.");
							
						}
					break;	
					}
					case "@":{
						String fData ="", SData="";
						String fValue="", SValue="";
						if(firstChild.getToken().getName().equals("IDENT")){
							Token fToken = getTokenSymbol(firstChild.getToken().getLexeme(), parent.info);
							if(fToken!=null){
								fData =  fToken.getActualType();
								fValue = fToken.getValue();
							}
							else{
								parent.getToken().setErrorMessage("ERROR! missing identifier.");
								
								break;
							}
						}
						else{
							fData = firstChild.getToken().getExpectedType();
							fValue = firstChild.getToken().getValue();
						}
						if(secondChild.getToken().getName().equals("IDENT")){
							Token sToken = getTokenSymbol(secondChild.getToken().getLexeme(), parent.info);
							if(sToken!=null){
								SData =  sToken.getActualType();
								SValue = sToken.getValue();
							}
							else{
								parent.getToken().setErrorMessage("ERROR! missing identifier.");
								
								break;
							}
						}
						else{
							SData = secondChild.getToken().getExpectedType();
							SValue = secondChild.getToken().getValue();
						}
						if(fData.endsWith("b_var") && fData.equals("b_var")){
							parent.getToken().setExpectedType("b_var");
							parent.getToken().setValue(Operations.xor(convertToBoolean(fValue),convertToBoolean(SValue)) +"");
						}
						else{
							parent.getToken().setErrorMessage("ERROR! data type mismatch.");
							
						}
					break;	
					}
					case "!&":{
						String fData ="", SData="";
						String fValue="", SValue="";
						if(firstChild.getToken().getName().equals("IDENT")){
							Token fToken = getTokenSymbol(firstChild.getToken().getLexeme(), parent.info);
							if(fToken!=null){
								fData =  fToken.getActualType();
								fValue = fToken.getValue();
							}
							else{
								parent.getToken().setErrorMessage("ERROR! missing identifier.");
								
								break;
							}
						}
						else{
							fData = firstChild.getToken().getExpectedType();
							fValue = firstChild.getToken().getValue();
						}
						if(secondChild.getToken().getName().equals("IDENT")){
							Token sToken = getTokenSymbol(secondChild.getToken().getLexeme(), parent.info);
							if(sToken!=null){
								SData =  sToken.getActualType();
								SValue = sToken.getValue();
							}
							else{
								parent.getToken().setErrorMessage("ERROR! missing identifier.");
								
								break;
							}
						}
						else{
							SData = secondChild.getToken().getExpectedType();
							SValue = secondChild.getToken().getValue();
						}
						if(fData.endsWith("b_var") && fData.equals("b_var")){
							parent.getToken().setExpectedType("b_var");
							parent.getToken().setValue(Operations.nand(convertToBoolean(fValue),convertToBoolean(SValue)) +"");
						}
						else{
							parent.getToken().setErrorMessage("ERROR! data type mismatch.");
							
						}
					break;	
					}
					case "!|":{
						String fData ="", SData="";
						String fValue="", SValue="";
						if(firstChild.getToken().getName().equals("IDENT")){
							Token fToken = getTokenSymbol(firstChild.getToken().getLexeme(), parent.info);
							if(fToken!=null){
								fData =  fToken.getActualType();
								fValue = fToken.getValue();
							}
							else{
								parent.getToken().setErrorMessage("ERROR! missing identifier.");
								
								break;
							}
						}
						else{
							fData = firstChild.getToken().getExpectedType();
							fValue = firstChild.getToken().getValue();
						}
						if(secondChild.getToken().getName().equals("IDENT")){
							Token sToken = getTokenSymbol(secondChild.getToken().getLexeme(), parent.info);
							if(sToken!=null){
								SData =  sToken.getActualType();
								SValue = sToken.getValue();
							}
							else{
								parent.getToken().setErrorMessage("ERROR! missing identifier.");
								
								break;
							}
						}
						else{
							SData = secondChild.getToken().getExpectedType();
							SValue = secondChild.getToken().getValue();
						}
						if(fData.endsWith("b_var") && fData.equals("b_var")){
							parent.getToken().setExpectedType("b_var");
							parent.getToken().setValue(Operations.nor(convertToBoolean(fValue),convertToBoolean(SValue)) +"");
						}
						else{
							parent.getToken().setErrorMessage("ERROR! data type mismatch.");
							
						}
					break;	
					}
					case "&&":{
						String fData ="", SData="";
						String fValue="", SValue="";
						if(firstChild.getToken().getName().equals("IDENT")){
							Token fToken = getTokenSymbol(firstChild.getToken().getLexeme(), parent.info);
							if(fToken!=null){
								fData =  fToken.getActualType();
								fValue = fToken.getValue();
							}
							else{
								parent.getToken().setErrorMessage("ERROR! missing identifier.");
								
								break;
							}
						}
						else{
							fData = firstChild.getToken().getExpectedType();
							fValue = firstChild.getToken().getValue();
						}
						if(secondChild.getToken().getName().equals("IDENT")){
							Token sToken = getTokenSymbol(secondChild.getToken().getLexeme(), parent.info);
							if(sToken!=null){
								SData =  sToken.getActualType();
								SValue = sToken.getValue();
							}
							else{
								parent.getToken().setErrorMessage("ERROR! missing identifier.");
								
								break;
							}
						}
						else{
							SData = secondChild.getToken().getExpectedType();
							SValue = secondChild.getToken().getValue();
						}
						if(fData.endsWith("b_var") && fData.equals("b_var")){
							parent.getToken().setExpectedType("b_var");
							parent.getToken().setValue(Operations.and(convertToBoolean(fValue),convertToBoolean(SValue)) +"");
						}
						else{
							parent.getToken().setErrorMessage("ERROR! data type mismatch.");
							
						}
					break;	
					}
					case "||":{
						String fData ="", SData="";
						String fValue="", SValue="";
						if(firstChild.getToken().getName().equals("IDENT")){
							Token fToken = getTokenSymbol(firstChild.getToken().getLexeme(), parent.info);
							if(fToken!=null){
								fData =  fToken.getActualType();
								fValue = fToken.getValue();
							}
							else{
								parent.getToken().setErrorMessage("ERROR! missing identifier.");
								
								break;
							}
						}
						else{
							fData = firstChild.getToken().getExpectedType();
							fValue = firstChild.getToken().getValue();
						}
						if(secondChild.getToken().getName().equals("IDENT")){
							Token sToken = getTokenSymbol(secondChild.getToken().getLexeme(), parent.info);
							if(sToken!=null){
								SData =  sToken.getActualType();
								SValue = sToken.getValue();
							}
							else{
								parent.getToken().setErrorMessage("ERROR! missing identifier.");
								
								break;
							}
						}
						else{
							SData = secondChild.getToken().getExpectedType();
							SValue = secondChild.getToken().getValue();
						}
						if(fData.endsWith("b_var") && fData.equals("b_var")){
							parent.getToken().setExpectedType("b_var");
							parent.getToken().setValue(Operations.or(convertToBoolean(fValue),convertToBoolean(SValue)) +"");
						}
						else{
							parent.getToken().setErrorMessage("ERROR! data type mismatch.");
							
						}
					break;	
					}
					case "!":{
						String fData ="", SData="";
						String fValue="", SValue="";
						if(firstChild.getToken().getName().equals("IDENT")){
							Token fToken = getTokenSymbol(firstChild.getToken().getLexeme(), parent.info);
							if(fToken!=null){
								fData =  fToken.getActualType();
								fValue = fToken.getValue();
							}
							else{
								parent.getToken().setErrorMessage("ERROR! missing identifier.");
								
								break;
							}
						}
						else{
							fData = firstChild.getToken().getExpectedType();
							fValue = firstChild.getToken().getValue();
						}
						if(fData.equals("b_var")){
							parent.getToken().setExpectedType("b_var");
							parent.getToken().setValue(Operations.not(convertToBoolean(fValue)) +"");
						}
						else{
							parent.getToken().setErrorMessage("ERROR! data type mismatch.");
							
						}
						break;
					}
					case "dugtong":{
						String fData ="", SData="";
						String fValue="", SValue="";
						if(firstChild.getToken().getName().equals("IDENT")){
							Token fToken = getTokenSymbol(firstChild.getToken().getLexeme(), parent.info);
							if(fToken!=null){
								fData =  fToken.getActualType();
								fValue = fToken.getValue();
							}
							else{
								parent.getToken().setErrorMessage("ERROR! missing identifier.");
								
								break;
							}
						}
						else{
							fData = firstChild.getToken().getExpectedType();
							fValue = firstChild.getToken().getValue();
						}
						if(secondChild.getToken().getName().equals("IDENT")){
							Token sToken = getTokenSymbol(secondChild.getToken().getLexeme(), parent.info);
							if(sToken!=null){
								SData =  sToken.getActualType();
								SValue = sToken.getValue();
							}
							else{
								parent.getToken().setErrorMessage("ERROR! missing identifier.");
								
								break;
							}
						}
						else{
							SData = secondChild.getToken().getExpectedType();
							SValue = secondChild.getToken().getValue();
						}
						if(fData.endsWith("s_var") && fData.equals("s_var")){
							parent.getToken().setExpectedType("s_var");
							parent.getToken().setValue(Operations.dugtong(fValue,SValue) +"");
						}
						else{
							parent.getToken().setErrorMessage("ERROR! data type mismatch.");
							
						}
					break;	
					}
					case "kunin_part":{
						String fData ="", SData="";
						String fValue="", SValue="";
						if(firstChild.getToken().getName().equals("IDENT")){
							Token fToken = getTokenSymbol(firstChild.getToken().getLexeme(), parent.info);
							if(fToken!=null){
								fData =  fToken.getActualType();
								fValue = fToken.getValue();
							}
							else{
								parent.getToken().setErrorMessage("ERROR! missing identifier.");
								
								break;
							}
						}
						else{
							fData = firstChild.getToken().getExpectedType();
							fValue = firstChild.getToken().getValue();
						}
						if(secondChild.getToken().getName().equals("IDENT")){
							Token sToken = getTokenSymbol(secondChild.getToken().getLexeme(), parent.info);
							if(sToken!=null){
								SData =  sToken.getActualType();
								SValue = sToken.getValue();
							}
							else{
								parent.getToken().setErrorMessage("ERROR! missing identifier.");
								
								break;
							}
						}
						else{
							SData = secondChild.getToken().getExpectedType();
							SValue = secondChild.getToken().getValue();
						}
						if(fData.endsWith("s_var") && fData.equals("s_var")){
							parent.getToken().setExpectedType("s_var");
							parent.getToken().setValue(Operations.kunin_part(fValue,SValue) +"");
						}
						else{
							parent.getToken().setErrorMessage("ERROR! data type mismatch.");
							
						}
					break;	
					}
					case "hanapin":{
						String fData ="", SData="";
						String fValue="", SValue="";
						if(firstChild.getToken().getName().equals("IDENT")){
							Token fToken = getTokenSymbol(firstChild.getToken().getLexeme(), parent.info);
							if(fToken!=null){
								fData =  fToken.getActualType();
								fValue = fToken.getValue();
							}
							else{
								parent.getToken().setErrorMessage("ERROR! missing identifier.");
								
								break;
							}
						}
						else{
							fData = firstChild.getToken().getExpectedType();
							fValue = firstChild.getToken().getValue();
						}
						if(secondChild.getToken().getName().equals("IDENT")){
							Token sToken = getTokenSymbol(secondChild.getToken().getLexeme(), parent.info);
							if(sToken!=null){
								SData =  sToken.getActualType();
								SValue = sToken.getValue();
							}
							else{
								parent.getToken().setErrorMessage("ERROR! missing identifier.");
								
								break;
							}
						}
						else{
							SData = secondChild.getToken().getExpectedType();
							SValue = secondChild.getToken().getValue();
						}
						if(fData.endsWith("s_var") && fData.equals("s_var")){
							parent.getToken().setExpectedType("i_var");
							parent.getToken().setValue(Operations.hanapin(fValue,SValue) +"");
						}
						else{
							parent.getToken().setErrorMessage("ERROR! data type mismatch.");
							
						}
					break;	
					}
					case "haba":{
						String fData ="", SData="";
						String fValue="", SValue="";
						if(firstChild.getToken().getName().equals("IDENT")){
							Token fToken = getTokenSymbol(firstChild.getToken().getLexeme(), parent.info);
							if(fToken!=null){
								fData =  fToken.getActualType();
								fValue = fToken.getValue();
							}
							else{
								parent.getToken().setErrorMessage("ERROR! missing identifier.");
								
								break;
							}
						}
						else{
							fData = firstChild.getToken().getExpectedType();
							fValue = firstChild.getToken().getValue();
						}
						if(secondChild.getToken().getName().equals("IDENT")){
							Token sToken = getTokenSymbol(secondChild.getToken().getLexeme(), parent.info);
							if(sToken!=null){
								SData =  sToken.getActualType();
								SValue = sToken.getValue();
							}
							else{
								parent.getToken().setErrorMessage("ERROR! missing identifier.");
								
								break;
							}
						}
						else{
							SData = secondChild.getToken().getExpectedType();
							SValue = secondChild.getToken().getValue();
						}
						if(fData.endsWith("s_var") && fData.equals("s_var")){
							parent.getToken().setExpectedType("i_var");
							parent.getToken().setValue(Operations.haba(fValue,SValue) +"");
						}
						else{
							parent.getToken().setErrorMessage("ERROR! data type mismatch.");
							
						}
					break;	
					}
				}
			}
			else{
				if(firstChild.getToken().getErrorMessage().equals("")){
					parent.getToken().setErrorMessage(firstChild.getToken().getErrorMessage());
				}
				else if(secondChild.getToken().getErrorMessage().equals("")){
					parent.getToken().setErrorMessage(secondChild.getToken().getErrorMessage());
				}
			}
		}
		public Token getTokenSymbol(String lexeme, String parentInfo){
			Stack<SymbolTable> usedSymbolTables = new Stack<SymbolTable>();
			if(parentInfo.equals("forStatement")){
				usedSymbolTables.push(stack.pop());
			}
			while(!stack.isEmpty()){
				SymbolTable table = stack.pop();
				Token token = table.get(lexeme);
				usedSymbolTables.push(table);
				if(token != null){
					while(!usedSymbolTables.isEmpty()){
						stack.push(usedSymbolTables.pop());
					}
					return token;
				}
			}
			return null;
		}
		public void updateTokenSymbol(String lexeme, String parentInfo, String attribute, String updatedValue){
			Stack<SymbolTable> usedSymbolTables = new Stack<SymbolTable>();
			if(parentInfo.equals("forStatement")){
				usedSymbolTables.push(stack.pop());
			}
			while(!stack.isEmpty()){
				SymbolTable table = stack.pop();
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
						stack.push(usedSymbolTables.pop());
					}
					break;
				}
			}
		}
		public boolean convertToBoolean(String a){
			if(a.equals("true") || a.equals("TAMA"))
				return true;
				else
					return false;
		}

}
