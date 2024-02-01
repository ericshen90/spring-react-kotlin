package com.eric.spring.react.repo

import com.eric.spring.react.entity.Client
import org.springframework.data.jpa.repository.JpaRepository


/**
 *
 *
 * @author ericshen (ahsbt@126.com)
 */
interface ClientRepository : JpaRepository<Client, Long> {

}
