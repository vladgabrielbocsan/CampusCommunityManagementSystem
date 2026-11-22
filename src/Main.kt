fun main() {
    val seedData = SeedData()
    val eventViewer = StudentEventViewer(seedData)

    println("===== CAMPUS COMMUNITY MANAGEMENT SYSTEM =====")

    eventViewer.viewAllEvents()
    eventViewer.searchEvents()
}
