enum class LectureType{
    ONLINE,
    ON_PREMISE
}

class Student(val name: String, val surname: String, val indexNumber: Number){
    var markList: MutableList<Int> = mutableListOf()
    fun addMark(mark: Int){
        markList.add(mark)
    }
    fun getAverage(): Double {
        return if(markList.isNotEmpty()){
            var sum = 0
            markList.forEach { sum+=it }
            sum.toDouble() /markList.size
        }else{
            0.0
        }
    }
}

class Lecture(val name: String, val numberOfMeetings: Int, val description: String, val lecturerName: String, val lectureType:LectureType){
    var studentList: MutableList<Student> = mutableListOf()
    fun addStudent(student: Student){
        studentList.add(student)
    }
    fun removeStudent(studentIndex: Int){
        studentList.removeIf { it.indexNumber == studentIndex }
    }
    fun addMark(studentIndex: Int, mark: Int){
        studentList.find{it.indexNumber == studentIndex}?.addMark(mark)
    }
}


fun main() {
    val lecture1 = Lecture("Math", 10, "Introduction to Calculus", "Dr. Smith", LectureType.ONLINE)
    val lecture2 = Lecture("History", 8, "World History", "Prof. Johnson", LectureType.ON_PREMISE)
    val lecture3 = Lecture("Computer Science", 12, "Introduction to Programming", "Dr. Brown", LectureType.ONLINE)

    val student1 = Student("John", "Doe", 12345)
    val student2 = Student("Jane", "Smith", 67890)
    lecture1.addStudent(student1)
    lecture1.addStudent(student2)

    lecture1.addMark(student1.indexNumber.toInt(), 2)
    lecture1.addMark(student2.indexNumber.toInt(), 4)

    println("Lecture Information:")
    println("Name: ${lecture1.name}")
    println("Number of Meetings: ${lecture1.numberOfMeetings}")
    println("Description: ${lecture1.description}")
    println("Lecturer Name: ${lecture1.lecturerName}")
    println("Lecture Type: ${lecture1.lectureType}")

    println("\nStudents in the Lecture:")
    lecture1.studentList.forEach { student ->
        println("Student: ${student.name} ${student.surname}")
        println("Index Number: ${student.indexNumber}")
        println("Marks: ${student.markList.joinToString()}")
        println("Average Mark: ${student.getAverage()}\n")
    }

    lecture1.removeStudent(student1.indexNumber.toInt())

    println("\nStudents in the Lecture after Removal:")
    lecture1.studentList.forEach { student ->
        println("Student: ${student.name} ${student.surname}")
        println("Index Number: ${student.indexNumber}")
        println("Marks: ${student.markList.joinToString()}")
        println("Average Mark: ${student.getAverage()}\n")
    }
}
