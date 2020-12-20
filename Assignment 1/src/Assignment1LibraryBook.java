import java.awt.image.BufferedImage; // Using a buffered image to get image dimensions for setXY()
import javax.imageio.ImageIO; // Using to get buffered image dimensions for setXY()
import java.io.File; // Required to read file - using for setXY/Buffered Image/ImageIO
import java.io.IOException; // Required for FileIO
import java.util.Random; // Wanted this to randomize math questions
import java.util.concurrent.TimeUnit; // User for delays

public class Assignment1LibraryBook {
	public static void main(String[] args) {
		// Declare & Initializing variables
		String playAgain = "yes";
		int[] windowXY = {800, 500};

		// Configure GTerm
		GTerm gt = new GTerm(windowXY[0], windowXY[1]);
		gt.setBackgroundColor(0, 0, 0); // Set Background Color (RGB Value) (Black)

		// Main While Loop
		while (playAgain.matches("yes|y")) {
			boolean acceptedQuest = false;
			boolean attendedClass = false;
			boolean visitedReception = false;
			boolean wentHome = false;
			boolean passedMaths = false;
			boolean visitedLibrary = false;
			boolean returnedBook = false;
			boolean gotDetention = false;
			int mathsScore = 0;
			
			
			// Start of the Game
			gt.setFontColor(74, 246, 38); // Set Font Color (RGB Value) (Terminal Green)
			gt.println("Assignment 1 - Return The Library Book!"); // Program Name
			gt.println("---------------------------------------"); // Simple Divider to look nicer
	
			String UserName = gt.getInputString("Hello, What is your name?"); // Request Users Name, store it as variable
			if (UserName.isEmpty()) {
				// UserName is Empty so they shall be NameLess
				UserName = "TheNameLess";
			}
					
			gt.addImageIcon("src/jack-book.jpg"); // Print this image to window
			gt.setXY(windowXY[0]/4, 40); // Change XY to compensate for image placement using window dimensions 
			
			gt.print("Jack: Hello "); // Print hello do not moved to next line
			gt.setFontColor(255, 255, 255); // Set Font Color (RGB Value) (White)
			gt.print(UserName); //  // Print the User input, No new line
			gt.setFontColor(74, 246, 38); // Set Font Color (RGB Value) (Terminal Green)
			gt.println(", My Name is Jack and I am pleased to meet you!");
			
			// Question 1
			gt.println("Jack: Would you be interested in doing a little favor for me? (Yes/No/Y/N)"); //Print Question to Line (So User can see a transcript of events
			String Q1_input = gt.getInputString("Would you be interested in doing a little favor for me? (Yes/No/Y/N)");
			Q1_input = Q1_input.toLowerCase(); // Convert input to lower-case
			
			gt.setFontColor(255, 255, 255); // Set Font Color (RGB Value) (White)
			if (Q1_input.equals("y")) {
				Q1_input = "yes"; // Rewrite short hand
			} else if (Q1_input.equals("n")) {
				Q1_input = "no"; // Rewrite short hand
			}
			gt.println(Q1_input); // Print the User input
			gt.println(""); // Print blank line
			gt.setFontColor(74, 246, 38); // Set Font Color (RGB Value) (Terminal Green)
			
			while(!Q1_input.matches("yes|no|y|n")) {
				// No match on required input
				
				if (Q1_input.isEmpty()) {
					// Empty Input Response
					gt.println("Hmm... Speechless Hey...");  // Print text move to new line
				} else {
					// Invalid Response
					gt.println("Huh, I dont understand!?!");  // Print text move to new line
				}
				
				gt.println("Would you be interested in doing a little favor for me? (Yes/No/Y/N)"); //Print Question to Line (So User can see a transcript of events
				Q1_input = gt.getInputString("Would you be interested in doing a little favor for me? (Yes/No/Y/N)"); 
				Q1_input = Q1_input.toLowerCase(); // Convert input to lower-case
				
				if (Q1_input.equals("y")) {
					Q1_input = "yes"; // Rewrite short hand
				} else if (Q1_input.equals("n")) {
					Q1_input = "no"; // Rewrite short hand
				}
				
				gt.setFontColor(255, 255, 255); // Set Font Color (RGB Value) (White)
				gt.println(Q1_input); // Print the User input
				gt.setFontColor(74, 246, 38); // Set Font Color (RGB Value) (Terminal Green)
			}
			
			// Action based on users input
			if (Q1_input.equals("yes")) {
				// User wants to help
				acceptedQuest = true; // Update boolean value to true
				gt.println("Great! Look I need you to go on a Quest to return this Library Book."); // Print Text Move to New Line
				gt.println("Good Luck Adventurer!"); // Print Text Move to New Line
				gt.setFontColor(255, 0, 0); // Set Font Color (RGB Value) (Red)
				gt.println("You Receive a book."); // Print Text Move to New Line
				gt.setFontColor(74, 246, 38); // Set Font Color (RGB Value) (Terminal Green)
			} else {
				acceptedQuest = false; // Update boolean value to false
				gt.println("Well that is very unfortunate indeed."); // Print Text Move to New Line
				gt.print("Farewell "); // Print hello do not moved to next line
				gt.setFontColor(255, 255, 255); // Set Font Color (RGB Value) (White)
				gt.print(UserName); //  // Print the User input, No new line
				gt.setFontColor(74, 246, 38); // Set Font Color (RGB Value) (Terminal Green)
				gt.println(", Maybe Another Time?");
			}
			// End - Question 1
			
			gt.println(""); // Blank Line
					
			// Question 2 - Destinations
			if (acceptedQuest == true) { // if the user accepted the quest do this otherwise skip it
				gt.setFontColor(204, 204, 0); // Set Font Color (RGB Value) (Yellowish) 
				gt.print("Where do you want to go? "); // Print hello do not moved to next line
				gt.setFontColor(204, 0, 204); // Set Font Color (RGB Value) (Purple)
				gt.println("[Library/Reception/Class/Home]"); // Print Text Move to New Line
				String Q2_input = gt.getInputString("Where should we go? [Library/Reception/Class/Home]");
				Q2_input = Q2_input.toLowerCase(); // Convert input to lower-case
				gt.println(Q2_input); // Print the User input
				gt.println(""); // Blank Line
				
				while (!Q2_input.matches("library|reception|class|home")) {
					// No match on required input
					gt.println("Thats not a valid travel location..");
					
					gt.setFontColor(204, 204, 0); // Set Font Color (RGB Value) (Yellowish) 
					gt.print("Where do you want to go? "); // Print hello do not moved to next line
					gt.setFontColor(204, 0, 204); // Set Font Color (RGB Value) (Purple)
					gt.println("[Library/Reception/Class/Home]"); // Print Text Move to New Line
					Q2_input = gt.getInputString("Where should we go? [Library/Reception/Class/Home]");
					Q2_input = Q2_input.toLowerCase(); // Convert input to lower-case
					gt.println(Q2_input); // Print the User input
					gt.println(""); // Blank Line
					
				}
						
				// Action tasks
				// Action Loop for bouncing back and forth between the options
				while (Q2_input.matches("library|reception|class|home")) {
		
					if (Q2_input.equals("home")) {
						gt.clear(); // Empty Window
						gt.setXY(10, 10); // reset X position and update Y position 
						
						wentHome = true; // Update Boolean value to true
						// Destination: Home
						gt.setFontColor(204, 204, 0); // Set Font Color (RGB Value) (Yellowish)
						gt.println("You go home and skip school!"); // Print Text Move to New Line
						gt.setFontColor(74, 246, 38); // Set Font Color (RGB Value) (Terminal Green)
						
						// Using a buffered image to get image dimensions for setXY() as it is
						// more accurate than guessing
						BufferedImage homeIMG = null;
						// Attempt to read image, if it fails print error
						try {
							homeIMG = ImageIO.read(new File("src/home.jpg")); // Read in file contents
							int homeIMGheight = homeIMG.getHeight(); // Get Height of Image
	
							gt.addImageIcon(homeIMG); // print buffered image to screen
							gt.setXY(10, 20 + homeIMGheight); // reset X position and update Y position
							gt.println(""); // Print blank line
							
						} catch (IOException error) { // Catch any IOerrors and store it in variable error
							gt.println("[IMAGE FILE NOT FOUND]"); // Print and move to new line
							gt.println(""); // Print blank line
						}
						break; // Break away from the while loop
						
					} else if (Q2_input.equals("reception")) {
						gt.clear(); // Empty Window
						gt.setXY(10, 10); // reset X position and update Y position
						// Destination: Reception
						visitedReception = true; // Update Boolean value to true
						gt.println("--- RECEPTION ---"); // Print Text Move to New Line
						
						// User gets detention
						gotDetention = true;
						
						// Using a buffered image to get image dimensions for setXY() as it is
						// more accurate than guessing
						BufferedImage receptionIMG = null;
						// Attempt to read image, if it fails print error
						try {
							receptionIMG = ImageIO.read(new File("src/reception.jpg")); // Read in file contents
							int receptionIMGheight = receptionIMG.getHeight(); // Get Height of Image
							
							gt.addImageIcon(receptionIMG); // print buffered image to screen
							gt.setXY(10, 20 + receptionIMGheight); // reset X position and update Y position
							gt.println(""); // Print blank line
							
						} catch (IOException error) { // Catch any IOerrors and store it in variable error
							gt.println("[IMAGE FILE NOT FOUND]"); // Print and move to new line
							gt.println(""); // Print blank line
						}
						gt.setFontColor(204, 204, 0); // Set Font Color (RGB Value) (Yellowish)
						gt.println("You enter the School Reception, The Principal glances at you."); // Print and move to new line
						gt.println(""); // Print empty line
						
						// Wait before next action
						try {
							TimeUnit.SECONDS.sleep(2); // Sleep for 2 seconds
						} catch (InterruptedException e) {
							// Auto-generated catch block
							e.printStackTrace();
						}
						gt.setFontColor(74, 246, 38); // Set Font Color (RGB Value) (Terminal Green)
						gt.print("Principal: "); // Print to Current Line
						gt.setFontColor(255, 255, 255); // Set Font Color (RGB Value) (White)
						gt.print(UserName); // Print to Current Line
						gt.setFontColor(74, 246, 38); // Set Font Color (RGB Value) (Terminal Green)
						gt.println(" Wait Right there!"); // Print and move to new line
						gt.println("Principal: I will be with you in just a moment."); // Print and move to new line
						gt.println(""); // Print empty line
						// Wait before next action
						try {
							TimeUnit.SECONDS.sleep(5); // Sleep for 5 seconds
						} catch (InterruptedException e) {
							// Auto-generated catch block
							e.printStackTrace();
						}
						gt.println("Principal: What are you doing out of class with out a hall-pass...");
						gt.println("Principal: Its Detention for you!");
						gt.setFontColor(204, 0, 204); // Set Font Color (RGB Value) (Purple)

						// Wait before next action
						try {
							TimeUnit.SECONDS.sleep(5); // Sleep for 5 seconds
						} catch (InterruptedException e) {
							// Auto-generated catch block
							e.printStackTrace();
						}
						gt.clear(); // Empty Window
						gt.setXY(10, 10); // reset X position and update Y position
						gt.println("--- DETETION ---");
						// Using a buffered image to get image dimensions for setXY() as it is
						// more accurate than guessing
						BufferedImage detentionIMG = null;

						// Attempt to read image, if it fails print error
						try {
							detentionIMG = ImageIO.read(new File("src/detention.jpg")); // Read in file contents 
							int detentionIMGheight = detentionIMG.getHeight(); // Get Height of Image
							
							gt.addImageIcon(detentionIMG); // print buffered image to screen
							gt.setXY(10, 20 + detentionIMGheight); // reset X position and update Y position
							gt.println(""); // Print blank line
							
						} catch (IOException error) { // Catch any IOerrors and store it in variable error
							gt.println("[IMAGE FILE NOT FOUND]"); // Print and move to new line
							gt.println(""); // Print blank line
						}
						gt.setFontColor(74, 246, 38); // Set Font Color (RGB Value) (Terminal Green)
						gt.println("[Do The Crime, Do The Time...]");
						gt.println("");
						gt.setFontColor(204, 0, 204); // Set Font Color (RGB Value) (Purple)
						
						// Wait 5 Seconds then ask to play again
						try {
							TimeUnit.SECONDS.sleep(5); // Sleep for 5 seconds
						} catch (InterruptedException e) {
							// Auto-generated catch block
							e.printStackTrace();
						}
						break; // Break Away from while loop
						
					} else if (Q2_input.equals("class")) {
						gt.clear(); // Empty Window
						gt.setXY(10, 10); // reset X position and update Y position
						
						// Destination: Class
						attendedClass = true; // Update Boolean value to true
						
						gt.println("--- CLASS ---"); // Print Text Move to New Line
						// Your class is in the library
						
						// Using a buffered image to get image dimensions for setXY() as it is
						// more accurate than guessing
						BufferedImage classroomIMG = null;
						// Attempt to read image, if it fails print error
						try {
							classroomIMG = ImageIO.read(new File("src/classroom.jpg")); // Read in file contents
							int classroomIMGheight = classroomIMG.getHeight(); // Get Height of Image
							
							gt.addImageIcon(classroomIMG); // print buffered image to screen
							gt.setXY(10, 20 + classroomIMGheight); // reset X position and update Y position
							gt.println(""); // Print blank line
							
						} catch (IOException error) { // Catch any IOerrors and store it in variable error
							gt.println("[IMAGE FILE NOT FOUND]"); // Print and move to new line
							gt.println(""); // Print blank line
						}
						gt.setFontColor(204, 204, 0); // Set Font Color (RGB Value) (Yellowish) 
						gt.println("You enter the classroom and take your seat."); // Print hello do not moved to next line
						
						// Stay in class until the bell rings
						try {
							TimeUnit.SECONDS.sleep(10); // Sleep for 10 seconds
						} catch (InterruptedException e) {
							// Auto-generated catch block
							e.printStackTrace();
						}
						gt.setFontColor(255, 0, 0); // Set Font Color (RGB Value) (Red)
						gt.println("You hear the school bell ring."); // Print hello do not moved to next line
						gt.println("");
						
						// Request New Travel Location
						gt.setFontColor(204, 204, 0); // Set Font Color (RGB Value) (Yellowish) 
						gt.print("Where do you want to go? "); // Print hello do not moved to next line
						gt.setFontColor(204, 0, 204); // Set Font Color (RGB Value) (Purple)
						gt.println("[Library/Reception/Class/Home]"); // Print Text Move to New Line
						Q2_input = gt.getInputString("Where should we go? [Library/Reception/Class/Home]"); // Request User Input and save to variable
						Q2_input = Q2_input.toLowerCase(); // Convert input to lower-case
						gt.println(Q2_input); // Print the User input
						gt.println(""); // Blank Line
						
						// Location Loop
						while (!Q2_input.matches("library|reception|class|home")) {
							// No match on required input
							gt.println("Thats not a valid travel location..");
							
							gt.setFontColor(204, 204, 0); // Set Font Color (RGB Value) (Yellowish) 
							gt.print("Where do you want to go? "); // Print hello do not moved to next line
							gt.setFontColor(204, 0, 204); // Set Font Color (RGB Value) (Purple)
							gt.println("[Library/Reception/Class/Home]"); // Print Text Move to New Line
							Q2_input = gt.getInputString("Where should we go? [Library/Reception/Class/Home]");
							Q2_input = Q2_input.toLowerCase(); // Convert input to lower-case
							gt.println(Q2_input); // Print the User input
							gt.println(""); // Blank Line
						}				
					} else {
						gt.clear(); // Empty Window
						gt.setXY(10, 10); // reset X position and update Y position
						// Destination: Library
						// Moving on to Question 3
						// The Dreaded Maths teacher intercepts you you must answer 2/3 questions correct to gain access to the library
						gt.println("--- Math Battle! [You Vs Dreaded Maths Teacher] ---"); // Print Text Move to New Line
						
						// Using a buffered image to get image dimensions for setXY() as it is
						// more accurate than guessing
						BufferedImage mathsIMG = null;
						// Attempt to read image, if it fails print error
						try {
							mathsIMG = ImageIO.read(new File("src/maths-teacher.jpg")); // Read in file contents
							int mathsIMGheight = mathsIMG.getHeight(); // Get Height of Image
							
							gt.addImageIcon(mathsIMG); // print buffered image to screen
							gt.setXY(10, 20 + mathsIMGheight); // reset X position and update Y position
							gt.println(""); // Print blank line
							
						} catch (IOException error) { // Catch any IOerrors and store it in variable error
							gt.println("[IMAGE FILE NOT FOUND]"); // Print and move to new line
							gt.println(""); // Print blank line
						}
						
						/*  Random Maths Questions
						 *
						 *  MATHS QUESTION 1
						 *  Pick Random Value
						 */
						int maths1;
						int maths1b;
						int maths1Total; 
						String maths1User = "";
						
						Random rand = new Random(); //Initialize Class Object Random
						int intBoundary = 100; // Random Int Boundary (Cannot be hit this number or higher) 
						maths1 = rand.nextInt(intBoundary); // Select Random int taking into account boundary and set variable
						maths1b = rand.nextInt(intBoundary); // Select Random int taking into account boundary and set variable
						maths1Total = maths1 + maths1b; 

						while (!maths1User.matches("^[0-9]+$")) {
							maths1User = gt.getInputString("Question: " + maths1 + " + " + maths1b + " = ?");
							gt.setFontColor(74, 246, 38); // Set Font Color (RGB Value) (Terminal Green)
							gt.println("Question: " + maths1 + " + " + maths1b + " = ?"); // print and go to new line
							gt.setFontColor(204, 0, 204); // Set Font Color (RGB Value) (Purple)
							
						}
						int maths1UserInt = Integer.parseInt(maths1User); // Set Variable to contents of this variable with conversion (Interger.parseInt) 
						if (maths1UserInt == maths1Total) {
							mathsScore++;
							gt.setFontColor(74, 246, 38); // Set Font Color (RGB Value) (Terminal Green)
							gt.println(maths1User + " is correct.");
							gt.setFontColor(204, 0, 204); // Set Font Color (RGB Value) (Purple)
							
						} else {
							gt.setFontColor(74, 246, 38); // Set Font Color (RGB Value) (Terminal Green)
							gt.println(maths1User + " is wrong, the correct answer is " + maths1Total);
							gt.setFontColor(204, 0, 204); // Set Font Color (RGB Value) (Purple)
						}
						
						
						// MATHS QUESTION 2
						// Pick Random Value
						int maths2;
						int maths2b;
						int maths2Total; 
						String maths2User = "";
						
						Random rand2 = new Random(); //Initialize Class Object Random
						int intBoundary2 = 12; // Random Int Boundary (Cannot be hit this number or higher) 
						maths2 = rand2.nextInt(intBoundary2); // Select Random int taking into account boundary and set variable
						maths2b = rand2.nextInt(intBoundary2); // Select Random int taking into account boundary and set variable
						maths2Total = maths2 * maths2b; 

						while (!maths2User.matches("^[0-9]+$")) {
							maths2User = gt.getInputString("Question: " + maths2 + " X " + maths2b + " = ?");
							gt.setFontColor(74, 246, 38); // Set Font Color (RGB Value) (Terminal Green)
							gt.println("Question: " + maths2 + " X " + maths2b + " = ?"); // print and go to new line
							gt.setFontColor(204, 0, 204); // Set Font Color (RGB Value) (Purple)
						}
						int maths2UserInt = Integer.parseInt(maths2User); // Set Variable to contents of this variable with conversion (Interger.parseInt) 
						if (maths2UserInt == maths2Total) {
							mathsScore++;
							gt.setFontColor(74, 246, 38); // Set Font Color (RGB Value) (Terminal Green)
							gt.println(maths2User + " is correct.");
							gt.setFontColor(204, 0, 204); // Set Font Color (RGB Value) (Purple)
							
						} else {
							gt.setFontColor(74, 246, 38); // Set Font Color (RGB Value) (Terminal Green)
							gt.println(maths2User + " is wrong, the correct answer is " + maths1Total);
							gt.setFontColor(204, 0, 204); // Set Font Color (RGB Value) (Purple)
						}

						// MATHS QUESTION 3
						// Pick Random Value
						int maths3;
						int maths3b;
						int maths3Total; 
						String maths3User = "";
						
						Random rand3 = new Random(); //Initialize Class Object Random
						int intBoundary3 = 20; // Random Int Boundary (Cannot be hit this number or higher) 
						maths3 = rand3.nextInt(intBoundary3); // Select Random int taking into account boundary and set variable
						maths3b = rand3.nextInt(intBoundary3); // Select Random int taking into account boundary and set variable
						maths3Total = maths3 * maths3b; 

						while (!maths3User.matches("^[0-9]+$")) {
							maths3User = gt.getInputString("Question: " + maths3 + " X " + maths3b + " = ?");
							gt.setFontColor(74, 246, 38); // Set Font Color (RGB Value) (Terminal Green)
							gt.println("Question: " + maths3 + " X " + maths3b + " = ?"); // print and go to new line
							gt.setFontColor(204, 0, 204); // Set Font Color (RGB Value) (Purple)
						}
						int maths3UserInt = Integer.parseInt(maths3User); // Set Variable to contents of this variable with conversion (Interger.parseInt) 
						if (maths3UserInt == maths3Total) {
							mathsScore++;
							gt.setFontColor(74, 246, 38); // Set Font Color (RGB Value) (Terminal Green)
							gt.println(maths3User + " is correct.");
							gt.setFontColor(204, 0, 204); // Set Font Color (RGB Value) (Purple)
							
						} else {
							gt.setFontColor(74, 246, 38); // Set Font Color (RGB Value) (Terminal Green)
							gt.println(maths3User + " is wrong, the correct answer is " + maths1Total);
							gt.setFontColor(204, 0, 204); // Set Font Color (RGB Value) (Purple)
						}
						
						if (mathsScore < 2 ) {
							passedMaths = false;  // Update Boolean value to false
						} else {
							passedMaths = true; // Update Boolean value to true
						}
						break; // Break away from the while loop
					}
				}
			}
			// End - Question 2
			// Question 3 - Library
			if (wentHome == false && passedMaths == true) {
				gt.clear(); // Empty Window
				gt.setXY(10, 10); // reset X position and update Y position
				
				gt.println("--- The Library ---"); // Print Text Move to New Line
				// Destination: Class
				visitedLibrary = true; // Update Boolean value to true
				// Question 3 - Library
				
				// Using a buffered image to get image dimensions for setXY() as it is
				// more accurate than guessing
				BufferedImage libraryIMG = null;
				// Attempt to read image, if it fails print error
				try {
					libraryIMG = ImageIO.read(new File("src/library.jpg")); // Read in file contents
					int libraryIMGheight = libraryIMG.getHeight(); // Get Height of Image
					
					gt.addImageIcon(libraryIMG); // print buffered image to screen
					gt.setXY(10, 20 + libraryIMGheight); // reset X position and update Y position
					gt.println(""); // Print blank line
					
				} catch (IOException error) { // Catch any IOerrors and store it in variable error
					gt.println("[IMAGE FILE NOT FOUND]"); // Print and move to new line
					gt.println(""); // Print blank line
				}
				
				// Give user option to return book or go home
				gt.setFontColor(204, 204, 0); // Set Font Color (RGB Value) (Yellowish) 
				gt.print("What would you like todo? "); // Print hello do not moved to next line
				gt.setFontColor(204, 0, 204); // Set Font Color (RGB Value) (Purple)
				gt.println("[Return Book/Go Home/Home]"); // Print Text Move to New Line
				String libraryAction = gt.getInputString("What would you like todo? [Return Book/Go Home/Home]");
				libraryAction = libraryAction.toLowerCase(); // Convert input to lower-case
				gt.setFontColor(255, 255, 255); // Set Font Color (RGB Value) (White)
				gt.println(libraryAction); // Print the User input
				gt.println(""); // Blank Line
				
				// Location Loop
				while (!libraryAction.matches("return book|return|book|go home|home")) {
					// No match on required input
					gt.println("Thats not a valid option..");
					
					gt.setFontColor(204, 204, 0); // Set Font Color (RGB Value) (Yellowish) 
					gt.print("What would you like todo? "); // Print hello do not moved to next line
					gt.setFontColor(204, 0, 204); // Set Font Color (RGB Value) (Purple)
					gt.println("[Return Book/Go Home/Home]"); // Print Text Move to New Line
					libraryAction = gt.getInputString("What would you like todo? [Return Book/Go Home/Home]");
					libraryAction = libraryAction.toLowerCase(); // Convert input to lower-case
					gt.setFontColor(255, 255, 255); // Set Font Color (RGB Value) (White)
					gt.println(libraryAction); // Print the User input
					gt.println(""); // Blank Line
				}
				
				if (libraryAction.matches("return book|book|return")) {
					returnedBook = true; // Update Boolean value to true
				}
				
				// Ask user to return the book
			} else if (wentHome == false && passedMaths == false && acceptedQuest == true) {
				// Do Nothing
			} else if (wentHome == true || acceptedQuest == false) {
				// User went home do nothing
			} else {
				// User should never fall in here... but just in case for testing purposes
				gt.setFontColor(255, 0, 0); // Set Font Color (RGB Value) (Red)
				gt.println(">>> [SOMETHING WENT WRONG - Please Report this bug!] <<<"); // Just a Error Message
				gt.setFontColor(255, 255, 255); // Set Font Color (RGB Value) (White)
			}
			
			// ending, conversation then show results
			if (returnedBook == false) { 
				gt.setFontColor(255, 0, 0); // Set Font Color (RGB Value) (Red)
				gt.println("FAILED!");
				gt.setFontColor(255, 255, 255); // Set Font Color (RGB Value) (White)
			} else {
				gt.setFontColor(74, 246, 38); // Set Font Color (RGB Value) (Terminal Green)
				gt.println("PASSED!");
				gt.setFontColor(255, 255, 255); // Set Font Color (RGB Value) (White)
			}
			
			gt.println(UserName + ", You Completed the Following Task");
		
			// Attended Class Results
			if (attendedClass == true) {
				gt.setFontColor(255, 255, 255); // Set Font Color (RGB Value) (White)
				gt.print("Attended Class: ");
				gt.setFontColor(74, 246, 38); // Set Font Color (RGB Value) (Terminal Green)
				gt.println("Yes");
			} else {
				gt.setFontColor(255, 255, 255); // Set Font Color (RGB Value) (White)
				gt.print("Attended Class: ");
				gt.setFontColor(255, 0, 0); // Set Font Color (RGB Value) (Red)
				gt.println("No");			
			}
			
			// Visited Reception Results
			if (visitedReception == true) {
				gt.setFontColor(255, 255, 255); // Set Font Color (RGB Value) (White)
				gt.print("Visited Reception: ");
				gt.setFontColor(74, 246, 38); // Set Font Color (RGB Value) (Terminal Green)
				gt.println("Yes");
			} else {
				gt.setFontColor(255, 255, 255); // Set Font Color (RGB Value) (White)
				gt.print("Visited Reception: ");
				gt.setFontColor(255, 0, 0); // Set Font Color (RGB Value) (Red)
				gt.println("No");			
			}
			
			// Visited Library Results
			if (visitedLibrary == true) {
				gt.setFontColor(255, 255, 255); // Set Font Color (RGB Value) (White)
				gt.print("Visited Library: ");
				gt.setFontColor(74, 246, 38); // Set Font Color (RGB Value) (Terminal Green)
				gt.println("Yes");
			} else {
				gt.setFontColor(255, 255, 255); // Set Font Color (RGB Value) (White)
				gt.print("Visited Library: ");
				gt.setFontColor(255, 0, 0); // Set Font Color (RGB Value) (Red)
				gt.println("No");			
			}
			
			// Returned Book Results
			if (returnedBook == true) {
				gt.setFontColor(255, 255, 255); // Set Font Color (RGB Value) (White)
				gt.print("Returned Book: ");
				gt.setFontColor(74, 246, 38); // Set Font Color (RGB Value) (Terminal Green)
				gt.println("Yes");
			} else {
				gt.setFontColor(255, 255, 255); // Set Font Color (RGB Value) (White)
				gt.print("Returned Book: ");
				gt.setFontColor(255, 0, 0); // Set Font Color (RGB Value) (Red)
				gt.println("No");	
			}
	
			// Went Home Results
			if (wentHome == true) {
				gt.setFontColor(255, 255, 255); // Set Font Color (RGB Value) (White)
				gt.print("Went Home: ");
				gt.setFontColor(74, 246, 38); // Set Font Color (RGB Value) (Terminal Green)
				gt.println("Yes");
			} else {
				gt.setFontColor(255, 255, 255); // Set Font Color (RGB Value) (White)
				gt.print("Went Home: ");
				gt.setFontColor(255, 0, 0); // Set Font Color (RGB Value) (Red)
				gt.println("No");	
			}
			
			// Detention Results
			if (gotDetention == true) {
				gt.setFontColor(255, 255, 255); // Set Font Color (RGB Value) (White)
				gt.print("Detention: ");
				gt.setFontColor(74, 246, 38); // Set Font Color (RGB Value) (Terminal Green)
				gt.println("Yes");
			} else {
				gt.setFontColor(255, 255, 255); // Set Font Color (RGB Value) (White)
				gt.print("Detention: ");
				gt.setFontColor(255, 0, 0); // Set Font Color (RGB Value) (Red)
				gt.println("No");	
			}
			
			// Maths Battle Results
			if (passedMaths == true) {
				gt.setFontColor(255, 255, 255); // Set Font Color (RGB Value) (White)
				gt.print("Won Maths Battle: ");
				gt.setFontColor(74, 246, 38); // Set Font Color (RGB Value) (Terminal Green)
				gt.println("Yes [" + mathsScore + "/3]");
			} else {
				gt.setFontColor(255, 255, 255); // Set Font Color (RGB Value) (White)
				gt.print("Won Maths Battle: ");
				gt.setFontColor(255, 0, 0); // Set Font Color (RGB Value) (Red)
				gt.println("No [" + mathsScore + "/3]");
			}
			
			// Would you like to play again?
			// Wait 5 Seconds then ask to play again
			try {
				TimeUnit.SECONDS.sleep(5); // Sleep for 5 seconds
			} catch (InterruptedException e) {
				// Auto-generated catch block
				e.printStackTrace();
			}
			playAgain = gt.getInputString("Want to Play Again? [Yes/No Y/N]");
			playAgain = playAgain.toLowerCase(); // Convert input to lower-case
			if (playAgain.matches("y|yes")) {
				gt.clear(); // Empty Window if user is playing again
				gt.setXY(0,0); // Reset XY to 0
			}
		}
		gt.close(); // Exit App
	}
}
 