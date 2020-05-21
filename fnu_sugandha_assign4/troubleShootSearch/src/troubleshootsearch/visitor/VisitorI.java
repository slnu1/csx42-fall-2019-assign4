package troubleshootsearch.visitor;

import troubleshootsearch.element.MyArrayList;
import troubleshootsearch.element.MyTree;

public interface VisitorI {
	
	public void visit(MyArrayList myArrayListIn);
	public void visit(MyTree myTreeIn);
}
