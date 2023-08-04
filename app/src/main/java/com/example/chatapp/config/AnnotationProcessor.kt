package com.example.chatapp.config

import com.example.chatapp.annotations.Autowire
import com.example.chatapp.services.ContactService

object AnnotationProcessor {


    fun inject(target: Any) {
        val fields = target::class.java.declaredFields
        for (field in fields) {
            if (field.isAnnotationPresent(Autowire::class.java)) {
                field.isAccessible = true
                val fieldType = field.type
                val dependency = getDependencyInstance(fieldType)
                field.set(target, dependency)
            }
        }
    }

    private fun getDependencyInstance(fieldType: Class<*>): Any {
        // Here, you should implement the logic to create or provide the appropriate instance
        // of the dependency based on the fieldType. You can use a DI framework or custom logic
        // to obtain the instance.

        // For demonstration purposes, let's assume a few example dependencies:

        return when (fieldType) {
            ContactService::class.java -> ContactService()
            // Add more cases as needed for other dependency types
            else -> throw IllegalArgumentException("Unknown dependency type: $fieldType")
        }
    }
}