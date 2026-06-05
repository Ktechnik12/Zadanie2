#!/bin/bash

ngrok config add-authtoken "$NGROK_AUTHTOKEN"

sbt run &
sleep 15

ngrok http 8080
