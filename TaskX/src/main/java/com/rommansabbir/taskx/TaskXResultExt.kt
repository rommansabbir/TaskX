package com.rommansabbir.taskx

/**
 * Verify that [TaskXResult] is Error or Success.
 */
fun TaskXResult.isError() = this is TaskXResult.Error

/**
 * To get [TaskXResult] as Success.
 *
 * @see [isError]
 */
fun TaskXResult.getSuccess() = this as TaskXResult.Success

/**
 * To get [TaskXResult] as Error.
 *
 * @see [isError]
 */
fun TaskXResult.getError() = this as TaskXResult.Error

/**
 * Callback to get notified on Success or Error.
 *
 * @param success Success callback
 * @param error Error callback
 *
 * @see [getSuccess]
 * @see [getError]
 * @see [isError]
 */
fun TaskXResult.getResult(
    success: (TaskXResult.Success) -> Unit,
    error: (TaskXResult.Error) -> Unit
) {
    if (isError()) success.invoke(getSuccess()) else error.invoke(getError())
}