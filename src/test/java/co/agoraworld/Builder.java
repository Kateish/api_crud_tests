package co.agoraworld;

import java.util.function.Consumer;

public interface Builder<T> {
    T build();

    static <T> T given(Builder<T> builder) {
        return builder.build();
    }

    static <T> Builder<T> the(T object) {
        return () -> object;
    }

    static <T> Assertion<T> when(T object) {
        return new Assertion<>(object);
    }

    class Assertion<T> {

        private final T object;

        public Assertion(T object) {
            this.object = object;
        }

        public Assertion<T> thenThere(Consumer<T> consumer) {
            consumer.accept(object);
            return this;
        }
    }
}

