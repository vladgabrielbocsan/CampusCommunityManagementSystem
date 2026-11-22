class StudentEventViewer(
    private val seedData: SeedData
) {

    // TASK 1: View all community events
    fun viewAllEvents() {
        println("\n===== COMMUNITY EVENTS =====")

        if (seedData.events.isEmpty()) {
            println("No events available.")
            return
        }

        for (event in seedData.events) {
            displayEvent(event)
        }
    }

    // Display complete information about an event
    fun displayEvent(event: Event) {

        val activeReservations = seedData.reservations.count {
            it.event.eventId == event.eventId &&
                    it.status == ReservationStatus.ACTIVE
        }

        val remainingCapacity =
            event.maximumCapacity - activeReservations

        println("\nEvent ID: ${event.eventId}")
        println("Title: ${event.eventTitle}")
        println("Category: ${event.eventCategory}")
        println("Organiser: ${event.eventOrganiser}")
        println("Date: ${event.eventDate}")
        println("Time: ${event.eventTime}")
        println("Location: ${event.eventLocation}")
        println("Maximum Capacity: ${event.maximumCapacity}")
        println("Active Reservations: $activeReservations")
        println("Remaining Places: $remainingCapacity")
        println("Status: ${event.eventStatus}")
        println("------------------------------")
    }

    // TASK 1: Search community events
    fun searchEvents() {

        println("\n===== SEARCH COMMUNITY EVENTS =====")
        println("1. Search by title")
        println("2. Search by category")
        println("3. Search by organiser")
        println("4. Search by date")

        print("Choose an option (1-4): ")
        val option = readlnOrNull()?.trim()

        if (option !in listOf("1", "2", "3", "4")) {
            println("Invalid search option.")
            return
        }

        print("Enter search text: ")
        val searchText = readlnOrNull()?.trim().orEmpty()

        if (searchText.isBlank()) {
            println("Search text cannot be empty.")
            return
        }

        val matchingEvents = seedData.events.filter { event ->
            when (option) {
                "1" -> event.eventTitle.contains(
                    searchText,
                    ignoreCase = true
                )

                "2" -> event.eventCategory.contains(
                    searchText,
                    ignoreCase = true
                )

                "3" -> event.eventOrganiser.contains(
                    searchText,
                    ignoreCase = true
                )

                "4" -> event.eventDate.contains(
                    searchText,
                    ignoreCase = true
                )

                else -> false
            }
        }

        if (matchingEvents.isEmpty()) {
            println("\nNo matching events found.")
        } else {
            println(
                "\nFound ${matchingEvents.size} matching event(s)."
            )

            for (event in matchingEvents) {
                displayEvent(event)
            }
        }
    }
}
