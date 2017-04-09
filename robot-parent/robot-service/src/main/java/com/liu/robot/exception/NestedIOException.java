package com.liu.robot.exception;

import java.io.IOException;

@SuppressWarnings("serial")
public class NestedIOException extends IOException {




	/**
	 * Construct a {@code NestedIOException} with the specified detail message.
	 * @param msg the detail message
	 */
	public NestedIOException(String msg) {
		super(msg);
	}

	/**
	 * Construct a {@code NestedIOException} with the specified detail message
	 * and nested exception.
	 * @param msg the detail message
	 * @param cause the nested exception
	 */
	public NestedIOException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
