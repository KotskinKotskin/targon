package bpmn2.targon.repository

import bpmn2.targon.entity.Employee
import org.springframework.data.repository.CrudRepository
import java.util.*

interface EmployeeRepository: CrudRepository<Employee, UUID> {
}