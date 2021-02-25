package bpmn2.targon.repository

import bpmn2.targon.entity.Employee
import bpmn2.targon.entity.Task
import bpmn2.targon.entity.enums.Status
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.PagingAndSortingRepository
import java.util.*

interface TaskRepository: PagingAndSortingRepository<Task, UUID> {


    fun findByIdempotentKey(idempotentKey: UUID): Task?
    fun findByEmployeeAndStatusNotIn(employee: Employee, statuses: List<Status>, pageable: Pageable ): List<Task>?

}