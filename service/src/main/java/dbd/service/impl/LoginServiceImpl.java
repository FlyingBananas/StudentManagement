package dbd.service.impl;


import dbd.model.Student;
import dbd.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import dbd.repository.StudentRepository;
import dbd.repository.TeacherRepository;
import dbd.service.LoginService;

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
