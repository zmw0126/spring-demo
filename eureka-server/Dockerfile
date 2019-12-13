FROM reg1.sgeg.shenhua.cc/eccl_library/alpine-java:jdk8u202
VOLUME /tmp
#时区设置
RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
RUN echo 'Asia/Shanghai' >/etc/timezone
ADD target/app.jar app.jar
RUN sh -c 'touch /app.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -jar -Xmx512m /app.jar" ]
