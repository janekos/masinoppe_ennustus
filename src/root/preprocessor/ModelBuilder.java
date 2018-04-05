package root.preprocessor;

import java.io.BufferedReader;
import java.io.FileReader;

import weka.attributeSelection.AttributeSelection;
import weka.classifiers.functions.MultilayerPerceptron;
import weka.classifiers.meta.AttributeSelectedClassifier;
import weka.classifiers.meta.FilteredClassifier;
import weka.core.Instances;
import weka.core.SerializationHelper;
import weka.core.Utils;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.StringToWordVector;

public class ModelBuilder {
	public static int buildModel(String trainingDataPath, String modelPath, boolean timeStamp) {
		
		// https://forums.pentaho.com/threads/97648-Attribute-selection-followed-by-classification-in-weka-explorer/
		// https://stackoverflow.com/questions/28940110/how-can-i-use-my-text-classifier-in-practice-as-of-getting-the-tf-idf-values-of
		// http://www.hakank.org/weka/TextClassifier.java
		try {
			
			if(modelPath.equals("")) { modelPath = "file.model"; }
			
			System.out.println("Starting classifier build");
			
			BufferedReader reader = new BufferedReader(new FileReader(System.getProperty("user.dir") + trainingDataPath));
			Instances trainingData = new Instances(reader);
			reader.close();
			System.out.println("Got data.");
			
			//select which attribtue is model going to be predicting. here its selecting the last column
			trainingData.setClassIndex(trainingData.numAttributes() - 1);
			
			// transform strings into word vectors
			StringToWordVector filter = new StringToWordVector();
			filter.setTFTransform(true);
			filter.setIDFTransform(true);
			filter.setOutputWordCounts(true);
			filter.setWordsToKeep(10000);
			filter.setLowerCaseTokens(true);
			filter.setInputFormat(trainingData);
			System.out.println("Filter set.");
			
			MultilayerPerceptron mlp = new MultilayerPerceptron();
			mlp.setHiddenLayers("o");
			mlp.setLearningRate(0.5);
			mlp.setMomentum(0.2);
			mlp.setTrainingTime(500);
			System.out.println("Classifier set.");
			
			FilteredClassifier fc = new FilteredClassifier();			
			fc.setClassifier(mlp);
			fc.setFilter(filter);
			
			System.out.println("Building classifier.");
			fc.buildClassifier(trainingData);
			
			System.out.println("Classifier built!");
			
			SerializationHelper.write(modelPath, fc);
			System.out.println("Classifier model written. File: "+ modelPath);
			
		} catch (Exception e) {
			System.out.println("Something went wrong while trying to build the model.");
			e.printStackTrace();
		}
		
		return 0;		
	}
}
