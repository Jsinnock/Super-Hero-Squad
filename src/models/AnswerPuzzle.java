package models;

public class AnswerPuzzle extends Puzzle{
	String puzzleAnswer;
	AnswerPuzzle(String roomLocation, String puzzleDescription, String puzzleName, String puzzleHint, String puzzleAnswer) {
		super(roomLocation, puzzleDescription, puzzleName, puzzleHint);
		this.puzzleAnswer = puzzleAnswer;
	}
	
}
