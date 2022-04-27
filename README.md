# play on graalvm

## requirements

- docker

## build

```
docker build .
```

## run

```shell
docker run -p 9000:9000 -it --rm <<image sha256>>
```

```shell
open http://localhost:9000/
```