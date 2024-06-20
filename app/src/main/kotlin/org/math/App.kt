package org.example

import kotlin.math.PI


fun main() {
}

class CleanMath {
    companion object {
        fun sum(vararg numbers: Number): Double {
            return numbers.sumOf { it.toDouble() }
        }

        fun subtract(vararg numbers: Number): Double {
            if (numbers.isEmpty()) return 0.0
            return numbers.map { it.toDouble() }.reduce { acc, i -> acc - i }
        }

        fun multiply(vararg numbers: Number): Double {
            if (numbers.isEmpty()) return 0.0
            return numbers.map { it.toDouble() }.reduce { acc, i -> acc * i }
        }

        fun divide(vararg numbers: Number): Double {
            if (numbers.isEmpty()) return 0.0
            return numbers.map { it.toDouble() }.reduce { acc, i -> acc / i }
        }

        fun power(base: Number, exponent: Number): Double {
            var result = 1.0
            for (i in 1..exponent.toInt()) {
                result *= base.toDouble()
            }
            return result
        }
        
        fun modulo(dividend: Number, divisor: Number): Double {
            return dividend.toDouble() % divisor.toDouble()
        }
        
        fun absolute(value: Number): Double {
            val doubleValue = value.toDouble()
            return if (doubleValue < 0) -doubleValue else doubleValue
        }
        
        fun factorial(n: Number): Double {
            var result = 1.0
            for (i in 2..n.toInt()) {
                result *= i
            }
            return result
        }
        
        fun squareRoot(n: Number): Double {
            var x = n.toDouble()
            var y = 1.0
            val e = 0.000001
            while (x - y > e) {
                x = (x + y) / 2
                y = n.toDouble() / x
            }
            return x
        }
        
        fun cubeRoot(n: Number): Double {
            var x = n.toDouble()
            var y: Double
            do {
                y = x
                x = ((n.toDouble() / (y * y)) + 2 * y) / 3
            } while (absolute(y - x) > 0.000001)
            return x
        }
        
        fun log(base: Number, x: Number): Double {
            val numerator = ln(x)
            val denominator = ln(base)
            return numerator / denominator
        }
        
        fun ln(x: Number): Double {
            val n = 1000.0
            val a = x.toDouble() - 1
            var sum = 0.0
            for (i in 1..n.toInt()) {
                if (i % 2 != 0) {
                    sum += power(a, i) / i.toDouble()
                } else {
                    sum -= power(a, i) / i.toDouble()
                }
            }
            return sum
        }

        fun cos(x: Number): Double {
            var sum = 0.0
            for (i in 0..10) {
                val coefficient = if (i % 2 == 0) 1 else -1
                val numerator = power(x.toDouble(), 2 * i)
                val denominator = factorial(2 * i)
                sum += coefficient * (numerator / denominator)
            }
            return sum
        }
        
        fun sin(x: Number): Double {
            var sum = 0.0
            for (i in 0..10) {
                val coefficient = if (i % 2 == 0) 1 else -1
                val numerator = power(x.toDouble(), 2 * i + 1)
                val denominator = factorial(2 * i + 1)
                sum += coefficient * (numerator / denominator)
            }
            return sum
        }
        
        fun tan(x: Number): Double {
            return sin(x) / cos(x)
        }

        fun asin(x: Number): Double {
            var sum = 0.0
            val z = x.toDouble()
            for (i in 0..10) {
                val numerator = factorial(2 * i) * power(z, 2 * i + 1)
                val denominator = power(4, i) * power(factorial(i), 2) * (2 * i + 1)
                sum += numerator / denominator
            }
            return sum
        }
        
        fun acos(x: Number): Double {
            return Math.PI / 2 - asin(x)
        }
        
        fun atan(x: Number): Double {
            var sum = 0.0
            val z = x.toDouble()
            for (i in 0..10) {
                val coefficient = if (i % 2 == 0) 1 else -1
                val numerator = coefficient * power(z, 2 * i + 1)
                val denominator = 2 * i + 1
                sum += numerator / denominator
            }
            return sum
        }
        
        fun toRadians(degrees: Number): Double {
            return degrees.toDouble() * Math.PI / 180
        }
        
        fun toDegrees(radians: Number): Double {
            return radians.toDouble() * 180 / Math.PI
        }

        fun hypotenuse(adjacent: Number, opposite: Number): Double {
            return squareRoot(power(adjacent, 2) + power(opposite, 2))
        }

        fun areaOfCircle(radius: Number): Double {
            return PI * power(radius, 2)
        }

        fun circumferenceOfCircle(radius: Number): Double {
            return 2 * PI * radius.toDouble()
        }

        fun areaOfRectangle(length: Number, width: Number): Double {
            return length.toDouble() * width.toDouble()
        }

        fun perimeterOfRectangle(length: Number, width: Number): Double {
            return 2 * (length.toDouble() + width.toDouble())
        }

        fun areaOfSquare(side: Number): Double {
            return power(side, 2)
        }

        fun perimeterOfSquare(side: Number): Double {
            return 4 * side.toDouble()
        }

        fun areaOfTriangle(base: Number, height: Number): Double {
            return 0.5 * base.toDouble() * height.toDouble()
        }

        fun perimeterOfTriangle(side1: Number, side2: Number, side3: Number): Double {
            return side1.toDouble() + side2.toDouble() + side3.toDouble()
        }

        fun volumeOfCube(side: Number): Double {
            return power(side, 3)
        }

        fun surfaceAreaOfCube(side: Number): Double {
            return 6 * power(side, 2)
        }

        fun volumeOfCuboid(length: Number, width: Number, height: Number): Double {
            return length.toDouble() * width.toDouble() * height.toDouble()
        }

        fun surfaceAreaOfCuboid(length: Number, width: Number, height: Number): Double {
            return 2 * (length.toDouble() * width.toDouble() + width.toDouble() * height.toDouble() + height.toDouble() * length.toDouble())
        }

        fun volumeOfCylinder(radius: Number, height: Number): Double {
            return PI * power(radius, 2) * height.toDouble()
        }

        fun surfaceAreaOfCylinder(radius: Number, height: Number): Double {
            return 2 * PI * radius.toDouble() * (radius.toDouble() + height.toDouble())
        }

        fun volumeOfCone(radius: Number, height: Number): Double {
            return 1.0 / 3.0 * PI * power(radius, 2) * height.toDouble()
        }

        fun surfaceAreaOfCone(radius: Number, height: Number): Double {
            val l = squareRoot(power(radius, 2) + power(height, 2))
            return PI * radius.toDouble() * (radius.toDouble() + l)
        }

        fun volumeOfSphere(radius: Number): Double {
            return 4.0 / 3.0 * PI * power(radius, 3)
        }

        fun surfaceAreaOfSphere(radius: Number): Double {
            return 4 * PI * power(radius, 2)
        }

        fun volumeOfPyramid(baseArea: Number, height: Number): Double {
            return 1.0 / 3.0 * baseArea.toDouble() * height.toDouble()
        }

        fun surfaceAreaOfPyramid(baseArea: Number, basePerimeter: Number, slantHeight: Number): Double {
            return 0.5 * basePerimeter.toDouble() * slantHeight.toDouble() + baseArea.toDouble()
        }

        fun volumeOfPrism(baseArea: Number, height: Number): Double {
            return baseArea.toDouble() * height.toDouble()
        }

        fun surfaceAreaOfPrism(basePerimeter: Number, baseApothem: Number, height: Number): Double {
            return basePerimeter.toDouble() * (baseApothem.toDouble() + height.toDouble()) + 2 * basePerimeter.toDouble()
        }

        fun volumeOfTetrahedron(baseArea: Number, height: Number): Double {
            return 1.0 / 3.0 * baseArea.toDouble() * height.toDouble()
        }

        fun surfaceAreaOfTetrahedron(baseArea: Number, side: Number): Double {
            return baseArea.toDouble() + 3 * power(side, 2)
        }

        fun volumeOfOctahedron(side: Number): Double {
            return 1.0 / 3.0 * squareRoot(2) * power(side, 3)
        }

        fun surfaceAreaOfOctahedron(side: Number): Double {
            return 2 * squareRoot(3) * power(side, 2)
        }

        fun volumeOfDodecahedron(side: Number): Double {
            return 1.0 / 4.0 * (15 + 7 * squareRoot(5)) * power(side, 3)
        }

        fun surfaceAreaOfDodecahedron(side: Number): Double {
            return 3 * squareRoot(25 + 10 * squareRoot(5)) * power(side, 2)
        }

        fun volumeOfIcosahedron(side: Number): Double {
            return 5.0 / 12.0 * (3 + squareRoot(5)) * power(side, 3)
        }

        fun surfaceAreaOfIcosahedron(side: Number): Double {
            return 5 * squareRoot(3) * power(side, 2)
        }

        fun isPrime(n: Number): Boolean {
            if (n.toInt() < 2) return false
            for (i in 2..squareRoot(n).toInt()) {
                if (n.toInt() % i == 0) return false
            }
            return true
        }

        fun isEven(n: Number): Boolean {
            return n.toInt() % 2 == 0
        }

        fun isOdd(n: Number): Boolean {
            return n.toInt() % 2 != 0
        }

        fun isPerfectSquare(n: Number): Boolean {
            val squareRoot = squareRoot(n)
            return squareRoot == squareRoot.toInt().toDouble()
        }

        fun isArmstrongNumber(n: Number): Boolean {
            val digits = n.toString().length
            var sum = 0.0
            var temp = n.toInt()
            while (temp != 0) {
                val remainder = temp % 10
                sum += power(remainder, digits)
                temp /= 10
            }
            return sum == n.toDouble()
        }

        fun isPalindrome(n: Number): Boolean {
            return n.toString() == n.toString().reversed()
        }

        fun gcd(a: Number, b: Number): Int {
            return if (b.toInt() == 0) a.toInt() else gcd(b, a.toInt() % b.toInt())
        }

        fun lcm(a: Number, b: Number): Int {
            return a.toInt() * b.toInt() / gcd(a, b)
        }

        fun fibonacci(n: Number): Int {
            if (n.toInt() <= 1) return n.toInt()
            var a = 0
            var b = 1
            var c = 0
            for (i in 2..n.toInt()) {
                c = a + b
                a = b
                b = c
            }
            return c
        }

        fun reverse(n: Number): Int {
            var reversed = 0
            var temp = n.toInt()
            while (temp != 0) {
                val remainder = temp % 10
                reversed = reversed * 10 + remainder
                temp /= 10
            }
            return reversed
        }

        fun sumOfDigits(n: Number): Int {
            var sum = 0
            var temp = n.toInt()
            while (temp != 0) {
                sum += temp % 10
                temp /= 10
            }
            return sum
        }

        fun productOfDigits(n: Number): Int {
            var product = 1
            var temp = n.toInt()
            while (temp != 0) {
                product *= temp % 10
                temp /= 10
            }
            return product
        }

        fun countDigits(n: Number): Int {
            return n.toString().length
        }

        fun isPerfectNumber(n: Number): Boolean {
            var sum = 0
            for (i in 1 until n.toInt()) {
                if (n.toInt() % i == 0) {
                    sum += i
                }
            }
            return sum == n.toInt()
        }

        fun isStrongNumber(n: Number): Boolean {
            var sum = 0
            var temp = n.toInt()
            while (temp != 0) {
                sum += factorial(temp % 10).toInt()
                temp /= 10
            }
            return sum == n.toInt()
        }

        fun isHarshadNumber(n: Number): Boolean {
            return n.toInt() % sumOfDigits(n) == 0
        }

        fun isAbundantNumber(n: Number): Boolean {
            return sumOfFactors(n) > n.toInt()
        }

        fun sumOfFactors(n: Number): Int {
            var sum = 0
            for (i in 1 until n.toInt()) {
                if (n.toInt() % i == 0) {
                    sum += i
                }
            }
            return sum
        }

        fun isAutomorphicNumber(n: Number): Boolean {
            val square = power(n, 2)
            return square.toString().endsWith(n.toString())
        }

        fun isDisariumNumber(n: Number): Boolean {
            var sum = 0
            var temp = n.toInt()
            var length = n.toString().length
            while (temp != 0) {
                val remainder = temp % 10
                sum += power(remainder, length).toInt()
                temp /= 10
                length--
            }
            return sum == n.toInt()
        }

        fun isKaprekarNumber(n: Number): Boolean {
            val square = power(n, 2)
            val digits = square.toString().length
            val divisor = power(10, digits / 2)
            val sum = square / divisor + square % divisor
            return sum == n.toDouble()
        }

        fun isNarcissisticNumber(n: Number): Boolean {
            val digits = n.toString().length
            var sum = 0
            var temp = n.toInt()
            while (temp != 0) {
                sum += power(temp % 10, digits).toInt()
                temp /= 10
            }
            return sum == n.toInt()
        }

        fun isPronicNumber(n: Number): Boolean {
            for (i in 1 until n.toInt()) {
                if (i * (i + 1) == n.toInt()) {
                    return true
                }
            }
            return false
        }

        fun isSmithNumber(n: Number): Boolean {
            var sumOfDigits = sumOfDigits(n)
            var sumOfPrimeFactors = 0
            var temp = n.toInt()
            for (i in 2..temp) {
                while (temp % i == 0) {
                    sumOfPrimeFactors += sumOfDigits(i)
                    temp /= i
                }
            }
            if (temp > 1) {
                sumOfPrimeFactors += sumOfDigits(temp)
            }
            return sumOfDigits == sumOfPrimeFactors
        }

        fun isHappyNumber(n: Number): Boolean {
            var slow = n.toInt()
            var fast = n.toInt()
            do {
                slow = sumOfSquaresOfDigits(slow)
                fast = sumOfSquaresOfDigits(sumOfSquaresOfDigits(fast))
            } while (slow != fast)
            return slow == 1
        }

        fun sumOfSquaresOfDigits(n: Int): Int {
            var sum = 0
            var temp = n
            while (temp != 0) {
                sum += power(temp % 10, 2).toInt()
                temp /= 10
            }
            return sum
        }
    }
}

class CleanCalculus {
    companion object {
        fun differentiate(expression: String): String {
            val terms = expression.split("+")
            return terms.joinToString("+") { term ->
                val parts = term.split("x^")
                val coefficient = parts[0].trim().toDouble()
                val exponent = parts[1].trim().toInt()
                "${coefficient * exponent}x^${exponent - 1}"
            }
        }

        fun integrate(expression: String): String {
            val terms = expression.split("+")
            return terms.joinToString("+") { term ->
                val parts = term.split("x^")
                val coefficient = parts[0].trim().toDouble()
                val exponent = parts[1].trim().toInt()
                "${coefficient / (exponent + 1)}x^${exponent + 1}"
            }
        }

        
    }
}
