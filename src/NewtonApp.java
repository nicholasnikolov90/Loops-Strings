
/**
 * NewtonApp is a command line interface application used to estimate the square 
 * root of a number using Newton's square root method
 * 
 * @author Nick Nikolov
 *
 */
public class NewtonApp {
	
	private InteractiveCLI cli;
	private NewtonSolver newton;
	
	/**
	 * create new instances of the NewtonSolver class and the InteractivewCLI class
	 */
	public NewtonApp() {
		cli = new InteractiveCLI();
		newton = new NewtonSolver();
	}

	
	/**prompts the user to enter a positive number, an initial guess, and the maximum error
	 * 
	 * makes calls to the NewtonSolver class, and displays the final calculated square root
	 * and the number of iterations it took to solve the calculation
	 */
	public void run() {
		
		//get all user inputs for number, error, and initial guess
		cli.display("*** Calculate Square Root using Newtons Method ***");
		cli.display("Enter a positive number, e.g. 25.3: ");
		while(true) {
			newton.number = cli.getKeyboardDouble();
			if (newton.number >= 0) {
				break;
			}
			else {
				cli.display("You must enter a positive number, try again!");
			}
			
		}
		cli.display("Enter a maximum error, e.g. 0.001: ");
		newton.error = cli.getKeyboardDouble();
		cli.display("Enter an initial guess e.g. 12.1: ");
		while(true) {
			newton.setInitialGuess(cli.getKeyboardDouble());
			if (newton.getInitialGuess() > 0) {
				break;
			}
			else {
				cli.display("You must enter a positive number as the initial guess, try again!");
			}
				
				
		}
		cli.display("You entered number = " + newton.number + " error = " + newton.error + " initial guess = " + newton.getInitialGuess());
		
		double result = newton.Sqrt(newton.getInitialGuess(), newton.number, newton.error);

		cli.display("The square root of " + newton.number + " is:" + result);
		
		cli.display("Computed in: " + newton.getIterations() + " iterations");
		
		
	}

	public static void main(String[] args) {
		NewtonApp app = new NewtonApp();
		app.run();

	}

}
