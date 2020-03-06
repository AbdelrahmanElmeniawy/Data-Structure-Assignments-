package eg.edu.alexu.csd.datastructure.iceHockey;

public class Cell {
	int player = -1;
	Boolean match = false;
	public Cell() {
		player = -1;
		match = false;
	}
	public Boolean getMatch() {
		return match;
	}
	public void setMatch() {
		match = true;
	}
	public int getPlayer() {
		return player;
	}
	public void setplayer(int b) {
		player = b;
	}
}
