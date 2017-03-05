package writer;

import java.io.FileWriter;
import java.io.IOException;

import model.dto.FlashCardAppDTO;
import model.dto.FlashCardDTO;
import model.dto.StackWithFlashCardsDTO;

public class CSVWriter implements IStackWriter{
	private static final String COMMA_DELIMITER = ",";
	 private static final String NEW_LINE_SEPARATOR = "\n";
	 
	 private static final String FILE_HEADER = "question,answer";
	 
	 @Override
	 public void writeStacksToFile(String fileName, String path, FlashCardAppDTO flashCardApp) {
		 if(flashCardApp.getStackWithFlashCards() != null) {
			 for(StackWithFlashCardsDTO stackWithFlashCards : flashCardApp.getStackWithFlashCards()) {
				 writeStackToFile(fileName + "_" + stackWithFlashCards.getStack().getName().replaceAll("\\s+", "_"), path, stackWithFlashCards);
			 }
		 }
	 }
	 
	 @Override
	 public void writeStackToFile(String fileName, String path, StackWithFlashCardsDTO stackWithFlashCards) {
		 FileWriter fileWriter = null;
		         try {
		             fileWriter = new FileWriter(path + "/" + fileName + ".csv");
		             fileWriter.append(FILE_HEADER.toString());
		             fileWriter.append(NEW_LINE_SEPARATOR);
		             if(stackWithFlashCards.getFlashcards() != null) {
			             for (FlashCardDTO flashcard : stackWithFlashCards.getFlashcards()) {
			                 fileWriter.append(flashcard.getQuestion());
			                 fileWriter.append(COMMA_DELIMITER);
			                 fileWriter.append(flashcard.getAnswer());
			                 fileWriter.append(NEW_LINE_SEPARATOR);
			             }
		             }
		             System.out.println("CSV file was created successfully !!!");
		 
		         } catch (Exception e) {
		             System.out.println("Error in CsvFileWriter !!!");
		             e.printStackTrace();
		         } finally {
		             try {
		                 fileWriter.flush();
		                 fileWriter.close();
		             } catch (IOException e) {
		                 System.out.println("Error while flushing/closing fileWriter !!!");
		                 e.printStackTrace();
		             }
		         }

	 }

}
