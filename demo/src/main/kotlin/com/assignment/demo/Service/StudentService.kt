package com.assignment.demo.Service

import StudentDTO
import com.assignment.demo.Repository.StudentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class StudentService{
    @Autowired
    private lateinit var studentRepository : StudentRepository

    //service untuk mengambil seluruh data melalui repository
    fun getAll(): List<StudentDTO>{
        return studentRepository.findAll()
    }
    //service untuk membuat data baru berdasarkan parameter yang dikirim melalui repository
    fun newStudent(newStudent : StudentDTO): StudentDTO{
        return studentRepository.save(newStudent)
    }
}