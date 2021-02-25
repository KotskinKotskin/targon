package bpmn2.targon.service

import bpmn2.targon.DTO.IncomingSource
import bpmn2.targon.entity.Source

interface ISourceService {
    fun createSource(incomingSource: IncomingSource): Source
}