package root;

import root.online.Requests;
import root.preprocessor.Preprocessor;

import java.util.Arrays;

import root.analyzer.Analyzer;

public class Main {

	public static void main(String[] args) {
		
		Analyzer.getPrediction("file-500-16h-33m-51s.model", "Mina olen Juku. Mulle meeldima süüa.");
		
		//Analyzer gp = new Analyzer();
		//Requests.initServer(); //starts api	
		//System.out.println("ngrams: " + Arrays.toString(asd));
		//Preprocessor p = new Preprocessor();
		//p.writeModel("/keeletase_tekstiga.arff", "", false);
	}
}
