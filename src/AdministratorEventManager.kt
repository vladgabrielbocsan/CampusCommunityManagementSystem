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

        print("Enter event date: ")
        val eventDate = readln()

        print("Enter event time: ")
        val eventTime = readln()

        print("Enter event location: ")
        val eventLocation = readln()

        var maximumCapacity = 0

        while (maximumCapacity < 1) {
            print("Enter maximum capacity: ")

            val enteredCapacity = readln().toIntOrNull()

            if (enteredCapacity == null) {
                println("Please enter a valid whole number.")
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
}