package com.example.application



fun main() {
    // arithmetic operations
    // +, -, *, /
    var num1 = 20
    var num2 = 10

    var add = num1 + num2
    var sub = num1 - num2
    var product = num1 * num2
    var div = num1 / num2

    println("Addition: ${add}")
    println("Subtraction: ${sub}")
    println("Product: ${product}")
    println("Division: ${div}")

    // assignment operators
    // =
    var a = 10
    var b = 20

    // += , -=, *=, /=
    a += 10
    b -= 10
    a *= 2
    b /= 1

    a++
    b--

    println("Is a equal to b?: ${a == b}")
    println("Is a greater than b?: ${a > b}")
    println("Is a smaller than b?: ${a < b}")
    println("Are a and b different: ${a != b}")

    // && and, || or

    val val1 = true
    val val2 = false
    println("AND &&: ${val1 && val2}")
    println("OR ||: ${val1 || val2}")
}