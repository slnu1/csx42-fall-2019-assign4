package troubleshootsearch.visitor;

import troubleshootsearch.element.MyArrayList;
import troubleshootsearch.element.MyTree;
import troubleshootsearch.util.MyLogger;

public class ExactMatchVisitor implements VisitorI {

	@Override
	public void visit(MyArrayList myArrayListIn) {
		MyLogger.writeMessage("ExactMatchVisitor - MyArrayList Element - Visitor", MyLogger.DebugLevel.VISITOR);
		myArrayListIn.results.addResult("Exact Match\n");
		myArrayListIn.results.addResult("-----------\n");
		boolean matched = false;
		for(int i = 0; i < myArrayListIn.productInfo.size(); i++) {
			if(myArrayListIn.productInfo.get(i).toLowerCase().contains(myArrayListIn.keywordInfo.toLowerCase())) {
				//add to result
				matched = true;
				myArrayListIn.results.addResult(myArrayListIn.productInfo.get(i)+"\n");
				myArrayListIn.results.addResult("\n");
				//System.out.println("exact match "+myArrayListIn.productInfo.get(i));
				//System.out.println("");
			}
		}
		if(!matched) {
			myArrayListIn.results.addResult("No exact match\n");
			myArrayListIn.results.addResult("\n");
			//System.out.println("No exact match");
			//System.out.println("");
		}
		
	}

	@Override
	public void visit(MyTree myTreeIn) {
		// TODO Auto-generated method stub
		
	}

}
