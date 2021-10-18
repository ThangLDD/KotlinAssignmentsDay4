data class Car(
    override var manufacturer: String,
    override var year: Int,
    override var price: Int,
    override var color: String,
    var numSeat: Int,
    var typeEngine: String
) : Vehicle(manufacturer, year, price, color)