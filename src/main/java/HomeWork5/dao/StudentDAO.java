package HomeWork5.dao;

import HomeWork5.entity.Student;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface StudentDAO {

    void saveOrUpdate(Student student)throws SQLException;

    List<Student> getAll() throws SQLException;

    Optional<Student> getById(Long id) throws SQLException;

    void remove (Student student) throws SQLException;


}
