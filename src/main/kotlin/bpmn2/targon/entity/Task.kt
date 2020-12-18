package bpmn2.targon.entity

import bpmn2.targon.entity.enums.Status
import org.springframework.data.annotation.CreatedDate

import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "tg_tasks")
data class Task (

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: UUID = UUID.randomUUID(),
        @CreatedDate
        val createdDate: LocalDateTime = LocalDateTime.now(),
        @LastModifiedDate
        var lastModifiedDate: LocalDateTime?,


        var priority: Long,
        @ManyToOne(optional = false)
        @JoinColumn(name = "source_id", nullable = false)
        var source: Source,
        @Column(columnDefinition = "TIMESTAMP")
        var dueDate: LocalDateTime?,
        var businessObjectId: String,
        var formId: String,
        var businessDomain: String,
        @ManyToOne(optional = true)
        @JoinColumn(name = "workbasket_id", nullable = false)
        var workbasket: Workbasket?,
        @ManyToOne(optional = false)
        @JoinColumn(name = "employee_id", nullable = false)
        var employee: Employee?,
        @Enumerated(EnumType.STRING)
        var status: Status
) {
}
