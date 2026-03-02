package TestPackage;

import java.util.Arrays;

import org.testng.annotations.DataProvider;

public class HomeData {
	
	@DataProvider(name = "LinkName")
	public Object[][] getLinkName() {
		return new Object[][] { { "Register" }, { "Sign in" } };
	}
	
	@DataProvider(name = "OptionName") 
		public Object[] getOptionName() {
		return new Object[] {Arrays.asList ("Arrays", "Linked List", "Stack", "Queue", "Tree", "Graph") };	
	}
	
	@DataProvider(name = "OptionsWithoutSignIn")
	public Object[][] getOptionsWithoutSignIn() {
		return new Object[][] { { "Arrays" }, { "Linked List" }, { "Stack" }, { "Queue" }, { "Tree" }, { "Graph" } };
	}
	
	@DataProvider(name = "TabNameWithoutSignIn")
	public Object[][] getTanNameWithoutSignIn() {
		return new Object[][] { { "Array" }, { "Linked List" }, { "Stack" }, { "Queue" }, { "Tree" }, { "Graph" }, { "Data Structures-Introduction" }};
	}
	
	@DataProvider(name = "HomeLinkText")
	public Object[][] getHomeLinkText() {
		return new Object[][] { { "ValidUser" }, { "Sign out" } };
	}
	
	@DataProvider(name = "HomeOptionsWithSignin")
	public Object[][] getHomeOptionsWithSignin() {
		return new Object[][] { { "Arrays", "Array" }, { "Linked List", "Linked List" }, { "Stack", "Stack" }, { "Queue", "Queue" }, { "Tree", "Tree" }, 
			{ "Graph", "Graph" } };
	}
	
	@DataProvider(name = "TabNameWithSignin")
	public Object[][] getTabNameWithSignin() {
		return new Object[][] { { "Array", "Array" }, { "Linked List", "Linked List" }, { "Stack", "Stack" }, { "Queue", "Queue" }, { "Tree", "Tree" }, 
			{ "Graph", "Graph" }, { "Data Structures-Introduction", "Data Structures-Introduction" } };
	}


}
