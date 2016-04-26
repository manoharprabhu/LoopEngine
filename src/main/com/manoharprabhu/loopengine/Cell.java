package com.manoharprabhu.loopengine;

import java.util.ArrayList;

public class Cell {
	private int state = 0;

	public Cell(int state) {
		this.state = state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public boolean hasUpwardFacingOpening(){
		return Cell.statesWithTopOpen.contains(this.state);
	}
	
	public boolean hasDownwardFacingOpening(){
		return Cell.statesWithBottomOpen.contains(this.state);
	}
	
	public boolean hasLeftFacingOpening(){
		return Cell.statesWithLeftOpen.contains(this.state);
	}
	
	public boolean hasRightFacingOpening(){
		return Cell.statesWithRightOpen.contains(this.state);
	}

	public void turnCellClockwise() {
		switch (this.state) {
		case 0:
			this.state = 0;
			break;
		case 1:
			this.state = 2;
			break;
		case 2:
			this.state = 3;
			break;
		case 3:
			this.state = 4;
			break;
		case 4:
			this.state = 1;
			break;
		case 5:
			this.state = 8;
			break;
		case 6:
			this.state = 9;
			break;
		case 7:
			this.state = 5;
			break;
		case 8:
			this.state = 10;
			break;
		case 9:
			this.state = 6;
			break;
		case 10:
			this.state = 7;
			break;
		case 11:
			this.state = 13;
			break;
		case 12:
			this.state = 11;
			break;
		case 13:
			this.state = 14;
			break;
		case 14:
			this.state = 12;
			break;
		case 15:
			this.state = 15;
			break;

		default:
			break;
		}
	}

	private static final ArrayList<Integer> statesWithTopOpen = new ArrayList<Integer>() {
		{
			add(1);
			add(5);
			add(6);
			add(7);
			add(11);
			add(12);
			add(14);
			add(15);
		}
	};
	private static final ArrayList<Integer> statesWithBottomOpen = new ArrayList<Integer>() {
		{
			add(3);
			add(6);
			add(8);
			add(10);
			add(11);
			add(13);
			add(14);
			add(15);
		}
	};
	private static final ArrayList<Integer> statesWithLeftOpen = new ArrayList<Integer>() {
		{
			add(4);
			add(7);
			add(9);
			add(10);
			add(12);
			add(13);
			add(14);
			add(15);
		}
	};
	private static final ArrayList<Integer> statesWithRightOpen = new ArrayList<Integer>() {
		{
			add(2);
			add(5);
			add(8);
			add(9);
			add(11);
			add(12);
			add(13);
			add(15);
		}
	};
}
