FROM openjdk:8

WORKDIR /areptarea4/balancer/bin


COPY /target/classes /areptarea4/balancer/bin/classes

COPY /target/dependency /areptarea4/balancer/bin/dependency

CMD ["java","-cp","./classes:./dependency/*","edu.escuelaing.arep.Balancer"]
