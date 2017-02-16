package xml.sax;

import org.junit.Test;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import xml.Food;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static xml.Tests.RESOURCES_FILE_PATH;

public class MenuSaxHandlerTest {
    @Test
    public void getFoodList() throws Exception {
        XMLReader reader = XMLReaderFactory.createXMLReader();
        MenuSaxHandler handler = new MenuSaxHandler();
        reader.setContentHandler(handler);
        reader.parse(new InputSource(RESOURCES_FILE_PATH + "menu.xml"));

        List<Food> foodList = handler.getFoodList();
        assertTrue(foodList
                .contains(
                        new Food()
                                .id(1)
                                .name("Belgian Waffles")
                                .price("$5.95")
                                .description("two of our famous Belgian Waffles with plenty of real maple syrup")
                                .calories(650)));
    }
}