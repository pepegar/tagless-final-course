package com.pepegar.taglessfinal.effects

import com.pepegar.taglessfinal.{EmailMessage, User}

import cats.effect.IO

trait EmailSender {
  def sendEmail(emailMessage: EmailMessage): IO[Unit]
}
class EmailSenderImpl() extends EmailSender {

  def sendEmail(emailMessage: EmailMessage): IO[Unit] =
    IO(println(s"email sent: $emailMessage"))

}









trait UserRepository {
  def retrieveUser(id: String): IO[Option[User]]
}
class UserRepositoryImpl() extends UserRepository {
  def retrieveUser(id: String): IO[Option[User]] =
    IO.pure(Some(User(id, "foo@email.com")))
}








trait NotificationService {
  def notifyUser(id: String, message: String): IO[Unit]
}
class NotificationServiceImpl(
  // TODO: Add dependencies
  ) extends NotificationService {
  // TODO: Implement together
  def notifyUser(id: String, message: String): IO[Unit] = ???
}
