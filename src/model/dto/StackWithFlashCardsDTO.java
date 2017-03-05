package model.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

@XmlAccessorType(XmlAccessType.FIELD)
public class StackWithFlashCardsDTO {
	private StackDTO stack;
	@XmlElementWrapper(name = "flashcards")
    @XmlElement(name = "flashcard")
	private List<FlashCardDTO> flashcards;
	
	public StackDTO getStack() {
		return stack;
	}
	public void setStack(StackDTO stack) {
		this.stack = stack;
	}
	public List<FlashCardDTO> getFlashcards() {
		return flashcards;
	}
	public void setFlashcards(List<FlashCardDTO> flashcards) {
		this.flashcards = flashcards;
	}
	
}
