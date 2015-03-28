package kavvase.android.coursera

import android.widget.TextView
import org.scaloid.common._

class TheAnswer extends SActivity {

  val answers = List(42, -10, 0, 100, 1000)
  val answer = 42

  onCreate {
    setContentView(R.layout.answer_layout)
    val answerView = find[TextView](R.id.answer_view)
    val output = findAnswer() match {
      case Some(_) => "42"
      case None    => "We may never know"
    }
    answerView text s"The answer to life, the universe and everything is:\n\n$output"
  }

  private def findAnswer(): Option[Int] = {
    answers.find(_ == answer)
  }

}
