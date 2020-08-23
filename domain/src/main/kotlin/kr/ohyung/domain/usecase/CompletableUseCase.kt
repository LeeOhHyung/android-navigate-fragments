package kr.ohyung.domain.usecase

import io.reactivex.Completable
import io.reactivex.Scheduler

/**
 * Created by Lee Oh Hyung on 2020/08/23.
 */
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
