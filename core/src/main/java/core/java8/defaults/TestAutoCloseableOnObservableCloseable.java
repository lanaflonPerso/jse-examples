package com.core.java8.defaults;

import java.io.IOException;

public class TestAutoCloseableOnObservableCloseable {

	public static void main(String...args) throws IOException {

		try (SomeCloseableClass someObject = new SomeCloseableClass()) {
			someObject.addObserver(new CloseListener() {
				@Override
				public void objectWillBeClosed(CloseableObservable closeable) {
					System.out.println("Object will be closed!");
				}

				@Override
				public void objectClosed(CloseableObservable closeable) {
					System.out.println("Object was closed!");
				}
			});
		} // try-with-resource

	} // main
}*/