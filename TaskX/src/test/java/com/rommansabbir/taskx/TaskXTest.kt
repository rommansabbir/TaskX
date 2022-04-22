package com.rommansabbir.taskx

import org.junit.Test

class TaskXTest {
    class TestClass(val data: String)

    @Test
    fun checkTaskXExecution() {
        val result = executeTaskX(
            mutableListOf(
                //First task, return an instance of TestClass
                TaskXBody { TestClass("Hello") },
                //Second task, throw an Exception
                TaskXBody { throw Exception("test") },
                //Third task, return a String
                TaskXBody { "Hello" },
            )
        )
        //First task should be Success and data is 'Hello'
        val firstResult = result[0]
        assert(!firstResult.isError())
        assert((firstResult.getSuccess().data as TestClass).data == "Hello")

        //Second task should be Error, an Instance of Exception and message is 'test'
        val secondResult = result[1]
        assert(secondResult.isError())
        assert(secondResult.getError().exception is Exception)
        assert(secondResult.getError().exception.message == "test")

        //Third task should be Success and data is 'Hello'
        val thirdResult = result[2]
        assert(!thirdResult.isError())
        assert(thirdResult.getSuccess().data == "Hello")
    }
}