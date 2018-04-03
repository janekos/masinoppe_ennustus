package root.online;

import static spark.Spark.*;

import java.util.Arrays;

import root.analyzer.AnalyzerMain;

public class Requests {
	
	private static AnalyzerMain am = new AnalyzerMain();
	
	public static void initServer() {
		
		port(4568);
		
		path("/api", () -> {
		    before("/*", (q, a) -> System.out.println("got a call"));
		    path("/tekst", () -> {
		        get("/:tekst", (req, res) -> {
		        	return /*Arrays.toString(am.getNgram(*/req.params(":tekst");/*));*/ //todo here itll call fn that does the predictions
		        });
		    });
		});
	}
}
