package root.analyzer;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class TextToNgram {

	public static String[] createNgrams(int ngramLen, String text) {
		
		String[] wordTypes = getWordTypesFromText(text);
		List<String> ngramsList = new ArrayList<String>();

		for(int i = 1; i < wordTypes.length - (ngramLen - 2); i++ ) {
			String ngram = "";

			for(int j = -1; j < ngramLen-2; j++) { ngram += wordTypes[i+j]; }

			ngramsList.add(ngram);
		}
		
		String[] ngramsArray = ngramsList.toArray(new String[ngramsList.size()]);
		
		return ngramsArray;
	}

	public static String[] getWordTypesFromText(String text){

		String[] wordTypes = null;
		String s = null;
		
		//https://alvinalexander.com/java/edu/pj/pj010016
		try {
			Process p = null;
			ProcessBuilder pb = new ProcessBuilder("python","text_to_postag.py","\""+text+"\"");
			pb.directory(new File(System.getProperty("user.dir")));
			p = pb.start();
			
			BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
			
			s = stdInput.readLine();
			if(!s.equals("ErrNo1")) {
				s = s.replace("[", "").replace("]", "").replace(" ", "");
				wordTypes = s.split(",");
			}
			/*while ((s = stdInput.readLine()) != null) {
				//implement writing into wordTypes list
				System.out.println(s);
			}*/
			
			/*BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
			
			while ((s = stdError.readLine()) != null) {
                System.out.println(s);
            }*/
			
		} catch (IOException e) { System.out.println(e); }

		return wordTypes; //returns list of each words postag

	}	
}