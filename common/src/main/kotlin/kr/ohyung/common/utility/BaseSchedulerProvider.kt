package kr.ohyung.common.utility

import io.reactivex.Scheduler

interface BaseSchedulerProvider {
    fun io(): Scheduler
    fun mainThread(): Scheduler
    fun computation(): Scheduler
    fun trampoline(): Scheduler
}
