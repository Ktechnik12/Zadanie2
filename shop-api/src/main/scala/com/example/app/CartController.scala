package com.example.app

import org.scalatra.*
import org.json4s.*
import org.json4s.jackson.JsonMethods.*
import org.json4s.jackson.Serialization.write

class CartController extends ScalatraServlet:

  implicit val formats: Formats = DefaultFormats

  var cart = List[CartItem]()

  before():
    contentType = "application/json"

  get("/"):
    write(cart)

  get("/:id"):
    write(cart.find(_.id == params("id").toInt))

  post("/"):
    val body = parse(request.body)
    val item = body.extract[CartItem]
    cart = cart :+ item
    write(item)

  put("/:id"):
    val id = params("id").toInt
    val body = parse(request.body)
    val updated = body.extract[CartItem]
    cart = cart.map(c => if c.id == id then updated else c)
    write(updated)

  delete("/:id"):
    val id = params("id").toInt
    cart = cart.filterNot(_.id == id)
    write("deleted")
