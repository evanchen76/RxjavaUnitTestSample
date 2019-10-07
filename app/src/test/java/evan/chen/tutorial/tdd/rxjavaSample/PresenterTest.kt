package evan.chen.tutorial.tdd.rxjavaSample

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.TestObserver
import io.reactivex.schedulers.Schedulers
import org.junit.Assert
import org.junit.Test

import org.junit.Assert.*
import org.mockito.Mockito
import org.mockito.Mockito.`when`

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class PresenterTest {

    @Test
    fun getDataTest() {
        val repository = Mockito.mock(IRepository::class.java)

        //Mock一個repository，回傳Observable
        `when`(repository.getSingleString()).thenReturn(Single.just("Test"))

        val presenter = Presenter(repository)
        presenter.getSomeBoolean()

        Assert.assertEquals("Test Plus", presenter.someString)
    }

    @Test
    fun testScheduler(){
        val testObserver = TestObserver<String>()

        val schedulerProvider = TrampolineSchedulerProvider()

        Single.just("1")
            .subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.mainThread())
            .subscribe(testObserver)

        testObserver.assertResult("1")
    }
}
