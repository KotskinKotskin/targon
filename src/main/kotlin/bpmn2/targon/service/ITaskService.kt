package bpmn2.targon.service

import bpmn2.targon.DTO.IncomingTask
import bpmn2.targon.entity.Employee
import bpmn2.targon.entity.Task
import bpmn2.targon.entity.Workbasket
import java.util.*

interface ITaskService {
    fun createTask(incomingTask: IncomingTask, idempotencyKey: UUID): Task
    fun findNextTask(employeeLogin: String): Task?
    fun findNextTask(employeeLogin: String, workbasketId: UUID): Task?
    fun findNextTask(workbasketId: UUID): Task?

}
