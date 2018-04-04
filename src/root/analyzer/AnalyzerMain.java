package root.analyzer;

public class AnalyzerMain {
	
	private TextToNgram ttn = new TextToNgram();
	private GetPrediction gp = new GetPrediction();
	
	public void getPrediction(String text) {
		gp.predict(getNgramString(text) , "");
	}
	
	public String getNgramString(String text) {
		return ttn.createNgrams(3, text);
	}
	
}
