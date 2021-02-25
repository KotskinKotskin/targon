package bpmn2.targon.service

import bpmn2.targon.DTO.IncomingSource
import bpmn2.targon.entity.Source
import bpmn2.targon.repository.SourceRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.*

@Service
class SourceService(private val sourceRepository: SourceRepository): ISourceService {
    override fun createSource(incomingSource: IncomingSource): Source {
        return sourceRepository.save(Source( UUID.randomUUID(), LocalDateTime.now(), LocalDateTime.now(), incomingSource.name, incomingSource.frameUrl,null))
    }
}