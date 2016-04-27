package com.manoharprabhu.loopengine;

public class LoopEngine {

	private Table table = null;

	public LoopEngine(int rowCount, int colCount) {
		this.table = new Table(rowCount, colCount);
	}

	public void setTableStates(int[][] states) {
		if (this.table.getRowSize() != states.length
				|| this.table.getColumnSize() != states[0].length) {
			return;
		}

		for (int i = 0; i < this.table.getRowSize(); i++) {
			for (int j = 0; j < this.table.getColumnSize(); j++) {
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
