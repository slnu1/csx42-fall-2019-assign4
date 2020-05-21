package troubleshootsearch.element;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import troubleshootsearch.util.MyLogger;
import troubleshootsearch.util.Results;
import troubleshootsearch.visitor.VisitorI;

public class MyArrayList{
	
	public List<String> productInfo;
	public Map<String,String> synonymsInfoMap;
	public String keywordInfo;
	public Results results;
	
	public MyArrayList(Results resultsIn) {
		MyLogger.writeMessage("MyArrayList - constructor",MyLogger.DebugLevel.CONSTRUCTOR);
		productInfo = new ArrayList<String>();
		synonymsInfoMap = new HashMap<String, String>();
		results = resultsIn ;
	}
	
	public void accept(VisitorI visitor,String keywordInfoIn) {
		// TODO Auto-generated method stub
		keywordInfo = keywordInfoIn;
		visitor.visit(this);
	}

}
