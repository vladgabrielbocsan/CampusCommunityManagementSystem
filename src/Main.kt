
fun main() {
    val seedData = SeedData()

    val eventViewer = StudentEventViewer(seedData)
    val reservationManager = StudentReservationManager(seedData)
    val reservationViewer = StudentReservationViewer(seedData)

    var running = true

    while (running) {
        println("\n======================================")
        println(" CAMPUS COMMUNITY MANAGEMENT SYSTEM")
        println("======================================")
        println("         STUDENT MAIN MENU")
        println("--------------------------------------")
        println("1. View all community events")
        println("2. Search community events")
        println("3. Make an event reservation")
        println("4. View my reservations")
        println("5. Cancel a reservation")
        println("6. Exit")
        println("--------------------------------------")

        print("Choose an option (1-6): ")

        when (readlnOrNull()?.trim()) {
            "1" -> eventViewer.viewAllEvents()

            "2" -> eventViewer.searchEvents()

            "3" -> reservationManager.makeReservation()

            "4" -> reservationViewer.viewReservations()

            "5" -> reservationViewer.cancelReservation()

            "6" -> {
                println("\nThank you for using the system.")
                running = false
            }

            else -> {
                println("\nInvalid option. Please choose 1-6.")
            }
        }
    }
}
