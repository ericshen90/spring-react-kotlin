package com.eric.spring.react.controller

import com.eric.spring.react.entity.Client
import com.eric.spring.react.service.ClientService
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.data.jpa.domain.AbstractPersistable_.id
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI
import java.util.*


/**
 *
 *
 * @author shenbingtong (shenbingtong@corp.netease.com)
 */
@RestController
class ClientController(@Qualifier("clientServiceImpl") private val clientService: ClientService) {


    @GetMapping("/client/all")
    fun all() = clientService.all()

    @GetMapping("/client/{id}")
    fun get(@PathVariable id: Long) = clientService.get(id)

    @PostMapping("/client/")
    fun save(@RequestBody client: Client): ResponseEntity<Client> {
        val c = clientService.save(client)
        return ResponseEntity.created(URI.create("/client/$id")).body(c)
    }

    @PutMapping("/client/{id}")
    fun update(@PathVariable id: Long, @RequestBody client: Client): ResponseEntity<Client> {
        val c = Optional.ofNullable(clientService.get(id)).orElseThrow { RuntimeException("Client not found") }
        clientService.save(Client(id, client.name, client.email))

        return ResponseEntity.ok(c)
    }

    @DeleteMapping("/client/{id}")
    fun delete(@PathVariable id: Long) = clientService.delete(id)


}
