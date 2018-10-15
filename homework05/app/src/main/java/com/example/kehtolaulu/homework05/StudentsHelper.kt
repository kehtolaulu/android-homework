package com.example.kehtolaulu.homework05

import java.util.*

class StudentsHelper {

    object DataProviderManager {
        fun getStudents(): MutableList<Student>? {
            return Arrays.asList(
                    Student("Lesya", 20),
                    Student("Aina", 19),
                    Student("Dima", 19),
                    Student("Emiliya", 21)
            )
        }

        fun sortByAlpha(students: MutableList<Student>?): List<Student>? {
            return students?.sortedWith(compareBy(Student::name))
        }

        fun sortByAge(students: MutableList<Student>?): List<Student>? {
            return students?.sortedWith(compareBy(Student::age))
        }

    }
}
