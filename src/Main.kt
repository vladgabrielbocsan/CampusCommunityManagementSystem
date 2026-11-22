fun main() {
    val seedData = SeedData()
    val reservationManager = StudentReservationManager(seedData)

    println("===== CAMPUS COMMUNITY MANAGEMENT SYSTEM =====")

    reservationManager.makeReservation()
}
