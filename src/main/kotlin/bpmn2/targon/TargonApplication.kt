package bpmn2.targon

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TargonApplication

fun main(args: Array<String>) {
	runApplication<TargonApplication>(*args)
}
