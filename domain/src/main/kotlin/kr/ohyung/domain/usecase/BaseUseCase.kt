package kr.ohyung.domain.usecase

import kr.ohyung.domain.UseCase

/**
 * Created by Lee Oh Hyung on 2020/08/23.
 */
abstract class BaseUseCase<in Params> : UseCase {

    abstract fun execute(params: Params): Any

}
