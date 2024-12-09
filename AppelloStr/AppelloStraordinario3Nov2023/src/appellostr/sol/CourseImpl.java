package appellostr.sol;

import java.util.List;

public class CourseImpl implements Course {
	
	private static final int BASE_SALARY = 1000;
    private static final int EXTRA_SALARY_PER_TEACHING = 500;
    private static final int BASE_TEACHING_COUNT = 2;
    private static final double EXTRA_SALARY_PER_H = 10;
	
	private List<Person> people;
    private List<Book> books;
    
    

    public CourseImpl(List<Person> people, List<Book> books) {
        this.people = people;
        this.books = books;
    }

    public double calculateTotalCost() {
    	
        double bookCost = books.stream()
            .mapToDouble(Book::getPrice)
            .sum();

        double teacherCost = people.stream()
                .filter(person -> person instanceof Teacher)
                .map(person -> (Teacher) person)
                .mapToDouble(teacher -> {
                    int teachingCount = teacher.getSubjects().size();
                    int extraTeachingCount = (teachingCount <= BASE_TEACHING_COUNT) ? 0 : teachingCount - BASE_TEACHING_COUNT;
                    return BASE_SALARY + extraTeachingCount * EXTRA_SALARY_PER_TEACHING ;
                })
                .sum();

            return bookCost + teacherCost;
    }
    
    
    public double calculateTotalCostH() {
        double bookCost = books.stream()
            .mapToDouble(Book::getPrice)
            .sum();
    

        double teacherCost = people.stream()
            .filter(person -> person instanceof Teacher)
            .map(person -> (Teacher) person)
            .mapToDouble(teacher -> {
            	int baseH = teacher.getMaxH();
                int totalH = teacher.getSubjectsCFU().stream()
                		.mapToInt(Pair::getY)
                		.sum();
                int extraH = Math.max(0, totalH - baseH);
                return BASE_SALARY + extraH * EXTRA_SALARY_PER_H;
            })
            .sum();

        return bookCost + teacherCost;
    }
   

	public void addPerson(Person person) {
		this.people.add(person);
		
	}

	public List<Person> getPeople() {
		return this.people;
	}


	@Override
	public void addBook(Book book) {
		this.books.add(book);
		
	}
}