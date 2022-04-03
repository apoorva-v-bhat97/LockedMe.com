import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileOps {
	static final String PATH="Y:\\simplilearn\\FileOps\\";
    static Scanner sc=new Scanner(System.in);

	public static void main(String[] args) {
		 System.out.println("WELCOME to LockedMe.com");
		 System.out.println("Project Name : LockedMe.com, Developer : Apoorva Bhat");

		 try {
		//Enter main context..
		while(true) {
			System.out.println("Please Enter Your Choice :: \n 1. DISPLAY_FILES 2. DO_FILE_OPS 3. EXIT");
			int mainContext=sc.nextInt();
			switch(mainContext) {
			case 1:
				System.out.println("Selected Option: DISPLAY_FILES");
				System.out.println("Fetching the files in the inventoy..");
				
				File f = new File(PATH);
				ArrayList <String> filesInDirectory = new ArrayList<String>();
				//since listFiles does't guarantee listing in alphabetical order, sort manually.
				File listOfFiles[]=f.listFiles();
				for(File file : listOfFiles) {
					filesInDirectory.add(file.getName());
				}
				filesInDirectory.sort(null);
				System.out.println("Printing the files in the inventoy..");
				for (String fileName : filesInDirectory) {
					System.out.println(fileName);
				}
				
			break;
			case 2:
				System.out.println("Selected Option: DO_FILE_OPS");
				PerformFileOps();
				break;
			case 3:
				System.exit(0);
			break;
			default:
				System.out.println("Invalid option entered!! Please select between 1 to 3");
			break;
			}
		}
		 }catch (Exception e){
				System.err.println("Encountered exception");
				e.printStackTrace();
		 }
		 finally {
			 sc.close();
		 }
	}

public static void PerformFileOps() {
		//allow user to perform File operation
	     Boolean endlessLoop = true;
		while(endlessLoop) {
			System.out.println("Please Enter Your Choice :: \n 1. ADD_FILE 2. DELETE_FILE 3. SEARCH_FILE 4. EXIT");
			int subContext=sc.nextInt();
			switch(subContext) {
			case 1:
				System.out.println("Selected Option: ADD_FILE");
				try {
					System.out.println("Enter the file name");
					String fileName=sc.next();
					File f = new File(PATH.concat(fileName));	
					boolean res = f.createNewFile();
					if(res) {
						System.out.println("File " + fileName + " Created successfully..");
					}
					else {
						System.err.println("File name " + fileName + " already exists. Couldnt create the file..");
						System.err.println("\n");
					}
				} catch (IOException e){
					System.err.println("Encountered IO exception");
					e.printStackTrace();
				}
			break;
			case 2:
				System.out.println("Selected Option:DELETE_FILE");
				try {
					System.out.println("Enter the file name to be delete from inventory");
					String fileName=sc.next();
					boolean res = false;
					File f = new File(PATH);
					File listOfFiles[]=f.listFiles();
					for(File file : listOfFiles) {
						if(fileName.equals(file.getName())) {
							f = file;
							res = f.delete();
							break;
						}
					}
					if(res)
							System.out.println("File " + fileName + " deleted successfully..");
					else {
							System.err.println("Couldnt delete the file.. Check if File " + fileName + " exists..");
							System.err.println("\n"); }

				} catch (Exception e){
					System.err.println("Encountered exception");
					e.printStackTrace();
				}
				break;
				
			case 3:
				System.out.println("Selected Option:SEARCH_FILE");
				try {
				System.out.println("Enter the file name to search in inventory");
				String fileName = sc.next();
				File f = new File(PATH);

				File listOfFiles[]=f.listFiles();
				boolean isFound = false;
				File searchedFile = null;
				for(File file : listOfFiles) {
					if(file.getName().equals(fileName)) {
						isFound = true;
						searchedFile = file;
						break;
					}
				}
				
				if(isFound) {
					System.out.println("File found, File Details : " + searchedFile.toString());
				}
				else {
					System.err.println("File is not found");
				}
				} catch (Exception e) {
					System.err.println("Encountered exception");
					e.printStackTrace();
				}

				
			break;
			case 4:
				System.out.println("Going Back to Main context..");
				endlessLoop=false;			
				break;
			default:
				System.out.println("Invalid option entered!! Please select between 1 to 4");
			break;
			}
		}
		
	}
}



