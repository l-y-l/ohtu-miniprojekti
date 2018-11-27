
package app.utilities;

import java.util.Collection;
import java.util.List;


/**
 * 
 * Class containing general static helper methods and constants.
 * 
 */
public class Utilities {
    public static String DEPLOYMENT_DATABASE = "hibernate.cfg.xml";
    public static String TEST_DATABASE = "test.cfg.xml"; 
    
    
    /**
     * 
     * Creates a comma-separated string that contains representations of the collection
     * 
     * @param coll Collection to be converted into one string
     * @return String representations of the collection in one string.
     */
    public static String formStringSeparatedByCommas(Collection coll){
        String result = "";
        
        if(coll == null || coll.isEmpty()){
            return result; 
        }
        
        for(Object o: coll){
            result += o.toString() + ", ";
        }
        
        return result.substring(0, result.length() - 2); 
    }
    
    

    
}
