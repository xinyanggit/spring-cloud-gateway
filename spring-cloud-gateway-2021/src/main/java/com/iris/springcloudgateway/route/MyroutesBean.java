package com.iris.springcloudgateway.route;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yx start
 * @create 2019/4/15,9:58
 */
@Component
@RestController
public class MyroutesBean {

    /***
     * 在spring cloud gateway中使用RouteLocator的Bean进行路由转发，
     * 将请求进行处理，最后转发到目标的下游服务。
     * 1.很奇怪，这里的get竟然不能修改 ？
     * 2.路由中添加熔断器 fallback 是springcloud 中自带的
     * 添加路由：
     *    当请求的host 中 含有 *.iris.hystrix.com 设置name,设置是熔断机制
     *
     */
 /*   @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        String httpUrl = "http://httpbin.org:80";
        return builder.routes().route(
                p -> p.path("/get").uri(httpUrl))
                .route( p -> p.host("*")
                           .filters(hy -> hy.hystrix(config -> config.setName("/iris")
                                   .setFallbackUri("forward:/fallback")) ).uri(httpUrl))
                .build();
         // 可以自带熔断器进行 服务降级处理 ，转发到对应的请求fallback 中
    }*/


    @RequestMapping("/fallback")
    public Object fallback(){
        return  "this is fallback" ;
    }


}
