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
		String filePath = System.getProperty("user.dir");//reads the program/s file path
		Date today = new Date();//allows for the system time to be read
		SimpleDateFormat dateTime = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");//date format that reads date and time
		SimpleDateFormat dateOnly = new SimpleDateFormat("dd-MM-yyyy"); //makes a date format that only reads the date
		Scanner input = new Scanner(System.in);//allows for inputs from the keyboard
		BufferedWriter bw = null;//declares a buffered writer for log writing
		FileWriter fw = null; //declares a file writer for the buffered writer to run from
		BufferedWriter errbw = null;//declares a buffered writer to write to error files
		while (start >0) { //start of the while loop enclosing the program
		// general opening text
		say("Authors: Sterling McCrevey & Mason Rhodes... \n"//us
				+ "This is the example program for the 2021 java project......");//yeah------
		System.out.println("System Time: " + dateTime.format(today));//prints the system time and date to the user 
		say("Default File Path: " + filePath); //prints the file path for the program to the user(not required)
		say("----------------------");
		//-----------------------creates a log folder and an error log folder------------------------------
		File logFolder = new File(filePath + "/logs");
		File errFolder = new File(filePath + "/errlogs");
			logFolder.mkdir();//makes the directory
			errFolder.mkdir();//makes the directory
		String errPath = filePath + "/errlogs/";
		String logPath = filePath + "/logs/";
		//----------------------only creates folders on the first time running the program---------------------
		say("Choose your desired function from the choices below.... \n"
				//Menu defining the different functions of the program...
				+ " 1. Create Credentials\n"
				+ " 2. Read/Write Existing Credentials (if you've already generated a file...)");
		String mainMenu = input.nextLine();
		//if statement for the different menu options
		
		//---------------------------------------first function of the program--------------------------------------------
			if(mainMenu.equalsIgnoreCase("1") || mainMenu.equalsIgnoreCase("new")) {
				say("Please enter a name: ");
				String seshNameVar = input.nextLine();
				//defined nameVar as the user's name 
				say("Please print your age: ");
				String ageVar = input.nextLine();
				//took an input from user and defined it again as the age...
				say("Is the entered information correct? \n"
						+ "Name: " + seshNameVar);
						say("Age: " + ageVar);
				say("Yes or no? (y/n)");
				String ch1Var = input.nextLine();
				//declaring the file naming system 
				String fileName2=seshNameVar.replace(" ","-"); //naming the file with the user's inputed name and replacing the spaces with -
				String fileName1 = dateOnly.format(today);//naming the file with the date and time
				String fileEnd = ".md";//making it a mark-up document
				//--------------------------------------
						if (ch1Var.equalsIgnoreCase("yes") || ch1Var.equalsIgnoreCase("y")) {
							try	{
								//defining the file naming system
							File newFile = new File(logPath + fileName1 + "-" + fileName2 + fileEnd);//prepares to create a file with the specified name
								if(newFile.createNewFile()) {//creates the file with the specified name
									fw = new FileWriter(newFile);//gives the file path to the file writer
									bw = new BufferedWriter(fw);//allows the buffered writer to access the file
									say("File successfully generated!");//tells the user what's up
									say("You can find the file here: " + newFile.getAbsolutePath());//prints the file path
									//writing to the generated file
									bw.write("Information: "); bw.newLine(); bw.write("Name: " + seshNameVar); bw.newLine(); bw.write("Age: " + ageVar); bw.newLine(); bw.write("Correct Info? " + ch1Var);
									bw.write("--------------------------------------------");
									bw.flush();bw.close(); //closes as flushes the file
									//done writing to the file
								}
							}catch(Exception e) {
								File errFile = new File(errPath + fileName1 + fileName2 + "-error-" + fileEnd);// making an error file
								errFile.createNewFile(); //creating the file
								FileWriter errfw = new FileWriter(errFile); //creating a file writer that allows the buffered writer to write to files
								errbw = new BufferedWriter(errfw); //creating a buffered-writer that will write to the error file
								errbw.write(e + " " + dateOnly); errbw.flush(); errbw.close(); //writing to the error file
								System.err.println("Whoops! Something went really wrong!\n"
										+ e);//prints the error message to the user 
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
									start = 0; //stops the program
								}
								else {
									
									System.err.println("Whoops! We encountered a mistake!"
											+ "Restarting the program.....");
									continue; //restarts the program
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
							say("Do you want to reload the program? (y/n)"); //asks the user if they want to reload the program
							String resetVar = input.nextLine();
								if (resetVar.equalsIgnoreCase("yes") || resetVar.equalsIgnoreCase("y")) { //takes the input and makes it a boolean
									continue;//loops
								}
								else if(resetVar.equalsIgnoreCase("no") || resetVar.equalsIgnoreCase("n")) {
									start = 0;//stops
								}
								else {
									System.err.println("Whoops! We encountered a mistake!"
											+ "Restarting the program.....");
									continue;//loops
								}
						}
			}	//--------------------------------end of first function------------------------------------------------	
			
			//------------------------------------start of second function------------------------------------------------
			else if (mainMenu.equalsIgnoreCase("2") || mainMenu.equalsIgnoreCase("write") || mainMenu.equalsIgnoreCase("read")) { //takes the input and makes it a boolean
					//second program capability that reads and writes to files!!!!
				say("Please enter the name used while creating the file: ");
				String transplantName = input.nextLine();
			}

				
		}//end of the while loop
	}//end of main

}//end of public class
