package com.pepegar.taglessfinal

final case class EmailMessage(
  subject: String,
  body: String,
  headers: Map[String, String],
  to: String,
  from: String)

object EmailMessage {
  def create(
    subject: String = "",
    body: String = "",
    headers: Map[String, String] = Map.empty,
    to: String = "",
    from: String = ""
  ): EmailMessage =
    EmailMessage(subject, body, headers, to, from)
}

final case class User(
  id: String,
  email: String)
