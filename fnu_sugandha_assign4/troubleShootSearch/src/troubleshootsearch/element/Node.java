package troubleshootsearch.element;

import java.util.ArrayList;
import java.util.List;

import troubleshootsearch.util.MyLogger;

public class Node {
	private String word;
	private List<Integer> lineNumbersFoundIn;
	
	public Node(String wordIn) {
		MyLogger.writeMessage("Node - constructor",MyLogger.DebugLevel.CONSTRUCTOR);
		word = wordIn;
		lineNumbersFoundIn = new ArrayList<Integer>();
	}
	
	public String getWord() {
		return word;
	}
	
	public void setWord(String word) {
		this.word = word;
	}
	
	public List<Integer> getLineNumbersFoundIn() {
		return lineNumbersFoundIn;
	}
	
	public void setLineNumbersFoundIn(List<Integer> lineNumbersFoundIn) {
		this.lineNumbersFoundIn = lineNumbersFoundIn;
	}
	
	public String toString() {
		String lines = "";
		for(int i = 0; i < lineNumbersFoundIn.size(); i++) {
			lines = lines + " " + lineNumbersFoundIn.get(i);
		}
		return "\nWord: "+word+ " Linenumbers: "+ lines;
	}
}
