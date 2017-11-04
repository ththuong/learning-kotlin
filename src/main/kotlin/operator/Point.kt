package operator

/**
 * Created by ththuong on 11/4/2017
 */
data class Point(val x: Int, val y: Int) {
    // overloading binary arithmetic operator
    operator fun times(other: Point): Point {
        return Point(x * other.x, y * other.y)
    }
    /**
     * you don’t need to use the same types for the two
    operands
     */
    operator fun times(scale: Double): Point {
        return Point((x * scale).toInt(), (y * scale).toInt())
    }
}

/**
 * Kotlin don't automatically support commutativity
 * (the ability to  swap the left and right sides
 * of an operator 1.5 * p, p * 1.5 )
 */
operator fun Double.times(other: Point): Point {
    return Point((this * other.x).toInt(), (this * other.y).toInt())
}
operator fun Point.plus(other: Point) : Point {
    return Point(x + other.x, y + other.y)
}

fun main(args: Array<String>) {
    val p1 = Point(1, 2)
    println(0.5 * p1)
    println(p1 * 0.5)
}
