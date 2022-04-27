FROM hseeberger/scala-sbt:graalvm-ce-21.3.0-java11_1.6.2_2.13.8 as build

RUN gu install native-image

# for publishLocal
#COPY ivy2/local/ /root/.ivy2/local/

COPY ./ /app/
WORKDIR /app

RUN sbt graalvm-native-image:packageBin

FROM almalinux:latest as app

WORKDIR /app
COPY --from=build /app/target/graalvm-native-image/* .

ENTRYPOINT ["./play-on-graalvm"]
