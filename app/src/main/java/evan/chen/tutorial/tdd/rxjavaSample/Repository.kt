package evan.chen.tutorial.tdd.rxjavaSample

import io.reactivex.Single

interface IRepository {
    fun getSingleString(): Single<String>
}

class Repository : IRepository {

    override fun getSingleString(): Single<String>{
        return Single.just("Test")
    }
}