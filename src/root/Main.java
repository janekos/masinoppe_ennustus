package root;

import root.online.Requests;
import root.analyzer.TextToNgram;

public class Main {

	public static void main(String[] args) {
		
		//Requests.initServer(); //starts api	
		TextToNgram.getWordTypesFromText("Tallinna Ülikooli eesti vahekeele korpus (EVKK) on eesti keele kui riigikeele (teise keele) ja võõrkeele õppijate kirjalike tekstide kogu.EVKK-s on rida alamkorpusi, kasutajaliides, mitmetasandiline annoteerimis- ja märgendussüsteem, statistikamoodul, tekstide automaatanalüüsi võimalused jm. Kombineerides erinevaid alamkorpusi, tekstilisi tunnuseid, vealiike ja metateavet õppija kohta, võimaldab korpuse kasutajaliides teostada mitmetasandilist otsingut. \r\n Korpust saab kasutada empiirilises ja rakenduslikku laadi uurimistöös; tulevaste õpetajate ja lingvistide koolitamisel; tegevõpetajate täiendõppes jm.");
		
	}
}
