package test.panowiep.android_router.observer

import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.PublishSubject
import test.panowiep.android_router.model.User


//
// inspiration: https://android.jlelse.eu/rxbus-kotlin-listen-where-ever-you-want-e6fc0760a4a8
//

class RxEvent {
    data class ShowProfile(val user: User?)
}



//

class EventObserver {

    fun publish(event: Any) {
        RxBus.publish(event)
    }

    // Listen should return an Observable and not the publisher
    // Using ofType we filter only events that match that class type
    fun <T> subscribe(eventType: Class<T>): Observable<T> = RxBus.listen(eventType)
}

//

// Use object so we have a singleton instance (1 instance of publisher)
object RxBus {

    private val publisher = PublishSubject.create<Any>()

    fun publish(event: Any) {
        publisher.onNext(event)
    }

    // Listen should return an Observable and not the publisher
    // Using ofType we filter only events that match that class type
    fun <T> listen(eventType: Class<T>): Observable<T> = publisher.ofType(eventType)

}