import org.junit.*;
import org.junit.rules.*;

import model.Modifier;
import model.PrimitiveType;
import model.UmlMethod;
import model.UmlParams;
import model.Visibility;
import java.util.Set;
import java.util.HashSet;

import static org.junit.Assert.*;

/**
 * Test class for {@link UmlMethod}
 * @author echodeltaFR
 * @version 1.0
 */
public class UmlMethodTest {

    private UmlMethod methodTest1;
    private UmlMethod methodTest2;
    private UmlMethod methodTest3;
    private UmlParams paramTest1;
    private UmlParams paramTest2;
    private Set<UmlParams> params;
    private Set<Modifier> modifiers;

    @Before public void setUp() {
        paramTest1 = new UmlParams(PrimitiveType.INT, "Paramètre 1");
        paramTest2 = new UmlParams(PrimitiveType.BOOLEAN, "Paramètre 2");
        params = new HashSet<UmlParams>(paramTest1, paramTest2);
        modifiers = new HashSet<Modifier>(Modifier.ABSTRACT);
        methodTest1 = new UmlMethod("MethodTest1");
        methodTest2 = new UmlMethod("MethodTest2", null, null, null, null);
        methodTest3 = new UmlMethod("MethodTest3", params, PrimitiveType.INT, Visibility.PRIVATE, modifiers);
    }

    @Test public void testConstructor1() {
        assertEquals("Check the name", "MethodTest1", methodTest1.getName());
        assertTrue("Check the params", methodTest1.getParams().isEmpty());
        assertEquals("Check the return type", null, methodTest1.getReturnType());
        assertEquals("Check the visibility", Visibility.PUBLIC, methodTest1.getVisibility());
        assertTrue("Check the modifiers", modifiers.equals(methodTest1.getModifier()));
    }

    @Test public void testConstructor2() {
        assertEquals("Check the name", "MethodTest2", methodTest2.getName());
        assertTrue("Check the params", methodTest2.getParams().isEmpty());
        assertEquals("Check the return type", null, methodTest2.getReturnType());
        assertEquals("Check the visibility", Visibility.PUBLIC, methodTest2.getVisibility());
        assertTrue("Check the modifiers", modifiers.equals(methodTest2.getModifier()));
    }

    @Test public void testConstructor3() {
        assertEquals("Check the name", "MethodTest3", methodTest3.getName());
        assertTrue("Check the params", params.equals(methodTest3.getParams()));
        assertEquals("Check the return type", PrimitiveType.INT, methodTest3.getReturnType());
        assertEquals("Check the visibility", Visibility.PRIVATE, methodTest3.getVisibility());
        assertTrue("Check the modifiers", modifiers.equals(methodTest2.getModifier()));
    }

    @Test public void testSetName() {
        methodTest3.setName("MethodTest33");
        assertEquals("Check the name", "MethodTest33", methodTest3.getName());
    }

    @Test public void testReturnType() {
        methodTest3.setReturnType(PrimitiveType.LONG);
        assertEquals("Check the return type", PrimitiveType.LONG, methodTest3.getReturnType());
    }

}
