package me.masahito.actors.message

import akka.actor.Actor

class MessageActor extends Actor {
  import MessageActorProtocol._

  var internalState = Vector[String]()

  def receive = {
    case Message(data) => internalState = internalState :+ data
    case GetState(receiver)  => receiver ! internalState
  }

  def state = internalState
}
