package root;

import root.online.Requests;

import java.util.Arrays;

import root.analyzer.TextToNgram;

public class Main {

	public static void main(String[] args) {
		
		//Requests.initServer(); //starts api	
		String[] asd = TextToNgram.getWordTypesFromText("Automaatsed hindamiss�steemid aitavad suuresti v�hendada hindajate ja �petajate koormust, individualiseerivad �ppimisega seotud aspekte, soodustavad ise�ppimist jm, ent sellegipoolest on need s�steemid saanud ka kriitika osaliseks. �he miinusena on v�lja toodud, et need s�steemid ei ole v�imelised inimlikult hindama. Teisena on m�rgitud, et hindamiss�steemid on liialt pinnapealsed, hinnates peamiselt esseede m��detavaid tegureid nagu essee pikkus ja s�nade j�rjestus v�i j�ttes need k�rvale ja hinnates ainult sisu. (Dikli 2006: 24-26)15 Kolmandaks probleemiks v�i ohuks on peetud v�imalust automaatset hindamiss�steemi petta, kui selle t��p�him�tted ja hindamise alused on teada. Hindamiss�steemide arendajad l�kkavad need v�ited �mber v�i lubavad s�steeme edasi arendada, et sarnast situatsiooni v�ltida. Neljandaks ohuks peetakse seda, et �pilased hakkavad kirjutama �masinale� ja �petajad �petama �masinale� kirjutamist, sest k�ik teavad, et t�id hinnatakse automaatselt. Viiendaks, kui t�id hinnatakse automaatselt ja on teada, millistel teguritel on essee hindamisel (j�relikult ka kirjutamisel) suurem kaal, siis arvatakse, et eksamineerija v�ib s�steemi osaliselt petta. (Blood 2011: 55-59)16 Eespool loetletud puudused on automaatsete hindamiss�steemide arendajad kas juba �mber l�kanud v�i lubavad s�steeme edasi arendades neid probleeme v�ltida. T�� autor on arvamusel, et inimfaktor ei kao esseede hindamisel kuhugi. Automaatse hindamiss�steemi ja vastavate tarkvaralahenduste eesm�rk pole inimteguri kaotamine, vaid nimetatud kahe suuna s�mbioos, koostoimimine, et anda keele�ppijatele ja hindajatele avaramaid v�imalusi enesekontrolliks. Sellest on abi keele �ppimisel, keelekorralduses, samuti keelekasutuse uurimisel.");
		System.out.println(Arrays.toString(asd));
		
	}
}
