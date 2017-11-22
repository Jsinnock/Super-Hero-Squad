package models;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class PuzzleList {

	// actual Media Library data
	private ArrayList<Puzzle> puzzleListItems = new ArrayList<Puzzle>();

	public void addItem(Puzzle item) {
		puzzleListItems.add(item);
	}

	public void printPuzzleItems() {
		for (int i = 0; i < puzzleListItems.size(); i++) {
			Puzzle temp = puzzleListItems.get(i);
			System.out.println(temp);
		}
	}

	public static void main(String[] args) {
		// create puzzleList by reading in from text file named PuzzleList.txt
		PuzzleList puzzleList = new PuzzleList();
		try {
			// open text file
			File mediaFile = new File("PuzzleList.txt");
			// open a Scanner to read data from File
			Scanner fileReader = new Scanner(mediaFile);

			// read one person at a time
			while (fileReader != null && fileReader.hasNext()) {

				String name = fileReader.nextLine();
				String location = fileReader.nextLine();
				String description = fileReader.nextLine();
				String hint = fileReader.nextLine();
				String type = fileReader.nextLine();

				if (type.equalsIgnoreCase("Answer")) {
					String answer = fileReader.nextLine();
					AnswerPuzzle answerPuzzle = new AnswerPuzzle(name, location, description, hint, type, answer);
					puzzleList.addItem(answerPuzzle);

				} else if (type.equalsIgnoreCase("Item")) {
					String item = fileReader.nextLine();

					ItemPuzzle itemPuzzle = new ItemPuzzle(name, location, description, hint, type, item);
					puzzleList.addItem(itemPuzzle);
				}

			}

		} catch (

		FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		puzzleList.printPuzzleItems();
	}
}
