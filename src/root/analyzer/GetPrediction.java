package root.analyzer;

import java.io.BufferedReader;
import java.io.FileReader;

import weka.classifiers.functions.MultilayerPerceptron;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instances;

public class GetPrediction {

	// https://stackoverflow.com/questions/28694971/using-neural-network-class-in-weka-in-java-code
	// https://stackoverflow.com/questions/38968732/add-double-array-to-weka-instances
	// https://weka.wikispaces.com/Use+WEKA+in+your+Java+code
	// http://weka.8497.n7.nabble.com/Multi-layer-perception-td2896.html
	// https://weka.wikispaces.com/Programmatic+Use
	
	// http://weka.8497.n7.nabble.com/Using-Latent-Semantic-Analysis-td7320.html LSA jaoks
	
	public void predict(String[] ngrams, String filepath)
	{
		
		try {
			//create training data for the model
			BufferedReader reader = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/keeletase_ja_ngramid.arff"));
			Instances trainingData = new Instances(reader);
			reader.close();
			
			//select which attribtue is model going to be predicting. here its selecting the last column
			trainingData.setClassIndex(trainingData.numAttributes() - 1);
			
			//defining algorithm, (options) and training.
			MultilayerPerceptron mlp = new MultilayerPerceptron();
			//mlp.setOptions(Utils.splitOptions("-L 0.1 -M 0.2 -N 2000 -V 0 -S 0 -E 20 -H 3"));
			mlp.buildClassifier(trainingData);
			
			String s = "";
			for(String a : ngrams) {
				s += a;
			}
			
			System.out.println(s);
			
			DenseInstance testInstance = new DenseInstance(1);
			testInstance.setValue(new Attribute("ngramid"), s);
			testInstance.setDataset(trainingData);
			
			double classify = mlp.classifyInstance(testInstance);
			System.out.println(classify);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
