import java.lang.IllegalArgumentException

class Address(val street: String, val streetNumber: Int, val aptNumber: Int, val postalCode: String, val city: String, val country: String){
    init{
        if(postalCode.isEmpty() || !postalCode.matches(Regex("^\\d{2}-\\d{3}\$"))){
            throw IllegalArgumentException("${postalCode} nie jest właściwym kodem pocztowym!")
        }
        if(aptNumber <0 || streetNumber<0){
            throw IllegalArgumentException("Niewłaściwy numer ulicy lub mieszkania.")
        }
    }
}

class Person(val name: String, surname:String){

}

class Palace(val name: String, val address: Address, val owner: Person, val yearBuilt: Int, val numberOfRooms: Int ){
    init{
        if(yearBuilt< 0){
            throw IllegalArgumentException("Rok musi być większy od roku zerowego.")
        }
        if(numberOfRooms< 0){
            throw IllegalArgumentException("Liczba pokoi musi być większa od zera.")
        }
    }
}

fun main(){
    val palac1 = Palace("palacyk1", Address("Orzechowa", 1, 12, "00-222", "Warszawa", "Polska"), Person("Jan", "Kowalski"), 1200, 3 )
    val palac2 = Palace("palacyk2", Address("Klonowa", 5, 7, "11-333", "Kraków", "Polska"), Person("Anna", "Nowak"), 1500, 4 )
    val palac3 = Palace("pałac3", Address("Brzozowa", 3, 8, "22-444", "Wrocław", "Polska"), Person("Marek", "Nowicki"), 1000, 2 )
}