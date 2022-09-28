package HomeWork5.servicies;

import HomeWork5.dao.StudentDAO;
import HomeWork5.entity.Student;
import HomeWork5.utils.SessionUtil;
import org.hibernate.Session;

import javax.persistence.Query;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class StudentService extends SessionUtil implements StudentDAO {

    private Session session;


    @Override
    public void saveOrUpdate(Student student) throws SQLException {
        session = openTransaction();
        session.saveOrUpdate(student);
        closeTransaction();
    }

    @Override
    public List<Student> getAll() throws SQLException {
        session = openTransaction();
        Query query = session.createNativeQuery("SELECT * FROM students").addEntity(Student.class);
        List<Student> students = query.getResultList();
        closeTransaction();
        return students;
    }

    @Override
    public Optional<Student> getById(Long id) throws SQLException {
        session = openTransaction();
        Optional<Student> optionalStudent = Optional.ofNullable(session.get(Student.class,id));
        closeTransaction();
        return optionalStudent;
    }

    @Override
    public void remove(Student student) throws SQLException {
        session = openTransaction();
        session.remove(student);
        closeTransaction();
    }

}
