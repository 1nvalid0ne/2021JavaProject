import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
//this is an input handler and manager that can record user input
	public static void say (String s) {
		System.out.println(s);
		//creating a macro called say for the command above
	}
	public static void main(String[] args) throws IOException {
		int start = 1;
		//establishing functions
		String filePath = System.getProperty("user.dir");
		Date today = new Date();
		SimpleDateFormat dateTime = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		SimpleDateFormat dateOnly = new SimpleDateFormat("dd-MM-yyyy");
		Scanner input = new Scanner(System.in);
		while (start >0) { //start of the while loop enclosing the program
		// general opening text
		say("Authors: Sterling McCrevey & Mason Rhodes... \n"
				+ "This is the example program for the 2021 java project......");
		System.out.println("System Time: " + dateTime.format(today));
		say("Default File Path: " + filePath);
		say("----------------------");
		//-----------------------creates a log folder and an error log folder------------------------------
		File logFolder = new File(filePath + "/logs");
		File errFolder = new File(filePath + "/errlogs");
			logFolder.mkdir();
			errFolder.mkdir();
		String errPath = filePath + "/errlogs/";
		String logPath = filePath + "/logs/";
		//----------------------only creates folders on the first time running the program---------------------
		say("Choose your desired function from the choices below.... \n"
				//Menu defining the different functions of the program...
				+ " 1. Create Credentials\n"
				+ " 2. Read/Write Existing Credentials (if you've already generated a file...)");
		String mainMenu = input.nextLine();
		//if statement for the different menu options
			if(mainMenu.equalsIgnoreCase("1") || mainMenu.equalsIgnoreCase("new")) {
				say("Please enter a name: ");
				String nameVar = input.nextLine();
				//defined nameVar as the user's name 
				say("Please print your age: ");
				String ageVar = input.nextLine();
				//took an input from user and defined it again as the age...
				say("Is the entered information correct? \n"
						+ "Name: " + nameVar);
						say("Age: " + ageVar);
						String fileName2=nameVar.replace(" ","-"); //naming the file with the user's inputed name and replacing the spaces with -
						String fileName1 = dateOnly.format(today);//naming the file with the date and time
						String fileEnd = ".md";//making it a mark-up document
				say("Yes or no? (y/n)");
				String ch1Var = input.nextLine();
						if (ch1Var.equalsIgnoreCase("yes") || ch1Var.equalsIgnoreCase("y")) {
							try	{
								//defining the file naming system
							File newFile = new File(logPath + fileName1 + "-" + fileName2 + fileEnd);//prepares to create a file with the specified name
								if(newFile.createNewFile()) {
									say("File successfully generated!");
									say("You can find the file here: " + newFile.getAbsolutePath());
								}
							}catch(Exception e) {
								File errFile = new File(errPath + fileName1 + fileName2 + "-error-" + fileEnd);// making an error file
								errFile.createNewFile();
								System.err.println("Whoops! Something went really wrong!\n"
										+ e);
								say(" The error above was printed in the file path below: \n"
										+ errPath);
							}
							//created a reset choice for the user to restart the program
							say("Do you want to reload the program? (y/n)");
							String resetVar = input.nextLine();
								if (resetVar.equalsIgnoreCase("yes") || resetVar.equalsIgnoreCase("y")) {
									continue;//loops the whole program
								}
								else if(resetVar.equalsIgnoreCase("no") || resetVar.equalsIgnoreCase("n")) {
									start = 0;
								}
								else {
									
									System.err.println("Whoops! We encountered a mistake!"
											+ "Restarting the program.....");
									continue;
								}
						}
						else if (ch1Var.equalsIgnoreCase("no") || ch1Var.equalsIgnoreCase("n")){
							say("no");
							//reload the program so the user can re-enter data.
							say("Reloading the program....\n"
									+ " \n"
									+ "_____________");
								continue;
								
						}
						else
						{
							System.err.println("Whoops");
							say("Something went wrong!");
							//created a reset choice for the user to restart the program
							say("Do you want to reload the program? (y/n)");
							String resetVar = input.nextLine();
								if (resetVar.equalsIgnoreCase("yes") || resetVar.equalsIgnoreCase("y")) {
									continue;
								}
								else if(resetVar.equalsIgnoreCase("no") || resetVar.equalsIgnoreCase("n")) {
									start = 0;
								}
								else {
									System.err.println("Whoops! We encountered a mistake!"
											+ "Restarting the program.....");
									continue;
								}
						}
			}
			else if (mainMenu.equalsIgnoreCase("2") || mainMenu.equalsIgnoreCase("write") || mainMenu.equalsIgnoreCase("read")) {
				
			}

				
		}//end of the while loop
	}//end of main

}//end of public class
