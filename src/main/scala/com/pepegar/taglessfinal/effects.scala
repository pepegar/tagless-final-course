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
  emailSender: EmailSender,
  userRepository: UserRepository
  ) extends NotificationService {

  def notifyUser(id: String, message: String): IO[Unit] = {

    for {
      maybeUser <- userRepository.retrieveUser(id)
      _ <- maybeUser match {
	      case Some(user) =>
          val emailMessage = EmailMessage.create(to = user.email, body = message)

          emailSender.sendEmail(emailMessage)
	      case None =>
          IO.raiseError(new Exception("no user"))
      }
    } yield ()
  }
}
