package bpmn2.targon.repository

import bpmn2.targon.entity.Workbasket
import org.springframework.data.repository.CrudRepository
import java.util.*

interface WorkbasketRepository: CrudRepository<Workbasket, UUID> {
}