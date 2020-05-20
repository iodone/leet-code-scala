package WordSearch

/**
  * Created by iodone on {19-9-27}.
  */

/**
  * 解题报告
  * 
  * 说明：路径search的问题，一般都是采用回溯的算法。
  * 
  * 思路：构建二维path记录表，也就是visited表用于标记已经走过的点
  *      1. search 路径，有四个方向，上下左右
  *      2. word的search可以分解成head + 四个子问题，一旦有成功的就返回
  *      3. visited标记后，需要回溯还原
  */

object Solution {
  def exist(board: Array[Array[Char]], word: String): Boolean = {
    val rows = board.length
    val colmuns = board(0).length
    val visited = Array.fill(rows, colmuns)(false)
    for (i <- 0 until rows) {
      for (j <- 0 until colmuns) {
        if (searchWord(word, visited, (i, j), board)) return true
      }
    }
    false
  }

  def isInBoard(position: (Int, Int), boad: Array[Array[Char]]) = {
    position._1 < boad.length && position._1 >= 0 && position._2 < boad(0).length && position._2 >= 0
  }

  def searchWord(word: String, visited: Array[Array[Boolean]], position: (Int, Int), board: Array[Array[Char]]): Boolean = {
    val nextActions = Array((0,-1),(-1,0),(0,1),(1,0))

    if (word.isEmpty) true
    else if (isInBoard(position, board) && word.head == board(position._1)(position._2) && !visited(position._1)(position._2)) {
      visited(position._1)(position._2) = true
      for (action <- nextActions) {
        val nextPosition = (action._1 + position._1, action._2 + position._2)
        if (searchWord(word.tail, visited, nextPosition, board) ) return true
      }
      visited(position._1)(position._2) = false
      false
    } else {
      false
    }
  }

  def main(args: Array[String]): Unit = {
    val board = Array(
      Array('A','B','C','E'),
      Array('S','F','C','S'),
      Array('A','D','E','E')
    )
    println(exist(board, "ABCCED"))
    println(exist(board, "SEE"))
    println(exist(board, "ABCB"))
  }
}
