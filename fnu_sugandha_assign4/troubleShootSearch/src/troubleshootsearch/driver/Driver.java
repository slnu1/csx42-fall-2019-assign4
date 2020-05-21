package troubleshootsearch.driver;

import troubleshootsearch.element.MyArrayList;
import troubleshootsearch.element.MyTree;
import troubleshootsearch.util.FileProcessor;
import troubleshootsearch.util.MyLogger;
import troubleshootsearch.util.Results;
import troubleshootsearch.visitor.ExactMatchVisitor;
import troubleshootsearch.visitor.NaiveMatchVisitor;
import troubleshootsearch.visitor.SemanticMatchVisitor;
import troubleshootsearch.visitor.VisitorI;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args.length != 5 || args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}") || args[3].equals("${arg3}") || args[4].equals("${arg4}") ) {

			System.err.println("Error: Incorrect number of arguments. Program accepts 5 argumnets.");
			System.exit(0);
		}
		
		MyLogger.setDebugLevel(Integer.parseInt(args[4]));
		
		Results re = new Results(args[3]);
		MyArrayList al = new MyArrayList(re);
		MyTree mt = new MyTree(re);
		
		VisitorI vem = new ExactMatchVisitor();
		VisitorI vnm = new NaiveMatchVisitor();
		VisitorI vsm = new SemanticMatchVisitor();
		
		//technicalInfo.txt
		FileProcessor fp = new FileProcessor(args[0]);
		fp.readTechicalInfo(al,mt);
		fp = new FileProcessor(args[2]);
		fp.readSynonyms(al,mt);
		fp = new FileProcessor(args[1]);
		fp.readUserInput(al,mt,vem,vnm,vsm);
		re.createFile();
		re.displayResults();
		re.closeFile();
		re.displayStdoutResults();
	}

}
