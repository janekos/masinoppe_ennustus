package root.analyzer;

import root.Config;
import root.preprocessor.CreateDataToPredict;

import weka.classifiers.Classifier;
import weka.core.Instance;
import weka.core.SerializationHelper;

// https://stackoverflow.com/questions/28940110/how-can-i-use-my-text-classifier-in-practice-as-of-getting-the-tf-idf-values-of
// https://stackoverflow.com/questions/23275600/cant-predicted-the-class-with-weka-using-java-code

public class GetPrediction {
	public String predict(String text) {
		
		String predictionStr = "<pre>";
		
		try {
			Classifier cls = (Classifier) SerializationHelper.read(System.getProperty("user.dir") + Config.getActiveModel());
			Instance testInstance = CreateDataToPredict.createData(text);

			double[] prediction = cls.distributionForInstance(testInstance);
			
			for(int i = 0; i < prediction.length; i = i+1){
				System.out.println(testInstance.classAttribute().value(i) + " keeletaseme tõenäosus on: "+ Double.toString(prediction[i]) + "\n");
				predictionStr += testInstance.classAttribute().value(i) + " keeletaseme tõenäosus on: "+ Double.toString(prediction[i]) + "<br>";
			}

		} catch (Exception e) {
			System.out.println("Something wrong with the prediction");
			e.printStackTrace();
		}
		predictionStr += "</pre>";
		return predictionStr;
	}	
}
