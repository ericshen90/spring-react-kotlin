package com.eric.spring.react.service

import com.eric.spring.react.entity.Client


/**
 *
 *
 * @author shenbingtong (shenbingtong@corp.netease.com)
 */
interface ClientService {

    fun all(): List<Client>

    fun save(client: Client): Client

    fun get(id: Long): Client?

    fun delete(id: Long)

}
