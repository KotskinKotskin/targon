package bpmn2.targon.service

import bpmn2.targon.DTO.IncomingEmployee
import bpmn2.targon.entity.Employee


interface IEmployeeService {

    fun createEmployee(incomingEmployee: IncomingEmployee): Employee
}