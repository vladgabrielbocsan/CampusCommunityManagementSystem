class Student(
    val studentId: String,
    val fullName: String,
    val email: String,
    val course: String,
    username: String,
    password: String
) : User(username, password)
