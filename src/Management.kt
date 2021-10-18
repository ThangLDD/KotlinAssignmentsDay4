import java.util.*

var listCar: MutableList<Car> = mutableListOf()
var listMotor: MutableList<Motor> = mutableListOf()
var listTruck: MutableList<Truck> = mutableListOf()

var mark = false

val scanner = Scanner(System.`in`)
fun main() {
    println("\nWelcome to Vehicle Management!")
    loop@ do {
        println("\n==============================\n")
        println("Enter 1 to Add a vehicle")
        println("Enter 2 to Remove a vehicle")
        println("Enter 3 to Search a vehicle")
        println("Enter 4 to Print a group of vehicle")
        println("Enter 0 to Exit.")
        print("Enter your choice: ")
        val n = scanner.next()

        when (n) {
            "0" -> {
                println("You chose Exit Program.")
                break@loop
            }
            "1" -> addVehicle()
            "2" -> removeVehicle()
            "3" -> searchVehicle()
            "4" -> printVehicle()
        }
    } while (n != "0" && n != "1" && n != "2" && n != "3" && n != "4" || mark)
}

fun printVehicle() {
    var nPrint: String
    do {
        println("\n==============================\n")
        println("Enter type of vehicle to print:")
        println("1. Car\t2. Motor\t3. Truck")
        print("Your choice: ")
        nPrint = scanner.next()

        when (nPrint) {
            "1" -> {
                if (listCar.size == 0) {
                    println("There are no cars.")
                } else {
                    println("\nThere are ${listCar.size} car(s):")
                    for (i in listCar) {
                        println(i)
                    }
                }
                mark = true
            }
            "2" -> {
                if (listMotor.size == 0) {
                    println("There are no motors.")
                } else {
                    println("\nThere are ${listMotor.size} motor(s):")
                    for (i in listMotor) {
                        println(i)
                    }
                }
                mark = true
            }
            "3" -> {
                if (listTruck.size == 0) {
                    println("There are no trucks.")
                } else {
                    println("\nThere are ${listTruck.size} truck(s):")
                    for (i in listTruck) {
                        println(i)
                    }
                }
                mark = true
            }
        }
    } while (nPrint != "1" && nPrint != "2" && nPrint != "3")
}

fun searchVehicle() {
    var nSearch: String
    var keep = true
    do {
        println("\n==============================\n")
        println("Enter property of vehicle to search:")
        println("1. Manufacturer\t2. Color\t0. Break")
        print("Your choice: ")
        nSearch = scanner.next()

        when (nSearch) {
            "0" -> {
                println("Exit Search vehicle.")
                mark = true
                keep = false
            }
            "1" -> {
                print("Enter manufacturer of vehicle: ")
                val manu = scanner.next()
                val listSearch = mutableListOf<Vehicle>()

                println(manu)
                for (i in listCar) {
                    if (i.manufacturer.equals(manu, ignoreCase = true)) {
                        listSearch.add(i)
                    }
                }

                for (i in listMotor) {
                    if (i.manufacturer.equals(manu, ignoreCase = true)) {
                        listSearch.add(i)
                    }
                }

                for (i in listTruck) {
                    if (i.manufacturer.equals(manu, ignoreCase = true)) {
                        listSearch.add(i)
                    }
                }

                println("${listSearch.size} found ")
                for (i in listSearch) {
                    println(i)
                }
                mark = true
            }
            "2" -> {
                print("Enter color of vehicle: ")
                val color = scanner.next()
                val listSearch = mutableListOf<Vehicle>()

                for (i in listCar) {
                    if (i.color.equals(color, ignoreCase = true)) {
                        listSearch.add(i)
                    }
                }

                for (i in listMotor) {
                    if (i.color.equals(color, ignoreCase = true)) {
                        listSearch.add(i)
                    }
                }

                for (i in listTruck) {
                    if (i.color.equals(color, ignoreCase = true)) {
                        listSearch.add(i)
                    }
                }
                println("${listSearch.size} found ")
                for (i in listSearch) {
                    println(i)
                }
                mark = true
            }
        }
    } while ((nSearch != "0" && nSearch != "1" && nSearch != "2") && keep)
}

fun removeVehicle() {
    var nRemove: String
    var keep = true
    do {
        println("\n==============================\n")
        println("Enter type of vehicle to remove:")
        println("1. Car\t2. Motor\t3. Truck\t0. Break")
        print("Your choice: ")
        nRemove = scanner.next()

        when (nRemove) {
            "0" -> {
                println("Exit Remove vehicle.")
                mark = true
                keep = false
            }
            "1" -> {
                if (listCar.size == 0) {
                    println("List car is empty.")
                } else {
                    for (i in listCar) {
                        println(i)
                    }
                    print("Enter index of car: ")
                    var pos = scanner.nextInt()
                    while (pos > listCar.size) {
                        print("Enter index less than number of car: ")
                        pos = scanner.nextInt()
                    }
                    listCar.removeAt(pos - 1)
                    println("Remove successfully. List car: ")
                    for (i in listCar) {
                        println(i)
                    }
                }
                mark = true
            }
            "2" -> {
                if (listMotor.size == 0) {
                    println("List motor is empty.")
                } else {
                    for (i in listMotor) {
                        println(i)
                    }
                    print("Enter index of motor: ")
                    var pos = scanner.nextInt()
                    while (pos > listMotor.size) {
                        print("Enter index less than number of car: ")
                        pos = scanner.nextInt()
                    }
                    listMotor.removeAt(pos - 1)
                    println("Remove successfully. List motor: ")
                    for (i in listMotor) {
                        println(i)
                    }
                }
                mark = true
            }
            "3" -> {
                if (listTruck.size == 0) {
                    println("List truch is empty.")
                } else {
                    for (i in listTruck) {
                        println(i)
                    }
                    print("Enter index of truck: ")
                    var pos = scanner.nextInt()
                    while (pos > listTruck.size) {
                        print("Enter index less than number of car: ")
                        pos = scanner.nextInt()
                    }
                    listTruck.removeAt(pos - 1)
                    println("Remove successfully. List truck: ")
                    for (i in listTruck) {
                        println(i)
                    }
                }
                mark = true
            }
        }
    } while ((nRemove != "0" && nRemove != "1" && nRemove != "2" && nRemove != "3") && keep)
}

fun addVehicle() {
    var nAdd: String
    var keep = true
    do {
        println("\n==============================\n")
        println("Enter type of vehicle to add:")
        println("1. Car\t2. Motor\t3. Truck\t0. Break")
        print("Your choice: ")
        nAdd = scanner.next()

        when (nAdd) {
            "0" -> {
                println("Exit Add vehicle.")
                mark = true
                keep = false
            }
            "1" -> {
                print("Enter manufacturer: ")
                val manufacturer = scanner.next()
                print("Enter year: ")
                val year = scanner.nextInt()
                print("Enter price: ")
                val price = scanner.nextInt()
                print("Enter color: ")
                val color = scanner.next()
                print("Enter number of seat: ")
                val numSeat = scanner.nextInt()
                print("Enter type of engine: ")
                val typeEngine = scanner.next()

                val car = Car(manufacturer, year, price, color, numSeat, typeEngine)
                listCar.add(car)
                println("Add successfully. There are ${listCar.size} cars.")
                for (i in listCar) {
                    println(i)
                }
                mark = true
            }
            "2" -> {
                print("Enter manufacturer: ")
                val manufacturer = scanner.next()
                print("Enter year: ")
                val year = scanner.nextInt()
                print("Enter price: ")
                val price = scanner.nextInt()
                print("Enter color: ")
                val color = scanner.next()
                print("Enter power: ")
                val power = scanner.nextInt()

                val motor = Motor(manufacturer, year, price, color, power)
                listMotor.add(motor)
                println("Add successfully. There are ${listMotor.size} cars.")
                for (i in listMotor) {
                    println(i)
                }
                mark = true
            }
            "3" -> {
                print("Enter manufacturer: ")
                val manufacturer = scanner.next()
                print("Enter year: ")
                val year = scanner.nextInt()
                print("Enter price: ")
                val price = scanner.nextInt()
                print("Enter color: ")
                val color = scanner.next()
                print("Enter weight: ")
                val weight = scanner.nextInt()

                val truck = Truck(manufacturer, year, price, color, weight)
                listTruck.add(truck)
                println("Add successfully. There are ${listTruck.size} cars.")
                for (i in listTruck) {
                    println(i)
                }
                mark = true
            }
        }
    } while ((nAdd != "0" && nAdd != "1" && nAdd != "2" && nAdd != "3") && keep)
}