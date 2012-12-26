# Towers Of Hanoi
## Problem P-3.10 in G&T
Program that solves the Towers of Hanoi problem. This program will take in a number for the main tower size and then demonstrate the solution to move all of the blocks to another tower.

## Solution to Towers of Hanoi for 4 discs
Each row represents a tower, because I was too lazy to actually make it pretty.
<table border=1>
	<tr>
		<td>
			1.
			<ul>
				<li>- 4 3 2 1</li>
				<li>- </li>		
				<li>- </li>
			</ul>	
		</td>
		<td>
			2.
			<ul>
				<li>- 4 3 2</li>
				<li>- 1</li>
				<li>- </li>
			</ul>
		</td>
		<td>
			3.
			<ul>
				<li>- 4 3</li>
				<li>- 1</li>
				<li>- 2</li>
			</ul>
		</td>
		<td>
			4.
			<ul>
				<li>- 4 3</li>
				<li>- </li>
				<li>- 2 1</li>
			</ul>
		</td>
		<td>
			5.
			<ul>
				<li>- 4</li>
				<li>- 3 </li>
				<li>- 2 1</li>
			</ul>
		</td>
		<td>
			6.
			<ul>
				<li>- 4 1</li>
				<li>- 3 </li>
				<li>- 2</li>
			</ul>
		</td>
	</tr>
	<tr>
		<td>
			7.
			<ul>
				<li>- 4 1</li>
				<li>- 3 2</li>
				<li>- </li>
			</ul>
		</td>
		<td>
			8.
			<ul>
				<li>- 4</li>
				<li>- 3 2 1</li>
				<li>- </li>
			</ul>
		</td>
		<td>
			9.
			<ul>
				<li>- </li>
				<li>- 3 2 1</li>
				<li>- 4</li>
			</ul>
		</td>
		<td>
			10.
			<ul>
				<li>- </li>
				<li>- 3 2</li>
				<li>- 4 1</li>
			</ul>
		</td>
		<td>
			11.
			<ul>
				<li>- 2</li>
				<li>- 3</li>
				<li>- 4 1</li>
			</ul>
		</td>
		<td>
			12.
			<ul>
				<li>- 2 1</li>
				<li>- 3</li>
				<li>- 4</li>
			</ul>
		</td>
	</tr>
	<tr>
		<td>
			13.
			<ul>
				<li>- 2 1</li>
				<li>-</li>
				<li>- 4 3</li>
			</ul>
		</td>
		<td>
			14.
			<ul>
				<li>- 2<br></li>
				<li>- 1<br></li>
				<li>- 4 3<br></li>
			</ul>
		</td>
		<td>
			15.
			<ul>
				<li>- </li>
				<li>- 1</li>
				<li>- 4 3 2</li>
			</ul>
		</td>
		<td>
			16.
			<ul>
				<li>- </li>
				<li>- </li>
				<li>- 4 3 2 1</li>
			</ul>
		</td>
	</tr>
</table>

## Notes for the Solution

### Ideas for how this works
* Sequential building-up and breaking-down of towers to get from one thing to another thing
* Buiding up and breaking down depends on how many more blocks to place and where we want the blocks to go

### Pseudo code for solving the towers of hanoi
Code for breaking down a tower, which wants to go to towerTo
```
BreakDown(towerFrom, towerTo, bottomSize)
	while(towerFrom.Top <= bottomSize)
		isOddBlock = (bottomSize - towerFrom.Top) % 2
		if(isOddBlock)
			try to put towerFrom.Top onto not towerTo
			if can't, BuildUp(towerTo, bottomSize - towerFrom.Top)
		else
			try to put towerFrom.Top onto towerTo
			if can't, BuildUp(not towerTo, bottomSize - towerFrom.Top)
		end
	end
end
```

Code for building up a tower with base block size bottomSize
```
BuildUp(tower, bottomSize)
	while(tower.Top != 1)
		if(either other tower has tower.Top-1 on top)
			move otherTower.top to tower.Top
		else
			BreakDown(tower with needed block, other tower ,tower.Top-1)
		end
	end
end
```
woo!
