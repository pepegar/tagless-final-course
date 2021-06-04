package com.pepegar.taglessfinal.tagless2

import com.pepegar.taglessfinal.{EmailMessage, User}
import cats.effect.Sync

trait EmailSender[F[_]] {
  def sendEmail(emailMessage: EmailMessage): F[Unit]
}
object EmailSender {

  implicit def instance[F[_]: Sync]: EmailSender[F] =
    new EmailSender[F] {
      def sendEmail(emailMessage: EmailMessage): F[Unit] =
        Sync[F].delay(println(s"email sent: $emailMessage"))
    }

}









trait UserRepository[F[_]] {
  def retrieveUser(id: String): F[Option[User]]
}
object UserRepository { 

  implicit def instance[F[_]: Sync]: UserRepository[F] =
    new UserRepository[F] {
      def retrieveUser(id: String): F[Option[User]] =
        Sync[F].pure(Some(User(id, "foo@email.com")))
    }
}








trait NotificationService[F[_]] {
  def notifyUser(id: String, message: String): F[Unit]
}
object NotificationService {
  // TODO: Implement
}
