
/**
 * @author Nick Nikolov
 *
 */
public class NewtonSolver {
	
	private double initialGuess;
	public double number;
	public double error;
	private int iterations;
	
	/** Constructor used to initialize values when a new object is created with no inputs
	 * 
	 */
	public NewtonSolver () {
		this.initialGuess = 0;
		this.number = 0;
		this.error = 1;
		this.iterations = 0;
	}
	
	/**getter function used to get the number of iterations performed while calculating the square root
	 * @return number of iterations (int)
	 */
	public int getIterations() {
		return this.iterations;
	}
	
	
	/** setter function used to set the initial guess
	 * @param initialGuess (double) - initial guess entered by the user
	 */
	public void setInitialGuess(double initialGuess) {
		if (initialGuess > 0) {
			this.initialGuess = initialGuess;
		}
	}
	
	/** getter function used to get the initial user guess
	 * @return initial guess entered by the user
	 */
	public double getInitialGuess() {
		return this.initialGuess;
	}
	/** constructor used to set the local variables 
	 * @param g1 (double) - initial guess of what the square root might be
	 * @param n (double) - initial number to take the square root of
	 * @param e (double) - maximum error allowed
	 */
	public NewtonSolver(double g1, double n, double e) {
		this.initialGuess = g1;
		this.number = n;
		this.error = e;
	}
	
	/**estimates the square root of a number by approximating it using Newtons Method
	 * 
	 * @param g1 (double) - initial guess of what the square root might be
	 * @param n (double) - initial number to take the square root of
	 * @param e (double) - maximum error allowed
	 * @return the estimated square root of the input value
	 */
	public double Sqrt (double g1, double n, double e) {
		double g2;
		
		while (true) {

			g2 = ((n / g1) + g1) / 2.0;
 			
			this.iterations += 1;
			
			if (e >= Math.abs(g1 - g2)) {
				break;
			}
			g1 = g2;
		}
		
		return g2;
	}
}
