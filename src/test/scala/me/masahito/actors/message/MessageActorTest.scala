package me.masahito.actors.message

import org.scalatest.{WordSpecLike, FunSuite}
import akka.actor.ActorSystem
import org.scalatest.MustMatchers
import akka.testkit.{TestActorRef, TestKit}

/**
 * Created by masahito on 2014/08/12.
 */
class MessageActorTest extends TestKit(ActorSystem("test"))
  with WordSpecLike
  with MustMatchers
  with StopSystemAfterAll {

    "A actor" must {
      "chagne state when it receives a message" in {
        import MessageActorProtocol._

        val actor = TestActorRef[MessageActor]

        actor ! Message("ハロー")
        actor.underlyingActor.state must (contain("ハロー"))
      }
    }
  }