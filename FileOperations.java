package com;
import java.io.IOException;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.Scanner;



public class FileOperations {
	public static void ShowMenu() {
		String menu = "\n --- Select any option number from below and press Enter --\n"
				+ "1) Get all files of \"main\" folder\n" + "2) Menu for File operations\n"
				+ "3) Exit program\n";
		System.out.println(menu);

	}

	public static void FileMenuOperations() {
		String fileMenu = "\n\n-----Select any option number from below and press Enter -----\n\n"
				+ "1) Add a file to \"main\" folder\n" + "2) Delete a file from \"main\" folder\n"
				+ "3) Search for a file from \"main\" folder\n" + "4) Show Previous Menu\n" + "5) Exit program\n";

		System.out.println(fileMenu);
	}
	
	public static void ShowAllFiles(String path) {
		System.out.println("The files with directory structure in ascending order\n");	
		listFilesInDirectory(path, 0, new ArrayList<String>());	
	}
	
	public static List<String> listFilesInDirectory(String path, int Count, List<String> fileList) {
		File dirctr = new File(path);
		File[] files = dirctr.listFiles();
		List<File> filesList = Arrays.asList(files);

		Collections.sort(filesList);

		if (files != null && files.length > 0) {
			for (File file : filesList) {

				System.out.print(" ".repeat(Count * 2));

				if (file.isDirectory()) {
					System.out.println("`** " + file.getName());

					// Recursively indent and display the files
					fileList.add(file.getName());
					listFilesInDirectory(file.getAbsolutePath(), Count + 1, fileList);
				} else {
					System.out.println("|** " + file.getName()+"**|");
					fileList.add(file.getName());
				}
			}
		} else {
			System.out.print(" ".repeat(Count * 2));
			System.out.println("|** Empty Directory **|");
		}
		System.out.println();
		return fileList;
	}
	
	public static void createFile(String fAdd, Scanner sc) {
		Path filePath = Paths.get("./main/" + fAdd);
		try {
			Files.createDirectories(filePath.getParent());
			Files.createFile(filePath);
			System.out.println(fAdd + " created successfully");

			System.out.println("Would you like to add some content to the file? (Y/N)");
			String choice = sc.next().toLowerCase();

			sc.nextLine();
			if (choice.equals("y")) {
				System.out.println("\n\nInput content and press enter\n");
				String content = sc.nextLine();
				Files.write(filePath, content.getBytes());
				System.out.println("\nContent written to file " + fAdd);
				System.out.println("Content can be read using Notepad or Notepad++");
			}
			else
			{
				FileMenuOperations();
			}
			

		} catch (IOException e) {
			System.out.println(" "
					+ "File creation failed " + fAdd);
			System.out.println(e.getClass().getName());
		}
	}
	
	
	//Method to Search file location
	
	public static List<String> FileLocation(String fName, String path) {
		List<String> fileList = new ArrayList<>();
		searchFile(path, fName, fileList);

		if (fileList.isEmpty()) {
			System.out.println("\n\n----No file with given file name \"" + fName + "\" ----\n\n");
		} else {
			System.out.println("\n\n Found the given file at location(s):");

			List<String> files = IntStream.range(0, fileList.size())
					.mapToObj(index -> (index + 1) + ": " + fileList.get(index)).collect(Collectors.toList());

			files.forEach(System.out::println);
		}

		return fileList;
	}
	
	//Method to delete File
	
	public static void FileDelRecursively(String path) {

		File Fdel = new File(path);
		File[] files = Fdel.listFiles();

		if (files != null && files.length > 0) {
			for (File file : files) {

				String fileName = file.getName() + " at " + file.getParent();
				if (file.isDirectory()) {
					FileDelRecursively(file.getAbsolutePath());
				}

				if (file.delete()) {
					System.out.println(fileName + " deleted successfully");
				} else {
					System.out.println("Failed to delete " + fileName);
				}
			}
		}

		String delFile = Fdel.getName() + " at " + Fdel.getParent();
		if (Fdel.delete()) {
			System.out.println(delFile + " deleted successfully");
		} else {
			System.out.println("deletion failed " + delFile);
		}
	}
	
	//Method to search for files
	
	public static void searchFile(String path, String fName, List<String> fileList) {
		File dir = new File(path);
		File[] files = dir.listFiles();
		List<File> fList = Arrays.asList(files);

		if (files != null && files.length > 0) {
			for (File file : fList) {

				if (file.getName().startsWith(fName)) {
					fileList.add(file.getAbsolutePath());
				}
				if (file.isDirectory()) {
					searchFile(file.getAbsolutePath(), fName, fileList);
				}
			}
		}
	}
	
	


}
