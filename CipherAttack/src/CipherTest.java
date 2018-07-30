import java.util.Arrays;

public class CipherTest {

	public static void main(String[] args) {		

		String cText = "ydonoaT4ethh1tpStefeo1e30brmKuinor7saighsgndar"
				+ "eanwsaretr-n-aatrsityangdaalunopelaTmltwhnsirexpteco"
				+ "onuaoYibteceorrtedpuaet13nhoOocthft1e30broaBck(l7aiy)r"
				+ "dFodnvncadtasceitriceehrobeyusinngogllniqadssdseiauncfi"
				+ "soteadTctsyraleohbaerhmcesntasheadlelsrtstteealdmalotira"
				+ "nsiovffietweitcsichhatehoeopgtretmonhennotadnrfeteobrmn"
				+ "ieohtohegfnOtct3h11e30brotnosad7tilyrctolwtolfsitrenhotn"
				+ "sciuaninotctthedoeIrfyodwifltuaoyrouamoveesslreewihrtabnu"
				+ "lelcredpendtwaneeaorrefv-t-assektecdanfeyoroalsvereufnaia"
				+ "dstoountleestdrneaoumtileorwlrznedaigclefoipTchereoaplsoe"
				+ "PlinowlokayobctlhipPiuaVsdIhpoepevleoiwnhsdtregtasiellhwy"
				+ "htePutpnedepuosrsuperwHileerehattrlstplnoeaFnctriucrcshein"
				+ "nsadhtgeaiateossrcpetgrnhosnofudotriceehhneeitstnhaetvPhop"
				+ "tetlastfieciondsoenhiiutpuorspsyooufrtnloteyRethenhooothpf"
				+ "l-spur-erofayutnhthtiiawleonesnsaterymoudandobeLrrytouihw";
		
		String pText = "Today on the 14th of September 1307 our King has signed"
				+ " an arrest warrant -- against you and all Templars with no "
				+ "exception You are to be captured on the 13th of October 1307 "
				+ "(Black Friday) and convicted as heretics your belongings and "
				+ "liquid assets confiscated The royal chamber has sent sealed "
				+ "letters to all administrative offices with the charge to open "
				+ "them on and not before the morning of the 13th October 1307 "
				+ "and to strictly follow the instructions contained to the word "
				+ "If you fail to arm yourselves there will be an unprecedented "
				+ "wave of arrests --and take care of your selves and fail not "
				+ "to underestimate our well organized police force The Pope "
				+ "also will not back you Philipp IV has developed his own "
				+ "strategy he will put the Pope under pressure He will threaten "
				+ "to split Frances church and instigate a process on the grounds "
				+ "of heretics in the event that the Pope fails to discontinue his "
				+ "support for you Rely not on the help of others -- put your faith "
				+ "in the own alertness and may our Lord be with you";
		
		TranspositionCipher t = new TranspositionCipher();
		
		//Attack
		System.out.println("ATTACK MODE");
		PlainText pObj = t.attack(cText, 7);
		System.out.println(pObj.p);
		System.out.println("Key: " + Arrays.toString(pObj.key));

		int[] key = {6, 4, 1, 5, 0, 2, 3};

		//Decrypt
		System.out.println("DECRYPT MODE");
		String plainText = t.decrypt(cText, key);
		System.out.println(plainText);
		
		//Encrypt
		System.out.println("ENCRYPT MODE");
		String crypText = t.encrypt(pText, key);
		System.out.println(crypText);
		
	}
	
}
