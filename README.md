# play on graalvm

## requirements

- docker or asdf

## Docker を使う場合

ベースイメージは[scala-sbt](https://hub.docker.com/r/sbtscala/scala-sbt/tags?page=1&name=graalvm)を使います。

### build

```shell
docker build .
```

### run

```shell
docker run -p 9000:9000 -it --rm <<image sha256>>
```

```shell
open http://localhost:9000/
```

## ローカル(mac)で実行する場合

asdfでGraalVM環境を設定しているものとします。

### build

```shell
sbt GraalVMNativeImage/packageBin
```

### run

```shell
target/graalvm-native-image/play-scala-seed
```

```shell
open http://localhost:9000/
```

# パフォーマンス比較

[こちらの記事](https://www.playframework.com/blog/play-on-graal)を参考に [wrk](https://github.com/wg/wrk) を使いました。

## GraalVM

```shell
% wrk -t2 -c100 -d1m http://localhost:9000
Running 1m test @ http://localhost:9000
  2 threads and 100 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     8.47ms    6.62ms 337.61ms   90.01%
    Req/Sec     6.21k   646.17     8.55k    78.08%
  741283 requests in 1.00m, 542.22MB read
Requests/sec:  12352.84
Transfer/sec:      9.04MB
```

## JVM

```shell
% wrk -t2 -c100 -d1m http://localhost:9000
Running 1m test @ http://localhost:9000
  2 threads and 100 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency    19.03ms   70.79ms   1.61s    98.58%
    Req/Sec     4.50k     1.02k    5.96k    82.11%
  535938 requests in 1.00m, 392.02MB read
Requests/sec:   8926.96
Transfer/sec:      6.53MB
```
