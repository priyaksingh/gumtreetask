/**
 * 
 */
package com.gumtree.task.service.exception;

// TODO: Auto-generated Javadoc
/**
 * The Class AddressBookProcessException.
 *
 * @author priyakrishna
 */
public class AddressBookProcessException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The error msg. */
	private String errorMsg;

	/**
	 * Instantiates a new address book process exception.
	 *
	 * @param errorMsg
	 *            the error msg
	 */
	public AddressBookProcessException(final String errorMsg) {
		super(errorMsg);
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Throwable#toString()
	 */
	public String toString() {
		return ("AddressBookProcessException occurred: " + errorMsg);
	}

}
