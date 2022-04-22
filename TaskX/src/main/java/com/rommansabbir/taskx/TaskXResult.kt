package com.rommansabbir.taskx

/**
 * Sealed class that represent a task result as Success or Error.
 */
sealed class TaskXResult {
    /**
     * Success Result.
     *
     * @param data Data that should be returned.
     *
     * [Note: Client need additional Type Casting to get required object from [data].]
     */
    class Success(val data: Any) : TaskXResult()

    /**
     * Error Result.
     *
     * @param exception [Exception] that should be returned.
     */
    class Error(val exception: Throwable) : TaskXResult()
}
