package scanner;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class fileIO {
	private String filePath;
	private Scanner scan;
	private String charArrayStore;
	private char[] charArray;
	private int end, start;
	private int length;
	
	public fileIO(String filePath){
		this.filePath = filePath;
		start = 0;
		end = 0;
	}	
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public Scanner getScan() {
		return scan;
	}
	public void setScan(Scanner scan) {
		this.scan = scan;
	}
	public String getCharArrayStore() {
		return charArrayStore;
	}
	public void setCharArrayStore(String charArrayStore) {
		this.charArrayStore = charArrayStore;
	}
	public char[] getCharArray() {
		return charArray;
	}
	public void setCharArray(char[] charArray) {
		this.charArray = charArray;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	
	//use reset if you got an unmatched token in the DFA
	public void reset(){
		end = start;
	}
	//use finalize if you got a matched token in the DFA
	public void finalize(){
		start = end;
	}
	public void read() throws FileNotFoundException{
		// reads the entire file and store it in the array;
		scan = new Scanner(new FileReader(filePath));
		charArrayStore = scan.nextLine() +"`EOL";
		while(scan.hasNextLine()){
				charArrayStore = charArrayStore+scan.nextLine()+"`EOL";
		}
		String wholeText = charArrayStore.substring(0, (charArrayStore.length() - 4));
		wholeText+="`EOF";
		charArrayStore = wholeText;
		charArray = charArrayStore.toCharArray();
		length = charArray.length;
	}
	//same style it's just that every time you increment end var will move
	public void increment(){
//		System.out.println(end);
	// call this first before you use getChar
		if(end < length){
			end ++;
		}
		else
			System.out.println("ERROR! can't increment.");
	}
	//same you can use this to get the char
	public char getChar(){
		return charArray[end];
	}
	//same use this to pushback if you want
	public void pushBack(){
	// call this if you want to move back
		end--;
	}
	public String getError(){
		String error = "";
		for(int i = start; i < end; i++){
			error += charArray[i];
		}
		return error;
	}
	public boolean canIncrement() {
		int temp = end;
		temp++;
		return (temp <= length) ? true : false;
	}
}
