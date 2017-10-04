import java.util.ArrayList;
import java.util.Scanner;

public class Quizzer
{
	static ArrayList <FlashCard> questions = new ArrayList <FlashCard>();
	static int numberOfQuestions;
	static int questionsRight;
	
	public static void main(String[] args)
	{
		CardGenerator.createQuiz();
	}
	
	public static void quiz()
	{
		Scanner in = new Scanner(System.in);
		System.out.println("How many of those questions do you want to be tested on?");
		numberOfQuestions = in.nextInt();
		System.out.println("Here we goooooooo!");
		System.out.println();
		questionsRight = 0;
		
		for (int i = 0; i < numberOfQuestions; i++)
		{
			int randomNumber = (int) (Math.random()*questions.size());
			
			Scanner ans = new Scanner(System.in);
			System.out.println("_____________________________________________________________________________");
			System.out.println("Q: " + questions.get(randomNumber).getQuestion());
			System.out.print("A: ");
			String answer = ans.nextLine();
						
			if (answer.equals(questions.get(randomNumber).getAnswer()))
			{
				questionsRight = questionsRight + 1;
			}
			
			questions.remove(randomNumber);
			System.out.println("_____________________________________________________________________________");
			System.out.println();
		}		
		score();
	}
	
	public static void score()
	{
		System.out.println("_____________________________________________________________________________");
		int percentage = (100 / numberOfQuestions) * questionsRight;
		
		System.out.println("You got " + questionsRight + " right out of " + numberOfQuestions + ": " + percentage + "%");
	}
}