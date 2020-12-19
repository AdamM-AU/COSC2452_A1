public class Assignment1LibraryBook {
	public static void main(String[] args) {
		GTerm gt = new GTerm(600, 400);
		gt.setBackgroundColor(0, 0, 0); // Set Background Color (RGB Value) (Black)
		// Declare & Initializing variables
		boolean attendedClass = false;
		boolean visitedReception = false;
		boolean wentHome = false;
		boolean passedMaths = false;
		boolean visitedLibrary = false;
		boolean returnedBook = false;
		boolean gotDetention = false;
		
		// Start of the Game
		gt.setFontColor(74, 246, 38); // Set Font Color (RGB Value) (Terminal Green)
		gt.println("Assignment 1 - Return The Library Book!"); // Program Name
		gt.println("---------------------------------------"); // Simple Divider to look nicer
		
		String UserName = gt.getInputString("Hello, What is your name?"); // Request Users Name, store it as variable
		if (UserName.isEmpty()) {
			// UserName is Empty so they shall be NameLess
			UserName = "TheNameLess";
		}
		
		gt.print("Hello "); // Print hello do not moved to next line
		gt.setFontColor(255, 255, 255); // Set Font Color (RGB Value) (White)
		gt.print(UserName); //  // Print the User input, No new line
		gt.setFontColor(74, 246, 38); // Set Font Color (RGB Value) (Terminal Green)
		gt.println(", My Name is John and I am pleased to meet you!");
		
		// Question 1
		gt.println("Would you be interested in doing a little favor for me? (Yes/No/Y/N)"); //Print Question to Line (So User can see a transcript of events
		String Q1_input = gt.getInputString("Would you be interested in doing a little favor for me? (Yes/No/Y/N)");
		Q1_input = Q1_input.toLowerCase(); // Convert input to lower-case
		
		gt.setFontColor(255, 255, 255); // Set Font Color (RGB Value) (White)
		if (Q1_input.equals("y")) {
			Q1_input = "yes"; // Rewrite short hand
		} else if (Q1_input.equals("n")) {
			Q1_input = "no"; // Rewrite short hand
		}
		gt.println(Q1_input); // Print the User input
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
			gt.println("Great! Look I need you to go on a Quest to return this Library Book."); // Print Text Move to New Line
			gt.println("Good Luck Adventurer!"); // Print Text Move to New Line
			gt.setFontColor(255, 0, 0); // Set Font Color (RGB Value) (Red)
			gt.println("You Receive a book."); // Print Text Move to New Line
			gt.setFontColor(74, 246, 38); // Set Font Color (RGB Value) (Terminal Green)
		} else {
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
		gt.setFontColor(204, 204, 0); // Set Font Color (RGB Value) (Yellowish) 
		gt.print("Where do you want to go? "); // Print hello do not moved to next line
		gt.setFontColor(204, 0, 204); // Set Font Color (RGB Value) (Purple)
		gt.println("[Library/Reception/Class/Home]"); // Print Text Move to New Line
		String Q2_input = gt.getInputString("Where should we go? [Library/Reception/Class/Home]");
		Q2_input = Q2_input.toLowerCase(); // Convert input to lower-case
		
		while (!Q2_input.matches("library|reception|class|home")) {
			// No match on required input
			gt.println("Thats not a valid travel location..");
			
			gt.setFontColor(204, 204, 0); // Set Font Color (RGB Value) (Yellowish) 
			gt.print("Where do you want to go? "); // Print hello do not moved to next line
			gt.setFontColor(204, 0, 204); // Set Font Color (RGB Value) (Purple)
			gt.println("[Library/Reception/Class/Home]"); // Print Text Move to New Line
			Q2_input = gt.getInputString("Where should we go? [Library/Reception/Class/Home]");
			Q2_input = Q2_input.toLowerCase(); // Convert input to lower-case
		}
				
		// Action tasks
		// Action Loop for bouncing back and forth between the options
		while (Q2_input.matches("library|reception|class|home")) {

			if (Q2_input.equals("home")) {
				wentHome = true; // Update Boolean value to true
				// Destination: Home
				gt.setFontColor(204, 204, 0); // Set Font Color (RGB Value) (Yellowish)
				gt.println("You go home and skip school!"); // Print Text Move to New Line
				gt.setFontColor(74, 246, 38); // Set Font Color (RGB Value) (Terminal Green)
				break;
				
			} else if (Q2_input.equals("reception")) {
				// Destination: Reception
				visitedReception = true; // Update Boolean value to true
				gt.println("--- RECEPTION ---"); // Print Text Move to New Line
				
				// Request New Travel Location
				gt.setFontColor(204, 204, 0); // Set Font Color (RGB Value) (Yellowish) 
				gt.print("Where do you want to go? "); // Print hello do not moved to next line
				gt.setFontColor(204, 0, 204); // Set Font Color (RGB Value) (Purple)
				gt.println("[Library/Reception/Class/Home]"); // Print Text Move to New Line
				Q2_input = gt.getInputString("Where should we go? [Library/Reception/Class/Home]");
				Q2_input = Q2_input.toLowerCase(); // Convert input to lower-case
				
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
				}
			} else if (Q2_input.equals("class")) {
				// Destination: Class
				attendedClass = true; // Update Boolean value to true
				
				gt.println("--- CLASS ---"); // Print Text Move to New Line
				// Your class is in the library
				
				// Request New Travel Location
				gt.setFontColor(204, 204, 0); // Set Font Color (RGB Value) (Yellowish) 
				gt.print("Where do you want to go? "); // Print hello do not moved to next line
				gt.setFontColor(204, 0, 204); // Set Font Color (RGB Value) (Purple)
				gt.println("[Library/Reception/Class/Home]"); // Print Text Move to New Line
				Q2_input = gt.getInputString("Where should we go? [Library/Reception/Class/Home]");
				Q2_input = Q2_input.toLowerCase(); // Convert input to lower-case
				
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
				}				
			} else {
				// Destination: Library
				// Moving on to Question 3
				// The Dreaded Maths teacher intercepts you you must answer 2/3 questions correct to gain access to the library
				passedMaths = true; // Update Boolean value to true
				break; // Break away from the while loop
			}
		}
		// End - Question 2
		
		gt.println(""); // Blank Line
		
		if (wentHome == false && passedMaths == true) {
			// Question 3 - Library
			// Give user option to return book
			
			visitedLibrary = true; // Update Boolean value to true
			returnedBook = true; // Update Boolean value to true
			
			// Ask user to return the book
		} else if (wentHome == false && passedMaths == false) {
			// You Got detention
			gotDetention = true;
		} else if (wentHome == true) {
			// User went home do nothing
		} else {
			// User should neever fall in here...
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
		
	}
}
 