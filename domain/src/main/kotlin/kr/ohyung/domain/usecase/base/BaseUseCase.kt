package kr.ohyung.domain.usecase.base

import kr.ohyung.domain.UseCase

abstract class BaseUseCase<in Params> : UseCase {
    abstract fun execute(params: Params): Any
}
