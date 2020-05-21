package troubleshootsearch.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import troubleshootsearch.element.MyArrayList;
import troubleshootsearch.element.MyTree;
import troubleshootsearch.element.Node;
import troubleshootsearch.visitor.VisitorI;


public class FileProcessor {
	private String inputFilename;
	
	public FileProcessor(String inputFilenameIn){
		MyLogger.writeMessage("FileProcessor - constructor",MyLogger.DebugLevel.CONSTRUCTOR);
		inputFilename = inputFilenameIn;	
	}
	
	public void readTechicalInfo(MyArrayList arrayListIn,MyTree myTreeIn) {
		MyLogger.writeMessage("readTechicalInfo",MyLogger.DebugLevel.FILE_PROCESSOR );
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(inputFilename);
			br = new BufferedReader(fr);
			String temp = null;
			int lineNumber = 1;
			while((temp = br.readLine()) != null) {
				arrayListIn.productInfo.add(temp);
				processTree(temp,myTreeIn,lineNumber);
				lineNumber++;
			}
		} catch(FileNotFoundException ex) {
			MyLogger.writeMessage("File not found exception readTechicalInfo method for "+ inputFilename+" "+ex,MyLogger.DebugLevel.ERROR );
			//System.out.println("File not found exception for " + inputFilename + ex);
			System.exit(1);
		} catch (IOException ex) {
			MyLogger.writeMessage("IO exception in readTechicalInfo method for "+ inputFilename+" "+ex,MyLogger.DebugLevel.ERROR );
			ex.printStackTrace();
			System.exit(1);
		} finally {
			try {
				br.close();
			} catch (IOException ex) {
				MyLogger.writeMessage("IO exception in readTechicalInfo method finally for "+ inputFilename+" "+ex,MyLogger.DebugLevel.ERROR );
				ex.printStackTrace();
				System.exit(1);
			}
		}
	}
	
	public void processTree(String productInfoIn,MyTree myTreeIn,int lineNumberIn) {
		MyLogger.writeMessage("processTree",MyLogger.DebugLevel.FILE_PROCESSOR );
		productInfoIn = productInfoIn.replaceAll("[,.:;!]"," ").trim();
		String[] temp = productInfoIn.split(" ");
		
		for (int i = 0; i < temp.length; i++) {
			String trimmed = temp[i].trim();
			if(trimmed.length() == 0) {
				continue;
			}
			if (myTreeIn.map.containsKey(trimmed)) {
				myTreeIn.map.get(trimmed).getLineNumbersFoundIn().add(lineNumberIn);
			} else {
				Node n  = new Node(trimmed);
				n.getLineNumbersFoundIn().add(lineNumberIn);
				myTreeIn.map.put(trimmed, n);
			}
		}
		
	}
	
	public void readUserInput(MyArrayList arrayListIn,MyTree myTreeIn,VisitorI visitorExactIn,VisitorI visitorNaiveIn,VisitorI visitorSemanticIn) {
		
		MyLogger.writeMessage("readUserInput",MyLogger.DebugLevel.FILE_PROCESSOR );
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(inputFilename);
			br = new BufferedReader(fr);
			String temp = null;
			while((temp = br.readLine()) != null) {
				arrayListIn.results.addResult("user input - "+temp+"\n");
				arrayListIn.accept(visitorExactIn,temp);
				myTreeIn.accept(visitorNaiveIn,temp);
				arrayListIn.accept(visitorSemanticIn,temp);
			}
			
		} catch(FileNotFoundException ex) {
			MyLogger.writeMessage("File not found exception in readUserInput method for " + inputFilename+" "+ex,MyLogger.DebugLevel.ERROR );
			//System.out.println("File not found exception for " + inputFilename + ex);
			System.exit(1);
		} catch (IOException ex) {
			MyLogger.writeMessage("IO exception in readUserInput method for " + inputFilename+" "+ex,MyLogger.DebugLevel.ERROR );
			ex.printStackTrace();
			System.exit(1);
		} finally {
			try {
				br.close();
			} catch (IOException ex) {
				MyLogger.writeMessage("IO exception in finally in readUserInput method for "+ inputFilename+" "+ex,MyLogger.DebugLevel.ERROR );
				ex.printStackTrace();
				System.exit(1);
			}
		}
	}
	
	public void readSynonyms(MyArrayList arrayListIn,MyTree myTreeIn) {
		
		MyLogger.writeMessage("readSynonyms",MyLogger.DebugLevel.FILE_PROCESSOR );
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(inputFilename);
			br = new BufferedReader(fr);
			String temp = null;
			while((temp = br.readLine()) != null) {
				String[] synonymsTemp = temp.split("=");
				arrayListIn.synonymsInfoMap.put(synonymsTemp[0], synonymsTemp[1]);
			}
			
		} catch(FileNotFoundException ex) {
			MyLogger.writeMessage("File not found exception in readSynonyms method for "+ inputFilename+" "+ex,MyLogger.DebugLevel.ERROR );
			//System.out.println("File not found exception for " + inputFilename + ex);
			System.exit(1);
		} catch (IOException ex) {
			MyLogger.writeMessage("IO exception in readSynonyms method for "+ inputFilename+" "+ex,MyLogger.DebugLevel.ERROR );
			ex.printStackTrace();
			System.exit(1);
		} finally {
			try {
				br.close();
			} catch (IOException ex) {
				MyLogger.writeMessage("IO exception in finally in readSynonyms method for "+ inputFilename+" "+ex,MyLogger.DebugLevel.ERROR );
				ex.printStackTrace();
				System.exit(1);
			}
		}
	}
}
