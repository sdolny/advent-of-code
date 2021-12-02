fun main() {
    fun part1(input: List<String>): Int {
        return input.map(String::toInt)
            .zipWithNext()
            .count { it.second > it.first }
    }

    fun part2(input: List<String>): Int {
        return input.map(String::toInt)
            .windowed(size = 3, step = 1)
            .map { it.sum() }
            .zipWithNext()
            .count { it.second > it.first }
    }

    val testInput = readInput("Day01_test")
    check(part1(testInput) == 7)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}