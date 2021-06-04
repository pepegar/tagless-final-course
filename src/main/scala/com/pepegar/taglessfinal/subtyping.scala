package com.pepegar.taglessfinal.subtyping


import com.pepegar.taglessfinal.{EmailMessage, User}


trait EmailSender {
  def sendEmail(emailMessage: EmailMessage): Unit
}
class EmailSenderImpl() extends EmailSender {
  def sendEmail(emailMessage: EmailMessage): Unit =
    println("email sent")
}









trait UserRepository {
  def retrieveUser(id: String): Option[User]
}
class UserRepositoryImpl() extends UserRepository {
  def retrieveUser(id: String): Option[User] =
    Some(User(id, "foo@email.com"))
}








trait NotificationService {
  def notifyUser(id: String, message: String): Unit
}
class NotificationServiceImpl(
  // TODO: Add dependencies
  ) extends NotificationService {
  // TODO: Implement together
  def notifyUser(id: String, message: String): Unit = ???
}
