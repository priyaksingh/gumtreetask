/**
 * 
 */
package com.gumtree.task.service.exception;

// TODO: Auto-generated Javadoc
/**
 * The Class AddressBookFileReaderException.
 *
 * @author priyakrishna
 */
public class AddressBookFileReaderException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The error msg. */
	private String errorMsg;

	/**
	 * Instantiates a new address book file reader exception.
	 *
	 * @param errorMsg the error msg
	 */
	public AddressBookFileReaderException(final String errorMsg) {
		super(errorMsg);
	}

	/* (non-Javadoc)
	 * @see java.lang.Throwable#toString()
	 */
	public String toString() {
		return ("AddressBookFileReaderException occurred: " + errorMsg);
	}

}
