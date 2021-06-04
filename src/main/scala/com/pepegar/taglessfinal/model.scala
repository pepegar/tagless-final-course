package com.pepegar.taglessfinal

final case class EmailAddress(value: String) extends AnyVal

final case class EmailMessage(
  subject: String,
  body: String,
  headers: Map[String, String],
  to: EmailAddress,
  from: EmailAddress)

object EmailMessage {
  def create(
    subject: String = "",
    body: String = "",
    headers: Map[String, String] = Map.empty,
    to: EmailAddress = EmailAddress(""),
    from: EmailAddress = EmailAddress("")
  ): EmailMessage =
    EmailMessage(subject, body, headers, to, from)
}

final case class User(
  id: String,
  email: String)
