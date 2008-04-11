package common;

public class StandardExpensiveService implements ExpensiveService {
	
	public void untestableMethod() {
		System.out.println("If you get here the testing game is over!");
		System.out.println("To simulate something which is untestable, the JVM will quit.");
		System.exit(-1);
	}

}
