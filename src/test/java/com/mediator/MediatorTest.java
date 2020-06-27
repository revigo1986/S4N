package com.mediator;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MediatorTest {

	@Test
	public void shouldExecuteMainProcess() {
		IMediator mediator = new Mediator();
		boolean executionOk = false; 
		executionOk = mediator.executeProcess();
		assertTrue(executionOk);
	}
}
