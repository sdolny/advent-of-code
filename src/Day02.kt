fun main() {
    data class Sum(val position: Int = 0, val depth: Int = 0, val aim: Int = 0)

    fun extractMoves(input: List<String>) = input.map {
        val move = it.split(' ')
        Pair(move[0], move[1].toInt())
    }

    fun part1(input: List<String>): Int {
        val moves = extractMoves(input)

        val forward = moves.filter { it.first == "forward" }.sumOf { it.second }
        val up = moves.filter { it.first == "up" }.sumOf { it.second }
        val down = moves.filter { it.first == "down" }.sumOf { it.second }

        val depth = down - up
        return forward * depth
    }

    fun part2(input: List<String>): Int {
        val moves = extractMoves(input)

        val result = moves.fold(Sum()) { s, b ->
            when (b.first) {
                "up" -> Sum(position = s.position, depth = s.depth, aim = s.aim - b.second)
                "down" -> Sum(position = s.position, depth = s.depth, aim = s.aim + b.second)
                else -> Sum(position = s.position + b.second, depth = s.depth + (s.aim * b.second), aim = s.aim)
            }
        }

        return result.position * result.depth
    }

    val testInput = readInput("Day02_test")
    check(part1(testInput) == 150)
    check(part2(testInput) == 900)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
// 578, 586, 596