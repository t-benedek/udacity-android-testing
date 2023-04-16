package com.example.android.architecture.blueprints.todoapp

import kotlinx.coroutines.*
import kotlinx.coroutines.test.*
import org.junit.rules.TestWatcher
import org.junit.runner.Description

class MainCoroutineRule {

    @ExperimentalCoroutinesApi
    class MainCoroutineRule(
        val dispatcher: TestCoroutineDispatcher = TestCoroutineDispatcher()
    ) : TestWatcher(), TestCoroutineScope by TestCoroutineScope(dispatcher) {

        override fun starting(description: Description?) {
            super.starting(description)
            Dispatchers.setMain(dispatcher)
        }

        override fun finished(description: Description?) {
            super.finished(description)
            cleanupTestCoroutines()
            Dispatchers.resetMain()
        }
    }
}