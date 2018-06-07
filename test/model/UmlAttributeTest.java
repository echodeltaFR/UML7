import org.junit.*;
import org.junit.rules.*;

import model.PrimitiveType;
import model.UmlAttribute;

import static org.junit.Assert.*;

/**
 * Test class for {@link UmlAttribute}
 * @author echodeltaFR
 * @version 1.0
 */
public class UmlAttributeTest {

    // A test attribute
    private UmlAttribute attrTest;

    @Before public void setUp() {
        attrTest = new UmlAttribute("Attribute", PrimitiveType.INT);
    }

    @Test public void testGetters() {
        assertEquals("Check the name", "Attribute", attrTest.getName());
        assertEquals("Check the type", PrimitiveType.INT, attrTest.getType());
    }

    @Test public void testSetters() {
        attrTest.setName("Other attribute");
        assertEquals("Check name setter", "Other Attribute", attrTest.getName());
        attrTest.setType(PrimitiveType.LONG);
        assertEquals("Check type setter", PrimitiveType.LONG, attrTest.getType());
    }
}
