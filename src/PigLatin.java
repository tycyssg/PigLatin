import java.util.Scanner;

public class PigLatin {
	
	static Scanner key = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		
		String sentence = checkSentence();
		int letterPosition = 0;
		String word = "", newWord = "",newSentence = "";
		
		
		do {
			
			while(sentence.charAt(letterPosition) != ' ' && sentence.charAt(letterPosition) != '.') {
				word += "" + sentence.charAt(letterPosition);
				letterPosition++;
			}
			
			int range = clusterConsonantCheck(word);
			
			if(range != 0) {
				newWord = word.substring(range, word.length()) + word.substring(0,range)+"ay";
			}else {
				newWord = word+"way";
			}
			
			newSentence += newWord+" ";
			newWord = "";
			word = "";
			letterPosition++;
		
		}while(sentence.charAt(letterPosition-1) != '.');
		
		System.out.println(newSentence);

	}
	

	public static String checkSentence(){
		System.out.println("Please input a sentence followed by full stop.");
		String sentence = key.nextLine();
		
			while(sentence.charAt(sentence.length()-1) != '.') {
				System.out.println("Error !");
				System.out.println("Please input a sentence followed by full stop.");
				sentence = key.nextLine();
			}
			
			return sentence;		
		}
	
	public static int clusterConsonantCheck(String word) {
		
		int counter = 0;
		
		for(int i = 0; i < word.length(); i++) {
			if(checkLetters(word.charAt(i))) {
				break;
			}else {
				counter++;
			}
		}
		
		return counter;
		
	}
	
	public static boolean checkLetters(char letter) {
		
		char firstLetter = Character.toLowerCase(letter);
		boolean itIsVowel = false;
		switch(firstLetter) {
		case 'a':;
		case 'e':;
		case 'i':;
		case 'o':;
		case 'u': itIsVowel= true;
		break;
		default: itIsVowel = false;
		}
		
		return itIsVowel;
	}
}
