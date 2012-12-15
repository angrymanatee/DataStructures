package main;

import java.lang.IllegalArgumentException;
import java.lang.IllegalStateException;


/**
 *	Towers of Hanoi object. Contains three stacks for the towers  and methods
 *	for playing the game. 
 *	@author angrymanatee
 */
public class TowersOfHanoi {

	private static final int NUMBER_OF_TOWERS = 3;

	private Tower[] tower;

	/**
	 *	Makes a new set of towers
	 *	@param start tower that has initial data
	 *	@param depth number of blocks to start initial tower with
	 */
	public TowersOfHanoi(int start, int depth) {
		this.tower = new Tower[NUMBER_OF_TOWERS];
		for(int currentTower = 0; currentTower<NUMBER_OF_TOWERS; currentTower++) {
			if(currentTower==start-1)
				this.tower[currentTower] = new Tower(depth);
			else
				this.tower[currentTower] = new Tower(0);
		}
	}

	/**
	 *	moves block from one tower to another
	 *	@param from initial position
	 *	@param to final position
	 */
	public void moveBlock(int from, int to) {
		int movingBlockSize = tower[from].peek();
		try{
			tower[to].push(tower[from].pop());
		}
		catch(IllegalArgumentException e) {
			throw new IllegalArgumentException("Can't put block size " + 
				movingBlockSize + "onto tower " + to + 
				"which has top block size" + tower[to].peek() + ".");
		}
		catch(IllegalStateException e) {
			throw new IllegalArgumentException("Nothing in Tower " + to +
				"to move.");
		}
	}

	/**
	 *	Returns list of tower elements
	 *	@return Tab delineated list of tower elements
	 */
	public String inspectFullTower(int towerToInspect) {
		return tower[towerToInspect].toString();
	}

	/**
	 *	peek at top element of a tower
	 *	@return size of the top block 
	 */
	public int topElement(int towerToPeek) {
		return tower[towerToPeek].peek();
	}
	

	/**
	 *	String representation of the towers
	 *	@return towers created
	 */
	public String toString() {
		String output = "";
		for(Tower currentTower : tower)
			output += currentTower.toString() + "\n";
		return output;
	}

	/**
	 *	Tower of blocks, implemented as a stack.
	 */
	private class Tower {

		private Block top;

		/**
		 *	Creates a tower with the given number of blocks.
		 *	@param startingNumberOfBlocks number of blocks to instantiate the tower with.
		 */
		public Tower(int startingNumberOfBlocks) 
				throws IllegalArgumentException 
		{
			if(startingNumberOfBlocks!=0) {
				top = new Block(startingNumberOfBlocks,null);
				for(int i = startingNumberOfBlocks-1; i > 0; i--) {
					top = new Block(i,top);
				}
			}
			else if(startingNumberOfBlocks==0) {
				top = null;
			}
			else {
				throw new IllegalArgumentException(
					"Towers can't go down, dude. (input is " + 
					startingNumberOfBlocks + ").");
			}
		}

		/**
		 *	Puts a new block on top of the tower
		 *	@param newTopBlock block to be put on top of the stack
		 */
		public void push(Block newTopBlock) {
			if(newTopBlock == null) {
				throw new IllegalArgumentException("Can't Push Nothing");
			}
			newTopBlock.setNextBlock(this.top);
			this.top = newTopBlock;
		}

		/**
		 *	Removes the top block of the tower.
		 *	@return The block that was on top of this tower
		 */
		public Block pop() throws IllegalStateException {
			if(this.top == null) {
				throw new IllegalStateException("Nothing to pop...");
			}
			Block blockToReturn = this.top;
			this.top = this.top.nextBlock();
			return blockToReturn;
		}

		/**
		 *	Tells user what size the top block is
		 *	@return size of top block. Zero if no top block.
		 */
		public int peek() {
			if(this.top == null) {
				return 0;
			}
			else return this.top.getSize();
		}

		/**
		 *	Gives String representation of this block and the blocks underneath
		 *	it.
		 *	@param inspectee block to check
		 *	@return Tab delineated String of blocks beneath this one. Ordered from highest (smallest) block to lowest (largest) block.
		 */
		public String inspect(Block inspectee) {
			if(inspectee.nextBlock()==null) {
				return Integer.toString(inspectee.getSize());
			}
			else {
				return inspectee.getSize() + "\t" +
					this.inspect(inspectee.nextBlock());
			}
		}

		public String toString() {
			return inspect(this.top);
		}
		
	}

	/**
	 *	One block in the tower. Has a size and points to the next block 
	 *	beneath it.
	 */
	private class Block {
		private Block next;
		private int size;

		/**
		 *	Creates a block
		 *	@param size Size of this block
		 *	@param next Block that this one sits on. Null if this is the bottom block.
		 */
		public Block(int size, Block next) {
			this.size = size;
			this.next = next;
		}

		/**
		 *	Gets the size of the block
		 *	@return Size of block (int)
		 */
		public int getSize() {
			return this.size;
		}

		/**
		 *	Gets the block that this one is on top of
		 *	@return block that this one sits on. Null if this is the bottom.
		 */
		public Block nextBlock() {
			return this.next;
		}

		/**
		 *	Puts this block on top of a different block.
		 *	@param nextBlock block to put this block on top of.
		 */
		public void setNextBlock(Block nextBlock) 
				throws IllegalArgumentException {
			if(nextBlock!=null && nextBlock.getSize() <= this.getSize()) {
				throw new IllegalArgumentException(
					"Cannot put this block of size " + 
					this.getSize() + "On top of a block size " + 
					nextBlock.getSize() + "!!!");
			}
			else {
				this.next = nextBlock;
			}
		}

		/**
		 *	Returns the size of this block in stringy form.
		 */
		public String toString() {
			return Integer.toString(this.getSize());
		}
	}
}