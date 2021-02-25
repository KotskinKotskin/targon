package bpmn2.targon.service

import bpmn2.targon.DTO.IncomingTask
import bpmn2.targon.entity.Task
import bpmn2.targon.entity.enums.Status
import bpmn2.targon.exception.NoEmployeeException
import bpmn2.targon.exception.NoSourceException
import bpmn2.targon.repository.EmployeeRepository
import bpmn2.targon.repository.SourceRepository
import bpmn2.targon.repository.TaskRepository
import bpmn2.targon.repository.WorkbasketRepository
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.*

@Service
class TaskService(private val taskRepository: TaskRepository,
                  private val sourceRepository: SourceRepository,
                  private val workbasketRepository: WorkbasketRepository,
                  private val employeeRepository: EmployeeRepository,
): ITaskService {


     override fun createTask(incomingTask: IncomingTask, idempotencyKey: UUID): Task{

        val taskCandidate = taskRepository.findByIdempotentKey(idempotencyKey)
        if (taskCandidate != null) return taskCandidate
        val sourceCandidate = sourceRepository.findByIdOrNull(incomingTask.sourceId)
        val employeeCandidate = employeeRepository.findByLogin(incomingTask.employeeLogin)
        return if (sourceCandidate != null) {
            val task = Task(
                    businessObjectId = incomingTask.businessObjectId,
                    workbasket = if (incomingTask.workbasketId != null ) workbasketRepository.findByIdOrNull(incomingTask.workbasketId!!) else null ,
                    dueDate = incomingTask.dueDate,
                    idempotentKey = idempotencyKey,
                    source = sourceCandidate,
                    employee = employeeCandidate,
                    formId = incomingTask.formId,
                    priority = incomingTask.priority ?: 1,
                    lastModifiedDate = LocalDateTime.now(),
                    status = Status.NEW
            )
            return taskRepository.save(task)

        } else throw NoSourceException()
    }

    override fun findNextTask(employeeLogin: String): Task? {
        val employeeCandidate = employeeRepository.findByLogin(employeeLogin) ?: throw NoEmployeeException()
        val sortByPriority = PageRequest.of(0,1, Sort.by("priority").descending())
        return taskRepository.findByEmployeeAndStatusNotIn(employeeCandidate, listOf(Status.COMPLETED),sortByPriority)?.firstOrNull()
    }

    override fun findNextTask(employeeLogin: String, workbasketId: UUID): Task? {
        TODO("Not yet implemented")
    }

    override fun findNextTask(workbasketId: UUID): Task? {
        TODO("Not yet implemented")
    }


}
