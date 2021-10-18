data class Motor(
    override var manufacturer: String,
    override var year: Int,
    override var price: Int,
    override var color: String,
    var power: Int
) : Vehicle(manufacturer, year, price, color)