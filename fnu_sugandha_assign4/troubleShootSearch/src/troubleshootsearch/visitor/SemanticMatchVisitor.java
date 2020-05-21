package troubleshootsearch.visitor;

import java.util.Map.Entry;

import troubleshootsearch.element.MyArrayList;
import troubleshootsearch.element.MyTree;
import troubleshootsearch.util.MyLogger;

public class SemanticMatchVisitor implements VisitorI {

	@Override
	public void visit(MyArrayList myArrayListIn) {
		// TODO Auto-generated method stub
		MyLogger.writeMessage("SemanticMatchVisitor - MyArrayList Element - Visitor", MyLogger.DebugLevel.VISITOR);
		//compatible processor
		String[] userInputs = myArrayListIn.keywordInfo.split(" ");
		int len = userInputs.length;
		//processor
		String synonym = "";
		String userInputTemp = userInputs[len-1].toLowerCase();
		for(Entry<String, String> entry : myArrayListIn.synonymsInfoMap.entrySet()) {
			if(entry.getValue().toLowerCase().equals(userInputTemp)) {
				synonym = entry.getKey().toLowerCase();
			}
			
			if(entry.getKey().toLowerCase().equals(userInputTemp)) {
				synonym = entry.getValue().toLowerCase();
			}	
		}
		myArrayListIn.results.addResult("Semantic Match\n");
		myArrayListIn.results.addResult("--------------\n");
		if(!synonym.isBlank() || !synonym.isEmpty()) {
			for(int i = 0; i < myArrayListIn.productInfo.size(); i++) {
				if(myArrayListIn.productInfo.get(i).toLowerCase().contains(synonym)) {
					myArrayListIn.results.addResult(myArrayListIn.productInfo.get(i)+"\n");
					myArrayListIn.results.addResult("\n");
				}
			}
		}else {
			myArrayListIn.results.addResult("No semantic match\n");
			myArrayListIn.results.addResult("\n");
		}			
	}

	@Override
	public void visit(MyTree myTreeIn) {
		// TODO Auto-generated method stub
		
	}

}
