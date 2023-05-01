package tree;

import java.util.ArrayList;
import java.util.Set;

import scanner.SymbolTable;
import scanner.Token;

public class SLLNode<T> {
	private int state;
    public T info;
    public int depth;
    public SLLNode<T> nextBrother;
    public SLLNode<T> firstChild;
    private int value = 0;
    private Token token;
    private SymbolTable symbolTable;
    
	public SymbolTable getSymbolTable() {
		return symbolTable;
	}
	public void setSymbolTable(SymbolTable symbolTable) {
		this.symbolTable = symbolTable;
	}
	public Token getToken() {
		return token;
	}
	public void setToken(Token token) {
		this.token = token;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public SLLNode(T el) {
        info = el;
        nextBrother = null;
        firstChild = null;
    }
    public SLLNode(T el, SLLNode<T> ptr1 ,SLLNode<T> ptr2) {
        info = el;
        firstChild = ptr1;
        nextBrother = ptr2;
    }
    public String toString() {
        String s="";
        if(this != null){
        	s = "[" + info+"";
        	if(firstChild != null){
        		s += " # ["+ firstChild.toString()+"]]";
        	}
        	else{
        		s+=" # []]";
        	}
        	if(this.nextBrother != null){
        		s += ","+this.nextBrother.toString() +"";
        	}
        }
        return s;
    }
    public void printSymbol() {
        if(this != null){
        	System.out.println(info);
        	if(this.symbolTable!=null)
        	debugSymbolTable(this.symbolTable);
        	if(firstChild != null){
        		firstChild.printSymbol();
        	}
        	if(this.nextBrother != null){
        		nextBrother.printSymbol();
        	}
        }
    }
	public void debugSymbolTable(SymbolTable table){
		Set<String> keys = table.getTable().keySet();
		System.out.print("\nKey set: ");
		for(String key: keys){
            System.out.print(key+" ");
        }
		System.out.println("\n");
	}
    public ArrayList<SLLNode<T>> getChildren(){
    	ArrayList<SLLNode<T>> childrens =  new ArrayList<SLLNode<T>>();
    		for(SLLNode<T> p = firstChild; p != null; p = p.nextBrother ){
    			childrens.add(p);
    		}
    	return childrens;
    }
}
