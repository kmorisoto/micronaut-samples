package com.example

class KtlintError {

    // No semicolons.
    fun error() {
        val v = "";
        println(v);
    }
}

// No consecutive blank lines.
// this in not a Python and you are not in PEP 8 realm
class A {}


class B {}

// No trailing whitespaces.
class C {}
class D {}

// No Unit returns.
fun f(): Unit {}

fun a(): Unit{}

// No empty class bodies.
class E {}

interface F {}

// Consistent string templates.
val a = "class = ${String::class.toString()}"
val b = "not ${a}"

