package kr.ohyung.domain.usecase.base

import io.reactivex.Completable
import io.reactivex.Scheduler

abstract class CompletableUseCase<in Params>(
    private val executorScheduler: Scheduler,
    private val postExecutionScheduler: Scheduler
) : BaseUseCase<Params>() {

    protected abstract fun buildUseCaseCompletable(): Completable

    override fun execute(params: Params): Completable =
        buildUseCaseCompletable()
            .subscribeOn(executorScheduler)
            .observeOn(postExecutionScheduler)
}
