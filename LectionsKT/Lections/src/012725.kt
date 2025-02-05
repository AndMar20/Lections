package person.Person 
fun main() {
val bob = Person()
    bob.name = "Bob"
    println(bob.name)
    println(bob.age)
}

// для определения класс
class Person constructor(_name: String){
    var name: String = "Noname"
    var age: Int = 18

    constructor(_name: String, _age: Int): this(_name){
        name = _name
        age = _age
    }

    fun sayHello(){
        println("Hello, I'm $name")
    }
}