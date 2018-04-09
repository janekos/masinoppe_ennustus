package root.analyzer;

public class Analyzer {
	
	private static TextToNgram ttn = new TextToNgram();
	private static GetPrediction gp = new GetPrediction();
	
	public static String getPrediction(String text) {
		return gp.predict(text);
	}
	
	public static String getNgramString(String text) {
		return ttn.createNgrams(text);
	}
	
}
