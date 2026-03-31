FROM kprzystalski/ebiznes-scala

USER root

WORKDIR /app
COPY . .

RUN mkdir -p /home/student/.sbt /home/student/.ivy2 && \
    chmod -R 777 /home/student && \
    apt-get update && \
    apt-get install -y curl unzip ca-certificates && \
    curl -fsSL https://ngrok-agent.s3.amazonaws.com/ngrok.asc | tee /etc/apt/trusted.gpg.d/ngrok.asc >/dev/null && \
    echo "deb https://ngrok-agent.s3.amazonaws.com buster main" > /etc/apt/sources.list.d/ngrok.list && \
    apt-get update && \
    apt-get install -y ngrok && \
    apt-get clean

ENV HOME=/home/student
ENV SBT_OPTS="-Dsbt.global.base=/home/student/.sbt -Dsbt.boot.directory=/home/student/.sbt/boot -Dsbt.ivy.home=/home/student/.ivy2"

EXPOSE 8080

CMD ["./start.sh"]
