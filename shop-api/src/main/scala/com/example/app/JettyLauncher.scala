package com.example.app

import org.eclipse.jetty.server.Server
import org.eclipse.jetty.ee10.webapp.WebAppContext

object JettyLauncher:

  def main(args: Array[String]): Unit =
    val port = sys.env.getOrElse("PORT", "8080").toInt

    val server = new Server(port)
    val context = new WebAppContext()

    context.setContextPath("/")
    context.setWar("src/main/webapp")

    server.setHandler(context)

    server.start()
    server.join()
