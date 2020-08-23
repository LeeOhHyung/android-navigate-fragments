package kr.ohyung.navigation.utility

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kr.ohyung.common.utility.BaseSchedulerProvider

class AppSchedulerProvider : BaseSchedulerProvider {
    override fun io(): Scheduler = Schedulers.io()
    override fun mainThread(): Scheduler = AndroidSchedulers.mainThread()
    override fun computation(): Scheduler = Schedulers.computation()
    override fun trampoline(): Scheduler = Schedulers.trampoline()
}
