public class Test_Simple
{
	/**
	* Test JavaDoc comment
	*
	*/
	public static void main (String[] args)
	{
		/*
		* Multiline comment with asterisks generated
		*
		*/
		
		System.out.println("// This is a bait comment");
		System.out.println("//This//is//also//bait");
		
		System.out.println("/* Bait comment 1 */"); // Test appended
		System.out.println("/*Bait comment 1a*/");
		System.out.println("/* Bait comment 2");
		System.out.println("Bait comment 3 */");
		
		System.out.println("Test1"); /*
		* Hmmmm
		*/
		
		System.out.println("Test2"); /*
		* Hmmmm
		*/ System.out.println("What in the heck is going on");
		
		System.out.println("This is a comment"); /* Single line multiline */
		System.out.println("This is another comment");
		System.out.println("This is a different comment");
		
		// This is a regular spaced test comment.
		//This is an irregular spaced test comment.
		
		System.out.println("This is a oneline comment"); // Spaced comment
		System.out.println("This is another oneline comment");// Irregular spaced comment
		System.out.println("This is a different oneline comment");//Irregular irregular
		
		String applesOriginal = "thing//";
		String apples = "thing*/";
		
		if (apples.contains("/*"))
		{
			System.out.println("Done");
		}
		
		if (applesOriginal.contains("//")) // bait comment
		{ // test comment
			System.out.println("Done");
		}
	}
	
	/*
	Test multiline comment with no asterisks generated
	*/
	public boolean isWorking ()
	{
		return false;
	}
	
	/* Test single line multiline */ // final ultimate test
	public boolean isNotWorking ()
	{
		return true;
	}
}