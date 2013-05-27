package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.StudentRepository;

@Service
@Transactional
public class StudentService {

    @Autowired
    StudentRepository studentRepository;
}
