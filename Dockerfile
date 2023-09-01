FROM ubuntu:latest
LABEL authors="sk"

ENTRYPOINT ["top", "-b"]