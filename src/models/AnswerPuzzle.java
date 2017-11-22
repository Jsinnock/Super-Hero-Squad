package models;

public class AnswerPuzzle extends Puzzle{
	String puzzleAnswer;
	AnswerPuzzle(String puzzleName, String roomLocation, String puzzleDescription,  String puzzleHint, String puzzleType, String puzzleAnswer) {
		super(puzzleName, roomLocation, puzzleDescription, puzzleHint, puzzleType);
		this.puzzleAnswer = puzzleAnswer;
	}
	
	public void setPuzzleAnswer(String puzzleAnswer)
	{
		this.puzzleAnswer = puzzleAnswer;
	}
	
	public String getPuzzleAnswer()
	{
		return puzzleAnswer;
	}
	
	
}
