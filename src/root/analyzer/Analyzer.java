package root.analyzer;

public class Analyzer {
	
	private static TextToNgram ttn = new TextToNgram();
	private static GetPrediction gp = new GetPrediction();
	
	public static void getPrediction(String modelPath, String text) {
		gp.predict(modelPath, text);
	}
	
	public static String getNgramString(int ngramType, String text) {
		return ttn.createNgrams(ngramType, text);
	}
	
}
