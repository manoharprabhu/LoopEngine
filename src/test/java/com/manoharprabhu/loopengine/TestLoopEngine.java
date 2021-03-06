package com.manoharprabhu.loopengine;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

public class TestLoopEngine {

	@Test
	public void testEmpty() throws Exception {
		LoopEngine loopEngine = new LoopEngine(1, 1);
		int states[][] = { { 0 } };
		loopEngine.setTableStates(states);

		assertTrue(loopEngine.isAllLoopClosed());
	}

	@Test
	public void testNotClosed() throws Exception {
		LoopEngine loopEngine = new LoopEngine(1, 1);
		int states[][] = { { 1 } };
		loopEngine.setTableStates(states);

		assertFalse(loopEngine.isAllLoopClosed());
	}

	@Test
	public void testAllClosed() throws Exception {
		LoopEngine loopEngine = new LoopEngine(1, 2);
		int states[][] = { { 2, 4 } };
		loopEngine.setTableStates(states);

		assertTrue(loopEngine.isAllLoopClosed());
	}

	@Test
	public void testAllOpen() throws Exception {
		LoopEngine loopEngine = new LoopEngine(1, 2);
		int states[][] = { { 2, 2 } };
		loopEngine.setTableStates(states);

		assertFalse(loopEngine.isAllLoopClosed());
	}

	@Test
	public void testSomeOpen1() throws Exception {
		LoopEngine loopEngine = new LoopEngine(2, 2);
		int states[][] = { { 2, 3 }, { 6, 1 } };
		loopEngine.setTableStates(states);

		assertFalse(loopEngine.isAllLoopClosed());
	}

	@Test
	public void testSomeOpen2() throws Exception {
		LoopEngine loopEngine = new LoopEngine(2, 2);
		int states[][] = { { 3, 3 }, { 1, 5 } };
		loopEngine.setTableStates(states);

		assertFalse(loopEngine.isAllLoopClosed());
	}

	@Test
	public void testAllClosed2() throws Exception {
		LoopEngine loopEngine = new LoopEngine(2, 2);
		int states[][] = { { 3, 3 }, { 1, 1 } };
		loopEngine.setTableStates(states);

		assertTrue(loopEngine.isAllLoopClosed());
	}

	@Test
	public void testAllClosed3() throws Exception {
		LoopEngine loopEngine = new LoopEngine(3, 3);
		int states[][] = { { 0, 3, 0 }, { 2, 15, 4 }, { 0, 1, 0 } };
		loopEngine.setTableStates(states);

		assertTrue(loopEngine.isAllLoopClosed());
	}

	@Test
	public void testTurnClose() throws Exception {
		LoopEngine loopEngine = new LoopEngine(2, 2);
		int states[][] = { { 3, 3 }, { 1, 4 } };
		loopEngine.setTableStates(states);
		assertFalse(loopEngine.isAllLoopClosed());
		loopEngine.turnCellClockWiseAt(1, 1);
		assertTrue(loopEngine.isAllLoopClosed());
		loopEngine.turnCellClockWiseAt(1, 1);
		assertFalse(loopEngine.isAllLoopClosed());
	}

	@Test
	public void testTurnClose2() throws Exception {
		LoopEngine loopEngine = new LoopEngine(3, 3);
		int states[][] = { { 1, 4, 3 }, { 0, 0, 4 }, { 0, 0, 0 } };
		loopEngine.setTableStates(states);
		assertFalse(loopEngine.isAllLoopClosed());
		loopEngine.turnCellClockWiseAt(0, 0);
		assertFalse(loopEngine.isAllLoopClosed());
		loopEngine.turnCellClockWiseAt(1, 2);
		assertTrue(loopEngine.isAllLoopClosed());
	}
	
	@Test(expected=Exception.class)
	public void testMismatchDimentions() throws Exception {
		LoopEngine loopEngine = new LoopEngine(3, 3);
		int states[][] = { { 1, 4, 3 }, { 0, 0, 4 }};
		loopEngine.setTableStates(states);
	}
	
	@Test(expected=Exception.class)
	public void testInvalidStateMore() throws Exception {
		LoopEngine loopEngine = new LoopEngine(2, 3);
		int states[][] = { { 1, 18, 3 }, { -1, 0, 4 }};
		loopEngine.setTableStates(states);
	}
	
	@Test(expected=Exception.class)
	public void testInvalidStateLess() throws Exception {
		LoopEngine loopEngine = new LoopEngine(2, 3);
		int states[][] = { { -1, 18, 3 }, { -1, 0, 4 }};
		loopEngine.setTableStates(states);
	}
	
	@Test(expected=Exception.class)
	public void testInvalidStateColSize() throws Exception {
		LoopEngine loopEngine = new LoopEngine(2, 4);
		int states[][] = { { 1, 1, 3 }, { 1, 1, 4 }};
		loopEngine.setTableStates(states);
	}
	
	@Test(expected=Exception.class)
	public void testNegativeInitializationRow() throws Exception {
		LoopEngine loopEngine = new LoopEngine(-5, 3);
		int states[][] = { { 1, 18, 3 }, { -1, 0, 4 }};
		loopEngine.setTableStates(states);
	}
	
	@Test(expected=Exception.class)
	public void testNegativeInitializationCol() throws Exception {
		LoopEngine loopEngine = new LoopEngine(2, -3);
		int states[][] = { { 1, 18, 3 }, { -1, 0, 4 }};
		loopEngine.setTableStates(states);
	}
	
	@Test
	public void testRandomActions() throws Exception {
		LoopEngine loopEngine = new LoopEngine(4, 4);
		int states[][] = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,1}};
		loopEngine.setTableStates(states);
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				loopEngine.turnCellClockWiseAt(i, j);
			}
		}
		Assert.assertFalse(loopEngine.isAllLoopClosed());
	}

}
