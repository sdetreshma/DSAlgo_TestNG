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
	
	@DataProvider(name = "TabName")
	public Object[][] getTabName() {
		return new Object[][] { { "Array" }, { "Linked List" }, { "Stack" }, { "Queue" }, { "Tree" }, { "Graph" }, { "Data Structures-Introduction" }};
	}
	
	@DataProvider(name = "HomeOptionsWithSignin")
	public Object[][] getHomeOptionsWithSignin() {
		return new Object[][] { { "Arrays", "Array" }, { "Linked List", "Linked List" }, { "Stack", "Stack" }, { "Queue", "Queue" }, { "Tree", "Tree" }, 
			{ "Graph", "Graph" } };
	}
	

}
