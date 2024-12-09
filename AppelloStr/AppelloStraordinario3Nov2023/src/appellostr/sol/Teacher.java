package appellostr.sol;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

public class Teacher extends Person {
    private List<String> subjects;
    private List<Pair<String,Integer>> subjectsH;
    private int maxH;

    public Teacher(String name, int age, List<String> subjects) {
        super(name, age);
        this.subjects = subjects;
        this.subjectsH = new ArrayList<>();
    }
    
    public Teacher(String name, int age, List<Pair<String,Integer>> subjects, int threshold) {
        super(name, age);
        this.subjects = new ArrayList<>();
        this.subjectsH = subjects;
        this.maxH = threshold;
    }
    
  
    public List<String> getSubjects() {
        return Collections.unmodifiableList(subjects);
    }
    
    public List<Pair<String, Integer>> getSubjectsCFU() {
        return Collections.unmodifiableList(subjectsH);
    }
    
    public int getMaxH() {
    	return this.maxH;
    }
}

