package it.uniurb.pmo.pmo13.nested;

public class Range3 implements Iterable<Integer>{
    
    private final int start;
    private final int stop;
    
    public Range3(final int start, final int stop){
    	this.start = start;
    	this.stop = stop;
    }
    
    public java.util.Iterator<Integer> iterator(){
    	return new java.util.Iterator<Integer>(){
            // Non ci può essere costruttore!
            private int current = start; // o anche Range4.this.start
            
            public Integer next(){
            	return this.current++;
            }
            public boolean hasNext(){
            	return this.current <= stop; // o anche Range4.this.stop
            }
            public void remove(){}
        }; // questo è il ; del return!!
    }
}
