package it.uniurb.pmo.pmo12.gui.mvc.view;

public interface DrawNumberViewObserver {
	
	void newAttempt(int n);
	
	void resetGame();
	
	void quit();
}
