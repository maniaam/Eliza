package eliza;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class RuleEval
{
	static Pattern REGEX_YOU = Pattern.compile("\\b(you)\\b(\\w+)?");
	static Pattern REGEX_YOUR = Pattern.compile("(your)\\s(\\w+)");
	static Pattern REGEX_ING = Pattern.compile("i\\s?[am]\\s(\\w+)ing");
	static Pattern REGEX_ING_TO = Pattern.compile("\\s?(\\w+)ing\\sto\\s(\\w+)");
	static Pattern REGEX_HRS = Pattern.compile("\\s([shr](\\w+))(ing|ed)\\s?");
	static Pattern REGEX_HTOT = Pattern.compile("([h-t](\\w+))(ing|ed)");
	static Pattern REGEX_EMOTIONS = Pattern.compile("fine|happy|sad");
	public String processAnswer(String message)
	{
		String response=null;
		if(response==null)
			response = checkYou(message);		
		if(response==null)
			response = checkYour(message);
		if (response==null)
			response = checkVerbHRS(message);
		if (response==null)
			response = checkVerbHtoT(message);
		if (response==null) 
			response = checkIngVerb(message);
		if (response==null)
			response = checkIngVerbTo(message);
		if (response==null)
			response = checkEmotions(message);
		if (response==null)
			response = randomAnswer();
		
		return response;	
	}
	public String checkYou(String str2Check)
	{
		Matcher regexMatcher = REGEX_YOU.matcher(str2Check);
		
		if(regexMatcher.find())
			return "I thought we are talking bout you not me!";
		else return null;
	}	
	public String checkYour( String str2Check)
	{
		Matcher regexMatcher = REGEX_YOUR.matcher(str2Check);
		
		if(regexMatcher.find())
			return "What is it about "+ regexMatcher.group(2) + " that interests you?";
		else return null;
	}	
	public String checkEmotions( String str2Check)
	{
		Matcher regexMatcher = REGEX_EMOTIONS.matcher(str2Check);
		
		if(regexMatcher.find())
			return "What made you feel " + regexMatcher.group();
		else return null;
	}	
	public String checkVerbHRS(String str2Check)
	{
		Matcher regexMatcher = REGEX_HRS.matcher(str2Check);
		if(regexMatcher.find())
			return "Why do you need to " + regexMatcher.group(1) + " " +
			str2Check.substring(regexMatcher.end(), str2Check.length());
		else return null;
	}
		
	public String checkVerbHtoT(String str2Check)
	{
		Matcher regexMatcher = REGEX_HTOT.matcher(str2Check);
		if(regexMatcher.find())
			return "Why do you need to " + regexMatcher.group(1)+ " " +
			str2Check.substring(regexMatcher.end(), str2Check.length());
		else return null;
	}
	public String checkIngVerbTo(String str2Check)
	{
		Matcher regexMatcher = REGEX_ING_TO.matcher(str2Check);
		if(regexMatcher.find())
			return "What made you " + regexMatcher.group(1)
				+ " to " + regexMatcher.group(2);
		     else  return null;
	}	
	public String checkIngVerb(String str2Check)
	{
		Matcher regexMatcher = REGEX_ING.matcher(str2Check);
		if(regexMatcher.find())	
			return "What made you " + regexMatcher.group(1) + 
					str2Check.substring(regexMatcher.end(), str2Check.length());
		else return null;
	}
	public String randomAnswer()
	{
		String [] randomAnswer = {"Tell me more","I'd have to know more","What else","Please collaborate"};
		Random rand = new Random();
		int x = rand.nextInt(4);
		return randomAnswer[x];
	}
	
	
}
	
	

