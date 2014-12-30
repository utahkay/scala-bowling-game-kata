import org.scalatest.{BeforeAndAfter, FunSuite}

class BowlingGameTest extends FunSuite with BeforeAndAfter {
  var game: BowlingGame = _

  before {
    game = new BowlingGame
  }

  test("all rolls are 0") {
    rollMany(0, 20)
    assert(0 === game.score)
  }

  test("all rolls are 1") {
    rollMany(1, 20)
    assert(20 === game.score)
  }

  test("spare") {
    rollSpare
    game.roll(4)
    rollMany(0, 17)
    assert(18 === game.score)
  }

  test("strike") {
    rollStrike
    game.roll(4)
    game.roll(3)
    rollMany(0, 16)
    assert(24 === game.score)
  }

  private def rollStrike = {
    game.roll(10)
  }

  private def rollSpare = {
    game.roll(5)
    game.roll(5)
  }

  private def rollMany(pins: Int, times: Int) = {
    for (i <- 0 until times) game.roll(pins)
  }


}
