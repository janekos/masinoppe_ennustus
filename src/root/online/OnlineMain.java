package root.online;

import static spark.Spark.*;

public class OnlineMain {
	
	private Requests req;
	
	public OnlineMain() {
		req = new Requests();
		port(5555);
		Requests.GetData();
	}
}
