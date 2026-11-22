
class StudentReservationManager(
    private val seedData: SeedData
) {

    fun makeReservation() {
        println("\n===== MAKE EVENT RESERVATION =====")

        print("Enter your Student ID: ")
        val studentId = readlnOrNull()?.trim().orEmpty()

        val student = seedData.students.find {
            it.studentId.equals(studentId, ignoreCase = true)
        }

        if (student == null) {
            println("Student not found. Reservation failed.")
            return
        }

        println("\nWelcome, ${student.fullName}!")

        println("\n===== UPCOMING EVENTS =====")

        val upcomingEvents = seedData.events.filter {
            it.eventStatus == EventStatus.UPCOMING
        }

        if (upcomingEvents.isEmpty()) {
            println("No upcoming events available.")
            return
        }

        for (event in upcomingEvents) {
            val activeCount = seedData.reservations.count {
                it.event.eventId == event.eventId &&
                        it.status == ReservationStatus.ACTIVE
            }

            val remainingPlaces =
                event.maximumCapacity - activeCount

            println(
                "${event.eventId} - ${event.eventTitle} " +
                        "(Remaining places: $remainingPlaces)"
            )
        }

        print("\nEnter Event ID to reserve: ")
        val eventId = readlnOrNull()?.trim().orEmpty()

        val event = seedData.events.find {
            it.eventId.equals(eventId, ignoreCase = true)
        }

        if (event == null) {
            println("Event not found. Reservation failed.")
            return
        }

        if (event.eventStatus != EventStatus.UPCOMING) {
            println("Only upcoming events can be reserved.")
            return
        }

        val alreadyReserved = seedData.reservations.any {
            it.student.studentId == student.studentId &&
                    it.event.eventId == event.eventId &&
                    it.status == ReservationStatus.ACTIVE
        }

        if (alreadyReserved) {
            println("You already have an active reservation for this event.")
            return
        }

        val activeReservations = seedData.reservations.count {
            it.event.eventId == event.eventId &&
                    it.status == ReservationStatus.ACTIVE
        }

        if (activeReservations >= event.maximumCapacity) {
            println("This event is fully booked. Reservation failed.")
            return
        }

        val nextReservationNumber =
            (seedData.reservations.mapNotNull {
                it.id.removePrefix("R").toIntOrNull()
            }.maxOrNull() ?: 0) + 1

        val reservationId =
            "R" + nextReservationNumber.toString().padStart(3, '0')

        val reservation = Reservation(
            reservationId,
            student,
            event,
            ReservationStatus.ACTIVE
        )

        seedData.reservations.add(reservation)

        println("\n===== RESERVATION CONFIRMED =====")
        println("Reservation ID: ${reservation.id}")
        println("Student: ${student.fullName}")
        println("Event: ${event.eventTitle}")
        println("Date: ${event.eventDate}")
        println("Time: ${event.eventTime}")
        println("Location: ${event.eventLocation}")
        println("Status: ${reservation.status}")
        println("--------------------------------")
    }
}
