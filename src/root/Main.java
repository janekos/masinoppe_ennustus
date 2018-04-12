package root;

import root.online.Requests;
import root.preprocessor.ModelBuilder;

import java.text.SimpleDateFormat;
import java.util.Date;

import root.analyzer.Analyzer;

public class Main {

	public static void main(String[] args) {
		
		ConfigIO.readConfig();
		
		if(args.length != 0) {
			switch(args[0]) {
				case "-a": 
					System.out.println("API mode selected.");
					if(args.length == 1) {
						System.out.println("No port specified. Using default 4568.");
					} else {
						Config.setPort(Integer.parseInt(args[1]));
						System.out.println("Using port: " + args[1] + "." );
					}
					Requests.initServer();
					break;
					
				case "-m":
					System.out.println("Model building mode selected.");
					
					if(args.length == 1) {
						System.out.println("No model name given.");
						System.out.println("Starting model build with options from 'config.txt' and default name.");
						new ModelBuilder().buildModel("model-" + new SimpleDateFormat("yyyyMMddHHmm'.txt'").format(new Date()));
					} else { 
						System.out.println("Starting model build with options from 'config.txt' and name '" + args[1] + "'."); 
						new ModelBuilder().buildModel(args[1]);
					}
					
					break;
					
				case "-p":
					System.out.println("Prediction mode selected.");
					
					if(args.length == 1) {
						System.out.println("No text was given");
						System.out.println("Reminder! Text has to go inbetween \" \".");
					} else {
						System.out.println("Supplied text: " + args[1]);
						System.out.println("Predicting text language level using 'config.txt' values.");
						Analyzer.getPrediction(Analyzer.getNgramString(args[1]), false);
					}
					break;
					
				default:
					System.out.println("Incorrect arguments.");
					break;
			}
		}else {
			System.out.println("No arguments present.");
			System.out.println("API mode selected. Starting server.");
			Requests.initServer();
		}
	}	
}
