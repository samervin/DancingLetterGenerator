package generator;

import java.io.FileWriter;
import java.io.IOException;

public class Generator {

	public static void main(String[] args) throws IOException {
		//There is no ? in the small section.
		//All the q gifs have significantly fewer frames of animation.
		//This is really obvious in the small set. Sorry.
		//Also they're all really weird sizes, deal with it.
		
		String validLettersNums = "abcdefghijklmnopqrstuvwxyz0123456789";
		String[] validLargeChars = {"&", "other-amp", "@", "other-at", "!", "other-excl", "$", "other-usd", "?", "other-ques"};
		String[] validSmallChars = {"&", "other-amp", "@", "other-at", "!", "other-excl", "$", "other-usd"};
		
		String input = "test page";
		boolean bigLetters = true;
		
		FileWriter fw = new FileWriter("output.html", false);
		fw.write("<!DOCTYPEhtml><html><head><title>DancingLetterGenerator</title></head><body><p>\n");
		for(int i = 0; i < input.length(); i++) {
			String c = "" + input.charAt(i);
			
			if(c.equals(" ") || c.equals("\n")) { //spaces and newlines both break up lines
				fw.write("<p></p>\n");
			} else if(bigLetters && validLettersNums.contains(c)) { //large letter or digit
				fw.write("<img src=\"large-red\\" + c + ".gif\">\n");
			} else if(bigLetters) { //large other character
				for(int j = 0; j < validLargeChars.length; j++) {
					if(c.equals(validLargeChars[j]))
						fw.write("<img src=\"large-red\\" + validLargeChars[j+1] + ".gif\">\n");
				}
			} else if(validLettersNums.contains(c)) { //small letter or digit
				fw.write("<img src=\"small-color-changing\\" + c + ".gif\">\n");
			} else { //small character
				for(int j = 0; j < validSmallChars.length; j++) {
					if(c.equals(validSmallChars[j]))
						fw.write("<img src=\"small-color-changing\\" + validSmallChars[j+1] + ".gif\">\n");
				}
			}
		}
		fw.write("</p></body></html>");
		fw.close();
	}
}
