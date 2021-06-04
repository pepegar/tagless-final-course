package com.pepegar.taglessfinal.tagless1

import com.pepegar.taglessfinal.{EmailMessage, User}

import cats.effect.IO

trait EmailSender[F[_]] {
  def sendEmail(emailMessage: EmailMessage): F[Unit]
}
object EmailSender {

  implicit val instance: EmailSender[IO] =
    new EmailSender[IO] {
      def sendEmail(emailMessage: EmailMessage): IO[Unit] =
        IO(println(s"email sent: $emailMessage"))
    }

}









trait UserRepository[F[_]] {
  def retrieveUser(id: String): F[Option[User]]
}
object UserRepository { 

  implicit val instance: UserRepository[IO] =
    new UserRepository[IO] {
      def retrieveUser(id: String): IO[Option[User]] =
        IO.pure(Some(User(id, "foo@email.com")))
    }
}








trait NotificationService[F[_]] {
  def notifyUser(id: String, message: String): F[Unit]
}
object NotificationService {
  // TODO: Implement
}
