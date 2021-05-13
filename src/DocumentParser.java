/*
 * Author: Dan Stoakes
 * Purpose: Creates a java source code file that has been stripped of comments.
 * Date: 10/05/2020
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DocumentParser
{
	public static void main (String[] args)
	{
		// Ensure that the input and output directories are specified.
		if (args.length != 2)
		{
			System.out.println("Usage: DocumentParser.java input_folder output_folder");
			return;
		}
		// Get the command-line arguments as input and output path variables.
		String path = args[0];
		String outputFilePath = args[1];
		// Get the input and output directory paths as File objects
		File inputDirectory = new File(path);
		File outputDirectory = new File(outputFilePath);
		// Calculate index of first full stop to see if there is an extension.
		int index = outputDirectory.toString().lastIndexOf('.');
		// Check if the output path is a directory and if it exists
		if (index == -1 && !outputDirectory.exists())
			outputDirectory.mkdir();
		// Ensure that the input and output paths are directories.
		if (!inputDirectory.isDirectory() || !outputDirectory.isDirectory())
		{
			System.out.println("The input and output arguments need to be directories.");
			return;
		}
		// Assign the files to an array.
		File[] files = inputDirectory.listFiles();
		// Ensure that there is at least one file to use.
		if (files.length == 0)
		{
			System.out.println("The input argument does not point to a valid folder.");
			return;
		}
		// Loop through each file in the input directory.
		for (File file : files)
		{
			try
			{
				// Set up an input reader and output writer for the files.
				BufferedReader reader = new BufferedReader(new FileReader(file));
				BufferedWriter writer = new BufferedWriter(new FileWriter(
						outputDirectory + "\\Commentless_" + file.getName()));
				// Instantiate the CommentParser class.
				CommentParser parser = new CommentParser ();
				
				String line = "";
				boolean block = false;
				// Loop through the input reader until the end of the file.
				while ((line = reader.readLine()) != null)
				{
					int length = line.trim().length();
					// If the line from the input file has a single-line comment.
					if (parser.hasSymbol(line))
					{
						// Check if the line contains multiple comment symbols.
						if (parser.hasDuplicatedSymbol(line))
						{
							line = line.substring(0, parser.getLastIndex());
						} else
						{
							// Remove a standard single-line comment.
							line = line.replaceAll("//.*", "");
						}
					} 
					// If the line from the input file has a multi-line comment.
					if (parser.hasStartSymbol(line))
					{
						// If not a single line comment with multi-line notation.
						// Set block to true to prepare for multi-line deletion.
						if (!parser.isSingleLine(line))
							block = true;
						// Remove the multi-line comment start symbol.
						line = parser.replaceStartSymbol(line);
					} else if (parser.hasEndSymbol(line))
					{
						// Remove the multi-line comment end symbol.
						line = parser.replaceEndSymbol(line);
						block = false;
					} else
					{
						// Remove the multi-line comment content.
						if (block)
							line = "";
					}
					// Write the uncommented code to the output file if not null.
					if (line.trim().length() != 0 || length == 0)
						writer.write(line + "\n");
				}
				writer.flush();
				writer.close();
				reader.close();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		System.out.println("Uncommented files saved to: " + outputFilePath);
	}
}