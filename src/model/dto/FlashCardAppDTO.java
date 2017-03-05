package model.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="flashcardapp")
public class FlashCardAppDTO {
	@XmlElement(name="item_count") 
	private Long itemCount = 0l;
	@XmlElement(name="stack_with_flashcards")
	private List<StackWithFlashCardsDTO> stackWithFlashCards;
	
	public List<StackWithFlashCardsDTO> getStackWithFlashCards() {
		return stackWithFlashCards;
	}
	public void setStackWithFlashCards(List<StackWithFlashCardsDTO> stackWithFlashCards) {
		this.stackWithFlashCards = stackWithFlashCards;
	}
	public Long getItemCount() {
		return itemCount;
	}
	public void setItemCount(Long itemCount) {
		this.itemCount = itemCount;
	}
	
}