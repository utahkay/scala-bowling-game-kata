/**
 * Created by kjohansen on 12/30/2014.
 */
class BowlingGame {
  var pins = List[Int]()

  def roll(pin: Int) = {
    pins = pins ::: List(pin)
  }

  def score: Int = {
    scoreAssist(0, 0, 0)
  }

  private def scoreAssist(frameIndex: Int, pinIndex: Int, score: Int): Int = {
    if (frameIndex == 10)
      score
    else if (isStrike(pinIndex))
      scoreAssist(frameIndex + 1, pinIndex + 1, score + 10 + strikeBonus(pinIndex))
    else if (isSpare(pinIndex))
      scoreAssist(frameIndex + 1, pinIndex + 2, score + 10 + spareBonus(pinIndex))
    else
      scoreAssist(frameIndex + 1, pinIndex + 2, score + normalFrameScore(pinIndex))
  }

  def isStrike(pinIndex: Int): Boolean = {
    pins(pinIndex) == 10
  }

  def strikeBonus(pinIndex: Int): Int = {
    pins(pinIndex + 1) + pins(pinIndex + 2)
  }

  def spareBonus(pinIndex: Int): Int = {
    pins(pinIndex + 2)
  }

  def isSpare(pinIndex: Int): Boolean = {
    normalFrameScore(pinIndex) == 10
  }

  def normalFrameScore(pinIndex: Int): Int = {
    pins(pinIndex) + pins(pinIndex + 1)
  }
}
