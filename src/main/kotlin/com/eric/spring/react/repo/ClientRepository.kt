package com.eric.spring.react.repo

import com.eric.spring.react.entity.Client
import org.springframework.data.jpa.repository.JpaRepository


/**
 *
 *
 * @author shenbingtong (shenbingtong@corp.netease.com)
 */
interface ClientRepository : JpaRepository<Client, Long> {

}
