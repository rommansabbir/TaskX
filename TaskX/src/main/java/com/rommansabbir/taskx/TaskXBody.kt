package com.rommansabbir.taskx

/**
 * Class that represent a body where client executes it's logic.
 *
 * @param body Body to be executed.
 */
class TaskXBody<T>(val body: () -> T)
