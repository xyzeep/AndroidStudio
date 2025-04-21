package com.example.application

//Control Flow statement

fun main() {

    // if else
    var age = 19
    if (age >= 21) {
        println("You can drink alcohol.")
    }
    else {
        println("You cannot drink alcohol.")
    }

    print("Age: ")
    var yourAge: Int = readln().toInt()
    if (yourAge < 13) {
        println("Child")
    } else if (yourAge < 19) {
        println("Teenager")
    } else {
        if (yourAge < 50) {
            println("Adult")
        } else {
            println("Senior")
        }
    }

    // when
    print("Enter a number between 1 and 3: ")
    val input = readLine()?.toInt()
    when (input) {
        1 -> println("You chose One.")
        2 -> println("You chose Two.")
        3 -> println("You chose Three.")
        else -> println("Invalid input. Please enter 1, 2, or 3.")
    }

    // for loop
    for (i in 1..5){
        println("meow..")
    }

    // for each
    val meroList = listOf("halla", "bhid", "jhilimili")
    for (each in meroList) {
        println(each)
    }

    // while
    var cond = true
    var counter: Int = 0
    while (cond) {
        println("Najane gaun ko kina thegana sodhnu?")
        counter++
        if (counter > 4) {
            cond = false
        }
    }

    // do while
    var num = 1
    do {
        println("\n${num}")
        num ++
    } while (num < 7)
}