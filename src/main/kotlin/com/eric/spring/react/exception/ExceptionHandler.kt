package com.eric.spring.react.exception

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice


/**
 *
 *
 * @author shenbingtong (shenbingtong@corp.netease.com)
 */
@RestControllerAdvice
class ExceptionHandler {
    @ExceptionHandler(Exception::class)
    fun handle(e: Exception): ResponseEntity<String> {
        return ResponseEntity.badRequest().body(e.message)
    }

}
