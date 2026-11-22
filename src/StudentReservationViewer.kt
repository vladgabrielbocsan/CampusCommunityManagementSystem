
class StudentReservationViewer(
    private val seedData: SeedData
) {

    fun viewReservations() {
        println("\n===== STUDENT RESERVATIONS =====")

        val student = findStudent() ?: return

        val studentReservations = seedData.reservations.filter {
            it.student.studentId == student.studentId
        }

        if (studentReservations.isEmpty()) {
            println("You have no reservations.")
            return
        }

        println("\nReservations for ${student.fullName}:")

        for (reservation in studentReservations) {
            displayReservation(reservation)
        }
    }

    fun cancelReservation() {
        println("\n===== CANCEL EVENT RESERVATION =====")

        val student = findStudent() ?: return

        val studentReservations = seedData.reservations.filter {
            it.student.studentId == student.studentId
        }

        if (studentReservations.isEmpty()) {
            println("You have no reservations.")
            return
        }

        println("\nYour reservations:")

        for (reservation in studentReservations) {
            displayReservation(reservation)
        }

        print("\nEnter Reservation ID to cancel: ")
        val reservationId = readlnOrNull()?.trim().orEmpty()

        val reservation = studentReservations.find {
            it.id.equals(reservationId, ignoreCase = true)
        }

        if (reservation == null) {
            println("Reservation not found for this student.")
            return
        }

        if (reservation.status != ReservationStatus.ACTIVE) {
            println("Only active reservations can be cancelled.")
            return
        }

        if (reservation.event.eventStatus != EventStatus.UPCOMING) {
            println("Reservations can only be cancelled for upcoming events.")
            return
        }

        reservation.status = ReservationStatus.USER_CANCELLED

        println("\n===== RESERVATION CANCELLED =====")
        println("Reservation ID: ${reservation.id}")
        println("Event: ${reservation.event.eventTitle}")
        println("Status: ${reservation.status}")
        println("Your reserved place has been released.")
    }

    private fun findStudent(): Student? {
        print("Enter your Student ID: ")
        val studentId = readlnOrNull()?.trim().orEmpty()

        val student = seedData.students.find {
            it.studentId.equals(studentId, ignoreCase = true)
        }

        if (student == null) {
            println("Student not found.")
        }

        return student
    }

    private fun displayReservation(reservation: Reservation) {
        println("\nReservation ID: ${reservation.id}")
        println("Event ID: ${reservation.event.eventId}")
        println("Event: ${reservation.event.eventTitle}")
        println("Date: ${reservation.event.eventDate}")
        println("Time: ${reservation.event.eventTime}")
        println("Location: ${reservation.event.eventLocation}")
        println("Event Status: ${reservation.event.eventStatus}")
        println("Reservation Status: ${reservation.status}")
        println("------------------------------")
    }
}
