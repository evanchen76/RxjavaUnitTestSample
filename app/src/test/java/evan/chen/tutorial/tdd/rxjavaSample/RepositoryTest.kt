package evan.chen.tutorial.tdd.rxjavaSample

import io.reactivex.Single
import io.reactivex.Observable
import io.reactivex.observers.TestObserver
import org.junit.Assert
import org.junit.Test
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class RepositoryTest {

    @Test
    fun getDataTest() {

        val singleString = Repository().getSingleString()

        val expected = "Test"
        val actual = singleString.blockingGet()

        Assert.assertEquals(expected, actual)
    }

    @Test
    fun getDataTest2() {

        val singleString = Repository().getSingleString()

        val testObserver = TestObserver<String>()
        singleString.subscribe(testObserver)
        testObserver.assertResult("Test")

        testObserver.assertValueCount(1)

    }

    @Test
    fun test(){
        val testObserver = TestObserver<String>()
        Observable.just("a", "b", "c")
            .subscribe(testObserver)

        testObserver.assertValues("a", "b", "c" )

    }

}
