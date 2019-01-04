import static org.junit.Assert.assertEquals;

import java.io.BufferedWriter;
import java.io.File;

import java.io.FileWriter;
import java.io.IOException;
import static org.hamcrest.CoreMatchers.*;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class UnitTesting {
	
	
	    
	   
	   @Rule
	   public TemporaryFolder tempFolder = new TemporaryFolder();//will be deleted after test finishes
	   
	   @Test
	   public void test_addDigitsFromFile() throws IOException {
		    SumDigitsOfString myUnit = new SumDigitsOfString();		  
	        final File tempFile = tempFolder.newFile("tempFile.txt");//create file
	        FileWriter fileWriter = new FileWriter(tempFile.getAbsolutePath());
	        fileWriter.write("abc34");//Write to file
	        fileWriter.close();
	        Assert.assertEquals(7, myUnit.addDigitsFromFile(tempFile.getAbsolutePath()));//check the sum of digits
	   }

	    
	    
	    
	    @Test
	    public void test_addDigits_Default() {
	    	SumDigitsOfString myUnit = new SumDigitsOfString();
	        long result = myUnit.addDigits_Default("ab2c1");
	        assertEquals(3, result);
	        result=myUnit.addDigits_Default("pq"); //If no digits then answer must be 0
	        assertEquals(0, result);
	    }
	    
	    
	    
	    @Test
	    public void test_addHexDigits() {
	    	SumDigitsOfString myUnit = new SumDigitsOfString();

	        long result = myUnit.addHexDigits("abc123");

	        assertEquals(39, result);
	         result = myUnit.addHexDigits("xyz");//If no hexadecimal characters then answer must be 0
	         assertEquals(0, result);

	    }
	
	
	
}
