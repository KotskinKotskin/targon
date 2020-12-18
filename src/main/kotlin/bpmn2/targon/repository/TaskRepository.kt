package bpmn2.targon.repository

import bpmn2.targon.entity.Task
import org.springframework.data.repository.CrudRepository
import java.util.*

interface TaskRepository: CrudRepository<Task, UUID> {
}