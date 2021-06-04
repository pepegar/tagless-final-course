package com.pepegar.taglessfinal.effects

import com.pepegar.taglessfinal.{EmailMessage, User}

import cats.effect.IO

trait EmailSender[F[_]] {
  def sendEmail(emailMessage: EmailMessage): F[Unit]
}
class EmailSenderImpl() extends EmailSender[IO] {

  def sendEmail(emailMessage: EmailMessage): IO[Unit] =
    IO(println(s"email sent: $emailMessage"))

}









trait UserRepository[F[_]] {
  def retrieveUser(id: String): F[Option[User]]
}
class UserRepositoryImpl() extends UserRepository[IO] {
  def retrieveUser(id: String): IO[Option[User]] =
    IO.pure(Some(User(id, "foo@email.com")))
}








trait NotificationService[F[_]] {
  def notifyUser(id: String, message: String): F[Unit]
}
class NotificationServiceImpl(
  // TODO: Add dependencies
  ) extends NotificationService[IO] {
  // TODO: Implement together
  def notifyUser(id: String, message: String): IO[Unit] = ???
}
