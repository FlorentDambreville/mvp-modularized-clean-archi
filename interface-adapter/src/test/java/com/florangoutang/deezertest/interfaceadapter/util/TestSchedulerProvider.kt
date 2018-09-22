package com.florangoutang.deezertest.interfaceadapter.util

import com.florangoutang.deezertest.interfaceadapter.util.scheduler.BaseSchedulerProvider
import io.reactivex.schedulers.TestScheduler

class TestSchedulerProvider : BaseSchedulerProvider {

    override fun computation()= TestScheduler()

    override fun io() = TestScheduler()

    override fun ui() = TestScheduler()

}