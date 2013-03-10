/*
 * Vogon personal finance/expense analyzer.
 * License TBD.
 * Author: Dmitry Zolotukhin <zlogic@gmail.com>
 */
package org.zlogic.vogon.data.interop;

/**
 * Interface for importing data from files
 *
 * @author Dmitry Zolotukhin
 */
public interface FileImporter {

	/**
	 * Imports a file containing financial transactions
	 *
	 * @throws VogonImportException in case of any import errors (I/O, format
	 * etc.)
	 * @throws VogonImportLogicalException in case of any logical errors (such
	 * as an incorrect number of columns)
	 */
	public void importFile() throws VogonImportException, VogonImportLogicalException;
}