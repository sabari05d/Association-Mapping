package org.jsp.many2manyBi.controller;

import org.jsp.many2manyBi.dao.BatchStudentDao;

public class BatchStudentApp {
	static BatchStudentDao dao = new BatchStudentDao();
	public static void main(String[] args) {
		
	dao.FindStudentsByTrainerAndBatchCode();
	
	}
}
