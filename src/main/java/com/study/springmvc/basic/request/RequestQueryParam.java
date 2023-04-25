package com.study.springmvc.basic.request;

import com.study.springmvc.basic.HelloData;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Slf4j
@RestController
public class RequestQueryParam {
    @RequestMapping("request-param-v1")
    public void requestParmaV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        log.info("username={}, age={}", username, age);

        response.getWriter().write("ok");
    }

    @RequestMapping("request-param-v2")
    public String requestParmaV2(
            @RequestParam("username") String username,
            @RequestParam("age") int age
    ) {
        log.info("username={}, age={}", username, age);
        return "ok";
    }

    @RequestMapping("request-param-v3")
    public String requestParmaV3(
            @RequestParam String username,
            @RequestParam int age
    ) {
        log.info("username={}, age={}", username, age);
        return "ok";
    }

    @RequestMapping("request-param-v4")
    public String requestParmaV4(
            String username,
            int age
    ) {
        log.info("username={}, age={}", username, age);
        return "ok";
    }

    @RequestMapping("request-param-required")
    public String requestParmaRequired(
            @RequestParam(required = true) String username,
            @RequestParam(required = false) Integer age
    ) {
        log.info("username={}, age={}", username, age);
        return "ok";
    }

    @RequestMapping("request-param-default")
    public String requestParmaDefault(
            @RequestParam(required = true, defaultValue = "guest") String username,
            @RequestParam(required = false, defaultValue = "-1") Integer age
    ) {
        log.info("username={}, age={}", username, age);
        return "ok";
    }

    @RequestMapping("model-attribute-v1")
    public String modelAttributeV1(
            @RequestParam(required = true, defaultValue = "guest") String username,
            @RequestParam(required = false, defaultValue = "-1") Integer age
    ) {
        HelloData helloData = new HelloData();
        helloData.setUsername(username);
        helloData.setAge(age);

        return "ok";
    }

    @RequestMapping("model-attribute-v2")
    public String modelAttributeV2(
           HelloData helloData
    ) {
        log.info("username={}, age={}", helloData.getUsername(), helloData.getUsername());

        return "ok";
    }
}
