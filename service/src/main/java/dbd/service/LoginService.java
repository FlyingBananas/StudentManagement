package dbd.service;

import dbd.model.Student;
import dbd.model.Teacher;
import dbd.model.User;

/**
 * Use this interface instead of the Impl.
 *
 * Add methods on this interface and then implement on the corresponding Impl.
 */
public interface LoginService {

    public Teacher tryLoginAsTeacher(String username, String password);

    public Student tryLoginAsStudent(String username, String password);
}
