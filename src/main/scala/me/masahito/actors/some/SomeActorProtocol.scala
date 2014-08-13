package me.masahito.actors.some

import akka.actor.ActorRef

/**
 * Created by masahito on 2014/08/14.
 */
object SomeActorProtocol {
  case class SomeMessage()
  case class OtherMessage(receiver: ActorRef, msg: String)
}
