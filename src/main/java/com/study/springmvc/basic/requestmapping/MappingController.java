package com.study.springmvc.basic.requestmapping;

import lombok.extern.slf4j.Slf4j;
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
    @GetMapping("/mappingPath/{userId}")
    public String mappingPath(@PathVariable("userId") String userId) {
        log.info("PathVariable userId={}", userId);

        return "OK";
    }

    @GetMapping("/mappingPath/users/{userId}/orders/{orderId}")
    public String mappingPath(@PathVariable() String userId, @PathVariable Long orderId) {
        log.info("PathVariable userId={}, orderId={}", userId, orderId);

        return "OK";
    }
}
