package bpmn2.targon.controller

import bpmn2.targon.DTO.IncomingTask
import bpmn2.targon.service.TaskService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*


@RestController
@CrossOrigin(origins = ["*"], maxAge = 3600)
@RequestMapping("/api/v1/task")
class TaskController(private val taskService: TaskService) {



    @PostMapping
    fun createTask(@RequestHeader("idempotency-key") idempotencyKey: UUID, @RequestBody incomingTask: IncomingTask): ResponseEntity<*> {

        return ResponseEntity.ok("ok")
    }
}