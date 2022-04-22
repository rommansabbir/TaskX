[![Release](https://jitpack.io/v/jitpack/android-example.svg)](https://jitpack.io/#rommansabbir/TaskX)

# TaskX

Execute a list of given body (as a Task) and return a list of Result (Success or Error)

---

## Documentation

### Installation

Step 1. Add the JitPack repository to your build file .

```gradle
    allprojects {
        repositories {
            maven { url 'https://jitpack.io' }
        }
    }
```

Step 2. Add the dependency.

```gradle
    dependencies {
            implementation 'com.github.rommansabbir:TaskX:Tag'
    }
```

---

### Version available

| Releases
| ------------- |
| 1.0.0         |


# Usages

## Why TaskX?
- To execute a list of body (as a Task) in a linear way
- To get Results (Success or Error) of the Tasks

## Example?
```
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
```
----
### Happy Coding....

---

### Contact me

[LinkedIn](https://www.linkedin.com/in/rommansabbir/) | [Blog](https://rommansabbir.com/)

---

### License

[Apache Version 2.0](http://www.apache.org/licenses/LICENSE-2.0.html)

````html
Copyright (C) 2022 Romman Sabbir

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
````
