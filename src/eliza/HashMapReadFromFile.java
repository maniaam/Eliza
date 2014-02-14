package eliza;
import java.io.*;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class HashMapReadFromFile
{	
	HashMap<String, String> regularEspression = new HashMap();

	public static void main(String[] args)
	{
		
		Scanner kbd = new Scanner(System.in);
		HashMapReadFromFile r = new HashMapReadFromFile();
		r.readFile();
		System.out.println("Hello, I am Manya's concscience." +
				"\nPlease say BYE whenever you want to stop");
		String answer="";
		String response="";
		do{
			answer = kbd.nextLine().toLowerCase();
		    response = r.processAnswer(answer);
			System.out.println(response);
		} while (!answer.equalsIgnoreCase("Bye"));
		
		
	}
    private Scanner x;
	public void readFile()
	{
		try{	
			
			x = new Scanner(new File("C:/Users/MANYA/Desktop/Project1/Eliza/src/eliza/manya.txt")); 
		}catch(Exception e){
			System.out.println("Couldn't find the file");
		}	
		while(x.hasNext()){
			String str = x.nextLine();
			String[] column = str.split("\t");	
			regularEspression.put(column[0], column[1]);
		}
		x.close();		
	}
	public String processAnswer(String ans){
		for (Map.Entry<String, String> entry:regularEspression.entrySet()){
			if(answerMatches(entry.getKey(), ans));	
			{
				String str= entry.getValue();
				return str;
				//return entry.getValue();
			}
		}
		return randomAnswer();
	}
	public boolean answerMatches(String reg, String str2Check)
	{
		
		Pattern pat = Pattern.compile(reg);
		Matcher regexMatcher = pat.matcher(str2Check);
		
		if(regexMatcher.find())
			return true;	
		return false;
		
	}
	public String randomAnswer(){
		String [] randomAnswer = {"Tell me more","I'd have to know more","What else","Please collaborate"};
		Random rand = new Random();
		int x = rand.nextInt(4);
		return randomAnswer[x];
	}
	
}
