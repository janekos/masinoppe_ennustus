package root.online;

import static spark.Spark.*;
import static spark.Spark.get;
import static spark.Spark.put;

import root.Config;
import root.analyzer.Analyzer;

public class Requests {
	
	public static void initServer() {
		
		port(4568);
		
		path("/api", () -> {
		    before("/*", (q, a) -> System.out.println("got a call"));
		    path("/tekst", () -> {
		        get("/:tekst", (req, res) -> {
		        	return Analyzer.getPrediction(req.params(":tekst"));
		        });
		    });
		    path("/config", () -> {
		    	// these should be put() but i cant seem to make them work
		    	get("/idf/:idfvar", (req, res) -> {Config.setIdf(req.params(":idfvar"));                            return "'IDF' set to: " + Config.isIdf();});
		    	get("/tf/:var", (req, res) -> { Config.setTf(req.params(":var"));                                   return "'TF' set to: " + Config.isTf(); });
		    	get("/momentum/:var", (req, res) -> { Config.setMomentum(req.params(":var"));                       return "'Momentum' set to: " + Config.getMomentum(); });
		    	get("/activeModel/:var", (req, res) -> { Config.setActiveModel(req.params(":var"));                 return "'Active model' set to: " + Config.getActiveModel(); });
		    	get("/wordsToKeep/:var", (req, res) -> { Config.setWordsToKeep(req.params(":var"));                 return "'Words to keep' set to: " + Config.getWordsToKeep(); });
		    	get("/hiddenLayers/:var", (req, res) -> { Config.setHiddenLayers(req.params(":var"));               return "Hidden layers' set to: " + Config.getHiddenLayers(); });
		    	get("/trainingTime/:var", (req, res) -> { Config.setTrainingTime(req.params(":var"));               return "'Training time' set to: " + Config.getTrainingTime(); });
		    	get("/learningRate/:var", (req, res) -> { Config.setLearningRate(req.params(":var"));               return "'Learning rate' set to: " + Config.getLearningRate(); });
		    	get("/lowerCaseTokens/:var", (req, res) -> { Config.setLowerCaseTokens(req.params(":var"));         return "'Lower case tokens' set to: " + Config.isLowerCaseTokens(); });
		    	get("/outputWordCounts/:var", (req, res) -> { Config.setOutputWordCounts(req.params(":var"));       return "'Output word counts' set to: " + Config.isOutputWordCounts(); });
		    	get("/attributeIndices/:var", (req, res) -> { Config.setAttributeIndices(req.params(":var"));       return "'Attribute indices' set to: " + Config.getAttributeIndices(); });
			    get("/normalizeAttributes/:var", (req, res) -> { Config.setNormalizeAttributes(req.params(":var")); return "'Normalize attributes' set to: " + Config.isNormalizeAttributes(); });
		    });
		});
	}	
}
