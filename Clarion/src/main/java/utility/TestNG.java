package utility;

import org.testng.annotations.DataProvider;

public class TestNG 
{
	private static JavaHelpers Read1 = new JavaHelpers();

	
	//Boat-Ed
	
		//RegistrationTest - Test 1
		@DataProvider(name ="Registration")
		public static Object[][] Registration() throws Exception
			{
			        Object[][] retObjArr=
			        		Read1.GetTableArray(Constants.TestDataFileLocation, "BoatEd","Registration");
			        // Excel File must be of Word 97-2003 format as jxl support that only
			        return(retObjArr);
			}
		
	
			
}
