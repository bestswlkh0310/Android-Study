package com.example.composepractice.util

import java.math.BigInteger

object Calculator {
    fun factorial(n: Int): BigInteger {
        return when {
            n < 0 -> throw IllegalArgumentException("음수는 계산할 수 없습니다.")
            n <= 1 -> BigInteger.ONE
            else -> {
                var result = BigInteger("1")
                for (i in 1 .. n) {
                    result *= BigInteger("$i")
                }
                result
            }
        }
    }
}