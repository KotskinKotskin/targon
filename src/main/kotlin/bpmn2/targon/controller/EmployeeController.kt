package bpmn2.targon.controller

import bpmn2.targon.DTO.IncomingEmployee
import bpmn2.targon.service.EmployeeService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@CrossOrigin(origins = ["*"], maxAge = 3600)
@RequestMapping("/api/v1/employee")
class EmployeeController(private val employeeService: EmployeeService) {

    @PostMapping
    fun createEmployee(@RequestBody incomingEmployee: IncomingEmployee): ResponseEntity<*> {
       return ResponseEntity.ok(employeeService.createEmployee(incomingEmployee))
    }

}