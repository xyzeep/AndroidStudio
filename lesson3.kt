package com.example.application


// fundamentals of kotlin

fun main() {
    // variables
    var age = 45 // mutable
    val name = "Pawan" //immutable

    // data types
    var isTrue: Boolean = true
    var myChar: Char = 'a'
    var myFloat: Float = 135.3535f
    // and so on

    // type conversion in kotlin
    var number: Int = 4444
    var myString: String = number.toString()

    println(myString)

    // Strings

    var fullName: String = "Pawan Acharya"
    // string functions
    println(fullName.isEmpty())
    println(fullName.length)
    print(fullName.uppercase())
    println(fullName.plus(": The Great!"))
}





