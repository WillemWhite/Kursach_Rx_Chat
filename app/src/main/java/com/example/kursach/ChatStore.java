package com.example.kursach;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

public class ChatStore {
    private final Map<String, ChatMessage> cache =
            new HashMap<>();

   /*  Observable<T> - наблюдаемый (aka Subject, Flowable...)
    *  Observer - наблюдатель. (поток, блок кода, который регистрирует новое значение observable)
    *  Disposable(распоряжаемый) dispose = Observable.subscribe(observer)
    *
    *  anonymous function: a -> { func(a) }
    *
    *  int i = 0..10 - изменяемое наблюдоемое
    *
    *  Observable<int> values = Observable.create(sub -> {
    *  sub.onNext(int i, приходящие новыми от Observable, само наблюдаемое values);
    *  sub.onCompleted();
    *  });
    * */
    private final PublishSubject<Collection<ChatMessage>> subject =
            PublishSubject.create();

    public void put(ChatMessage value) {
        cache.put(value.getId(), value);
        subject.onNext(cache.values());
    }

    public Observable<Collection<ChatMessage>> getStream() {
        return subject;
    }
}
