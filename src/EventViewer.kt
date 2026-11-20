class EventViewer(
    private val seedData: SeedData
) {

    fun viewAllEvents() {
        println("\n----- ALL EVENTS -----")

        for (event in seedData.events) {
            println("Event ID: ${event.eventId}")
            println("Event Title: ${event.eventTitle}")
            println("Category: ${event.eventCategory}")
            println("Organiser: ${event.eventOrganiser}")
            println("Date: ${event.eventDate}")
            println("Time: ${event.eventTime}")
            println("Location: ${event.eventLocation}")
            println("Maximum Capacity: ${event.maximumCapacity}")

            var numberOfReservations = 0

            for (reservation in seedData.reservations) {
                if (reservation.event.eventId == event.eventId &&
                    reservation.status == ReservationStatus.ACTIVE) {

                    numberOfReservations++
                }
            }

            val remainingCapacity = event.maximumCapacity - numberOfReservations

            println("Number of Reservations: $numberOfReservations")
            println("Remaining Capacity: $remainingCapacity")
            println("Status: ${event.eventStatus}")
            println("* ".repeat(25))
        }
    }
}