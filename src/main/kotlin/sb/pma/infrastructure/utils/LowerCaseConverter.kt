package sb.pma.infrastructure.utils

import kotlin.reflect.KMutableProperty1
import kotlin.reflect.full.memberProperties

object LowerCaseConverter {
    fun <T : Any> convertToLowerCase(obj: T): T {
        val clazz = obj::class
        val properties = clazz.memberProperties

        for (property in properties) {
            if (property.returnType.classifier == String::class) {
                if (property is KMutableProperty1<*, *>) {
                    val value = property.get(obj as Nothing) as? String
                    value?.let {
                        property.set(obj as Nothing, it.lowercase() as Nothing)
                    }
                }
            }
        }

        return obj
    }
}