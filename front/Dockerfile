FROM openjdk:8

WORKDIR /areptarea4/front/bin

ENV PORT 6000

COPY /target/classes /areptarea4/front/bin/classes

COPY /target/dependency /areptarea4/front/bin/dependency

CMD ["java","-cp","./classes:./dependency/*","edu.escuelaing.arep.SparkWebApp"]
