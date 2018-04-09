package root;

import root.online.Requests;
import root.preprocessor.Preprocessor;

import root.analyzer.Analyzer;

public class Main {

	public static void main(String[] args) {
		
		ConfigIO.readConfig();
		Requests.initServer(); //starts api	
		
		//Analyzer.getPrediction("Tallinna Ülikooli eesti vahekeele korpus (EVKK) on eesti keele kui riigikeele (teise keele) ja võõrkeele õppijate kirjalike tekstide kogu. EVKK-s on rida alamkorpusi, kasutajaliides, mitmetasandiline annoteerimis- ja märgendussüsteem, statistikamoodul, tekstide automaatanalüüsi võimalused jm. Kombineerides erinevaid alamkorpusi, tekstilisi tunnuseid, vealiike ja metateavet õppija kohta, võimaldab korpuse kasutajaliides teostada mitmetasandilist otsingut. \r\nKorpust saab kasutada empiirilises ja rakenduslikku laadi uurimistöös; tulevaste õpetajate ja lingvistide koolitamisel; tegevõpetajate täiendõppes jm. ");
		
		//Preprocessor p = new Preprocessor();
		//p.writeModel("/keeletase_tekstiga.arff", "", false);
	}
	
	
}
