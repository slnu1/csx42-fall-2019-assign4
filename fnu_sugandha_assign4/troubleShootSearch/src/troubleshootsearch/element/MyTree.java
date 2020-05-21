package troubleshootsearch.element;

import java.util.Map;
import java.util.TreeMap;

import troubleshootsearch.util.MyLogger;
import troubleshootsearch.util.Results;
import troubleshootsearch.visitor.VisitorI;

public class MyTree{
	
	public Map<String,Node> map;
	public String keywordInfo;
	public Results results;
	
	public MyTree(Results resultsIn) {
		MyLogger.writeMessage("MyTree - constructor",MyLogger.DebugLevel.CONSTRUCTOR);
		map = new TreeMap<String,Node>();
		results = resultsIn;
	}

	public void accept(VisitorI visitor, String keywordInfoIn) {
		// TODO Auto-generated method stub
		keywordInfo = keywordInfoIn;
		visitor.visit(this);
	}
}
