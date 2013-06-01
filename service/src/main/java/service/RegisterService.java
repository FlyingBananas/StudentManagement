package service;

import model.Student;

public interface RegisterService {
	  public Student registerAsStudent(String username, String password, String name,String nrMatricol);
	  public Student registerAsStudent(Student student);
}
