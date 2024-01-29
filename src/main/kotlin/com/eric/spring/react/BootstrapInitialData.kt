package com.eric.spring.react

import com.eric.spring.react.entity.Client
import com.eric.spring.react.service.ClientService
import io.github.serpro69.kfaker.faker
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component


/**
 *
 *
 * @author shenbingtong (shenbingtong@corp.netease.com)
 */
@Component
class BootstrapInitialData(private val clientService: ClientService) : CommandLineRunner{
    override fun run(vararg args: String?) {
        val faker = faker {  }
        for (i in 1..100) {
            clientService.save(Client(name = faker.name.name(), email = faker.internet.email()))
        }
    }
}
