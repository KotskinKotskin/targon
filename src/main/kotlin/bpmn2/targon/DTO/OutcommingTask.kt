package bpmn2.targon.DTO

import bpmn2.targon.entity.Task
import java.time.LocalDateTime
import java.util.*

class OutcommingTask() {

    var task: Task? = null
    var sourceUrl: String? = null
    companion object {
        private const val serialVersionUID = -1764970284520387975L
    }
}