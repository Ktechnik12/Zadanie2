package com.example.app

import org.scalatra.*
import org.json4s.*
import org.json4s.jackson.JsonMethods.*
import org.json4s.jackson.Serialization.write

class ProductController extends ScalatraServlet:


  implicit val formats: Formats = DefaultFormats

  var products = List(
    Product(1,"Laptop",3000),
    Product(2,"Mouse",100)
  )

  before():
    contentType = "application/json"

  get("/"):
    write(products)

  get("/:id"):
    write(products.find(_.id == params("id").toInt))

  post("/"):
    val body = parse(request.body)
    val product = body.extract[Product]
    products = products :+ product
    write(product)

  put("/:id"):
    val id = params("id").toInt
    val body = parse(request.body)
    val updated = body.extract[Product]
    products = products.map(p => if p.id == id then updated else p)
    write(updated)

  delete("/:id"):
    val id = params("id").toInt
    products = products.filterNot(_.id == id)
    write("deleted")
