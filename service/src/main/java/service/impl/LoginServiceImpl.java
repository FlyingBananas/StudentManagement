package service.impl;


import model.Student;
import model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.StudentRepository;
import repository.TeacherRepository;
import service.LoginService;

@Service
@Transactional
public class LoginServiceImpl implements LoginService{

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    TeacherRepository teacherRepository;

    public Teacher tryLoginAsTeacher(String username, String password) {
        return teacherRepository.findOneByLoginUsernameAndLoginPassword(username, password);
    }

    public Student tryLoginAsStudent(String username, String password) {
        return studentRepository.findOneByLoginUsernameAndLoginPassword(username, password);
    }


}
