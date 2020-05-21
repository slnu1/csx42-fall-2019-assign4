package troubleshootsearch.visitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import troubleshootsearch.element.MyArrayList;
import troubleshootsearch.element.MyTree;
import troubleshootsearch.element.Node;
import troubleshootsearch.util.MyLogger;

public class NaiveMatchVisitor implements VisitorI {

	@Override
	public void visit(MyArrayList myArrayListIn) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(MyTree myTreeIn) {
		// TODO Auto-generated method stub
		MyLogger.writeMessage("NaiveMatchVisitor - MyTree Element - Visitor", MyLogger.DebugLevel.VISITOR);
		int wordCounter = 0;
		List <Integer> lineNumbers = new ArrayList<Integer>();
		//install software -- user input
		//dSeaGate software can be reinstalled only once --technicalInfo 
		String[] userInputs = myTreeIn.keywordInfo.split(" ");
		String userInputTemp = userInputs[0].toLowerCase();
		myTreeIn.results.addResult("Naive Stemming Match\n");
		myTreeIn.results.addResult("--------------------\n");
		for(Map.Entry<String,Node> entry : myTreeIn.map.entrySet()) { 
			if(entry.getKey().toLowerCase().indexOf(userInputTemp) > -1) {
				if(!entry.getKey().toLowerCase().equals(userInputTemp)) {
					wordCounter++;
					lineNumbers.addAll(entry.getValue().getLineNumbersFoundIn());					
				}
			}
		}	
		
		if(wordCounter > 0) {
			myTreeIn.results.addResult("Word Count = "+wordCounter+"\n");
			myTreeIn.results.addResult("Line Numbers = "+lineNumbers.toString().replaceAll("[\\[\\]]", "")+"\n");
			myTreeIn.results.addResult("\n");
			
		}else {
			myTreeIn.results.addResult("No naive stemming match\n");
			myTreeIn.results.addResult("\n");
		}
	}

}
