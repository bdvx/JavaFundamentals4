package xml.jaxb;

import org.junit.Before;
import org.junit.Test;
import xml.Food;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class JaxbDemoTest {

    private Food food;
    private JaxbDemo<Food> foodJaxbDemo;
    private File file = new File("src/test/resources/food.xml");

    @Before
    public void setUp() throws Exception {
        food = new Food()
                .id(123)
                .name("nnn")
                .description("ddd")
                .calories(234)
                .price("333");
        foodJaxbDemo = JaxbDemo.from(Food.class);
    }

    @Test
    public void marshal() throws Exception {
        foodJaxbDemo.marshal(food, file);
        assertEquals(food, foodJaxbDemo.unmarshal(file));
    }

}