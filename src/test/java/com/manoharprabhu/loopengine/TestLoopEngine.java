package com.manoharprabhu.loopengine;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

public class TestLoopEngine {

	@Test
	public void testEmpty() {
		LoopEngine loopEngine = new LoopEngine(1, 1);
		int states[][] = { { 0 } };
		loopEngine.setTableStates(states);

		assertTrue(loopEngine.isAllLoopClosed());
	}

	@Test
	public void testNotClosed() {
		LoopEngine loopEngine = new LoopEngine(1, 1);
		int states[][] = { { 1 } };
		loopEngine.setTableStates(states);

		assertFalse(loopEngine.isAllLoopClosed());
	}

	@Test
	public void testAllClosed() {
		LoopEngine loopEngine = new LoopEngine(1, 2);
		int states[][] = { { 2, 4 } };
		loopEngine.setTableStates(states);

		assertTrue(loopEngine.isAllLoopClosed());
	}

	@Test
	public void testAllOpen() {
		LoopEngine loopEngine = new LoopEngine(1, 2);
		int states[][] = { { 2, 2 } };
		loopEngine.setTableStates(states);

		assertFalse(loopEngine.isAllLoopClosed());
	}

	@Test
	public void testSomeOpen1() {
		LoopEngine loopEngine = new LoopEngine(2, 2);
		int states[][] = { { 2, 3 }, { 6, 1 } };
		loopEngine.setTableStates(states);

		assertFalse(loopEngine.isAllLoopClosed());
	}

	@Test
	public void testSomeOpen2() {
		LoopEngine loopEngine = new LoopEngine(2, 2);
		int states[][] = { { 3, 3 }, { 1, 5 } };
		loopEngine.setTableStates(states);

		assertFalse(loopEngine.isAllLoopClosed());
	}

	@Test
	public void testAllClosed2() {
		LoopEngine loopEngine = new LoopEngine(2, 2);
		int states[][] = { { 3, 3 }, { 1, 1 } };
		loopEngine.setTableStates(states);

		assertTrue(loopEngine.isAllLoopClosed());
	}

	@Test
	public void testAllClosed3() {
		LoopEngine loopEngine = new LoopEngine(3, 3);
		int states[][] = { { 0, 3, 0 }, { 2, 15, 4 }, { 0, 1, 0 } };
		loopEngine.setTableStates(states);

		assertTrue(loopEngine.isAllLoopClosed());
	}

	@Test
	public void testTurnClose() {
		LoopEngine loopEngine = new LoopEngine(2, 2);
		int states[][] = { { 3, 3 }, { 1, 4 } };
		loopEngine.setTableStates(states);
		assertFalse(loopEngine.isAllLoopClosed());
		loopEngine.turnCellClockWiseAt(1, 1);
		assertTrue(loopEngine.isAllLoopClosed());
		loopEngine.turnCellClockWiseAt(1, 1);
		assertFalse(loopEngine.isAllLoopClosed());
	}

}
