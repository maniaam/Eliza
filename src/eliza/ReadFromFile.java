package eliza;
import java.io.*;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ReadFromFile
{	
	String[] regularExpression;
	String[] answer;
	
	public static void main(String[] args)
	{
		
		Scanner kbd = new Scanner(System.in);
		ReadFromFile r = new ReadFromFile();
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
    private Scanner x, y;
	public void readFile()
	{
		try{	
			
			x = new Scanner(new File("C:/Users/MANYA/Desktop/Project1/Eliza/src/eliza/manya.txt")); 
			y = new Scanner(new File("C:/Users/MANYA/Desktop/Project1//Eliza/src/eliza/manya.txt")); 
		}catch(Exception e){
			System.out.println("Couldn't find the file");
		
		}
		int count=0;
		while(x.hasNext( )){
			String str = x.nextLine();
			count++;
		}
	
		regularExpression = new String [count];
		answer = new String[count];
		int i=0;
		while(y.hasNext()){
			String str = y.nextLine();
			String[] column = str.split("\t");	
			regularExpression[i] = column[0];
			answer[i] = column[1];	
				i++;
		}
		
		x.close();
		y.close();	
	}
	public String processAnswer(String ans){
		for(int i=0;i<regularExpression.length;i++){
			if (answerMatches(regularExpression[i],ans)){
				return answer[i];
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
