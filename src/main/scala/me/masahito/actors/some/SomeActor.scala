package me.masahito.actors.some

import akka.actor.{ActorLogging, Actor}

/**
 * Created by masahito on 2014/08/14.
 */
class SomeActor extends Actor with ActorLogging {
  import SomeActorProtocol._

    self ! SomeMessage


  override def receive = initial

  def unstashAll() {
    log.info("unstashAll")
  }

  def stash() {
    log.info("stash")
  }

  def initial: Receive = {
    case SomeMessage =>
      // do stuff
      unstashAll()
      context become initialized
    case _ => stash()
  }

  def initialized: Receive = {
    case OtherMessage(receiver, msg) => {
      log.info("received other message : {}", msg)
      receiver ! msg
    }
    case _ => log.info("initialized")
  }

}
