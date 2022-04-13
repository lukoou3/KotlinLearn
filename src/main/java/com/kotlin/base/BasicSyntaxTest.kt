package com.kotlin.base

import org.junit.Test

/**
 * https://kotlinlang.org/docs/basic-syntax.html
 */
class BasicSyntaxTest {

    @Test
    fun testPrint() {
        // 和scala一样
        println("print 日志")
    }

    @Test
    fun testStringTemplates() {
        val name: String = "aaa"
        val age: Int = 20
        // 和scala差不多，就是前面没有s，也就是说只要字符串中含有$就要考虑转义
        println("name: $name, age: $age, age + 1: ${age + 1}")
    }

    @Test
    fun testExpression() {
        // 和scala一样，用if代替三元表达式
        var x = 20
        val name1 = if (x > 10) "aaa" else "bbb"
        x = 8
        val name2 = if (x > 10) "aaa" else "bbb"

        println("$name1, $name2")
        // 元组的使用没scala方便
        println(Pair(name1, name2))
        println(Triple(3, name1, name2))
    }

    @Test
    fun testListForLoop() {
        // 和scala一样都有自己的集合类型，kotlin.collections.List
        val items: List<String> = listOf("apple", "banana", "kiwifruit")
        for (item in items) {
            println(item)
        }

        println()
        println("######################")
        println()

        println(items.indices)
        for (index in items.indices) {
            println("item at $index is ${items[index]}")
        }
    }

    @Test
    fun testListWhileLoop() {
        val items = listOf("apple", "banana", "kiwifruit")
        var index = 0
        while (index < items.size) {
            println("item at $index is ${items[index]}")
            index++
        }
    }

    @Test
    fun testWhenExpression() {
        val items = listOf("Hello", 1, 1L, "kiwifruit", 82.3)
        for (item in items) {
            val rst = when (item) {
                1 -> "One"
                "Hello" -> "Greeting"
                is Long -> "Long"
                !is String -> "Not a string"
                else -> "Unknown string"
            }
            println("$item => $rst")
        }

    }

    @Test
    fun testRanges() {
        // Check if a number is within a range using in operator.
        val x = 10
        val y = 9
        if (x in 1..y + 1) {
            println("fits in range")
        }

        println()
        println("######################")
        println()

        // Check if a number is out of range.
        val list = listOf("a", "b", "c")

        if (-1 !in 0..list.lastIndex) {
            println("-1 is out of range")
        }
        if (list.size !in list.indices) {
            println("list size is out of valid list indices range, too")
        }

        println()
        println("######################")
        println()

        // Iterate over a range.
        for (x in 1..5) {
            print(x)
            print(", ")
        }

        println()
        println("######################")
        println()

        // Or over a progression.
        for (x in 1..10 step 2) {
            print(x)
            print(", ")
        }
        println()
        for (x in 9 downTo 0 step 3) {
            print(x)
            print(", ")
        }
    }

    @Test
    fun testCollectionIterate() {
        val items = listOf("apple", "banana", "kiwifruit")

        for (item in items) {
            println(item)
        }
    }

    @Test
    fun testCollectionContainsUseIn() {
        val items = listOf("apple", "banana", "kiwifruit")

        // 和scala的match类似，可以代替if使用
        when {
            "orange" in items -> println("juicy")
            "apple" in items -> println("apple is fine too")
        }
    }

    @Test
    fun testCollectionFunc() {
        val fruits = listOf("banana", "avocado", "apple", "kiwifruit")

        fruits.filter { it.startsWith("a") }
                .sortedBy { it }
                .map { it.toUpperCase() }
                .forEach { println(it) }
    }
}