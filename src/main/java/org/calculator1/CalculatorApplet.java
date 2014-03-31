package org.calculator1;

import javax.swing.JApplet;

import org.calculator1.core.CalcMenu;
import org.calculator1.core.CalculatorController;
import org.calculator1.core.CalculatorModel;
import org.calculator1.core.CalcultorView;

/**
 * Calculator demo applet using a version of the Model-View-Controller (MVC) design pattern.
 * @author roman
 *
 */
public class CalculatorApplet  extends JApplet {
	public void init() {
		//MVC construction 
		/*
		 * Create instances of the model, view, and controller objects, and
		 * initialize them; view needs to know about controller, and controller
		 * needs to know about model and view
		 */
		CalculatorModel model = new CalculatorModel();
		CalcultorView view = new CalcultorView();
		CalcMenu menuBar = new CalcMenu();

		CalculatorController controller 
		= new CalculatorController(model, view);
		view.registerObserver(controller);
		/*
		 * Pack calculator to applet.
		 */
		setJMenuBar(menuBar);
		view.fullContentPane(getContentPane());
	}
}
