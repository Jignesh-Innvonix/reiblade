package com.reiblade.init;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class XLSReader {

	private final Fillo fillo;
	private final String filePath;

	private Connection connection;

	public XLSReader(String filePath) {
		fillo = new Fillo();
		this.filePath = filePath;
	}

	public String getField(String columnName, String query) throws FilloException {

		connection = fillo.getConnection(this.filePath);
		Recordset recordset = connection.executeQuery(query);
		return this.createSuite(columnName, recordset);

	}

	private String createSuite(String columnName, Recordset recordset) throws FilloException {

		String testName = null;
		while (recordset.next()) {

			testName = recordset.getField(columnName);
		}
		return testName;

	}

}
