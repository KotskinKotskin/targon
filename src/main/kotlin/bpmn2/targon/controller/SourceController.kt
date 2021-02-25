package bpmn2.targon.controller

import bpmn2.targon.DTO.IncomingSource
import bpmn2.targon.DTO.IncomingTask
import bpmn2.targon.exception.NoSourceException
import bpmn2.targon.service.ISourceService
import bpmn2.targon.service.TaskService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.lang.Exception
import java.util.*

@RestController
@CrossOrigin(origins = ["*"], maxAge = 3600)
@RequestMapping("/api/v1/source")
class SourceController(private val sourceService: ISourceService) {



    @PostMapping
    fun createSource( @RequestBody incomingSource: IncomingSource): ResponseEntity<*> {
        return try {
            val source = sourceService.createSource(incomingSource)
            ResponseEntity.ok(source)
        }
        catch (e: Exception) {
            ResponseEntity(mapOf(Pair("error", e.message)), HttpStatus.INTERNAL_SERVER_ERROR)
        }

    }
}