package bpmn2.targon.entity

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
@Table(name="tg_workbaskets")
data class Workbasket(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: UUID = UUID.randomUUID(),
        @CreatedDate
        val createdDate: LocalDateTime = LocalDateTime.now(),
        @LastModifiedDate
        var lastModifiedDate: LocalDateTime,

        var name: String,

        var idempotencyKey : String,

        @OneToMany(mappedBy = "workbasket")
        var tasks: Set<Task>?
        ) {}
