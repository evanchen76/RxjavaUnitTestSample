package evan.chen.tutorial.tdd.rxjavaSample

import io.reactivex.schedulers.Schedulers

interface ISchedulerProvider {
    fun computation() = Schedulers.trampoline()
    fun mainThread() = Schedulers.trampoline()
    fun io() = Schedulers.trampoline()
}