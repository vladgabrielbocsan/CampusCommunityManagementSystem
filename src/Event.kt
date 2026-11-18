class Event(
    val eventId: String,
    val eventTitle: String,
    val eventCategory: String,
    val eventOrganiser: String,
    val eventDate: String,
    val eventTime: String,
    val eventLocation: String,
    val maximumCapacity: Int,
    val eventStatus: EventStatus
)