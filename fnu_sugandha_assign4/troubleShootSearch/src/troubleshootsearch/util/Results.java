package troubleshootsearch.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Results implements FileDisplayInterface, StdoutDisplayInterface{
	
	static String output;
	String filename;
	BufferedWriter bw;
	
	
	public Results(String filenamein) {
		MyLogger.writeMessage("Results - constructor",MyLogger.DebugLevel.CONSTRUCTOR);
		output = "";
		filename = filenamein;
	}
	public void addResult(String messageIn) {
		// TODO Auto-generated method stub
		output = output + messageIn;
	}
	
	@Override
	public void displayStdoutResults() {
		// TODO Auto-generated method stub
		MyLogger.writeMessage(output, MyLogger.DebugLevel.OUTPUT);
	}
	
	@Override
	public void displayResults() {
		// TODO Auto-generated method stub
		try {
			bw.write(output);
			//bw.newLine(); 
	      } catch (IOException e) {
	    	  MyLogger.writeMessage("IO exception in displayResults method for " +filename+" "+e,MyLogger.DebugLevel.ERROR );
	          e.printStackTrace();
	      }
	}
	
	public void createFile() {
		try {
			 File file = new File(filename);
	         if (!file.exists()) {
	            file.createNewFile();
	         } 
	         FileWriter fw = new FileWriter(file.getAbsoluteFile());
		     bw = new BufferedWriter(fw);
		} catch (IOException e) {
			MyLogger.writeMessage("IO exception in createFile method for " +filename+" "+e,MyLogger.DebugLevel.ERROR );
			e.printStackTrace();
		}   	  
	}
	
	public void closeFile() {
		try {
			bw.close();
		} catch (IOException e) {
			MyLogger.writeMessage("IO exception in closeFile method for "+filename+" "+e,MyLogger.DebugLevel.ERROR );
			e.printStackTrace();
		}
	}
}
