package com.example.application

// kotlin collections

fun main() {
    // list (immutable)
    var people = listOf("ankita", "anup", "anshu", "aarav")
    println(people)

    // list (mutable)
    var mutableList = mutableListOf("Here", "There", "Where", "When")

    // sets
    val marks = setOf(11, 22, 33, 44, 55)
    for (each in marks) {
        println(each)
    }

    // map (dictionary)

    val namesAndRoles = mapOf(
        "Pawan" to "Leader",
        "Nikasutra" to "Leader",
        "Anubhav" to "Member",
        "Water" to "Element"
    )

    println("Keys: ${namesAndRoles.keys}")
    println("Values: ${namesAndRoles.values}")


    val leaders = namesAndRoles.filterValues { it == "Leader" }.keys
    println("${leaders} are leaders.")


    // mutable map
    val myImmuMap = mutableMapOf(
        "ta" to "anadar",
        "timi" to "madhyam aadar",
        "tapai" to "uchha aadar",
        "hajur" to "ati uchha aadar"
    )

    // Create a Dictionary app using mapOf() function where user will type a word and your
    // program should return the meaning of that word.

    val emotions = mapOf(
        "grief" to "intense sorrow, especially caused by someone's death.",
        "love" to "an intense feeling of deep affection.",
        "awe" to "a feeling of reverential respect mixed with fear or wonder.",
        "anger" to "a strong feeling of annoyance, displeasure, or hostility",
        "excitement" to "a feeling of great enthusiasm and eagerness.",
        "loneliness" to "a sad feeling caused by having no friends or company.",
    )

    // ask user
    print("Enter a feeling: ")
    val emotion = readLine()?.lowercase()

    if (emotion!= null) {
        val meaning = emotions[emotion]
        if (meaning != null) {
            println("${emotion.uppercase()}: ${meaning}")
        }
        else {
            println("Couldn't find that emotion.")
        }
    }
    else {
        println("Invalid input.")
    }

}