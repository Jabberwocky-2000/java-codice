package it.uniurb.pmo.pmo12.gui.mvc.model;

public interface DrawNumber {
	
	void reset();
	
	DrawResult attempt(int n) throws AttemptsLimitReachedException;
}
