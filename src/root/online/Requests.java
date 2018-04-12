package root.online;

import static spark.Spark.*;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import root.Config;
import root.ConfigIO;
import root.analyzer.Analyzer;
import root.preprocessor.ModelBuilder;

public class Requests {
	
	public static void initServer() {
		
		port(Config.getPort());
		
		path("/api", () -> {
		    //before("/*", (q, a) -> System.out.println("got a call"));
		    get("/predict/:tekst", (req, res) -> {          return Analyzer.getPrediction(Analyzer.getNgramString(req.params(":tekst")), true); });
		    get("/listArffs", (res, req) -> {               return Arrays.toString(ConfigIO.listItemsInDir("arff")); });
	    	get("/listModels", (res, req) -> {              return Arrays.toString(ConfigIO.listItemsInDir("models")); });
	    	get("/buildModel/:modelName", (req, res) -> {   return new ModelBuilder().buildModel(req.params(":modelName")); });
	    	get("/buildModel", (req, res) -> {              return new ModelBuilder().buildModel("model-" + new SimpleDateFormat("yyyyMMddHHmm'.txt'").format(new Date())); });
	    	
	    	path("/config/get", () -> {
	    		get("/tf", (req, res) -> {                  return Config.isTf(); });
		    	get("/idf", (req, res) -> {                 return Config.isIdf(); });
		    	get("/momentum", (req, res) -> {            return Config.getMomentum(); });
		    	get("/wordsToKeep", (req, res) -> {         return Config.getWordsToKeep(); });
		    	get("/activeModel", (req, res) -> {         return Config.getActiveModel(); });
		    	get("/trainingData", (req, res) -> {        return Config.getTrainingData(); });
		    	get("/hiddenLayers", (req, res) -> {        return Config.getHiddenLayers(); });
		    	get("/trainingTime", (req, res) -> {        return Config.getTrainingTime(); });
		    	get("/learningRate", (req, res) -> {        return Config.getLearningRate(); });
		    	get("/lowerCaseTokens", (req, res) -> {     return Config.isLowerCaseTokens(); });
		    	get("/outputWordCounts", (req, res) -> {    return Config.isOutputWordCounts(); });
		    	get("/attributeIndices", (req, res) -> {    return Config.getAttributeIndices(); });
		    	get("/normalizeAttributes", (req, res) -> { return Config.isNormalizeAttributes(); });
		    });
	    	
	    	path("/config/update", () -> {
	    		//should be put but it works only in postman so far, so get it is
		    	get("/idf/:var", (req, res) -> { Config.setIdf(req.params(":var"));                                 return Boolean.toString(Config.isIdf()).equals(req.params(":var")) ? "OK" : "NOOK"; });
		    	get("/tf/:var", (req, res) -> { Config.setTf(req.params(":var"));                                   return Boolean.toString(Config.isTf()).equals(req.params(":var")) ? "OK" : "NOOK"; });
		    	get("/momentum/:var", (req, res) -> { Config.setMomentum(req.params(":var"));                       return Double.toString(Config.getMomentum()).equals(req.params(":var")) ? "OK" : "NOOK"; });
		    	get("/wordsToKeep/:var", (req, res) -> { Config.setWordsToKeep(req.params(":var"));                 return Integer.toString(Config.getWordsToKeep()).equals(req.params(":var")) ? "OK" : "NOOK"; });
		    	get("/hiddenLayers/:var", (req, res) -> { Config.setHiddenLayers(req.params(":var"));               return Config.getHiddenLayers().equals(req.params(":var")) ? "OK" : "NOOK"; });
		    	get("/trainingTime/:var", (req, res) -> { Config.setTrainingTime(req.params(":var"));               return Integer.toString(Config.getTrainingTime()).equals(req.params(":var")) ? "OK" : "NOOK"; });
		    	get("/learningRate/:var", (req, res) -> { Config.setLearningRate(req.params(":var"));               return Double.toString(Config.getLearningRate()).equals(req.params(":var")) ? "OK" : "NOOK"; });
		    	get("/lowerCaseTokens/:var", (req, res) -> { Config.setLowerCaseTokens(req.params(":var"));         return Boolean.toString(Config.isLowerCaseTokens()).equals(req.params(":var")) ? "OK" : "NOOK"; });
		    	get("/outputWordCounts/:var", (req, res) -> { Config.setOutputWordCounts(req.params(":var"));       return Boolean.toString(Config.isOutputWordCounts()).equals(req.params(":var")) ? "OK" : "NOOK"; });
		    	get("/attributeIndices/:var", (req, res) -> { Config.setAttributeIndices(req.params(":var"));       return Config.getAttributeIndices().equals(req.params(":var")) ? "OK" : "NOOK"; });
		    	get("/activeModel/:var", (req, res) -> { Config.setActiveModel("/models/" + req.params(":var"));    return Config.getActiveModel().equals("/models/" + req.params(":var")) ? "OK" : "NOOK"; });
		    	get("/trainingData/:var", (req, res) -> { Config.setTrainingData("/arff/" + req.params(":var"));    return Config.getTrainingData().equals("/arff/" + req.params(":var")) ? "OK" : "NOOK"; });
		    	get("/normalizeAttributes/:var", (req, res) -> { Config.setNormalizeAttributes(req.params(":var")); return Boolean.toString(Config.isNormalizeAttributes()).equals(req.params(":var")) ? "OK" : "NOOK"; });
		    });
		});
	}	
}
