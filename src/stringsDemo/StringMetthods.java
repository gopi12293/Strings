package stringsDemo;

import java.awt.SplashScreen;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.regex.Pattern;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class StringMetthods {

	public static Workbook book;
	public static Sheet sheetName;

	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {
		// TODO Auto-generated method stub

		// stringSwap("One", "Two");
		// dublicateChar("gopi srinivas");
		// reverseString("welcome");
		// reverseWords("my name is Gopi Srinivas");
		// reverseAlphabetswithoutchangingSplcharecters("wel@co$m#e");
		// getData();
		// regEx("@$%%");
		//splCharPos("W$l%co&me@");
		
		DatafromExcel getExcelData = new DatafromExcel(); //comment
		String data = getExcelData.getData("Data", "Two", "Test");
		
		System.out.println(data);
		
		/*
		String z = "W$l%co&me@";
		z = z.replaceAll("[^a-zA-Z0-9]", "");
		System.out.println(z);
		
		String s10 = "Test";
		String s11 = "Test";
		s11 = s11+"123";
		System.out.println(s10 + " and " + s11);
		
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("ddMMyyyyHHmmSSS");
		System.out.println(df.format(date));*/
	/*	
		 * char[] ch = {'a', 'b', 'd', 'c'};
		 * 
		 * String te = String.valueOf(ch); String one = "srini@vas"; String five =
		 * "Srinivas"; StringBuffer sb= new StringBuffer(five); sb.reverse();
		 * System.out.println(sb); System.out.println(sb.insert(2, '@')); for (int i =
		 * 0; i < one.length(); i++) { if(one.charAt(i)>='a'&&one.charAt(i)<='z') {
		 * System.out.println("sequence is "+one.charAt(i)); }else {
		 * System.out.println(i + one.charAt(i)); } }
		 * System.out.println(five.compareTo(one));
		 * System.out.println(five.compareToIgnoreCase(one));
		 * System.out.println(one.matches("[a-zA-Z0-9!@#$%^&*()_+]+")); String two =
		 * "I love my country"; System.out.println(te);
		 * System.out.println(te.contains("bc")); System.out.println(te.replace('a',
		 * 'b')); System.out.println(te.replace("ab", "cd"));
		 * System.out.println(one.replaceFirst("i", "a"));
		 * System.out.println(one.replaceAll("i", "a"));
		 * System.out.println(one.toUpperCase()); String[] three = two.split(" ");
		 * for(String four: three) { System.out.println(four); }
		 * System.out.println(one.indexOf('i',one.indexOf('i', one.indexOf('i')+1)+1));
		 * System.out.println(two.indexOf("my")); System.out.println(two.indexOf("o",
		 * 8)); System.out.println(two.indexOf('l'));
		 * System.out.println(one.lastIndexOf('i'));
		 */

	}

	public static void getData() throws EncryptedDocumentException, InvalidFormatException, IOException {
		FileInputStream fis = new FileInputStream(
				new File("C:\\Users\\Gopi Srinivas Putta\\eclipse-workspace\\Strings\\TestData.xlsx"));
		book = WorkbookFactory.create(fis);
		sheetName = book.getSheet("Sheet1");
		String data = "";
		int rowcount = sheetName.getLastRowNum();
		System.out.println(rowcount);
		int colcount = sheetName.getRow(0).getLastCellNum();
		System.out.println(colcount);
		for (int i = 0; i < rowcount; i++) {
			for (int j = 0; j < colcount; j++) {
				data = sheetName.getRow(i).getCell(j).toString();
				System.out.println(data);
			}
			data = "";
		}
	}

	public static void reverseAlphabetswithoutchangingSplcharecters(String word) {
		int wordCount = word.length();
		String wordwithalphabets = "";
		String reversedword = "";
		boolean flag = false;
		for (int i = 0; i < wordCount; i++) {
			for (char ch = 'a'; ch <= 'z'; ch++) {
				if (word.charAt(i) == ch) {
					wordwithalphabets = wordwithalphabets + ch;
					flag = true;
				}
			}
			if (!flag) {
				System.out.println("Non alphabet char is " + word.charAt(i) + " and it is at index of " + i);
			}
			flag = false;
		}
		System.out.println(wordwithalphabets);
		for (int n = wordwithalphabets.length() - 1; n >= 0; n--) {
			reversedword = reversedword + wordwithalphabets.charAt(n);
		}
		char[] chars = reversedword.toCharArray();
		ArrayList<Character> aList = new ArrayList<>();
		for (int j = 0; j < chars.length; j++) {
			aList.add(chars[j]);
		}
		System.out.println(aList);
		aList.add(3, '@');
		aList.add(6, '$');
		aList.add(8, '#');
		for (int m = 0; m < aList.size(); m++) {
			System.out.print(aList.get(m));
		}
	}

	public static void reverseWords(String sentence) {
		String[] al = sentence.split(" ");
		int wordcount = al.length;
		String reversedwords = "";
		String wordtobereversed = "";
		String reversedword = "";
		for (int i = 0; i < wordcount; i++) {
			wordtobereversed = al[i];
			for (int j = wordtobereversed.length() - 1; j >= 0; j--) {
				reversedword = reversedword + wordtobereversed.charAt(j);
			}
			reversedwords = reversedwords + " " + reversedword;
			reversedword = "";
		}
		System.out.println("Reversed string is " + reversedwords);
	}

	public static void reverseString(String sentence) {
		int sentenceLength = sentence.length();
		String reversedString = "";
		for (int i = sentenceLength - 1; i >= 0; i--) {
			reversedString = reversedString + sentence.charAt(i);
		}
		System.out.println("ReversedString String is " + reversedString);
	}

	public static void dublicateChar(String sentence) {

		Map<Character, Integer> map = new HashMap<>();
		int sentenceLength = sentence.length();
		int count = 0;
		for (int i = 0; i < sentenceLength; i++) {
			for (int j = 0; j < sentenceLength; j++) {

				if (sentence.charAt(i) == sentence.charAt(j)) {
					count = count + 1;
					map.put(sentence.charAt(i), count);
				}
			}
			count = 0;
		}
		System.out.println("Charecters and their count are " + map);
		for (int m = 0; m < sentenceLength; m++) {
			if (map.get(sentence.charAt(m)) % 2 == 0) {
				System.out.println(sentence.charAt(m) + " printed even number of times");
			} else {
				System.out.println(sentence.charAt(m) + " printed odd number of times");
			}
		}
	}

	public static void stringSwap(String firstWord, String secondWord) {

		int firstStringLength = firstWord.length();
		int secondStringLength = secondWord.length();
		firstWord = firstWord + secondWord;
		secondWord = firstWord.substring(0, firstStringLength);
		firstWord = firstWord.substring(firstStringLength);
		System.out.println("After swapping words are " + firstWord + " and " + secondWord);
	}

	public static void regEx(String s) {

		System.out.println(Pattern.matches("[^a-zA-Z0-9]+", s));
	}

	public static void splCharPos(String s) {

		String splchar = "!@$%^&*()_+";
		int slength = s.length();
		int splLength = splchar.length();
		String reverse = "";
		TreeMap<Character, Integer> list = new TreeMap<>();

		for (int i = 0; i < slength; i++) {
			for (int j = 0; j < splLength; j++) {
				if (s.charAt(i) == splchar.charAt(j)) {
					System.out.println("splchar char is " + s.charAt(i) + " index is " + i);
					list.put(s.charAt(i), i);
				}
			}
		}
		System.out.println(list);
		Set<Character> list1 = list.keySet();
		System.out.println(list1);
		System.out.println(s);
		for(int z=slength-1; z>=0; z--) {
			if (s.charAt(z)>='a'&&s.charAt(z)<='z') {
				reverse = reverse + s.charAt(z);
			}else if (s.charAt(z)>='A'&&s.charAt(z)<='Z') {
				reverse = reverse + s.charAt(z);
			}
		}
		
		System.out.println(reverse);
		StringBuffer sb = new StringBuffer(reverse);
		for (char ch : list1) {
			sb.insert(list.get(ch), String.valueOf(ch));
			//sb.replace(list.get(ch), list.get(ch) + 1, String.valueOf(ch));
		}
		System.out.println(sb);
	}
}