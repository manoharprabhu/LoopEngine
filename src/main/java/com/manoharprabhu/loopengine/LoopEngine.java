package com.manoharprabhu.loopengine;

public class LoopEngine {

	private Table table = null;

	public LoopEngine(int rowCount, int colCount) throws Exception {
		if(rowCount < 0 || colCount < 0) {
			throw new Exception("Cannot allocate table of negative size");
		}
		this.table = new Table(rowCount, colCount);
	}

	public void setTableStates(int[][] states) throws Exception {
		if (this.table.getRowSize() != states.length
				|| this.table.getColumnSize() != states[0].length) {
			throw new Exception("Mismatched table dimensions");
		}

		for (int i = 0; i < this.table.getRowSize(); i++) {
			for (int j = 0; j < this.table.getColumnSize(); j++) {
				if(states[i][j] < 0 || states[i][j] > 15) {
					throw new Exception("Invaid state passed");
				}
				this.table.setStateAt(i, j, states[i][j]);
			}
		}
	}
	
	public boolean isAllLoopClosed() {
		return this.table.isAllLoopClosed();
	}
	
	public void turnCellClockWiseAt(int row, int column) {
		this.table.turnCellClockwise(row, column);
	}

}
