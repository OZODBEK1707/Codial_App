package com.example.codial_app.DB

import com.example.codial_app.Models.Guruh
import com.example.codial_app.Models.Kurslar
import com.example.codial_app.Models.Mentor
import com.example.codial_app.Models.Talaba


interface MyDbInterface {

    fun addKurslar(kurslar: Kurslar)
    fun getKurslar(): ArrayList<Kurslar>
    fun updateKusrlar(kurslar: Kurslar): Int
    fun deleteKurslar(kurslar: Kurslar)

    fun addGuruh(guruh: Guruh)
    fun getGuruh(): ArrayList<Guruh>
    fun updateGuruh(guruh: Guruh): Int
    fun deleteGuruh(guruh: Guruh)
    fun getMentorById(id: Int): Mentor

    fun addMentor(mentor: Mentor)
    fun getMentor() : ArrayList<Mentor>
    fun updateMentor(mentor: Mentor) : Int
    fun deleteMentor(mentor: Mentor)

    fun addStudent(talaba: Talaba)
    fun getStudent() : ArrayList<Talaba>
    fun updateStudent(talaba: Talaba) : Int
    fun deleteStudent(talaba: Talaba)
}