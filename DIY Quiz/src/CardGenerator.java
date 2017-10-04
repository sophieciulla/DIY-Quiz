import java.util.Scanner;

public class CardGenerator
{
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
			Quizzer.questions.add(new FlashCard(question, answer));
			System.out.println();
		}
		Quizzer.quiz();
	}
}
