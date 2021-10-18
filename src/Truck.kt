data class Truck(
    override var manufacturer: String,
    override var year: Int,
    override var price: Int,
    override var color: String,
    var weight: Int
) : Vehicle(manufacturer, year, price, color)