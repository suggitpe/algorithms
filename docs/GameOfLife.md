# Game of Life

## Rule
Life is played on a grid of square cells--like a chess board but extending infinitely in every direction. A cell can be live or dead. A live cell is shown by putting a marker on its square. A dead cell is shown by leaving the square empty. Each cell in the grid has a neighborhood consisting of the eight cells in every direction including diagonals.

To apply one step of the rules, we count the number of live neighbors for each cell. What happens next depends on this number.

* A dead cell with exactly three live neighbors becomes a live cell (birth).
* A live cell with two or three live neighbors stays alive (survival).		
* In all other cases, a cell dies or remains dead (overcrowding or loneliness).
			
Note: The number of live neighbors is always based on the cells before the rule was applied. In other words, we must first find all of the cells that change before changing any of them. Sounds like a job for a computer!

## Musings
### The first test
I always forget how difficult the first test is when developing in a test driven manner.  Then it hits me.  Just get a failing test, that's the only thing that matters to get you going.  As you write the test you are listening to it.  My first test positively screams at me.  I then begin to understand the next better test, and then the next one .. and so on.
