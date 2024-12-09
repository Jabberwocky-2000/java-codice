package it.uniurb.pmo.pmo13.lambda;

public interface Filter<X> {
	
	// Does element x pass the filter?
	boolean applyFilter(X x);
	
}
