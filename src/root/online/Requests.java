package root.online;

import static spark.Spark.*;

public class Requests {
	public static void GetData() {
		get("/hello", (req, res) -> "Hello World");
	}
}
