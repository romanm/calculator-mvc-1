package org.calculator1;

import javax.swing.JFrame;

import org.calculator1.core.CalcMenu;
import org.calculator1.core.CalculatorController;
import org.calculator1.core.CalculatorModel;
import org.calculator1.core.CalcultorView;

/**
 * Calculator demo GUI using a version of the Model-View-Controller (MVC) design pattern.
 * @author roman
 *
 */
public class CalculatorGUI {
	/**
	 * Main program that sets up main application window and starts user
	 * interaction.
	 * 
	 * @param args
	 *            command-line arguments; not used
	 */
	public static void main(String[] args) {
		//MVC construction 
		/*
		 * Create instances of the model, view, and controller objects, and
		 * initialize them; view needs to know about controller, and controller
		 * needs to know about model and view
		 */
		CalculatorModel model = new CalculatorModel();
		CalcultorView view = new CalcultorView();
		
		CalculatorController controller 
			= new CalculatorController(model, view);
		view.registerObserver(controller);
		/*
		 * Pack calculator to swing frame.
		 */
		JFrame frame = new JFrame();
		frame.setJMenuBar(new CalcMenu());
		view.fullContentPane(frame.getContentPane());
		frame.pack();
		frame.setVisible(true);
		//init controller with test data
		test(controller);
	}
	private static void test(CalculatorController controller) {
		controller.setNumber1(2);
		controller.setNumber2(3);
		controller.setOperator("+");
		controller.initView();
	}
}
