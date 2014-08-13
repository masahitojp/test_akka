package me.masahito.actors.message

import org.scalatest.{WordSpecLike, FunSuite}
import akka.actor.{Props, ActorSystem}
import org.scalatest.MustMatchers
import akka.testkit.{TestActorRef, TestKit}
import me.masahito.actors.StopSystemAfterAll
import me.masahito.actors.echo.EchoActor

/**
 * Created by masahito on 2014/08/12.
 */
class MessageActorTest extends TestKit(ActorSystem("test"))
  with WordSpecLike
  with MustMatchers
  with StopSystemAfterAll {

//    "A actor" should {
//      "chagne state when it receives a message" in {
//        import MessageActorProtocol._
//
//        val actor = TestActorRef[MessageActor]
//
//        actor ! Message("ハロー")
//        actor.underlyingActor.state must (contain("ハロー"))
//      }
//    }
    "A actor2" should {
      "change state when it receives a message, multi threaded" in {
        import MessageActorProtocol._

        val actor = system.actorOf(Props[MessageActor], "s3")
        val otherActor = system.actorOf(Props[EchoActor], "echo")

        actor ! Message("ハロー")
        actor ! Message("はろ〜")

        actor ! GetState(testActor)

        expectMsg(Vector("ハロー", "はろ〜"))
      }
    }
  }