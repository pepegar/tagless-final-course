package com.pepegar.taglessfinal

import com.pepegar.taglessfinal.tagless1._
import cats.effect.IOApp
import cats.effect.IO

object Main extends IOApp.Simple {

  def run: IO[Unit] = {
    val notificationService = implicitly[NotificationService[IO]]

    notificationService.notifyUser("pepegar", "pay the thigns pepe!")
  }

}
