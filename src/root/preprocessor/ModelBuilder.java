package root.preprocessor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import root.Config;
import weka.classifiers.functions.MultilayerPerceptron;
import weka.classifiers.meta.FilteredClassifier;
import weka.core.Instances;
import weka.core.SerializationHelper;
import weka.filters.unsupervised.attribute.StringToWordVector;

// https://forums.pentaho.com/threads/97648-Attribute-selection-followed-by-classification-in-weka-explorer/
// https://stackoverflow.com/questions/28940110/how-can-i-use-my-text-classifier-in-practice-as-of-getting-the-tf-idf-values-of
// http://www.hakank.org/weka/TextClassifier.java

public class ModelBuilder {
	public static int buildModel(String modelName) {
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

		try {
			
			if(modelName.equals("")) { modelName = "file.model"; }
			
			System.out.println("[" + dateFormat.format(new Date()) + "]" + " Starting classifier build.");
			
			BufferedReader reader = new BufferedReader(new FileReader(System.getProperty("user.dir") + Config.getTrainingData()));
			Instances trainingData = new Instances(reader);
			reader.close();
			System.out.println("[" + dateFormat.format(new Date()) + "]" + " Got data.");
			
			//select which attribtue is model going to be predicting. here its selecting the last column
			trainingData.setClassIndex(trainingData.numAttributes() - 1);
			
			// transform strings into word vectors
			StringToWordVector filter = new StringToWordVector();
			filter.setTFTransform(Config.isTf());
			filter.setIDFTransform(Config.isIdf());
			filter.setOutputWordCounts(Config.isOutputWordCounts());
			filter.setWordsToKeep(Config.getWordsToKeep());
			filter.setLowerCaseTokens(Config.isLowerCaseTokens());
			filter.setInputFormat(trainingData);
			System.out.println("[" + dateFormat.format(new Date()) + "]" + " Filter set.");
			
			MultilayerPerceptron mlp = new MultilayerPerceptron();
			mlp.setHiddenLayers(Config.getHiddenLayers());
			mlp.setLearningRate(Config.getLearningRate());
			mlp.setMomentum(Config.getMomentum());
			mlp.setTrainingTime(Config.getTrainingTime());
			System.out.println("[" + dateFormat.format(new Date()) + "]" + " Classifier set.");
			
			FilteredClassifier fc = new FilteredClassifier();			
			fc.setClassifier(mlp);
			fc.setFilter(filter);
			
			System.out.println("[" + dateFormat.format(new Date()) + "]" + " Building classifier.");
			fc.buildClassifier(trainingData);
			
			System.out.println("[" + dateFormat.format(new Date()) + "]" + " Classifier built!");
			
			SerializationHelper.write("models/" + modelName + ".model", fc);
			System.out.println("Classifier model written. File: "+ modelName);
			
		} catch (Exception e) {
			System.out.println("Something went wrong while trying to build the model.");
			e.printStackTrace();
		}
		
		return 0;		
	}
}
