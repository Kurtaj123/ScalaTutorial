package controllers

import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props


import models.{DB, Coffees, User}
import play.api._
import play.api.data.Forms._
import play.api.data._
import play.api.mvc._
import play.api.mvc.Controller


class HelloActor extends Actor {
  def receive = {
    case "hello" => println("Hello back to you mother fucker")
    case _ => println("HUH ME NO FOUND")
  }
}

object Main extends App{
  val system = ActorSystem("HelloSystem")

  val helloActor = system.actorOf(Props[HelloActor], name = "HelloActor")
  helloActor ! "Hello"
  helloActor ! "Buenos dias"
}

object Application extends Controller {


  def getAllCoffees = Action{
    val allCoffee = DB.query[Coffees].fetch()
    Ok(views.html.index(allCoffee.toList))
  }


  val coffeeForm: Form[Coffees] = Form(
  mapping(
    "cof_name" -> text,
    "sup_id" -> number,
    "price" -> number,
    "sales" -> number,
    "total" -> number)(Coffees.apply)(Coffees.unapply)
  )

  def deleteCoffee(id: Int) = Action {
    println(id + "hejsan")
    Coffees.delete(id)
    Redirect(routes.Application.getAllCoffees)
  }
  def addCoffeeForm = Action {
    Ok(views.html.coffee(coffeeForm))
  }

  def addNewCoffee = Action { implicit request =>
      coffeeForm.bindFromRequest.fold(
        formWithErrors => {
          BadRequest("ERROR")
        },
      userData => {
          Coffees.create(userData)
        Redirect(routes.Application.getAllCoffees())
      }
      )
  }



}
