package eliza;

import java.util.*;

public class ElizaM 
{

	public static void main(String[] args)
	{
			Scanner kbd = new Scanner(System.in);
			RuleEval re = new RuleEval();
			System.out.println("Hello, I am Manya's concscience." +
					"\nPlease say BYE whenever you want to stop");
			String answer="";
			String response="";
			do{
				answer = kbd.nextLine().toLowerCase();
				if (!answer.equalsIgnoreCase("Bye"))
				{
					response = re.processAnswer(answer);
					if(response!=null)
						System.out.println(response);
				}
			} while (!answer.equalsIgnoreCase("Bye"));
			
	}
}
			