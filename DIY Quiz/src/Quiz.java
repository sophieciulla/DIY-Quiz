
public class Quiz
{
	String question;
	String answer;
	
	public Quiz(String ques, String ans)
	{
		question = ques;
		answer = ans;
	}

	public String getQuestion()
	{
		return question;
	}

	public void setQuestion(String question)
	{
		this.question = question;
	}

	public String getAnswer()
	{
		return answer;
	}

	public void setAnswer(String answer)
	{
		this.answer = answer;
	}
}