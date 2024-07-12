package com.assignment.demo.Repository

import StudentDTO
import com.assignment.demo.Entity.StudentEntity
import org.jetbrains.exposed.sql.Database
import org.springframework.stereotype.Repository
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.beans.factory.annotation.Autowired


@Repository
class StudentRepository {

    @Autowired
    private lateinit var database: Database

    //function untuk mengambil seluruh data dari tabel
    fun findAll(): List<StudentDTO> {
        return transaction(database) {
            StudentEntity.all().map { it.toDTO() }
        }
    }

    //function untuk membuat data baru berdasarkan parameter
    fun save(studentDTO: StudentDTO): StudentDTO {
        return transaction(database) {
            val studentEntity = StudentEntity.new {
                studentName = studentDTO.name
                studentGender = studentDTO.gender
            }
            studentEntity.toDTO()
        }
    }
    //konversi dari studentEntity -> StudentDTO
    private fun StudentEntity.toDTO(): StudentDTO {
        return StudentDTO(
                id = id.value,
                name = studentName,
                gender = studentGender
        )
    }
}