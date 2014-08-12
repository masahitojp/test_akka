package me.masahito.actors.echo

import akka.actor.Actor

/**
 * An Actor that echoes everything you send to it
 */
class EchoActor extends Actor {
  def receive = {
    case msg => {
      sender() ! msg
    }
  }
}
