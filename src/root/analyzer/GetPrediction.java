package root.analyzer;

import java.io.BufferedReader;
import java.io.FileReader;

import weka.classifiers.Evaluation;
import weka.classifiers.functions.MultilayerPerceptron;
import weka.core.Instances;
import weka.core.Utils;

public class GetPrediction {

	// https://stackoverflow.com/questions/28694971/using-neural-network-class-in-weka-in-java-code
	// https://stackoverflow.com/questions/38968732/add-double-array-to-weka-instances
	// https://weka.wikispaces.com/Use+WEKA+in+your+Java+code
	// http://weka.8497.n7.nabble.com/Multi-layer-perception-td2896.html
	// https://weka.wikispaces.com/Programmatic+Use
	
	public void predict(String filepath)
	{
		
		try {
			//create training data for the model
			BufferedReader reader = new BufferedReader(new FileReader(filepath));
			Instances trainingData = new Instances(reader);
			reader.close();
			
			//select which attribtue is model going to be predicting. here its selecting the last column
			trainingData.setClassIndex(trainingData.numAttributes() - 1);
			
			//defining algorithm, (options) and training.
			MultilayerPerceptron mlp = new MultilayerPerceptron();
			//mlp.setOptions(Utils.splitOptions("-L 0.1 -M 0.2 -N 2000 -V 0 -S 0 -E 20 -H 3"));
			mlp.buildClassifier(trainingData);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/*ArrayList<Attribute> attributes = new ArrayList<Attribute>();
		attributes.add(new Attribute("x"));
		attributes.add(new Attribute("y"));
		attributes.add(new Attribute("z"));

		Instances dataRaw = new Instances("TestInstances", attributes , 0);
		dataRaw.setClassIndex(dataRaw.numAttributes() - 1); // Assuming z (z on lastindex) as classindex 

		for (Double[] a: myValues) {
			dataRaw.add(new DenseInstance(1.0, a));
		}

		// Then train or build the algorithm/model on instances (dataRaw) created above.

		MultilayerPerceptron mlp = new MultilayerPerceptron(); // Sample algorithm, go through about neural networks to use this or replace with appropriate algorithm.
		mlp.buildClassifier(dataRaw);

		// Create a test instance,I think you can create testinstance without
		// classindex value but cross check in weka as I forgot about it.

		double[] values = new double[]{-818.84, 9186.82, 2436.73}; // sample values
		DenseInstance testInstance = new DenseInstance(1.0, values);
		testInstance.setDataset(dataRaw); // To associate with instances object

		// now you can clasify
		double classify = mlp.classifyInstance(testInstance);
		*/
		
		/*try{
			//Making training data
			FileReader trainreader = new FileReader(filepath);
			Instances train = new Instances(trainreader);
			train.setClassIndex(train.numAttributes() - 1);
			//Instance of NN
			MultilayerPerceptron mlp = new MultilayerPerceptron();
			//Setting Parameters
			/*
		 * L = Learning Rate
		 * M = Momentum
		 * N = Training Time or Epochs
		 * H = Hidden Layers 
		 */
		/*mlp.setOptions(Utils.splitOptions("-L 0.1 -M 0.2 -N 2000 -V 0 -S 0 -E 20 -H 3"));

			//For evaluation of training data,
			Evaluation eval = new Evaluation(train);
			eval.evaluateModel(mlp, train);
			System.out.println(eval.errorRate()); //Printing Training Mean root squared Error
			System.out.println(eval.toSummaryString()); //Summary of Training

			//Prediction
			Instances datapredict = new Instances(new BufferedReader(new FileReader(/*data to predict path*//*))));
			datapredict.setClassIndex(datapredict.numAttributes() - 1);
			Instances predicteddata = new Instances(datapredict);
			//Predict Part
			for (int i = 0; i < datapredict.numInstances(); i++) {
				double clsLabel = mlp.classifyInstance(datapredict.instance(i));
				predicteddata.instance(i).setClassValue(clsLabel);
			}
			System.out.println(predicteddata.toString());

		}
		catch(Exception ex){
			ex.printStackTrace();
		}*/
	}
}
