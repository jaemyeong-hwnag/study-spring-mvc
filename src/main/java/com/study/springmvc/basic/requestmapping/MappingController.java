package com.study.springmvc.basic.requestmapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class MappingController {
    @RequestMapping(value = "/hello-basic", method = RequestMethod.POST)
    // @RequestMapping({"/hello-basic", "/hello-go"})
    public String helloBasic() {
        log.info("helloBasic");
        return "ok";
    }

    @RequestMapping("mapping-get-v1")
    public String mappingGetV1() {
        log.info("mappingGetV1");
        return "ok";
    }

    @GetMapping("mapping-get-v2")
    public String mappingGetV2() {
        log.info("mappingGetV2");
        return "ok";
    }

    /**
     * # @PathVariable 사용
     * # @PathVariable("userId") String userId
     * # @PathVariable() String userId // 같으면 생략
     *
     * @return String
     */
    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable("userId") String userId) {
        log.info("PathVariable userId={}", userId);

        return "OK";
    }

    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPath(@PathVariable() String userId, @PathVariable Long orderId) {
        log.info("PathVariable userId={}, orderId={}", userId, orderId);

        return "OK";
    }

    /**
     *
     * params = "mode"
     * params = "!mode"
     * params = "mode=debug"
     * params = "mode!=debug"
     * @return
     */
    @GetMapping(value = "/mapping-param", params = "mode=debug")
    public String mappingParam() {
        log.info("mappingParam");

        return "OK";
    }

    /**
     * 특정 헤더로 맵필
     * headers = "mode"
     * headers = "!mode"
     * headers = "mode=debug"
     * headers = "mode!=debug"
     * @return
     */
    @GetMapping(value = "/mapping-headwe", headers = "mode=debug")
    public String mappingHeader() {
        log.info("mappingHeader");

        return "OK";
    }

    /**
     * 특정 Content-Type
     * consumes = "application/json"
     * consumes = "!application/json"
     * consumes = "application/*"
     * headers = "mode!=debug"
     * headers = APPLICATION_JSON_VALUE
     * @return
     */
    @GetMapping(value = "/mapping-headwe", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String mappingConsumes() {
        log.info("mappingConsumes");

        return "OK";
    }

    /**
     * 특정 Accept
     * produces = "text/html"
     * produces = "!text/html"
     * produces = "text/*"
     * produces = "!text/*"
     * produces = "*\/*"
     * @return
     */
    @GetMapping(value = "/mapping-headwe", produces = "text/html")
    public String mappingProduces() {
        log.info("mappingConsumes");

        return "OK";
    }
}
