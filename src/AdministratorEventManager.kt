class AdministratorEventManager(
    private val seedData: SeedData
) {

    fun addEvent() {

        println("\n----- ADD NEW EVENT -----")

        print("Enter event title: ")
        val eventTitle = readln()

        print("Enter event category: ")
        val eventCategory = readln()

        print("Enter event organiser: ")
        val eventOrganiser = readln()

        print("Enter event date (DD MMM YYYY): ")
        val eventDate = readln()

        print("Enter event time (HH:mm): ")
        val eventTime = readln()

        print("Enter event location: ")
        val eventLocation = readln()

        var maximumCapacity = 0

        while (maximumCapacity < 1) {
            print("Enter maximum capacity: ")

            val enteredCapacity = readln().toIntOrNull()

            if (enteredCapacity == null) {
                println("Please enter a valid whole number (1, 2, 3...).")
            } else if (enteredCapacity < 1) {
                println("Maximum capacity must be greater than zero.")
            } else {
                maximumCapacity = enteredCapacity
            }
        }

        val eventId = "E" + (seedData.events.size + 1).toString().padStart(3, '0')

        val newEvent = Event(
            eventId = eventId,
            eventTitle = eventTitle,
            eventCategory = eventCategory,
            eventOrganiser = eventOrganiser,
            eventDate = eventDate,
            eventTime = eventTime,
            eventLocation = eventLocation,
            maximumCapacity = maximumCapacity,
            eventStatus = EventStatus.UPCOMING
        )

        seedData.events.add(newEvent)

        println("Event added successfully.")
        println("Event ID: $eventId")
    }

    fun modifyEvent() {

        println("\n----- MODIFY EVENT -----")

        print("Enter event ID: ")
        val eventId = readln()

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

        println("\nEvent found: ${selectedEvent.eventTitle}")
        println("Event ID: ${selectedEvent.eventId}")
        println("Category: ${selectedEvent.eventCategory}")
        println("Organiser: ${selectedEvent.eventOrganiser}")
        println("Date: ${selectedEvent.eventDate}")
        println("Time: ${selectedEvent.eventTime}")
        println("Location: ${selectedEvent.eventLocation}")
        println("Maximum Capacity: ${selectedEvent.maximumCapacity}")

        println("\nEnter the new event details:")

        print("Enter new event title: ")
        val newEventTitle = readln()

        print("Enter new event category: ")
        val newEventCategory = readln()

        print("Enter new event organiser: ")
        val newEventOrganiser = readln()

        print("Enter new event date (DD MMM YYYY): ")
        val newEventDate = readln()

        print("Enter new event time (HH:mm): ")
        val newEventTime = readln()

        print("Enter new event location: ")
        val newEventLocation = readln()

        var numberOfReservations = 0

        for (reservation in seedData.reservations) {
            if (reservation.event.eventId == selectedEvent.eventId &&
                reservation.status == ReservationStatus.ACTIVE) {

                numberOfReservations++
            }
        }

        var newMaximumCapacity = 0

        while (newMaximumCapacity < 1 ||
            newMaximumCapacity < numberOfReservations) {

            print("Enter new maximum capacity: ")

            val enteredCapacity = readln().toIntOrNull()

            if (enteredCapacity == null) {
                println("Please enter a valid whole number (1, 2, 3...).")
            } else if (enteredCapacity < 1) {
                println("Maximum capacity must be greater than zero.")
            } else if (enteredCapacity < numberOfReservations) {
                println("Capacity cannot be less than the number of active reservations: $numberOfReservations")
            } else {
                newMaximumCapacity = enteredCapacity
            }
        }

        selectedEvent.eventTitle = newEventTitle
        selectedEvent.eventCategory = newEventCategory
        selectedEvent.eventOrganiser = newEventOrganiser
        selectedEvent.eventDate = newEventDate
        selectedEvent.eventTime = newEventTime
        selectedEvent.eventLocation = newEventLocation
        selectedEvent.maximumCapacity = newMaximumCapacity

        println("\nEvent updated successfully.")
        println("Event ID: ${selectedEvent.eventId}")
    }
}