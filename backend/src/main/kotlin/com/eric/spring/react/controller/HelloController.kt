package com.eric.spring.react.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping


/**
 *
 *
 * @author ericshen (ahsbt@126.com)
 */
@Controller
class HelloController {

    @GetMapping
    fun hello() = "index.html"

}
