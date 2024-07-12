package com.assignment.demo.Entity

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable

//Table declaring (table name : Student)
object Student: IntIdTable(){
    val studentName = varchar("student_name", 255) //column name "student_name
    val studentGender = varchar("student_gender", 10) //column name "student_gender
}
//Create entity class (Exposed)
class StudentEntity(id: EntityID<Int>) : IntEntity(id) { //menandakan bahwa primary key integer
    companion object : IntEntityClass<StudentEntity>(Student) //fitur exposed untuk berinteraksi dengan database
    var studentName by Student.studentName
    var studentGender by Student.studentGender
}