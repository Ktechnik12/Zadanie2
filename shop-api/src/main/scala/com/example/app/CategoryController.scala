package com.example.app

import org.scalatra.*
import org.json4s.*
import org.json4s.jackson.JsonMethods.*
import org.json4s.jackson.Serialization.write

class CategoryController extends ScalatraServlet:

  implicit val formats: Formats = DefaultFormats

  var categories = List(
    Category(1,"Electronics"),
    Category(2,"Accessories")
  )

  before():
    contentType = "application/json"

  get("/"):
    write(categories)

  get("/:id"):
    write(categories.find(_.id == params("id").toInt))

  post("/"):
    val body = parse(request.body)
    val category = body.extract[Category]
    categories = categories :+ category
    write(category)

  put("/:id"):
    val id = params("id").toInt
    val body = parse(request.body)
    val updated = body.extract[Category]
    categories = categories.map(c => if c.id == id then updated else c)
    write(updated)

  delete("/:id"):
    val id = params("id").toInt
    categories = categories.filterNot(_.id == id)
    write("deleted")
