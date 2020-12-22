package bpmn2.targon.repository

import bpmn2.targon.entity.Source
import org.springframework.data.repository.CrudRepository
import java.util.*

interface SourceRepository: CrudRepository<Source, UUID> {


}