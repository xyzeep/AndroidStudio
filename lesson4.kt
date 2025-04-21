package com.example.application

//arrays

fun main() {

    // array of is static (fixed length)
    var marks = arrayOf(77, 88, 99, 67)
    println(marks) //gives memory address

    // arrayListOf
    var ages = arrayListOf<Int>()

    for (i in 0..5){
        ages.add(i * 2)
        println(ages[i])
    }

    var names = arrayListOf<String>()
    names.add("Pawan")
    names.add("Prabin")
    names.add("Sabin")
    names.add("Vitti")
    names.add("Aalu")

    names.remove("Prabin")
    names.removeAt(2)
}