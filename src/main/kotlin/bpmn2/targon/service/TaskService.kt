package bpmn2.targon.service

import bpmn2.targon.DTO.IncomingTask
import bpmn2.targon.entity.Task
import bpmn2.targon.repository.SourceRepository
import bpmn2.targon.repository.TaskRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*

@Service
class TaskService(private val taskRepository: TaskRepository, private val sourceRepository: SourceRepository,) {


    fun createTask(incomingTask: IncomingTask, idempotencyKey: UUID): Task?{

        val taskCandidate = taskRepository.findByIdempotencyKey(idempotencyKey)
        if (taskCandidate != null) return taskCandidate
        var sourceCandidate = sourceRepository.findByIdOrNull(incomingTask.sourceId)

    }
}