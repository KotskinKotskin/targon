package bpmn2.targon.service

import bpmn2.targon.DTO.IncomingEmployee
import bpmn2.targon.entity.Employee
import bpmn2.targon.repository.EmployeeRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class EmployeeService (private val employeeRepository: EmployeeRepository): IEmployeeService {

    override fun createEmployee(incomingEmployee: IncomingEmployee): Employee {

        return employeeRepository.findByLogin(incomingEmployee.login)
                ?: employeeRepository.save(Employee(login = incomingEmployee.login, tasks = null, lastModifiedDate = LocalDateTime.now()))

    }
}