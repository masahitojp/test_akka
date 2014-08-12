package me.masahito.actors.message

import akka.actor.ActorSystem
import akka.testkit.{TestActorRef,TestKit, ImplicitSender}

import org.scalatest.WordSpecLike
import org.scalatest.Matchers
import me.masahito.actors.echo.EchoActor
import akka.pattern.ask

import akka.util.Timeout
import scala.concurrent.duration._
import scala.concurrent.Await

class EchoActorSpec extends TestKit(ActorSystem("MySpec"))
  with ImplicitSender
  with WordSpecLike
  with Matchers
  with StopSystemAfterAll {

  "An Echo actor" should {
    implicit val timeout = Timeout(5 seconds)
    "send back messages" in {
      val echo = TestActorRef[EchoActor]
      val future = echo ? "hello world"
      val result = Await.result(future, timeout.duration).asInstanceOf[String]
      assert(result === "hello world")
    }

    "send back messages unchanged" in {
      val echo = TestActorRef[EchoActor]
      echo ! "hello world"
      expectMsg("hello world")
    }

  }
}

