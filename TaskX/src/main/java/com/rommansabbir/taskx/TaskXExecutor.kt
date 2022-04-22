package com.rommansabbir.taskx

/**
 * To execute any given task.
 */
internal interface TaskXExecutor {
    companion object {
        /**
         * Inline function to execute any given task from clients.
         *
         * @param body Body to be executed.
         *
         * @return [TaskXResult].
         */
        internal inline fun <T : Any> executeTask(crossinline body: () -> T): TaskXResult =
            safeTaskExecution(body)
    }
}

