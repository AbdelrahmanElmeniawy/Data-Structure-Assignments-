package eg.edu.alexu.csd.datastructure.iceHockey;

public class Player {
	int number = 0;
	int lower = 0;
	int upper = 55;
	int right = 0;
	int left = 55;
	int centerX, centerY;
	Boolean accepted = false;
	public
		Player() {
			number = 0;
			lower = 0;
			upper = 55;
			right = 0;
			left = 55;
			centerX = 0;
			centerY = 0;
			accepted = false;
		}
		void increasenumber() {
			number++;
		}
		int getNumber() {
			return number;
		}
		int getCenterX() {
			return centerX;
		}
		int getCenterY() {
			return centerY;
		}
		Boolean getAccepted() {
			return accepted;
		}
		void setBounders(int i, int j) {
			if (j < left) {
				left = j;
			}
			if (j > right) {
				right = j;
			}
			if (i > lower) {
				lower = i;
			}
			if (i < upper) {
				upper = i;
			}
		}
		void setCenter() {
			centerX = left + right + 1;
			centerY = lower + upper + 1;
		}
		void setAccepted() {
			accepted = true;
		}
}
