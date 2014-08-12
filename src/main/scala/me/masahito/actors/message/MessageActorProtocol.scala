package me.masahito.actors.message

import akka.actor.ActorRef

object MessageActorProtocol {
  case class Message(data: String)
  case class GetState(receiver: ActorRef)
}
