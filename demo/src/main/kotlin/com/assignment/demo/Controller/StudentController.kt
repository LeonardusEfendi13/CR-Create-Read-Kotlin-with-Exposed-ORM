package com.assignment.demo.Controller

import StudentDTO
import com.assignment.demo.Repository.StudentRepository
import com.assignment.demo.Service.StudentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/zeals")
class StudentController {
    @Autowired
    private lateinit var studentService: StudentService

    //Get all data
    @GetMapping("/show")
    fun showStudent():ResponseEntity<List<StudentDTO>>{
        val data = studentService.getAll()
        return ResponseEntity.ok(data)
    }

    //create new data based on request body
    @PostMapping("/insert")
    fun newStudentData(@RequestBody studentDTO: StudentDTO):ResponseEntity<StudentDTO>{
        val newData = studentService.newStudent(studentDTO)
        return ResponseEntity(newData, HttpStatus.CREATED)
    }
}