class Event(
    val eventId: String,
    var eventTitle: String,
    var eventCategory: String,
    var eventOrganiser: String,
    var eventDate: String,
    var eventTime: String,
    var eventLocation: String,
    var maximumCapacity: Int,
    var eventStatus: EventStatus
)