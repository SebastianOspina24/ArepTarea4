FROM openjdk:8

WORKDIR /areptarea4/back/bin

ENV PORT 6000

COPY /target/classes /areptarea4/back/bin/classes

COPY /target/dependency /areptarea4/back/bin/dependency

CMD ["java","-cp","./classes:./dependency/*","edu.escuelaing.arep.SparkWebApp"]
