package kr.ohyung.domain.usecase

import io.reactivex.Scheduler
import io.reactivex.Single
import kr.ohyung.domain.entity.UserProfile
import kr.ohyung.domain.repository.UserRepository
import kr.ohyung.domain.usecase.base.SingleUseCase

class GetUserProfileUseCase(
    private val userRepository: UserRepository,
    executorScheduler: Scheduler,
    postExecutionScheduler: Scheduler
) : SingleUseCase<UserProfile, String>(executorScheduler, postExecutionScheduler) {

    override fun buildUseCaseSingle(params: String): Single<UserProfile> =
        userRepository.getUserProfile(params)
}
