FROM gradle:7-jdk17-alpine
COPY . /docbuild
WORKDIR /docbuild
RUN gradle --no-daemon build
CMD gradle --no-daemon bootRun
