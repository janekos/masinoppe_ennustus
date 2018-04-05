package root.analyzer;

import root.preprocessor.CreateDataToPredict;

import weka.classifiers.Classifier;
import weka.core.Instance;
import weka.core.SerializationHelper;

public class GetPrediction {

	//https://stackoverflow.com/questions/23275600/cant-predicted-the-class-with-weka-using-java-code
	public void predict(String modelPath, String text) {
		// https://stackoverflow.com/questions/28940110/how-can-i-use-my-text-classifier-in-practice-as-of-getting-the-tf-idf-values-of
		try {
			Classifier cls = (Classifier) SerializationHelper.read(modelPath);
			Instance testInstance = CreateDataToPredict.createData(text);

			//double classify = cls.classifyInstance(testInstance);
			//System.out.println(classify);
			double[] prediction = cls.distributionForInstance(testInstance);

			//output predictions
			for(int i = 0; i < prediction.length; i = i+1)
			{
				System.out.println("Probability of class "+ testInstance.classAttribute().value(i) + " : "+ Double.toString(prediction[i]));
			}

		} catch (Exception e) {
			System.out.println("Something wrong with the prediction");
			e.printStackTrace();
		}

	}	
}
