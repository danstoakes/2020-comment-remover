public class Test_Simple
{
	public static void main (String[] args)
	{
		
		System.out.println("// This is a bait comment");
		System.out.println("//This//is//also//bait");
		
		System.out.println("/* Bait comment 1 */"); 
		System.out.println("/*Bait comment 1a*/");
		System.out.println("/* Bait comment 2");
		System.out.println("Bait comment 3 */");
		
		System.out.println("Test1"); 
		
		System.out.println("Test2"); 
		 System.out.println("What in the heck is going on");
		
		System.out.println("This is a comment"); 
		System.out.println("This is another comment");
		System.out.println("This is a different comment");
		
		
		System.out.println("This is a oneline comment"); 
		System.out.println("This is another oneline comment");
		System.out.println("This is a different oneline comment");
		
		String applesOriginal = "thing//";
		String apples = "thing*/";
		
		if (apples.contains("/*"))
		{
			System.out.println("Done");
		}
		
		if (applesOriginal.contains("//")) 
		{ 
			System.out.println("Done");
		}
	}
	
	public boolean isWorking ()
	{
		return false;
	}
	
	public boolean isNotWorking ()
	{
		return true;
	}
}
