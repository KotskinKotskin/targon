package bpmn2.targon.controller

import bpmn2.targon.DTO.IncomingTask
import bpmn2.targon.DTO.OutcommingTask
import bpmn2.targon.exception.NoEmployeeException
import bpmn2.targon.exception.NoSourceException
import bpmn2.targon.service.ITaskService
import bpmn2.targon.service.TaskService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*


@RestController
@CrossOrigin(origins = ["*"], maxAge = 3600)
@RequestMapping("/api/v1/task")
class TaskController(private val taskService: ITaskService) {



    @PostMapping
    fun createTask(@RequestHeader("idempotentKey") idempotentKey: UUID, @RequestBody incomingTask: IncomingTask): ResponseEntity<*> {
        return try {
            val task = taskService.createTask(incomingTask, idempotentKey)
            ResponseEntity.ok(task)
        }
        catch (e: NoSourceException) {
            ResponseEntity(mapOf(Pair("error", "No source for id ${incomingTask.sourceId}")), HttpStatus.BAD_REQUEST)
        }

    }

    @GetMapping
    fun findTask(@RequestParam("employeeLogin") employeeLogin: String): ResponseEntity<*> {
        return try {
            val taskCandidate = taskService.findNextTask(employeeLogin)
            if (taskCandidate != null) {

                var outTask = OutcommingTask().also {
                    it.task = taskCandidate
                    it.sourceUrl = taskCandidate.source.frameUrl
                }

                ResponseEntity.ok(outTask)
            }
            else ResponseEntity(mapOf(Pair("error", "No tasks for $employeeLogin")), HttpStatus.NOT_FOUND)
        }
        catch (e: NoEmployeeException) {
            ResponseEntity(mapOf(Pair("error", "No employee with login $employeeLogin")), HttpStatus.BAD_REQUEST)
        }
    }
}