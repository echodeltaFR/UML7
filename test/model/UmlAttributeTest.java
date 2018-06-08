package model;
import org.junit.*;
import org.junit.rules.*;

import model.Modifier;
import model.PrimitiveType;
import model.UmlAttribute;
import model.Visibility;

import static org.junit.Assert.*;
import java.util.Set;
import java.util.HashSet;

/**
 * Test class for {@link UmlAttribute}
 * @author echodeltaFR
 * @version 1.1
 */
public class UmlAttributeTest {

    // A test attribute
    private UmlAttribute attrTest1;
    private UmlAttribute attrTest2;
    private UmlAttribute attrTest3;
    private Set<Modifier> modifiers;

    @Before public void setUp() {
        modifiers = new HashSet<Modifier>();
        modifiers.add(Modifier.FINAL);
        attrTest1 = new UmlAttribute("Attribute1", PrimitiveType.INT);
        attrTest2 = new UmlAttribute("Attribute2", PrimitiveType.LONG, null, null);
        attrTest3 = new UmlAttribute("Attribute3", PrimitiveType.STRING, Visibility.PRIVATE, modifiers);

    }

    @Test public void testConstructor1() {
        assertEquals("Check the name", "Attribute1", attrTest1.getName());
        assertEquals("Check the type", PrimitiveType.INT, attrTest1.getType());
        assertEquals("Check the visibility", Visibility.PUBLIC, attrTest1.getVisibility());
        assertTrue("Check the modifiers", attrTest1.getModifier().isEmpty());
    }

    @Test public void testConstructor2() {
        assertEquals("Check the name", "Attribute2", attrTest2.getName());
        assertEquals("Check the type", PrimitiveType.LONG, attrTest2.getType());
        assertEquals("Check the visibility", Visibility.PUBLIC, attrTest2.getVisibility());
        assertTrue("Check the modifiers", attrTest1.getModifier().isEmpty());
    }

    @Test public void testConstructor3() {
        assertEquals("Check the name", "Attribute3", attrTest3.getName());
        assertEquals("Check the type", PrimitiveType.STRING, attrTest3.getType());
        assertEquals("Check the visibility", Visibility.PRIVATE, attrTest3.getVisibility());
        assertTrue("Check the modifiers", modifiers.equals(attrTest3.getModifier()));
    }

    @Test public void testSetName() {
        attrTest3.setName("Attribute33");
        assertEquals("Check name setter", "Attribute33", attrTest3.getName());
    }

    @Test public void testSetType() {
        attrTest3.setType(PrimitiveType.LONG);
        assertEquals("Check type setter", PrimitiveType.LONG, attrTest3.getType());
    }
}
