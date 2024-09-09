package detailed_package;

public class Driver {
	
	public static Operations helperMethod()
	{
		Operations operations = (Operations) new ConfidentialLogics();
		
		return operations;
	}
}
