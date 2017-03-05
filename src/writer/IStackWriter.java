package writer;

import model.dto.FlashCardAppDTO;
import model.dto.StackWithFlashCardsDTO;

public interface IStackWriter {
	 public void writeStacksToFile(String fileName, String path,  FlashCardAppDTO flashCardApp);
	 public void writeStackToFile(String fileName, String path, StackWithFlashCardsDTO stackWithFlashCards);
}
