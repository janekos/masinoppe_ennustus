package root.online;

import static spark.Spark.*;

public class Requests {
	public static void initServer() {
		
		port(4568);
		
		path("/api", () -> {
		    before("/*", (q, a) -> System.out.println("got a call"));
		    path("/tekst", () -> {
		        get("/:tekst", (req, res) -> {
		        	return req.params(":tekst"); //todo here itll call fn that does the predictions
		        });
		    });
		});
	}
}
