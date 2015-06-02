/**
 *The Main class that initialises the View, Model and Controller and calls the main method.
 *  @author Paul Calean 
 */

public class Main {

	/**
	 * The main method that runs when the program is launched.
	 * Initialises the Model, View, and Controller components.
	 * Calls the start method form the controller.
	 */
	public static void main(String[] args)
	{
		View view = new View();
		Model model = new Model();
		Controller controler = new Controller(view,model);
		controler.start();
	}
	
}
