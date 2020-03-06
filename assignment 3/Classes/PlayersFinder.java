package eg.edu.alexu.csd.datastructure.iceHockey;

public class PlayersFinder implements IPlayersFinder{
	int xLength;
	int yLength;
	public java.awt.Point[] findPlayers(String[] photo, int team, int threshold)
	{
		if (photo == null || photo.length == 0 || photo[0].length() == 0 ) 
		{
			System.out.println("the image is empty");
			return null;
		}
		else 
		{
			yLength = photo[0].length();
			xLength = photo.length;
			float mincells = (float) threshold / (float) 4;
			Cell[][] cells = new Cell[xLength][yLength];
			int size = (xLength * yLength) / 2 + 2;
			Player[] expected = new Player[size];
			
			for (int i = 0; i < xLength; i++) {
				for (int j = 0; j < yLength; j++) {
					cells[i][j] = new Cell();
					int z = photo[i].charAt(j) - '0';
					if (z == team) {
						cells[i][j].setMatch();
					}
				}
			}
			
			int numberexpected = count(cells ,expected), counter = 0;
			for (int i = 0; i < numberexpected; i++) {
				if (expected[i].getNumber() >= mincells) {
					expected[i].setAccepted();
					expected[i].setCenter();
					counter++;
				}
			}
			
			java.awt.Point[] players = new java.awt.Point[counter];
			int zz = 0;
			for (int i = 0; i < numberexpected; i++) {
				if(expected[i].getAccepted()) {
					players[zz] = new java.awt.Point(expected[i].getCenterX(), expected[i].getCenterY());
					zz++;
				}
			}
			
			sort(players, counter);
			return players;
		}
	}
	
	
	public Boolean valid (int i, int j) {
		if (i < 0 || i >= xLength || j < 0 || j >= yLength) {
			return false;
		}
		return true;
	}
	
	
	public int count(Cell[][] cells, Player[] expected) {
		int counter = 0;
		for (int i = 0; i < xLength; i++) {
			for (int j = 0; j < yLength; j++) {
				if (cells[i][j].getMatch() && cells[i][j].getPlayer() == -1) {
					int a = -1, b = -1;
					if(valid (i - 1, j) && cells[i - 1][j].getMatch() && cells[i - 1][j].getPlayer() != -1) {
						a = i - 1;
						b = j;
					}
					else if (valid (i, j - 1) && cells[i][j - 1].getMatch() && cells[i][j - 1].getPlayer() != -1) {
						a = i;
						b = j - 1;
					}
					else if (valid (i, j + 1) && cells[i][j + 1].getMatch() && cells[i][j + 1].getPlayer() != -1) {
						a = i;
						b = j + 1;
					}
					else if (valid (i + 1, j) && cells[i + 1][j].getMatch() && cells[i + 1][j].getPlayer() != -1) {
						a = i + 1;
						b = j;
					}
					int zxz;
					if (a != -1) {
						int x = cells[a][b].getPlayer();
						cells[i][j].setplayer(x);
						expected[x].increasenumber();
						expected[x].setBounders(i, j);
						zxz = x;
					} else {
						expected[counter] = new Player();
						cells[i][j].setplayer(counter);
						expected[counter].increasenumber();
						expected[counter].setBounders(i, j);
						zxz = counter;
						counter++;
					}
					int x = i + 1, y = j;
					recursion(cells, expected, x, y, zxz, 1);
					recursion(cells, expected, x, y, zxz, 2);
				}
			}
		}
		return counter;
	}
	
	
	public void recursion(Cell[][] cells, Player[] expected , int x, int y, int counter, int z) {
		Boolean s = false;
		if (valid(x, y) && cells[x][y].getMatch()) {
			if (cells[x][y].getPlayer() == -1) {
				cells[x][y].setplayer(counter);
				expected[counter].increasenumber();
				expected[counter].setBounders(x, y);
			}
			y = (z == 1)? y - 1 : y + 1;
			s = true;
			while (valid(x, y) && cells[x][y].getMatch() && cells[x][y].getPlayer() == -1) {
				cells[x][y].setplayer(counter);
				expected[counter].increasenumber();
				expected[counter].setBounders(x, y);
				y = (z == 1)? y - 1 : y + 1;
			}
		}
		if (s) {
			x++;
			y = (z == 1)? y + 1 : y - 1;
			if (valid(x, y) && cells[x][y].getMatch()) {
				if (z == 1) {
					recursion(cells, expected, x, y, counter, 1);
				}else {
					recursion(cells, expected, x, y, counter, 2);
				}
				
			}
		}
	}
	
	
	public void sort(java.awt.Point[] players, int counter) {
		for (int i = 0; i < counter - 1; i++) {
			for (int j = 0; j < counter - 1 - i; j++) {
				if (players[j].getX() > players[j + 1].getX()) {
					java.awt.Point t = new java.awt.Point((int)players[j].getX(),(int) players[j].getY());
					players[j].setLocation((int)players[j + 1].getX(),(int) players[j + 1].getY());
					players[j + 1].setLocation((int)t.getX(),(int) t.getY());
				}
				else if (players[j].getX() == players[j + 1].getX()) {
					if (players[j].getY() > players[j + 1].getY()) {
						java.awt.Point t = new java.awt.Point((int)players[j].getX(),(int) players[j].getY());
						players[j].setLocation((int)players[j + 1].getX(),(int) players[j + 1].getY());
						players[j + 1].setLocation((int)t.getX(),(int) t.getY());
					}
				}
			}
		}
	}
}

