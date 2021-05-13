/*
 * Author: Dan Stoakes
 * Purpose: Performs regex operations on input lines from a source-code file.
 * Date: 10/05/2020
*/

/*
 * The main CommentParser class
 * Contains all the methods for performing regex operations on input strings. 
 */
public class CommentParser
{
	private int lastIndex;
	
	private String symbol = "//";
	
	/**
	 * Gets the last found one-line comment index
	 * @return The last found index of the one-line comment symbol
	 */
	public int getLastIndex ()
	{
		return (lastIndex + symbol.length());
	}
	
	/**
	 * Determines whether a line contains the one-line comment symbol
	 * @param line The line of code to process
	 * @return Whether the symbol is within the comment line
	 */
	public boolean hasSymbol (String line)
	{
		return line.matches(".*(;|\\s|\\))//.*");
	}
	
	/**
	 * Determines whether a line contains duplicated one-line comment symbols
	 * @param line The line of code to process
	 * @return Whether the symbol is duplicated within the comment line
	 */
	public boolean hasDuplicatedSymbol (String line)
	{
		lastIndex = 0;
		
		int count = 0;
		for (int i = 0; i < line.length(); i++)
		{
			int j = line.indexOf(symbol);
			if (j != -1)
			{
				lastIndex += j;
				count = count + 1;
				line = line.substring(j + symbol.length());
			}
		}
		return (count > 1);
	}
	
	/**
	 * Determines whether a line contains the multi-line start comment symbol
	 * @param line The line of code to process
	 * @return Whether the symbol is within the comment line
	 */
	public boolean hasStartSymbol (String line)
	{
		return line.matches(".*(;|\\s|\\)|^)/\\*.*");
	}
	
	/**
	 * Replaces the contents following the multi-line start comment symbol
	 * @param line The line of code to process
	 * @return The line stripped of comment text
	 */
	public String replaceStartSymbol (String line)
	{
		return line.replaceAll("/\\*.*", "");
	}
	
	/**
	 * Determines whether a line contains the multi-line end comment symbol
	 * @param line The line of code to process
	 * @return Whether the symbol is within the comment line
	 */
	public boolean hasEndSymbol (String line)
	{
		return line.matches(".*\\*/(\\s|$).*");
	}
	
	/**
	 * Replaces the contents preceding the multi-line end comment symbol
	 * @param line The line of code to process
	 * @return The line stripped of comment text
	 */
	public String replaceEndSymbol (String line)
	{
		return line.replaceAll("\\*/", "");
	}
	
	/**
	 * Determines whether a multi-line comment spans a single line
	 * @param line The line of code to process
	 * @return Whether the multi-line symbol is on a single line
	 */
	public boolean isSingleLine (String line)
	{
		return line.matches(".*(/\\*.*\\*/).*");
	}
}