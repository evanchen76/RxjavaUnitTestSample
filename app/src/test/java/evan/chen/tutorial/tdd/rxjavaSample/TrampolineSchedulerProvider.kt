package evan.chen.tutorial.tdd.rxjavaSample

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class TrampolineSchedulerProvider :ISchedulerProvider{
    override fun computation() = Schedulers.computation()
    override fun mainThread() = Schedulers.trampoline()
    override fun io() = Schedulers.trampoline()
}