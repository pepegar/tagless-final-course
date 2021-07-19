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
  emailSender: EmailSender,
  userRepository: UserRepository
  ) extends NotificationService {

  def notifyUser(id: String, message: String): Unit = {
    val maybeUser = userRepository.retrieveUser(id)

    maybeUser match {
	    case Some(user) =>
        val emailMessage = EmailMessage.create(to = user.email, body = message)

        emailSender.sendEmail(emailMessage)
	    case None =>
        throw new Exception("user doesn't exist")
    }
  }
}
