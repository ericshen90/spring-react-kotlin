package com.eric.spring.react.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id


/**
 *
 *
 * @author ericshen (ahsbt@126.com)
 */
@Entity
class Client(
        @Id @GeneratedValue var id: Long?,
        var name: String,
        var email: String,
) {
    constructor(name: String, email: String) : this(null, name, email)
}


