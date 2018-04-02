package root.analyzer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class TextToNgram {

	public static String[] createNgrams(int ngramLen, String text) {
		
		List<String> wordTypes = getWordTypesFromText(text);
		List<String> ngramsList = new ArrayList<String>();

		for(int i = 1; i < wordTypes.size() - (ngramLen - 2); i++ ) {
			String ngram = "";

			for(int j = -1; j < ngramLen-2; j++) { ngram += wordTypes.get(i+j); }

			ngramsList.add(ngram);
		}
		
		String[] ngramsArray = ngramsList.toArray(new String[ngramsList.size()]);
		
		return ngramsArray;
	}

	public static List<String> getWordTypesFromText(String text){

		List<String> wordTypes = new ArrayList<String>();
		String s = null;
		System.out.println("siin1");
		//https://alvinalexander.com/java/edu/pj/pj010016
		try {
			//Process p = new ProcessBuilder().command(new String[] {"cmd", "python.exe text_to_postags.py"}).start();
			String[] command = new String[] {"python", "text_to_postags.py", "\""+text+"\""};
			Process p = new ProcessBuilder(command).start();
			BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
			System.out.println("siin2");
			System.out.println(stdInput.readLine());
			while ((s = stdInput.readLine()) != null) {
				//implement writing into wordTypes list
				System.out.println(s);
			}
			
			System.out.println("siin3");
		} catch (IOException e) { System.out.println(e); System.out.println("nahka");}
		System.out.println("siin4");
		return wordTypes; //returns list of each words postag

	}	
}