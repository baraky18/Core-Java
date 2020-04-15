package com.simplethreads.commonproblems;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/*
 * instead of performing several sync operations (using Future object, 
 * that's blocking the thread each time we are calling future.get(), we are using CompletableFuture object which allows us
 * to group several operations into Async operations that's not blocking the thread
 */
public class LimitedScalabilityProblem {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ArrayList<Integer> employeeIds = new ArrayList<Integer>();
		for (Integer id : employeeIds) {
			CompletableFuture.supplyAsync(() -> fetchEmp(id))
			.thenApplyAsync(employee -> fetchTaxRate(employee))
			.thenApplyAsync(taxRate -> calculateTax(taxRate))
			.thenApplyAsync(taxValue -> sendEmail(taxValue));
		}
		
	}

	private static Object sendEmail(Object taxValue) {
		//send email to employee using REST service
		return null;
	}

	private static Object calculateTax(Object taxRate) {
		//calculate current year tax
		return null;
	}

	private static Object fetchTaxRate(Object employee) {
		//fetch employee tax rate from REST service
		return null;
	}

	private static Object fetchEmp(Integer id) {
		//fetch employee details from DB
		return null;
	}
}
