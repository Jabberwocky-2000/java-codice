package appellostr.sol;

import static org.junit.Assert.*;

import org.junit.Before;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Implementare l'interfaccia Course che crea un corso di studi definito in base agli studenti iscritti 
 * e agli insegnanti che sul corso fanno didattica.
 * Mette poi  disposizione un metodo per calcolare la spesa totale che l'università deve sostenere per erogare quel corso di studi.
 * Si veda la documentazione del metodo per le regole da seguire nel computo della spesa totale.
 * 
 * L'utilizzo di aspetti di Java avanzati è considerato opzionale ma concorre al raggiungimento del punteggio massimo.
 * 
 */

public class Test {

	
    private Course course;
    private Course courseH;

    @Before
  	public void setUp() {
        Book book1 = new Book("Book 1", 25.0);
        Book book2 = new Book("Book 2", 30.0);

        List<Person> people = new ArrayList<>();
        people.add(new Student("Alice", 20, "12345"));
        people.add(new Student("Bob", 22, "67890"));
        people.add(new Teacher("Prof. Smith", 40, Arrays.asList("Math","Physics")));
        people.add(new Teacher("Prof. Johnson", 35, Arrays.asList("OOP","OS","DB")));
        
        List<Person> peopleH = new ArrayList<>();
        peopleH.add(new Student("Alice", 20, "12345"));
        peopleH.add(new Student("Bob", 22, "67890"));
        peopleH.add(new Teacher("Prof. Smith", 40, Arrays.asList(new Pair<>("Math",60),new Pair<>("Physics",60)),120));
        peopleH.add(new Teacher("Prof. Johnson", 35, Arrays.asList(new Pair<>("OOP",90),new Pair<>("OS",90),new Pair<>("OS",60)),120));
        
        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);

        course = new CourseImpl(people, books);
        courseH = new CourseImpl(peopleH,books);
    }

    @org.junit.Test
    public void testCalculateTotalCost() {
        assertEquals(2555.0, course.calculateTotalCost(), 0.001);
    }
    
    @org.junit.Test
    public void testCalculateTotalCostH() {
        assertEquals(3255.0, courseH.calculateTotalCostH(), 0.001);
    }
   
}