package me.masahito.actors.some

import org.scalatest.{Matchers, WordSpecLike, FunSuite}
import akka.testkit.{TestActorRef, ImplicitSender, TestKit}
import akka.actor.{Props, ActorSystem}
import me.masahito.actors.message.{MessageActor, MessageActorProtocol}
import me.masahito.actors.message.MessageActorProtocol.Message
import me.masahito.actors.StopSystemAfterAll

/**
 * Created by masahito on 2014/08/14.
 */
class SomeActorTest extends TestKit(ActorSystem("SomeActorTest"))
with ImplicitSender
with WordSpecLike
with Matchers
with StopSystemAfterAll {
  "A actor" must {
    "change receiverMethod when it receives a message" in {
      import SomeActorProtocol._

      val actor = TestActorRef(Props(new SomeActor), "someActor")

      actor ! SomeMessage()
      actor ! OtherMessage(testActor, "test")
      expectMsg("test")
      actor ! OtherMessage(testActor,"go")
      expectMsg("go")
    }
  }
}
