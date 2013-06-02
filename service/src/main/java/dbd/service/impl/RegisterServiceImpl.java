package dbd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dbd.model.LoginDetails;
import dbd.model.Student;
import dbd.repository.StudentRepository;
import dbd.service.RegisterService;
@Service
@Transactional
public class RegisterServiceImpl implements RegisterService{
	

    @Autowired
    StudentRepository studentRepository;

	public Student registerAsStudent(String username, String password,
			String name, String nrMatricol) {
		LoginDetails login=new LoginDetails(username,password);
		
		Student student=new Student();
		student.setName(name);
		student.setMatriculationNumber(nrMatricol);
		student.setLogin(login);	
		return studentRepository.save(student);

	}

	public Student registerAsStudent(Student student) {
		return studentRepository.save(student);
	}
	
	

}
