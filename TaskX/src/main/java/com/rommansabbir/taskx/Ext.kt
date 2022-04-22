package com.rommansabbir.taskx

/**
 * Safely execute an given body under the Try/Catch block.
 *
 * @param body Body to be executed.
 *
 * @return [TaskXResult].
 */
internal inline fun <T : Any> safeTaskExecution(crossinline body: () -> T): TaskXResult {
    return try {
        TaskXResult.Success(body.invoke())
    } catch (e: Throwable) {
        TaskXResult.Error(e)
    }
}

/**
 * Extension function to execute list of given [TaskXBody] in a linear way.
 *
 * @param list [MutableList] of [TaskXBody].
 *
 * @return [MutableList]<[TaskXResult]>.
 */
internal fun <T : Any> executeClientTasks(list: MutableList<TaskXBody<T>>): MutableList<TaskXResult> {
    val result = mutableListOf<TaskXResult>()
    list.forEach {
        result.add(TaskXExecutor.executeTask(it.body))
    }
    return result
}

