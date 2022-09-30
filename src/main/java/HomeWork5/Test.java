package HomeWork5;

import HomeWork5.entity.Student;
import HomeWork5.servicies.StudentService;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class Test {


    public static void main(String[] args) {
        StudentService service = new StudentService();

        // Генератор 1000 студентов
//        for (int i = 0; i < 1000; i++) {
//            Student student = createRandomStudent();
//            try {
//                service.saveOrUpdate(student);
//            }catch (SQLException e){
//                e.printStackTrace();
//            }
//
//        }



        try{

            List<Student> students = service.getAll();
            for (int i = 0; i < 2; i++) {
                System.out.println(students.get(i));
            }

            long removedStudentId = students.get(0).getId();
            long studentId = students.get(1).getId();

            service.remove(students.get(0));

            System.out.println(service.getById(removedStudentId).isPresent());
            Optional<Student> optionalStudent = service.getById(studentId);
            System.out.println(optionalStudent.isPresent());
            Student student = optionalStudent.get();
            student.setMark(123);
            service.saveOrUpdate(student);
            System.out.println(service.getById(studentId).get());

        }catch (SQLException e){
            e.printStackTrace();
        }








    }

    public static Student createRandomStudent(){
        Student student = new Student();
        int randomName = (int) (Math.random() * 9);
        int randomMark = 1 + (int) (Math.random()*4);
        student.setName(String.valueOf(StudentNames.values()[randomName]));
        student.setMark(randomMark);
        return student;
    }
}
