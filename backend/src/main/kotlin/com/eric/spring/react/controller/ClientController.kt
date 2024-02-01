package com.eric.spring.react.controller

import com.eric.spring.react.entity.Client
import com.eric.spring.react.service.ClientService
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI
import java.util.*


/**
 *
 *
 * @author ericshen (ahsbt@126.com)
 */
@RestController
@RequestMapping("clients")
class ClientController(@Qualifier("clientServiceImpl") private val clientService: ClientService) {


    @GetMapping
    fun all() = clientService.all()

    @GetMapping("/page")
    fun page(@RequestParam(defaultValue = "1") page: Int, @RequestParam(defaultValue = "10") size: Int) =
        clientService.page(page, size)

    @GetMapping("/{id}")
    fun get(@PathVariable id: Long) = clientService.get(id)

    @PostMapping
    fun save(@RequestBody client: Client): ResponseEntity<Client> {
        val c = clientService.save(client)
        return ResponseEntity.created(URI.create("/client/${c.id}")).body(c)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody client: Client): ResponseEntity<Client> {
        val c = Optional.ofNullable(clientService.get(id)).orElseThrow { RuntimeException("Client not found") }
        clientService.save(Client(id, client.name, client.email))

        return ResponseEntity.ok(c)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) = clientService.delete(id)


}
