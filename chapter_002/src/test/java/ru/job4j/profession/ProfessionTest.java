package ru.job4j.profession;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * @author Dmitry Rozhdestvenskiy (mailto:dmr1433@gmail.com)
 *  @version $Id$
 *  @since 0.1
 */
public class ProfessionTest {
    @Test
    public void healingFever() {
        Patient patient = new Patient();
        patient.setName("John Doe");
        patient.setAge(32);
        patient.setDiagnose("Fever");
        Doctor doctor = new Doctor("Doc John", 0, 0, 10, 10, "Male", "Teurapeut");
        String result = doctor.heal(patient);
        assertThat(result, is("Fever"));
    }
    @Test
    public void buildingHouse() {
        Engineer engineer = new Engineer("Peter", 10, 1, 10, 30, "Male");
        House house = new House();
        house.setType("wood house");
        String result = engineer.built(house);
        assertThat(result, is("wood house"));
    }
    @Test
    public void teachingALesson() {
        Teacher teacher = new Teacher("Andrew", 10, 1, 8, 30, "Male", "Mathematics");
        Student student = new Student();
        student.setName("Dumb Billy");
        student.setAge(8);
        student.setLesson("Math");
        String resultName = teacher.getName();
        assertThat(resultName, is("Andrew"));
        String result = teacher.teach(student);
        assertThat(result, is("Math"));
    }
}
