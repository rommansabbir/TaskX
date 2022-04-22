package com.rommansabbir.taskx

/**
 * Entry point for client to execute a list of given body and return a list of results.
 *
 * @param list List of [TaskXBody] to be executed.
 *
 * @return [MutableList]<[TaskXResult]>.
 */
fun <T : Any> executeTaskX(list: MutableList<TaskXBody<T>>): MutableList<TaskXResult> {
    return executeClientTasks(list)
}