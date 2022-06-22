package com.github.mcruzdev.babyfury.babyfuryweb.controllers

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI
import java.util.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@RestController
@RequestMapping("/apps")
@CrossOrigin("*")
class AppController {

    private val logger: Logger = LoggerFactory.getLogger(AppController::class.java)

    @PostMapping
    fun createApp(@RequestBody appRequest: CreateAppRequest): ResponseEntity<Void> {
        logger.info("[flow:create_app][app_name:{}] value: $appRequest" , appRequest.name)
        return ResponseEntity.created(URI.create("/apps/${UUID.randomUUID()}")).build()
    }
}

data class CreateAppRequest(
    @field:NotBlank val name: String, @field:NotNull val type: String
)