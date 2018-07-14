# Spring Cloud Sleuth
错过了这一篇，你可能再也学不会 Spring Cloud 了！Spring Boot做为下一代 web 框架，Spring Cloud 作为最新最火的微服务的翘楚，你还有什么理由拒绝。赶快上船吧，老船长带你飞。终章不是最后一篇，它是一个汇总，未来还会写很多篇。

案例全部采用Spring Boot 1.5.x ,Spring Cloud版本为Dalston.RELEASE

我为什么这些文章？一是巩固自己的知识，二是希望有更加开放和与人分享的心态，三是接受各位大神的批评指教，有任何问题可以联系我 m18813152580@163.com
github下载：[https://github.com/mliyz/springcloud.git](https://github.com/mliyz/springcloud.git),记得star哦！

### 欢迎购买我的书《深入理解Spring Cloud与微服务构建》

![1.jpg](https://upload-images.jianshu.io/upload_images/2279594-3d9ee1555f555040.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/300)

[京东购买](https://item.jd.com/12312724.html)  [当当购买](http://product.dangdang.com/25231114.html) [亚马逊购买](https://www.amazon.cn/dp/B079J8SCGY/ref=sr_1_2?ie=UTF8&qid=1521344315&sr=8-2&keywords=spring+cloud)

#### CSDN专栏汇总：[史上最简单的 SpringCloud 教程](http://blog.csdn.net/forezp/article/details/70148833)

### 《史上最简单的 SpringCloud 教程》系列：

* [史上最简单的 SpringCloud 教程 | 第一篇: 服务的注册与发现（Eureka）](http://blog.csdn.net/forezp/article/details/69696915)
* [史上最简单的SpringCloud教程 | 第二篇: 服务消费者（rest+ribbon）](http://blog.csdn.net/forezp/article/details/69788938)
* [史上最简单的SpringCloud教程 | 第三篇: 服务消费者（Feign）](http://blog.csdn.net/forezp/article/details/69808079)
* [史上最简单的SpringCloud教程 | 第四篇:断路器（Hystrix）](http://blog.csdn.net/forezp/article/details/69934399)
* [ 史上最简单的SpringCloud教程 | 第五篇: 路由网关(zuul)](http://blog.csdn.net/forezp/article/details/69939114)
* [史上最简单的SpringCloud教程 | 第六篇: 分布式配置中心(Spring Cloud Config)](http://blog.csdn.net/forezp/article/details/70037291)
* [史上最简单的SpringCloud教程 | 第七篇: 高可用的分布式配置中心(Spring Cloud Config)](http://blog.csdn.net/forezp/article/details/70037513)
* [史上最简单的SpringCloud教程 | 第八篇: 消息总线(Spring Cloud Bus)](http://blog.csdn.net/forezp/article/details/70148235)
* [史上最简单的SpringCloud教程 | 第九篇: 服务链路追踪(Spring Cloud Sleuth)](http://blog.csdn.net/forezp/article/details/70162074)
* [史上最简单的SpringCloud教程 | 第十篇: 高可用的服务注册中心](http://blog.csdn.net/forezp/article/details/70183572)
* [史上最简单的SpringCloud教程 | 第十一篇:docker部署spring cloud项目](http://blog.csdn.net/forezp/article/details/70198649)
* [史上最简单的SpringCloud教程 | 第十二篇: 断路器监控(Hystrix Dashboard)](http://blog.csdn.net/forezp/article/details/70217283)
* [史上最简单的SpringCloud教程 | 第十三篇: 断路器聚合监控(Hystrix Turbine)](http://blog.csdn.net/forezp/article/details/70233227)
* [ 史上最简单的 SpringCloud 教程 | 第十四篇: 服务注册(consul)](http://blog.csdn.net/forezp/article/details/70245644)
*  未完。。。
*  还有很多篇。。。
 
### 进阶篇

* [ Spring Cloud Sleuth超详细实战](http://blog.csdn.net/forezp/article/details/76795269)

### 源码篇：

* [深入理解Feign之源码解析](http://blog.csdn.net/forezp/article/details/73480304)
* [深入理解Eureka之源码解析](http://blog.csdn.net/forezp/article/details/73017664)
* [深入理解Ribbon之源码解析](http://blog.csdn.net/forezp/article/details/74820899)
*  [ 深入理解Hystrix之文档翻译](http://blog.csdn.net/forezp/article/details/75333088)
* [深入理解Zuul之源码解析](http://blog.csdn.net/forezp/article/details/76211680)

### 番外篇：

* [如何使用MongoDB+Springboot实现分布式ID?](http://blog.csdn.net/forezp/article/details/69056017)
* [ 如何在springcloud分布式系统中实现分布式锁？](http://blog.csdn.net/forezp/article/details/68957681)
* [ 如何用Redlock实现分布式锁](http://blog.csdn.net/forezp/article/details/70305336)
* [ 如何在IDEA启动多个Spring Boot工程实例](http://blog.csdn.net/forezp/article/details/76408139)


## 为什么需要Spring Cloud Sleuth

微服务架构是一个分布式架构，它按业务划分服务单元，一个分布式系统往往有很多个服务单元。由于服务单元数量众多，业务的复杂性，如果出现了错误和异常，很难去定位。主要体现在，一个请求可能需要调用很多个服务，而内部服务的调用复杂性，决定了问题难以定位。所以微服务架构中，必须实现分布式链路追踪，去跟进一个请求到底有哪些服务参与，参与的顺序又是怎样的，从而达到每个请求的步骤清晰可见，出了问题，很快定位。

举个例子，在微服务系统中，一个来自用户的请求，请求先达到前端A（如前端界面），然后通过远程调用，达到系统的中间件B、C（如负载均衡、网关等），最后达到后端服务D、E，后端经过一系列的业务逻辑计算最后将数据返回给用户。对于这样一个请求，经历了这么多个服务，怎么样将它的请求过程的数据记录下来呢？这就需要用到服务链路追踪。

Google开源的 Dapper链路追踪组件，并在2010年发表了论文《Dapper, a Large-Scale Distributed Systems Tracing Infrastructure》，这篇文章是业内实现链路追踪的标杆和理论基础，具有非常大的参考价值。
目前，链路追踪组件有Google的Dapper，Twitter 的Zipkin，以及阿里的Eagleeye （鹰眼）等，它们都是非常优秀的链路追踪开源组件。

## 基本术语

### Spring Cloud Sleuth采用的是Google的开源项目Dapper的专业术语。


    Span：基本工作单元，发送一个远程调度任务 就会产生一个Span，Span是一个64位ID唯一标识的，Trace是用另一个64位ID唯一标识的，Span还有其他数据信息，比如摘要、时间戳事件、Span的ID、以及进度ID。
    Trace：一系列Span组成的一个树状结构。请求一个微服务系统的API接口，这个API接口，需要调用多个微服务，调用每个微服务都会产生一个新的Span，所有由这个请求产生的Span组成了这个Trace。
    Annotation：用来及时记录一个事件的，一些核心注解用来定义一个请求的开始和结束 。这些注解包括以下：
        cs - Client Sent -客户端发送一个请求，这个注解描述了这个Span的开始
        sr - Server Received -服务端获得请求并准备开始处理它，如果将其sr减去cs时间戳便可得到网络传输的时间。
        ss - Server Sent （服务端发送响应）–该注解表明请求处理的完成(当请求返回客户端)，如果ss的时间戳减去sr时间戳，就可以得到服务器请求的时间。
        cr - Client Received （客户端接收响应）-此时Span的结束，如果cr的时间戳减去cs时间戳便可以得到整个请求所消耗的时间。


##  案例

本文案例一共七个工程采用多Module形式。需要新建一个主Maven工程，主要指定了Spring Boot的版本为1.5.4，Spring Cloud版本为Dalston.RELEASE。包含了eureka-server工程，作为服务注册中心，eureka-server的创建过程这里不重复；zipkin-server作为链路追踪服务中心，负责存储链路数据；gateway-service作为服务网关工程，负责请求的转发,同时它也作为链路追踪客户端，负责产生数据，并上传给zipkin-service；user-service为一个应用服务，对外暴露API接口，同时它也作为链路追踪客户端，负责产生数据；feign-service作为消费服务工程，负责请求的转发；config-server作为分布式配置中心，负责访问远程服务器文件；service-turbine作为断路器聚合监控工程，负责监控多个断路器。

## 构建zipkin-server工程

新建一个Module工程，取名为zipkin-server，其pom文件继承了主Maven工程的pom文件；作为Eureka Client，引入Eureka的起步依赖spring-cloud-starter-eureka，引入zipkin-server依赖，以及zipkin-autoconfigure-ui依赖，后两个依赖提供了Zipkin的功能和Zipkin界面展示的功能。代码如下：

    <parent>
        <groupId>com.forezp</groupId>
        <artifactId>sleuth</artifactId>
        <version>0.0.1-SNAPSHOT</version>
    </parent>
    <dependencies>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-eureka</artifactId>
        </dependency>
        <dependency>
            <groupId>io.zipkin.java</groupId>
            <artifactId>zipkin-server</artifactId>
        </dependency>
        <dependency>
            <groupId>io.zipkin.java</groupId>
            <artifactId>zipkin-autoconfigure-ui</artifactId>
        </dependency>
    </dependencies>
    
在程序的启动类ZipkinServiceApplication加上@EnableZipkinServer开启ZipkinServer的功能，加上@EnableEurekaClient注解，启动Eureka Client。代码如下：

    @SpringBootApplication
    @EnableEurekaClient
    @EnableZipkinServer
    public class ZipkinServerApplication {

        public static void main(String[] args) {
            SpringApplication.run(ZipkinServerApplication.class, args);
        }
    }

在配置文件application.yml文件，指定程序名为zipkin-server，端口为9411，服务注册地址为[http://localhost:8761/eureka/](http://localhost:8761/eureka/)。

    eureka:
      client:
        serviceUrl:
          defaultZone: http://localhost:8761/eureka/
    server:
      port: 9411
    spring:
      application:
        name: zipkin-server
        
## 构建user-service

在主Maven工程下建一个Module工程，取名为user-service，作为应用服务，对外暴露API接口。pom文件继承了主Maven工程的pom文件，并引入了Eureka的起步依赖spring-cloud-starter-eureka，Web起步依赖spring-boot-starter-web，Zipkin的起步依赖spring-cloud-starter-zipkin，代码如下：

    <dependencies>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-eureka</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-zipkin</artifactId>
            <version>RELEASE</version>
        </dependency>
    </dependencies>

在配置文件applicatiom.yml，指定了程序名为user-service，端口为8762，服务注册地址为[http://localhost:8761/eureka/](http://localhost:8761/eureka/)，Zipkin Server地址为[http://localhost:9411](http://localhost:9411)。spring.sleuth.sampler.percentage为1.0,即100%的概率将链路的数据上传给Zipkin Server，在默认的情况下，该值为0.1，代码如下：

    eureka:
      client:
        serviceUrl:
          defaultZone: http://localhost:8761/eureka/
    server:
      port: 8762
    spring:
      application:
        name: user-service
      zipkin:
        base-url: http://localhost:9411
      sleuth:
        sampler:
          percentage: 1.0
          
在UserController类建一个“/user/hi”的API接口，对外提供服务，代码如下：
       
    @RestController
    @RequestMapping("/user")
    public class UserController {
    
        @GetMapping("/hi")
        public String hi(){
            return "I'm forezp";
        }
    }

最后作为Eureka Client，需要在程序的启动类UserServiceApplication加上@EnableEurekaClient注解。

## 构建gateway-service

新建一个名为gateway-service工程，这个工程作为服务网关，将请求转发到user-service，作为Zipkin客户端，需要将链路数据上传给Zipkin Server，同时它也作为Eureka Client。它在pom文件除了需要继承主Maven工程的 pom，还需引入的依赖如下：

    <dependencies>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-eureka</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-zuul</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-zipkin</artifactId>
            <version>RELEASE</version>
        </dependency>
    </dependencies>
    
在application.yml文件，配置程序名为gateway-service，端口为5000，服务注册地址为[http://localhost:8761/eureka/](http://localhost:8761/eureka/)，Zipkin Server地址为[http://localhost:9411](http://localhost:9411)，以“/user-api/**”开头的Uri请求，转发到服务名为 user-service的服务。配置代码如下：

    eureka:
      client:
        serviceUrl:
          defaultZone: http://localhost:8761/eureka/
    
    server:
      port: 5000
    spring:
      application:
        name: gateway-service
      sleuth:
        sampler:
          percentage: 1.0
      zipkin:
        base-url: http://localhost:9411
    
    zuul:
      routes:
        api-a:
          path: /user-api/**
          serviceId: user-service
          
在程序的启动类GatewayServiceApplication，加上@EnableEurekaClient注解开启Eureka Client，加上@EnableZuulProxy注解，开启Zuul代理功能。代码如下：

    @SpringBootApplication
    @EnableZuulProxy
    @EnableEurekaClient
    public class GatewayServiceApplication {
    
        public static void main(String[] args) {
            SpringApplication.run(GatewayServiceApplication.class, args);
        }
    }
    
### 在链路数据中添加自定义数据

现在需要实现这样一个功能，需要在链路数据中加上操作人。这需要在gateway-service上实现。建一个ZuulFilter过滤器，它的类型为“post”，order为900，开启拦截。在拦截逻辑方法里，通过Tracer的addTag方法加上自定义的数据，比如本案例中加入了链路的操作人。另外也可以在这个过滤器中获取当前链路的traceId信息,traceId作为链路数据的唯一标识，可以存储在log日志中，方便后续查找。
    
    @Component
    public class LoggerFilter extends ZuulFilter {
    
        @Autowired
        Tracer tracer;
        @Override
        public String filterType() {
            return FilterConstants.POST_TYPE;
        }
    
        @Override
        public int filterOrder() {
            return 900;
        }
    
        @Override
        public boolean shouldFilter() {
            return true;
        }
    
        @Override
        public Object run() {
    
            tracer.addTag("operator","forezp");
            System.out.print(tracer.getCurrentSpan().traceIdString());
            return null;
        }
    }
    
### 使用spring-cloud-starter-stream-rabbit进行链路通讯

在上述的案例中，最终gateway-service收集的数据，是通过Http上传给zip-server的，在Spring Cloud Sleuth中支持消息组件来通讯的，在这一小节使用RabbitMQ来通讯。首先来改造zipkin-server，在pom文件将zipkin-server的依赖去掉，加上spring-cloud-sleuth-zipkin-stream和spring-cloud-starter-stream-rabbit，代码如下：
    
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-sleuth-zipkin-stream</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-stream-rabbit</artifactId>
    </dependency>

在application.yml配置上RabbitMQ的配置，包括host、端口、用户名、密码，如下：
    
    spring:
      rabbitmq:
        host: localhost
        port: 5672
        username: guest
        password: guest   
        
在程序的启动类ZipkinServerApplication上@EnableZipkinStreamServer注解，开启ZipkinStreamServer。代码如下：

    @SpringBootApplication
    @EnableEurekaClient
    @EnableZipkinStreamServer
    public class ZipkinServerApplication {
    
        public static void main(String[] args) {
            SpringApplication.run(ZipkinServerApplication.class, args);
        }
    } 
    
现在来改造下Zipkin Client（包括gateway-service、user-service），在pom文件中将spring-cloud-starter-zipkin以来改为spring-cloud-sleuth-zipkin-stream和spring-cloud-starter-stream-rabbit，代码如下：

    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-sleuth-zipkin-stream</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-stream-rabbit</artifactId>
    </dependency>
    
同时在applicayion.yml文件加上RabbitMQ的配置，同zipkin-server工程。

这样，就将链路的上传数据从Http改了为用消息代组件RabbitMQ。

### 将链路数据存储在Mysql数据库

在上述的例子中，Zipkin Server是将数据存储在内存中，一旦程序重启，之前的链路数据全部丢失，那么怎么将链路数据存储起来呢？Zipkin支持Mysql、Elasticsearch、Cassandra存储。这一小节讲述用Mysql存储，下一节讲述用Elasticsearch存储。

首先，在zipkin-server工程加上Mysql的连接依赖mysql-connector-java，JDBC的起步依赖spring-boot-starter-jdbc，代码如下：

    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-jdbc</artifactId>
    </dependency>
    
在配置文件application.yml加上数据源的配置，包括数据库的Url、用户名、密码、连接驱动，另外需要配置zipkin.storage.type为mysql，代码如下：

    spring:
      datasource:
        url: jdbc:mysql://localhost:3306/spring-cloud-zipkin?useUnicode=true&characterEncoding=utf8&useSSL=false
        username: root
        password: 1234
        driver-class-name: com.mysql.jdbc.Driver
    zipkin:
      storage:
        type: mysql
        
另外需要在Mysql数据库中初始化数据库脚本，数据库脚本地址：[]

## 项目演示

完整的项目搭建完毕，依次启动eureka-server、zipkin-server、config-server、user-service、feign-service、gateway-service、service-turbine。在浏览器上访问[http://localhost:5000/user-api/user/hi](http://localhost:5000/user-api/user/hi)，浏览器显示：