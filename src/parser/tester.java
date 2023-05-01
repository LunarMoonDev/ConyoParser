package parser;

import java.io.FileNotFoundException;

import semantic.semanticAnalyzer;
import tree.SLLTree;

public class tester {
	public static void main(String args[]){
		Parser parser = new Parser();
		parser.setSourceCode("test9.txt");
		try{
		parser.parse();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
		SLLTree<String> tree = parser.getParseTree();
		//tree.getRoot().printSymbol();
		//tree.printSymBol(tree.getRoot());
		semanticAnalyzer semantic = new semanticAnalyzer();
		System.out.println(tree);
		semantic.Semantic(tree.getRoot());
	}
}
