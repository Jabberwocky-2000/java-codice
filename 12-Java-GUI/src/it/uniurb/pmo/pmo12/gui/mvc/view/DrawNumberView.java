package it.uniurb.pmo.pmo12.gui.mvc.view;

import it.uniurb.pmo.pmo12.gui.mvc.model.DrawResult;

public interface DrawNumberView {
	
	void setObserver(DrawNumberViewObserver observer);
	
	void start(); 

	void numberIncorrect();

	void limitsReached();

	void result(DrawResult res);

}
