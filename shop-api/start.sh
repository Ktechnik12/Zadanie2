#!/bin/bash

sbt run &
sleep 15

ngrok http 8080
