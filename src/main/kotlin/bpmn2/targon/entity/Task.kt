package bpmn2.targon.entity

import bpmn2.targon.entity.enums.Status
import com.fasterxml.jackson.annotation.JsonIgnore
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

        var idempotentKey : UUID,
        var priority: Long,
        @ManyToOne(optional = false)
        @JoinColumn(name = "source_id", nullable = false)
        @JsonIgnore
        var source: Source,
        @Column(columnDefinition = "TIMESTAMP")
        var dueDate: LocalDateTime?,
        var businessObjectId: String,
        var formId: String,
        @ManyToOne(optional = true)
        @JoinColumn(name = "workbasket_id")
        var workbasket: Workbasket?,
        @ManyToOne(optional = true)
        @JoinColumn(name = "employee_id")
        @JsonIgnore
        var employee: Employee?,
        @Enumerated(EnumType.STRING)
        var status: Status
) {
}
