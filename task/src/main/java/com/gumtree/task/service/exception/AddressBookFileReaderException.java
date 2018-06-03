/**
 * 
 */
package com.gumtree.task.service.exception;

/**
 * @author priyakrishna
 */
public class AddressBookFileReaderException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String errorMsg;

	public AddressBookFileReaderException(final String errorMsg) {
		super(errorMsg);
	}

	public String toString() {
		return ("AddressBookFileReaderException occurred: " + errorMsg);
	}

}
