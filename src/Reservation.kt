class Reservation(
    val id: String,
    val student: Student,
    val event: Event,
    var status: ReservationStatus
)
