package root;

import root.online.Requests;
import root.analyzer.TextToNgram;

public class Main {

	public static void main(String[] args) {
		
		//Requests.initServer(); //starts api	
		TextToNgram.getWordTypesFromText("Tallinna �likooli eesti vahekeele korpus (EVKK) on eesti keele kui riigikeele (teise keele) ja v��rkeele �ppijate kirjalike tekstide kogu.EVKK-s on rida alamkorpusi, kasutajaliides, mitmetasandiline annoteerimis- ja m�rgenduss�steem, statistikamoodul, tekstide automaatanal��si v�imalused jm. Kombineerides erinevaid alamkorpusi, tekstilisi tunnuseid, vealiike ja metateavet �ppija kohta, v�imaldab korpuse kasutajaliides teostada mitmetasandilist otsingut. \r\n Korpust saab kasutada empiirilises ja rakenduslikku laadi uurimist��s; tulevaste �petajate ja lingvistide koolitamisel; tegev�petajate t�iend�ppes jm.");
		
	}
}
