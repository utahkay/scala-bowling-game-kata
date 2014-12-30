class BowlingGame {
  var rolls = List[Int]()

  def roll(pins: Int) = {
    rolls = rolls ::: List(pins)
  }

  def score: Int = {
    scoreAssist(0, 0, 0)
  }

  private def scoreAssist(frame: Int, roll: Int, score: Int): Int = {
    if (frame == 10)
      score
    else if (isStrike(roll))
      scoreAssist(frame + 1, roll + 1, score + 10 + strikeBonus(roll))
    else if (isSpare(roll))
      scoreAssist(frame + 1, roll + 2, score + 10 + spareBonus(roll))
    else
      scoreAssist(frame + 1, roll + 2, score + normalFrameScore(roll))
  }

  private def isStrike(roll: Int): Boolean = {
    rolls(roll) == 10
  }

  private def strikeBonus(roll: Int): Int = {
    rolls(roll + 1) + rolls(roll + 2)
  }

  private def spareBonus(roll: Int): Int = {
    rolls(roll + 2)
  }

  private def isSpare(roll: Int): Boolean = {
    rolls(roll) + rolls(roll + 1) == 10
  }

  private def normalFrameScore(roll: Int): Int = {
    rolls(roll) + rolls(roll + 1)
  }
}