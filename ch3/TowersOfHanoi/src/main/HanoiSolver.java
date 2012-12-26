package main;

import java.lang.IllegalArgumentException;

/**
 *	Solver for the towers of hanoi
 *	@author angrymanatee
 */
public class HanoiSolver {

	TowersOfHanoi 	towerSet;

	int startingTower;
	int endingTower;
	int startingDepth;

	int turnNumber;


	/**
	 *	Creates a Hanoi Solver with the specified towers
	 *	@param start tower to put starting blocks on
	 *	@param end tower that we want to end up on
	 *	@param depth number of blocks to have on starting tower
	 */
	public HanoiSolver(int start, int end, int depth) {
		this.startingTower 	= start;
		this.endingTower 	= end;
		this.startingDepth 	= depth;

		this.towerSet 		= new TowersOfHanoi(start,depth);

		this.turnNumber 	= 0;
	}

	/**
	 *	Solves the towers that make up this object
	 */
	public void SolveTowers() {

		if(startingDepth == 0) {
			return;
		}

		System.out.println(this.toString());
		this.BreakDown(startingTower, endingTower, startingDepth);
		this.BuildUp(endingTower,startingTower,startingDepth);
	}


	/**
	 *	Part of the tower solver. Breaks down the tower
	 *	@param towerFrom number tower to break down. [1-3]
	 *	@param towerTo tower that we want the blocks from towerFrom to go to. [1-3]
	 *	@param bottomSize bottom of the tower to break down
	 */
	private void BreakDown(int towerFrom, int towerTo, int bottomSize) {

		int notTowerTo = getOtherTower(towerFrom,towerTo);

		while(towerSet.TopBlock(towerFrom) <= bottomSize) {
			int isOddBlock = (bottomSize - towerSet.TopBlock(towerFrom))%2;
			if(isOddBlock==1) {
				if(towerSet.TopBlock(towerFrom) < towerSet.TopBlock(notTowerTo)) {
					towerSet.MoveBlock(towerFrom,notTowerTo);
					turnNumber++;
					System.out.println(this.toString());
				}
				else {
					this.BuildUp(towerTo, towerFrom, towerSet.TopBlock(towerFrom)-1);
				}
			}
			else {
				if(towerSet.TopBlock(towerFrom) < towerSet.TopBlock(towerTo)) {
					towerSet.MoveBlock(towerFrom,towerTo);
					turnNumber++;
					System.out.println(this.toString());
				}	
				else {
					this.BuildUp(notTowerTo, towerFrom, towerSet.TopBlock(towerFrom)-1);
				}
			}
		}
	}

	/**
	 *	Part of the tower solver. Builds the specified tower 
	 *	@param towerToBuild Desired tower to be build
	 *	@param towerTarget Tower to not build on top of because it is the original tower
	 *	@param bottomSize Size of tower we want to build
	 */ 
	private void BuildUp(int towerToBuild, int towerTarget, int bottomSize) {
		
		int notTowerTarget = getOtherTower(towerToBuild,towerTarget);

		while( towerSet.TopBlock(towerToBuild) > 1 ) {
			if(towerSet.TopBlock(towerTarget) == towerSet.TopBlock(towerToBuild) - 1) {
				towerSet.MoveBlock(towerTarget,towerToBuild);
				turnNumber++;
				System.out.println(this.toString());
			}
			else if(towerSet.TopBlock(notTowerTarget) == towerSet.TopBlock(towerToBuild) - 1) {
				towerSet.MoveBlock(notTowerTarget,towerToBuild);
				turnNumber++;
				System.out.println(this.toString());
			}
			else {
				if(towerSet.TopBlock(towerTarget) == 1 ) {
					this.BreakDown(towerTarget, towerToBuild, towerSet.TopBlock(towerToBuild) - 1);
				}
				else {
					this.BreakDown(notTowerTarget, towerToBuild, towerSet.TopBlock(towerToBuild) - 1);
				}
			}
		}
	}

	/**
	 *	Computes tower not specified
	 *	@param tower1 first tower to not return [1-3]
	 *	@param tower2 second tower to not return [i-3]
	 *	@return the other tower [1-3]
	 */
	private int getOtherTower(int tower1, int tower2) {
		switch(tower1) {
			case 1:
				if(tower2 == 2) return 3;
				else return 2;
			case 2:
				if(tower2 == 1) return 3;
				else return 1;
			case 3:
				if(tower2 == 1) return 2;
				else return 1;
			default:
				throw new IllegalArgumentException(
					"The tower to choose must be 1, 2, or 3. Given: " 
					+ tower1 
					+ " and " 
					+ tower2);
		}
	}


	/**
	 *	Prints a string representation of the current tower state
	 *	@return String representation of the tower state, 
	 *	including the current turn number and which blocks are in which towers
	 */
	public String toString() {
		return (new StringBuilder().append("Turn: ")
			.append(turnNumber)
			.append("\n")
			.append(towerSet.toString())
			.append('\n')).toString();
	}





	public static final int STARTING_TOWER_STANDARD = 1;
	public static final int ENDING_TOWER_STANDARD = 3;
	/**
	 *	Creates a simple instance of this Tower Solver
	 *	@oaram args Either null or the number of initial blocks
	 */
	public static void main(String[] args) {
		int inputTowerSize;
		HanoiSolver solver;

		switch(args.length) {
			case 0: 
				inputTowerSize = 4; 
				solver = new HanoiSolver(
					STARTING_TOWER_STANDARD, 
					ENDING_TOWER_STANDARD, 
					inputTowerSize);
				solver.SolveTowers();
				break;
				
			case 1: 
				try{
					inputTowerSize = Integer.parseInt(args[0]);
					solver = new HanoiSolver(
						STARTING_TOWER_STANDARD, 
						ENDING_TOWER_STANDARD, 
						inputTowerSize);
					solver.SolveTowers();
					break;
				}
				catch(IllegalArgumentException e) {
					System.out.println("Must have integer input");
					System.exit(1);
				}
			default:
				System.out.println("Only one input argument, please. :)");
				System.exit(2);
				break;
		}
	}
}