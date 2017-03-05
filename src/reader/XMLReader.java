package reader;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import model.dto.FlashCardAppDTO;

public class XMLReader {
	public static FlashCardAppDTO resolveFile(String filePath) throws Exception {
		JAXBContext jc = JAXBContext.newInstance(FlashCardAppDTO.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        File xml = new File(filePath);
        FlashCardAppDTO flashCardAppDTO = (FlashCardAppDTO) unmarshaller.unmarshal(xml);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "ISO-8859-1");
        marshaller.marshal(flashCardAppDTO, System.out);
        return flashCardAppDTO;
	}
}
