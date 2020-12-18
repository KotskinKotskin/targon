package bpmn2.targon.DTO

import java.time.LocalDateTime
import java.util.*

class IncomingTask(
        var formId: String,
        var businessObjectId: String,
        var sourceId: UUID
) {
    var priority: Long? = null
    var employeeLogin: String? = null
    var dueDate: LocalDateTime? = null
    var workbasketId: UUID? = null



    companion object {
        private const val serialVersionUID = -1764970284520387975L
    }


}