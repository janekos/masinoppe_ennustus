package root.online;

import static spark.Spark.*;
import static spark.Spark.get;
import static spark.Spark.put;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import root.Config;
import root.ConfigIO;
import root.analyzer.Analyzer;
import root.preprocessor.ModelBuilder;

public class Requests {
	
	public static void initServer() {
		
		port(4568);
		
		path("/api", () -> {
		    //before("/*", (q, a) -> System.out.println("got a call"));
		    get("/predict/:tekst", (req, res) -> {             return Analyzer.getPrediction(Analyzer.getNgramString(req.params(":tekst")), true); });
		    get("/listArffs", (res, req) -> {                  return Arrays.toString(ConfigIO.listItemsInDir("arff")); });
	    	get("/listModels", (res, req) -> {                 return Arrays.toString(ConfigIO.listItemsInDir("models")); });
	    	get("/buildModel/:modelName", (req, res) -> {      return new ModelBuilder().buildModel(req.params(":modelName")); });
	    	get("/buildModel", (req, res) -> {                 return new ModelBuilder().buildModel("model-" + new SimpleDateFormat("yyyyMMddHHmm'.txt'").format(new Date())); });
	    	
	    	path("/config", () -> {
		    	put("/idf/:idfvar", (req, res) -> {Config.setIdf(req.params(":var"));                               return Boolean.toString(Config.isIdf()).equals(req.params(":var")) ? "OK" : "NOOK"; });
		    	put("/tf/:var", (req, res) -> { Config.setTf(req.params(":var"));                                   return Boolean.toString(Config.isTf()).equals(req.params(":var")) ? "OK" : "NOOK"; });
		    	put("/momentum/:var", (req, res) -> { Config.setMomentum(req.params(":var"));                       return Double.toString(Config.getMomentum()).equals(req.params(":var")) ? "OK" : "NOOK"; });
		    	put("/activeModel/:var", (req, res) -> { Config.setActiveModel(req.params(":var"));                 return Config.getActiveModel().equals(req.params(":var")) ? "OK" : "NOOK"; });
		    	put("/wordsToKeep/:var", (req, res) -> { Config.setWordsToKeep(req.params(":var"));                 return Integer.toString(Config.getWordsToKeep()).equals(req.params(":var")) ? "OK" : "NOOK"; });
		    	put("/trainingData/:var", (req, res) -> { Config.setTrainingData(req.params(":var"));               return Config.getTrainingData().equals(req.params(":var")) ? "OK" : "NOOK"; });
		    	put("/hiddenLayers/:var", (req, res) -> { Config.setHiddenLayers(req.params(":var"));               return Config.getHiddenLayers().equals(req.params(":var")) ? "OK" : "NOOK"; });
		    	put("/trainingTime/:var", (req, res) -> { Config.setTrainingTime(req.params(":var"));               return Integer.toString(Config.getTrainingTime()).equals(req.params(":var")) ? "OK" : "NOOK"; });
		    	put("/learningRate/:var", (req, res) -> { Config.setLearningRate(req.params(":var"));               return Double.toString(Config.getLearningRate()).equals(req.params(":var")) ? "OK" : "NOOK"; });
		    	put("/lowerCaseTokens/:var", (req, res) -> { Config.setLowerCaseTokens(req.params(":var"));         return Boolean.toString(Config.isLowerCaseTokens()).equals(req.params(":var")) ? "OK" : "NOOK"; });
		    	put("/outputWordCounts/:var", (req, res) -> { Config.setOutputWordCounts(req.params(":var"));       return Boolean.toString(Config.isOutputWordCounts()).equals(req.params(":var")) ? "OK" : "NOOK"; });
		    	put("/attributeIndices/:var", (req, res) -> { Config.setAttributeIndices(req.params(":var"));       return Config.getAttributeIndices().equals(req.params(":var")) ? "OK" : "NOOK"; });
		    	put("/normalizeAttributes/:var", (req, res) -> { Config.setNormalizeAttributes(req.params(":var")); return Boolean.toString(Config.isNormalizeAttributes()).equals(req.params(":var")) ? "OK" : "NOOK"; });
		    });	    	
		});
	}	
}
