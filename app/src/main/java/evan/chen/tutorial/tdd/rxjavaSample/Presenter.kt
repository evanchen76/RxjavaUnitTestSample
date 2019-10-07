package evan.chen.tutorial.tdd.rxjavaSample

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class Presenter (private val repository: IRepository){

    lateinit var someString: String

    fun getSomeBoolean(){

        repository.getSingleString()
            .subscribe({ data ->
                someString = "$data Plus"
            },
                { throwable ->
                    println(throwable)
                })
    }
}