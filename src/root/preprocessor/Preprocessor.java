package root.preprocessor;

import weka.core.Instances;

public class Preprocessor {

	// https://stackoverflow.com/questions/28694971/using-neural-network-class-in-weka-in-java-code
	// https://stackoverflow.com/questions/38968732/add-double-array-to-weka-instances
	// https://weka.wikispaces.com/Use+WEKA+in+your+Java+code
	// http://weka.8497.n7.nabble.com/Multi-layer-perception-td2896.html
	// https://weka.wikispaces.com/Programmatic+Use

	// http://weka.8497.n7.nabble.com/Using-Latent-Semantic-Analysis-td7320.html LSA jaoks

	// https://machinelearningmastery.com/save-machine-learning-model-make-predictions-weka/
	
	public void writeModel(String trainingDataPath, String modelPath, boolean timestamp) {
		ModelBuilder.buildModel(trainingDataPath, modelPath, timestamp);
	}
}
