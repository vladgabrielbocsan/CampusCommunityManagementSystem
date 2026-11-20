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

    val events = mutableListOf(
        Event(
            eventId = "E001",
            eventTitle = "Python Coding Workshop",
            eventCategory = "Academic",
            eventOrganiser = "Helen Moore",
            eventDate = "14 Oct 2026",
            eventTime = "14:00",
            eventLocation = "Computing Lab B12",
            maximumCapacity = 6,
            eventStatus = EventStatus.UPCOMING
        ),
        Event(
            eventId = "E002",
            eventTitle = "Five-a-Side Football",
            eventCategory = "Sports",
            eventOrganiser = "Alex Turner",
            eventDate = "16 Oct 2026",
            eventTime = "17:00",
            eventLocation = "Sports Hall",
            maximumCapacity = 4,
            eventStatus = EventStatus.UPCOMING
        ),
        Event(
            eventId = "E003",
            eventTitle = "Careers in Technology",
            eventCategory = "Careers",
            eventOrganiser = "Rachel Adams",
            eventDate = "20 Oct 2026",
            eventTime = "13:00",
            eventLocation = "Lecture Hall 2",
            maximumCapacity = 6,
            eventStatus = EventStatus.UPCOMING
        ),
        Event(
            eventId = "E004",
            eventTitle = "Student Wellbeing Workshop",
            eventCategory = "Wellbeing",
            eventOrganiser = "Sarah Lewis",
            eventDate = "05 Oct 2026",
            eventTime = "11:00",
            eventLocation = "Room C05",
            maximumCapacity = 5,
            eventStatus = EventStatus.COMPLETED
        ),
        Event(
            eventId = "E005",
            eventTitle = "Community Volunteering Day",
            eventCategory = "Volunteering",
            eventOrganiser = "James Wilson",
            eventDate = "02 Oct 2026",
            eventTime = "09:00",
            eventLocation = "Community Hub",
            maximumCapacity = 6,
            eventStatus = EventStatus.COMPLETED
        ),
        Event(
            eventId = "E006",
            eventTitle = "International Students Social",
            eventCategory = "Social",
            eventOrganiser = "Maria Costa",
            eventDate = "18 Oct 2026",
            eventTime = "18:00",
            eventLocation = "Student Union",
            maximumCapacity = 5,
            eventStatus = EventStatus.CANCELLED
        )
    )

    val reservations = mutableListOf(
        Reservation(
            id = "R001",
            student = students[0],
            event = events[0],
            status = ReservationStatus.ACTIVE
        ),
        Reservation(
            id = "R002",
            student = students[1],
            event = events[0],
            status = ReservationStatus.ACTIVE
        ),
        Reservation(
            id = "R003",
            student = students[2],
            event = events[0],
            status = ReservationStatus.USER_CANCELLED
        ),
        Reservation(
            id = "R004",
            student = students[0],
            event = events[1],
            status = ReservationStatus.ACTIVE
        ),
        Reservation(
            id = "R005",
            student = students[1],
            event = events[1],
            status = ReservationStatus.ACTIVE
        ),
        Reservation(
            id = "R006",
            student = students[3],
            event = events[1],
            status = ReservationStatus.ACTIVE
        ),
        Reservation(
            id = "R007",
            student = students[4],
            event = events[1],
            status = ReservationStatus.ACTIVE
        ),
        Reservation(
            id = "R008",
            student = students[5],
            event = events[2],
            status = ReservationStatus.ACTIVE
        ),
        Reservation(
            id = "R009",
            student = students[0],
            event = events[3],
            status = ReservationStatus.COMPLETED
        ),
        Reservation(
            id = "R010",
            student = students[2],
            event = events[3],
            status = ReservationStatus.COMPLETED
        ),
        Reservation(
            id = "R011",
            student = students[3],
            event = events[4],
            status = ReservationStatus.COMPLETED
        ),
        Reservation(
            id = "R012",
            student = students[4],
            event = events[4],
            status = ReservationStatus.USER_CANCELLED
        ),
        Reservation(
            id = "R013",
            student = students[1],
            event = events[5],
            status = ReservationStatus.EVENT_CANCELLED
        ),
        Reservation(
            id = "R014",
            student = students[5],
            event = events[5],
            status = ReservationStatus.EVENT_CANCELLED
        )
    )
}
