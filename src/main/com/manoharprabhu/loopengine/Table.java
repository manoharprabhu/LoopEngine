package com.manoharprabhu.loopengine;

public class Table {

	private final int rowSize, columnSize;

	private Cell[][] cells;

	public Table(int row, int column) {
		this.rowSize = row;
		this.columnSize = column;
		cells = new Cell[row][column];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				cells[i][j] = new Cell(0);
			}
		}
	}

	public void setStateAt(int row, int column, int state) {
		cells[row][column].setState(state);
	}

	public void turnCellClockwise(int cellRow, int cellColumn) {
		if (cellRow >= rowSize || cellColumn >= columnSize) {
			return;
		}

		cells[cellRow][cellColumn].turnCellClockwise();
	}

	public boolean isAllLoopClosed() {

		for (int i = 0; i < rowSize; i++) {
			for (int j = 0; j < columnSize; j++) {
				Cell currentCell = cells[i][j];

				Cell topCell = null;
				Cell bottomCell = null;
				Cell rightCell = null;
				Cell leftCell = null;
				if (i != 0) {
					topCell = cells[i - 1][j];
				}
				if (i < rowSize - 1) {
					bottomCell = cells[i + 1][j];
				}
				if (j != 0) {
					leftCell = cells[i][j - 1];
				}
				if (j < columnSize - 1) {
					rightCell = cells[i][j + 1];
				}

				if (currentCell.hasUpwardFacingOpening()) {
					if (topCell == null || !topCell.hasDownwardFacingOpening()) {
						return false;
					}
				}

				if (currentCell.hasDownwardFacingOpening()) {
					if (bottomCell == null
							|| !bottomCell.hasUpwardFacingOpening()) {
						return false;
					}
				}

				if (currentCell.hasLeftFacingOpening()) {
					if (leftCell == null || !leftCell.hasRightFacingOpening()) {
						return false;
					}
				}

				if (currentCell.hasRightFacingOpening()) {
					if (rightCell == null || !rightCell.hasLeftFacingOpening()) {
						return false;
					}
				}
			}
		}

		return true;
	}

	public int getRowSize() {
		return rowSize;
	}

	public int getColumnSize() {
		return columnSize;
	}

}
