package org.calculator1.core;

/**
 * Controller class.
 * 
 * The "controller class" implement an interface that is used as the
 * declared type where needed, but no interface is provided in this very
 * simplified demo.
 * 
 * @author roman
 * 
 */
public class CalculatorController {
	/**
	 * Model object.
	 */
	private final CalculatorModel model;
	/**
	 * View object.
	 */
	private final CalcultorView view;

	/**
	 * Constructor; connects {@code this} to the model and view it coordinates.
	 * 
	 * @param model
	 *            model to connect to
	 * @param view
	 *            view to connect to
	 */
	public CalculatorController(CalculatorModel model, CalcultorView view) {
		this.view=view;
		this.model=model;
	}

	public void setNumber2(int i) {
		model.setNumber2(parseInt(i));
	}
	public void setNumber1(int i) {
		model.setNumber1(parseInt(i));
	}

	private String parseInt(int i) {
		Integer integer = new Integer(i);
		String number1 = integer.toString();
		return number1;
	}

	public void setOperator(String operator) {
		model.setOperator(operator);
	}

	/**
	 * 
	 * Make operation with two numbers.
	 * 
	 * @param numerString1
	 * @param operator
	 * @param numerString2
	 * @return 
	 *      Result arithmetic operation for two number.
	 * 
	 */
	public String calculate(String numerString1, String operator, String numerString2) {
		int numer1 = Integer.parseInt(numerString1);
		int numer2 = Integer.parseInt(numerString2);
		Integer result=null;
		switch (operator) {
		case "+":
			result=numer1+numer2;
			break;
		case "-":
			result=numer1-numer2;
			break;
		case "*":
			result=numer1*numer2;
			break;
		case "/":
			result=numer1/numer2;
			break;
		default:
			break;
		}
		String resultString = "";
		if(null!=result)
			resultString=result.toString();
		return resultString;
	}

	/**
	 * Set model data to view fields.
	 */
	public void initView() {
		view.getNumberField1().setText(model.getNumber1());
		view.getNumberField2().setText(model.getNumber2());
		view.getOperatorLabel().setText(model.getOperator());
	}
}
