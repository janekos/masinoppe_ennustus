package root;

import root.online.Requests;

import java.util.Arrays;

import root.analyzer.TextToNgram;

public class Main {

	public static void main(String[] args) {
		
		//Requests.initServer(); //starts api	
		String[] asd = TextToNgram.getWordTypesFromText("Automaatsed hindamissüsteemid aitavad suuresti vähendada hindajate ja õpetajate koormust, individualiseerivad õppimisega seotud aspekte, soodustavad iseõppimist jm, ent sellegipoolest on need süsteemid saanud ka kriitika osaliseks. Ühe miinusena on välja toodud, et need süsteemid ei ole võimelised inimlikult hindama. Teisena on märgitud, et hindamissüsteemid on liialt pinnapealsed, hinnates peamiselt esseede mõõdetavaid tegureid nagu essee pikkus ja sõnade järjestus või jättes need kõrvale ja hinnates ainult sisu. (Dikli 2006: 24-26)15 Kolmandaks probleemiks või ohuks on peetud võimalust automaatset hindamissüsteemi petta, kui selle tööpõhimõtted ja hindamise alused on teada. Hindamissüsteemide arendajad lükkavad need väited ümber või lubavad süsteeme edasi arendada, et sarnast situatsiooni vältida. Neljandaks ohuks peetakse seda, et õpilased hakkavad kirjutama „masinale” ja õpetajad õpetama „masinale” kirjutamist, sest kõik teavad, et töid hinnatakse automaatselt. Viiendaks, kui töid hinnatakse automaatselt ja on teada, millistel teguritel on essee hindamisel (järelikult ka kirjutamisel) suurem kaal, siis arvatakse, et eksamineerija võib süsteemi osaliselt petta. (Blood 2011: 55-59)16 Eespool loetletud puudused on automaatsete hindamissüsteemide arendajad kas juba ümber lükanud või lubavad süsteeme edasi arendades neid probleeme vältida. Töö autor on arvamusel, et inimfaktor ei kao esseede hindamisel kuhugi. Automaatse hindamissüsteemi ja vastavate tarkvaralahenduste eesmärk pole inimteguri kaotamine, vaid nimetatud kahe suuna sümbioos, koostoimimine, et anda keeleõppijatele ja hindajatele avaramaid võimalusi enesekontrolliks. Sellest on abi keele õppimisel, keelekorralduses, samuti keelekasutuse uurimisel.");
		System.out.println(Arrays.toString(asd));
		
	}
}
