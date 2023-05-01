package tree;

import java.util.Set;
import java.util.Stack;

import scanner.SymbolTable;
import scanner.Token;

public class SLLTree<T> {
	
    private SLLNode<T> root;
    int height;
    public SLLTree(){
    	root = null;
    	height = -1;
    }
    boolean isEmpty(){
    	return(root == null);
    }
    boolean isLeaf(SLLNode<T> node){
    	if(node == null)
    		return false;
    		else
    			return (node.firstChild == null);
    }
    public void setRoot(SLLNode<T> n){
    	root = n;
    }
    public SLLNode<T> getRoot(){
    	return root;
    }
    public SLLNode<T> setChild(SLLNode<T> n, SLLNode<T> a){
    	if(n.firstChild == null){
    		n.firstChild = a;
    		n.firstChild.depth = n.depth+1;
    	}
    	else{
    		/*
    		SLLNode<T> p;
    		for(p = n.firstChild; p.nextBrother != null; p = p.nextBrother);
    		p.nextBrother = a;
    		p.nextBrother.depth = n.firstChild.depth;
    		*/
    		a.nextBrother = n.firstChild;
    		n.firstChild = a;
    		a.depth = a.nextBrother.depth;
    	}
    	return a;
    }
    public String toString(){
        if (root == null)
            return "ht=undefined";
        return ("["+root.info+"# ["+root.firstChild.toString()+"]]");
    }
    public SLLNode<String> dissolve(SLLNode<String> parent){
    	SLLNode<String> transformedNode = null;
    	String operationGrammar = "<STRING_OP> <ARITHOP> <ARITHOP_TWO> <LOGOP> <LOGOP_TWO> <LOGOP_THREE> <LOGOP_FOUR> <LOGOP_FIVE> <LOGOP_SIX> <RELOP> <RELOP_TWO> <RELOP_THREE>";
    	if(operationGrammar.indexOf(parent.info) > -1){
    		transformedNode = specialDissolve(parent);
    	}
    	else{
    		transformedNode = normalDissolve(parent);
    	}
    	return transformedNode;
    }
    public SLLNode<String> normalDissolve(SLLNode<String> parent){
    	if(parent.firstChild != null){
    		SLLNode<String> p = parent.firstChild;
    		SLLNode<String> l = null;
    		for(l = p; p != null; p = p.nextBrother){
    
    			if((p.info.charAt(0) == '<' && !p.info.equals("<STMT>") && !p.info.equals("<INITIALIZE>") && !p.info.equals("<INCREMENT>") && !(p.info.equals("<MULTI_CON>")&&p.firstChild!=null) && !p.info.equals("<ELSE_EXPR>") && !p.info.equals("<WHILE_CATCH>") && !p.info.equals("<CASES>"))   || p.info.equals("OP_PARENTHESIS") || p.info.equals("COLON") || p.info.equals("CL_PARENTHESIS")|| p.info.equals("DELIM")|| p.info.equals("OP_BRACE") || p.info.equals("CL_BRACE")){
    				if(p.firstChild != null){
    					if(p == parent.firstChild){
    						SLLNode<String> k;
    						for(k = p.firstChild; k.nextBrother != null; k = k.nextBrother);
    						k.nextBrother = p.nextBrother;
    						parent.firstChild = parent.firstChild.firstChild;
    						parent.firstChild.depth = parent.depth + 1;
    						l = k;
    						p = k;
    					}
    					else{
    						SLLNode<String> k;
    						for(k = p.firstChild; k.nextBrother != null; k = k.nextBrother);
    						k.nextBrother = p.nextBrother;
    						l.nextBrother = p.firstChild;
    						k.depth = parent.firstChild.depth;
    						p = k;
    						l = k;
    					}
    				}
    				else{
    					if(p == parent.firstChild){
    						parent.firstChild = l.nextBrother;
    						parent.firstChild.depth = parent.depth + 1;
    						l = parent.firstChild;
    					}
    					else{
    						l.nextBrother = p.nextBrother;
    						if(l.nextBrother !=null)
    						l.nextBrother.depth = parent.firstChild.depth;
    						p = l;
    					}
    				}
    		  	}
    		  else{
    			  l = p;
    		  }
    		  if(p.info.equals("<CASES>")){
    			  p.info = "caseStatement";
    		  }
    		  if(p.info.equals("<MULTI_CON>")){
    			  p.info = "elseIfStatement";
    		  }
    		  if(p.info.equals("<ELSE_EXPR>")){
    			  p.info = "elseStatement";
    		  }
    		  if(p.info.equals("<WHILE_CATCH>")){
    			  p.info = "whileCatchStatement";
    		  }
    		  if(p.info.equals("<INITIALIZE>")){
    			  for(SLLNode<String> j = p.firstChild; j != null; j = j.nextBrother){
    				  p.info = "assignmentStatement";
    				  if(j.info.equals("last_na") || j.info.equals("DATA_TYPE")){
    					  p.info = "declarationStatement";
    					  break;
    				  }
    			  }
    		  }
    		  if(p.info.equals("<INCREMENT>")){
    			  p.info = "incrementStatement";
    		  }
    		  if(p.info.equals("<STMT>")){
    			  	String firstOfDeclr = "last_na DATA_TYPE";
    			  	String firstOfCassn = "IDENT";
    			  	String firstOfInput = "basahin_this";
    			  	String firstOfOutput= "ipakita_this";
    			  	String firstOfExpr  = "make_pili kung_true umikot_until make_pasok while_true";
					SLLNode<String> firstChild = p.firstChild;
					if(firstOfDeclr.indexOf(firstChild.info) > -1){
						p.info = "declarationStatement";
					}
					else if(firstOfCassn.indexOf(firstChild.info) > -1){
						p.info = "assignmentStatement";
					}
					else if(firstOfInput.indexOf(firstChild.info) > -1){
						p.info = "inputStatement";
					}
					else if(firstOfOutput.indexOf(firstChild.info) > -1){
						p.info = "outputStatement";
					}
					else if(firstOfExpr.indexOf(firstChild.info) > -1){
						if(firstChild.info.equals("make_pili")){
							p.info = "switchStatement";
						}
						else if(firstChild.info.equals("kung_true")){
							p.info = "ifStatement";
						}
						else if(firstChild.info.equals("umikot_until")){
							p.info = "forStatement";
						}
						else if(firstChild.info.equals("make_pasok")){
							p.info = "doStatement";
						}
						else if(firstChild.info.equals("while_true")){
							p.info = "whileStatement";
						}
					}
			  }
    		}
    	}
    	return parent;
    }
    public SLLNode<String> specialDissolve(SLLNode<String> parent){
    	SLLNode<String> p = parent.firstChild;
		SLLNode<String> l = null;
		SLLNode<String> k = null;
		for(l = p; p != null; p = p.nextBrother){
			 if(p.info.equals("<LOGOP_FOUR>") && p.firstChild.info.equals("LOG_NOT")){
		    		Stack<SLLNode<String>> operands = new Stack<SLLNode<String>>();
		    		operands.setSize(200);
		    		SLLTree<String> a = new SLLTree<String>();
		    		SLLNode<String> newP = p.firstChild;
		    		SLLNode<String> rightOperand = p.firstChild.nextBrother;
		    		newP.nextBrother = null;
	    		newP.depth = parent.depth + 1;
	    		rightOperand = a.setChild(newP,rightOperand);
	    		operands.push(newP);
	    		if(p != parent.firstChild){
	  	    		SLLNode<String> y = operands.pop();
	  	    		y.nextBrother = p.nextBrother;
	  	    		l.nextBrother = y;
	  	    		l = y;
	  	    		p = y;
	  	    	}
	  	    	else{
	  	    		SLLNode<String> y = operands.pop();
	  	    		y.nextBrother = p.nextBrother;
	  	    		parent.firstChild = y;
	  	    		l = y;
	  	    		p = y;
	  	    	}
	    	
		    }
	  		else if(p.info.charAt(0) == '<' ){	
  			String operations = "dugtong kunin_part hanapin haba ARITH_OP_LOWP ARITH_OP_HIGHP LOG_XNOR LOG_XOR LOG_NOTANDOR LOG_NOT LOG_AND LOG_OR REL_OP EQU_OP Sequal";
  	    	for(k = p.firstChild; k != null && operations.indexOf(k.info) == -1 ; k = k.nextBrother){
  	    	}
  	    	 if(k == null){
  	    		if(p == parent.firstChild){
  	    			p.firstChild.nextBrother = p.nextBrother;
  	    			parent.firstChild = p.firstChild;
  	    			parent.firstChild.depth = parent.depth+1;
  	    			l = parent.firstChild;
  	    			p = parent.firstChild;
  	    		}
  	    		else{
  	    			l.nextBrother = p.firstChild;
  	    			p = l.nextBrother;
  	    			l = p;
  	    		}
  	    	
  	    	 }
  	    	else{
  	    		Stack<SLLNode<String>> operands = new Stack<SLLNode<String>>();
  	    		operands.setSize(200);
  	    		Stack<SLLNode<String>> operation = new Stack<SLLNode<String>>();
  	    		operation.setSize(200);
  	    		String turn = "operands";
  	    		for(SLLNode<String> o = p.firstChild; o != null; o = o.nextBrother){
  	    			if(operations.indexOf(o.info) == -1){
  	    				operands.push(o);
  	    				turn = "operation";
  	    			}
  	    			else{
  	    				if(turn == "operands"){
  	    					operands.push(o);
  	    					turn = "operation";
  	    				}
  	    				else{
  	    					operation.push(o);
  	    					turn = "operands";
  	    				}
  	    						
  	    			}
  	    		}
  	    		while(operation.peek() != null){
  	    			SLLTree<String> a = new SLLTree<String>();
  	    			SLLNode<String> newParent = operation.pop();
  	    			SLLNode<String> rightOperand = operands.pop();
  	    			SLLNode<String> leftOperand = operands.pop();
  	    			
  	    			newParent.nextBrother = null;
  	    			newParent.depth = parent.depth + 1;
  	    			rightOperand = a.setChild(newParent,rightOperand);
  	    			leftOperand = a.setChild(newParent, leftOperand);
  	    			operands.push(newParent);
  	    		}
  	    		if(p != parent.firstChild){
  	    		SLLNode<String> y = operands.pop();
  	    		y.nextBrother = p.nextBrother;
  	    		l.nextBrother = y;
  	    		l = y;
  	    		p = y;
  	    		}
  	    		else{
  	    			SLLNode<String> y = operands.pop();
  	    			y.nextBrother = p.nextBrother;
  	    			parent.firstChild = y;
  	    			l = y;
  	    			p = y;
  	    		}
  	    	}
  		  }
  		l = p;
		}
		
	    return parent;
    }
    public void storeSymbolTable(SLLNode<String> parent){
    	for(SLLNode<String> p = parent.firstChild; p != null; p = p.nextBrother){
    		if(p.info.equals("caseStatement") || p.info.equals("switchStatement") || p.info.equals("elseStatement") || p.info.equals("whileCatchStatement")|| p.info.equals("elseIfStatement") || p.info.equals("ifStatement") || p.info.equals("forStatement") || p.info.equals("doStatement") || p.info.equals("whileStatement")){
    			if(p.getSymbolTable() == null){
    				createSymbolTable(p);
    			}/*
    			if(p.getSymbolTable() != null){
    				System.out.print("grandParent:"+parent.info+"\nparent: "+p.info);
    				debugSymbolTable(p.getSymbolTable());
    			}
    			*/
    		}
    	}
    }
    public void createSymbolTable(SLLNode<String> parent){
    	SymbolTable symbolTable = new SymbolTable();
    	for(SLLNode<String> p = parent.firstChild; p != null; p = p.nextBrother){
    		if(p.info.equals("declarationStatement")){
    			for(SLLNode<String>  o = p.firstChild; o!=null ;o = o.nextBrother){
    				if(o.info.equals("IDENT")){
    					if(symbolTable.get(o.getToken().getLexeme()) == null){
    						Token token = o.getToken();
    						symbolTable.put(token.getLexeme(), token);
    					}
    				}
    			}
    		}
    		else if(p.info.equals("forStatement")){
    			for(SLLNode<String>  k = p.firstChild; k!=null ;k = k.nextBrother){
    				if(k.info.equals("declarationStatement")){
    	    			for(SLLNode<String>  o = k.firstChild; o!=null ;o = o.nextBrother){
    	    				if(o.info.equals("IDENT")){
    	    					// could've have stored the data type and if possible the value also
    	    					if(symbolTable.get(o.getToken().getLexeme()) == null){
    	    						Token token = o.getToken();
    	    						symbolTable.put(token.getLexeme(), token);
    	    					}
    	    				}
    	    			}
    	    		}
    			}
    		}
    	}
    	parent.setSymbolTable(symbolTable);
    }
	public void debugSymbolTable(SymbolTable table){
		Set<String> keys = table.getTable().keySet();
		System.out.print("\nKey set: ");
		for(String key: keys){
            System.out.print(key+" ");
        }
		System.out.println("\n");
	}
	public boolean checkEmptySymbolTable(SymbolTable table){
		Set<String> keys = table.getTable().keySet();
		String checker ="";
		for(String key: keys){
            checker += key;
        }
		if(checker.equals(""))
			return true; // if empty return true
		else
			return false;
	}
	public void printSymBol(SLLNode<String> Node){
		if(Node.firstChild == null){
			if(Node.getSymbolTable()!=null)
				debugSymbolTable(Node.getSymbolTable());
		}
		else if(Node.nextBrother == null){
			if(Node.getSymbolTable()!=null)
				debugSymbolTable(Node.getSymbolTable());
		}
		else{
			SLLNode<String> firstChild = Node.firstChild;
			SLLNode<String> nextBrother = Node.nextBrother;
		}
	}
    
}