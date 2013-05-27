package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.StudentRepository;
import service.StudentService;

@Service
@Transactional
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentRepository studentRepository;


}
