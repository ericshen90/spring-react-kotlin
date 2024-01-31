package com.eric.spring.react.service

import com.eric.spring.react.entity.Client
import org.springframework.data.domain.Page


/**
 *
 *
 * @author shenbingtong (shenbingtong@corp.netease.com)
 */
interface ClientService {

    fun all(): List<Client>

    fun page(page: Int, size: Int): Page<Client>

    fun save(client: Client): Client

    fun get(id: Long): Client?

    fun delete(id: Long)

}
