package com.eric.spring.react.service

import com.eric.spring.react.entity.Client
import com.eric.spring.react.repo.ClientRepository
import org.springframework.stereotype.Service


/**
 *
 *
 * @author shenbingtong (shenbingtong@corp.netease.com)
 */
@Service("clientServiceImpl")
class ClientServiceImpl(private val clientRepository: ClientRepository): ClientService {
    override fun all(): List<Client> {
        return clientRepository.findAll().toList()
    }

    override fun save(client: Client): Client {
        return clientRepository.save(client)
    }

    override fun get(id: Long): Client? {
        return clientRepository.findById(id).orElse(null)
    }

    override fun delete(id: Long) {
        clientRepository.deleteById(id)
    }
}
