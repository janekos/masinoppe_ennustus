package root.analyzer;

public class Analyzer {
	
	private static TextToNgram ttn = new TextToNgram();
	private static GetPrediction gp = new GetPrediction();
	
	public static String getPrediction(String text, boolean html) {
		return gp.predict(text, html);
	}
	
	public static String getNgramString(String text) {
		String ret =  ttn.createNgrams(text);
		return ret;
	}
	
}
