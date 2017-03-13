package abs.model;

import java.util.Arrays;
import java.util.Scanner;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import java.nio.file.*;
import java.io.*;

import abs.model.interfaces.*;

public class AbsFileOps implements AbsSystem {
	
	private String filePath;
	private String fileName;
	
	public AbsFileOps(String filePath, String fileName){
		
		this.filePath = filePath;
		this.fileName = fileName;
		
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public void createFile() {
		
		System.out.println("A file is about to be created!");
		
		String path = this.getFilePath() + this.getFileName() + ".txt";
		
		Path file = Paths.get(path);
		
		try(BufferedWriter writer = Files.newBufferedWriter(file)) {
				writer.write("");
		}
		catch (IOException x)
		{
			System.err.println("Create fucked up man.");
		}
	}
	
	public void writeToFile() {
		
		String path = this.getFilePath() + this.getFileName() + ".txt";
	
		String input;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("You are about to type into file!");
		System.out.println("Type 'end' to end the session!");
		
		Boolean end = false;
		while(end == false)
		{
			try(FileWriter writer = new FileWriter(path, true))
			{
				input = scanner.nextLine();
				if(input.equals("end"))
				{
					end = true;
				}
				else
				{
					writer.write(input + System.lineSeparator());
				}
			}
			catch(IOException e)
			{
				System.err.println("Write fucked up splendidly.");
			}
		}
	}
	
	public void readFromFile(){
		
		String path = this.getFilePath() + this.getFileName() + ".txt";
		Path file = Paths.get(path);
		
		try(BufferedReader reader = Files.newBufferedReader(file)){
			String line = null;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		}
		catch(IOException e)
		{
			System.err.println("How come reading can fuck up?");
		}
	}
	
	public void readFromOwner(){
		
		String path = this.getFilePath() + this.getFileName() +  ".txt";
		Path file = Paths.get(path);
		
		try(BufferedReader reader = Files.newBufferedReader(file)){
			String line = null;
			line = reader.readLine();
			String[] data = line.split("\\,\\ "); 
			System.out.println(Arrays.toString(data));
		}
		catch(IOException e)
		{
			System.err.println("HAH IT FUCKED UP!");
		}
	}
}
