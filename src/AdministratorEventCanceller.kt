class AdministratorEventCanceller(
    private val seedData: SeedData
) {

    fun cancelEvent() {

        println("\n----- CANCEL EVENT -----")

        print("Enter event ID: ")
        val eventId = readln().trim()

        var selectedEvent: Event? = null

        for (event in seedData.events) {
            if (event.eventId.equals(eventId, ignoreCase = true)) {
                selectedEvent = event
                break
            }
        }

        if (selectedEvent == null) {
            println("No event found with ID: $eventId")
            return
        }

        if (selectedEvent.eventStatus != EventStatus.UPCOMING) {
            println("Only upcoming events can be cancelled.")
            return
        }

        println("\nEvent found: ${selectedEvent.eventTitle}")
        println("Event ID: ${selectedEvent.eventId}")

        var numberOfCancelledReservations = 0

        for (reservation in seedData.reservations) {

            if (reservation.event.eventId == selectedEvent.eventId &&
                reservation.status == ReservationStatus.ACTIVE) {

                reservation.status = ReservationStatus.EVENT_CANCELLED
                numberOfCancelledReservations++
            }
        }

        selectedEvent.eventStatus = EventStatus.CANCELLED

        println("\nEvent cancelled successfully.")
        println("Event ID: ${selectedEvent.eventId}")
        println("Updated reservations: $numberOfCancelledReservations")
    }
}