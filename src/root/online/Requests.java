package root.online;

import static spark.Spark.*;
import static spark.Spark.get;
import static spark.Spark.put;

import java.text.SimpleDateFormat;
import java.util.Date;

import root.Config;
import root.analyzer.Analyzer;
import root.preprocessor.ModelBuilder;

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
		    	put("/idf/:idfvar", (req, res) -> {Config.setIdf(req.params(":idfvar"));                            return "'IDF' set to: " + Config.isIdf(); });
		    	put("/tf/:var", (req, res) -> { Config.setTf(req.params(":var"));                                   return "'TF' set to: " + Config.isTf(); });
		    	put("/momentum/:var", (req, res) -> { Config.setMomentum(req.params(":var"));                       return "'Momentum' set to: " + Config.getMomentum(); });
		    	put("/activeModel/:var", (req, res) -> { Config.setActiveModel(req.params(":var"));                 return "'Active model' set to: " + Config.getActiveModel(); });
		    	put("/wordsToKeep/:var", (req, res) -> { Config.setWordsToKeep(req.params(":var"));                 return "'Words to keep' set to: " + Config.getWordsToKeep(); });
		    	put("/trainingData/:var", (req, res) -> { Config.setTrainingData(req.params(":var"));               return "'Training data' set to: " + Config.getTrainingData(); });
		    	put("/hiddenLayers/:var", (req, res) -> { Config.setHiddenLayers(req.params(":var"));               return "'Hidden layers' set to: " + Config.getHiddenLayers(); });
		    	put("/trainingTime/:var", (req, res) -> { Config.setTrainingTime(req.params(":var"));               return "'Training time' set to: " + Config.getTrainingTime(); });
		    	put("/learningRate/:var", (req, res) -> { Config.setLearningRate(req.params(":var"));               return "'Learning rate' set to: " + Config.getLearningRate(); });
		    	put("/lowerCaseTokens/:var", (req, res) -> { Config.setLowerCaseTokens(req.params(":var"));         return "'Lower case tokens' set to: " + Config.isLowerCaseTokens(); });
		    	put("/outputWordCounts/:var", (req, res) -> { Config.setOutputWordCounts(req.params(":var"));       return "'Output word counts' set to: " + Config.isOutputWordCounts(); });
		    	put("/attributeIndices/:var", (req, res) -> { Config.setAttributeIndices(req.params(":var"));       return "'Attribute indices' set to: " + Config.getAttributeIndices(); });
		    	put("/normalizeAttributes/:var", (req, res) -> { Config.setNormalizeAttributes(req.params(":var")); return "'Normalize attributes' set to: " + Config.isNormalizeAttributes(); });
		    });
	    	get("/buildModel/:modelName", (req, res) -> {      return new ModelBuilder().buildModel(req.params(":modelName")); });
	    	get("/buildModel", (req, res) -> {                 return new ModelBuilder().buildModel("model-" + new SimpleDateFormat("yyyyMMddHHmm'.txt'").format(new Date())); });
		});
	}	
}
