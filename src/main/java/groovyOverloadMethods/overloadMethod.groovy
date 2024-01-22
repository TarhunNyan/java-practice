import groovy.time.TimeCategory

use(TimeCategory)  {
  println 1.minute.from.now
  // => Wed Jan 17 10:42:17 KRAT 2024
  println 10.hours.ago
  // => Wed Jan 17 00:41:17 KRAT 2024

  def someDate = new Date()
  println someDate - 3.months
  // => Tue Oct 17 10:41:17 KRAT 2023
}
