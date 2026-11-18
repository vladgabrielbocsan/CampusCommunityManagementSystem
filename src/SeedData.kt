class SeedData {

    val administrator = Administrator(
        username = "admin",
        password = "Admin123"
    )

    val students = mutableListOf(
        Student(
            studentId = "S001",
            fullName = "Aisha Khan",
            email = "aisha.khan@student.ac.uk",
            course = "Computing",
            username = "aisha",
            password = "Student123"
        ),
        Student(
            studentId = "S002",
            fullName = "Daniel Green",
            email = "daniel.green@student.ac.uk",
            course = "Business Management",
            username = "daniel",
            password = "Student123"
        ),
        Student(
            studentId = "S003",
            fullName = "Maya Patel",
            email = "maya.patel@student.ac.uk",
            course = "Cyber Security",
            username = "maya",
            password = "Student123"
        ),
        Student(
            studentId = "S004",
            fullName = "Omar Hassan",
            email = "omar.hassan@student.ac.uk",
            course = "Software Engineering",
            username = "omar",
            password = "Student123"
        ),
        Student(
            studentId = "S005",
            fullName = "Emily Carter",
            email = "emily.carter@student.ac.uk",
            course = "Psychology",
            username = "emily",
            password = "Student123"
        ),
        Student(
            studentId = "S006",
            fullName = "Lucas Martin",
            email = "lucas.martin@student.ac.uk",
            course = "Digital Marketing",
            username = "lucas",
            password = "Student123"
        )
    )
}
