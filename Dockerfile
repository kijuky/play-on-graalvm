FROM sbtscala/scala-sbt:graalvm-ce-22.3.3-b1-java17_1.9.7_2.13.12 as build

RUN gu install native-image

COPY ./ /app/
WORKDIR /app

RUN sbt GraalVMNativeImage/packageBin

FROM almalinux:latest as app

WORKDIR /app
COPY --from=build /app/target/graalvm-native-image/* .

ENTRYPOINT ["./play-on-graalvm"]
