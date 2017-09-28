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
		System.out.println("How many Questions do you want on your quiz");
		numberOfQuestions = in.nextInt();
		System.out.println();
		
		for (int i = 0; i < numberOfQuestions; i++)
		{
			Scanner QandA = new Scanner(System.in);
			System.out.println("What question do you want for question number " + (i + 1) + "?");
			String question = QandA.nextLine();
			System.out.println("Great! and what would be the answer to that question?");
			String answer = QandA.nextLine();
			QuizQuestions.add(new Quiz(question, answer));
			System.out.println();
		}
		
		System.out.println("Now that you are done filling out the test....here we goooooooo!");
		System.out.println();
		quiz();
	}
	
	public static void quiz()
	{
		questionsRight = 0;
		for (int i = 0; i < numberOfQuestions; i++)
		{
			Scanner in = new Scanner(System.in);
			int randomNumber = (int) (Math.random()*numberOfQuestions) + 1;
			
			if (!NotRepeated.contains(randomNumber))
			{
				NotRepeated.add(new UniqueNumber(randomNumber));
				System.out.println((i + 1)+ ". " + QuizQuestions.get(randomNumber).getQuestion());
				String answer = in.nextLine();
						
				if (answer.equals(QuizQuestions.get(randomNumber).getAnswer()))
				{
					questionsRight = questionsRight + 1;
				}
						
				System.out.println();
			}
				 
			else
			{
				randomNumber = (int) (Math.random()*numberOfQuestions) + 1;
				i = i - 1;
			}
		}		
		score();
	}
	
	public static void score()
	{
		double percentage = (100 / numberOfQuestions) * questionsRight;
		
		System.out.println("You got " + questionsRight + " right out of " + numberOfQuestions + ": " + percentage + "%");
	}
}
