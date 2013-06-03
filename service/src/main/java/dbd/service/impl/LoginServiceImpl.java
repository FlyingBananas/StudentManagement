package dbd.service.impl;

import dbd.model.Student;
import dbd.model.Teacher;
import dbd.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import dbd.repository.StudentRepository;
import dbd.repository.TeacherRepository;
import dbd.service.LoginService;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    TeacherRepository teacherRepository;

    public Teacher tryLoginAsTeacher(String username, String password) {
        return teacherRepository.findOneByLoginUsernameAndLoginPassword(username, password);
    }

    public User getUserByUsername(String username, String password) {

        Teacher usersT;
        Student usersS;

        usersT = teacherRepository.findOneByLoginUsernameAndLoginPassword(username, password);
        
        if (usersT == null){
             usersS = studentRepository.findOneByLoginUsernameAndLoginPassword(username, password);
             return usersS;
        }

        return usersT;
    }

    public Student tryLoginAsStudent(String username, String password) {
        return studentRepository.findOneByLoginUsernameAndLoginPassword(username, password);
    }
}
