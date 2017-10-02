import java.util.*;

public class Main
{
	static ArrayList <Quiz> QuizQuestions = new ArrayList <Quiz>();
	static ArrayList <UniqueNumber> NotRepeated = new ArrayList <UniqueNumber>();
	static int numberOfQuestions;
	static int questionsRight;
	
	public static void main(String[] args)
	{
		createQuiz();
	}

	public static void createQuiz()
	{
		Scanner in = new Scanner(System.in);
		System.out.println("How many total flashcards do you want?");
		int allQuestions = in.nextInt();
		System.out.println();
		
		for (int i = 0; i < allQuestions; i++)
		{
			Scanner QandA = new Scanner(System.in);
			System.out.println("What question do you want for question number " + (i + 1) + "?");
			String question = QandA.nextLine();
			System.out.println("Great! and what would be the answer to that question?");
			String answer = QandA.nextLine();
			QuizQuestions.add(new Quiz(question, answer));
			System.out.println();
		}
		quiz();
	}
	
	public static void quiz()
	{
		Scanner in = new Scanner(System.in);
		System.out.println("How many of those questions do you want to be tested on?");
		numberOfQuestions = in.nextInt();
		System.out.println("Here we goooooooo!");
		System.out.println();
		System.out.println("_____________________________________________________________________________");
		questionsRight = 0;
		
		for (int i = 0; i < QuizQuestions.size(); i++)
		{
			int randomNumber = (int) (Math.random()*QuizQuestions.size());
			
			if (!NotRepeated.contains(randomNumber))
			{
				System.out.println();
				NotRepeated.add(new UniqueNumber(randomNumber));
				System.out.println((i + 1)+ ". " + QuizQuestions.get(randomNumber).getQuestion());
				String answer = in.nextLine();
						
				if (answer.equals(QuizQuestions.get(randomNumber).getAnswer()))
				{
					questionsRight = questionsRight + 1;
				}
				QuizQuestions.remove(randomNumber);
			}
				 
			else
			{
				i = i - 1;
			}
		}		
		score();
	}
	
	public static void score()
	{
		Scanner quizAgain = new Scanner(System.in);
		System.out.println("_____________________________________________________________________________");
		double percentage = (100 / numberOfQuestions) * questionsRight;
		
		System.out.println("You got " + questionsRight + " right out of " + numberOfQuestions + ": " + percentage + "%");
		System.out.println("Would you like to be quized again?");
		String yeaOrnea = quizAgain.nextLine();
		
		if (yeaOrnea.equals("yes"))
		{
			quiz();
		}
		
		else
		{
			System.out.println("Okay! Thank you for using a student's project to help you study for a test!");
		}
			
		quiz();
	}
}
