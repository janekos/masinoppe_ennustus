package root.analyzer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import weka.attributeSelection.AttributeSelection;
import weka.attributeSelection.Ranker;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instances;
import weka.core.SelectedTag;
import weka.core.converters.ArffSaver;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.StringToWordVector;

public class GetPrediction {

	// https://stackoverflow.com/questions/28694971/using-neural-network-class-in-weka-in-java-code
	// https://stackoverflow.com/questions/38968732/add-double-array-to-weka-instances
	// https://weka.wikispaces.com/Use+WEKA+in+your+Java+code
	// http://weka.8497.n7.nabble.com/Multi-layer-perception-td2896.html
	// https://weka.wikispaces.com/Programmatic+Use

	// http://weka.8497.n7.nabble.com/Using-Latent-Semantic-Analysis-td7320.html LSA jaoks

	//https://machinelearningmastery.com/save-machine-learning-model-make-predictions-weka/
	public void predict(String ngrams, String filepath)
	{

		try {
			//create training data for the model
			BufferedReader reader = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/keeletase_tekstiga.arff"));
			Instances trainingData = new Instances(reader);
			reader.close();
			System.out.println("Got data");
			//select which attribtue is model going to be predicting. here its selecting the last column
			trainingData.setClassIndex(trainingData.numAttributes() - 1);

			// setting filter
			StringToWordVector filtre = new StringToWordVector();
			filtre.setInputFormat(trainingData);
/*
			filtre.setAttributeIndices("first-last");
			filtre.setTFTransform(true);
			filtre.setIDFTransform(true);
			filtre.setLowerCaseTokens(true);
			SelectedTag selectedTag = new SelectedTag(2, StringToWordVector.TAGS_FILTER);
			filtre.setNormalizeDocLength(selectedTag);
*/
			Instances filteredData = Filter.useFilter(trainingData, filtre);
			System.out.println("Set filter");
			//defining algorithm, (options) and training.
			LatentSemanticAnalysis lsa = new LatentSemanticAnalysis();
			AttributeSelection selecter = new AttributeSelection();

			Ranker rank = new Ranker();
			selecter.setEvaluator(lsa);
			selecter.setSearch(rank);
			selecter.setRanking(true);
			selecter.SelectAttributes(filteredData);
			
			Instances newData1 = selecter.reduceDimensionality(filteredData);
			System.out.println("Dimensionality reduced");
			
			ArffSaver saver = new ArffSaver();
			saver.setInstances(newData1);
			saver.setFile(new File("test.arff"));
			saver.writeBatch();

			System.out.println("File written");
			/*mlp.setOptions(Utils.splitOptions("-L 0.1 -M 0.2 -N 2000 -V 0 -S 0 -E 20 -H 3"));
			mlp.buildClassifier(trainingData);

			DenseInstance testInstance = new DenseInstance(1);
			testInstance.setValue(new Attribute("ngramid"), ngrams);
			testInstance.setDataset(trainingData);

			double classify = mlp.classifyInstance(testInstance);
			System.out.println(classify);
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
