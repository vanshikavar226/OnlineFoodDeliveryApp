import com.school.data.*;
import com.school.util.*;

public class MainApp {
    public static void main(String[] args) {
        Student s = new Student("Neha", 80, 70, 75);
        Analyzer a = new Analyzer();

        double avg = a.calculateAverage(s);
        System.out.println(s);
        System.out.println("Average: " + avg);
        System.out.println("Grade: " + a.findGrade(avg));
    }
}
