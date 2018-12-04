
package app.utilities;

import static app.utilities.Utilities.formStringSeparatedByCommas;
import org.junit.Test;
import java.util.List; 
import java.util.ArrayList; 
import java.util.LinkedList;
import static org.junit.Assert.*;
import org.junit.Before;


public class UtilitiesTest {
    private List<Integer> integerList;
    
    
    public UtilitiesTest() {
    }
    
    
    @Before
    public void setUp() {
        integerList = new ArrayList(); 
        for(int i = 8; i >= 3; i--){
            integerList.add(i);
        }
        
        
    }
    
    @Test
    public  void formStringReturnsEmptyStringForNullCollection(){
        assertEquals("", formStringSeparatedByCommas(null));
    }
    
    @Test
    public void formStringReturnsEmptyStringForEmptyCollection(){
        assertEquals("", formStringSeparatedByCommas(new LinkedList()));
    }
    
    @Test
    public void formStringReturnsStringOfElementWhenCollectionHasOnlyOneElement(){
        List<String> singleElement = new LinkedList(); 
        singleElement.add("Test");
        assertEquals("Test", formStringSeparatedByCommas(singleElement));
    }
    
    @Test
    public void formStringReturnsCorrectlyWithArrayListWithMultipleElements(){
        assertEquals("8, 7, 6, 5, 4, 3", formStringSeparatedByCommas(integerList));
    }
    



    
}
