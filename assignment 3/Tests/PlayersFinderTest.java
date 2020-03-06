package eg.edu.alexu.csd.datastructure.iceHockey;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;

import org.junit.jupiter.api.Test;

class PlayersFinderTest {

	@Test
	void test() {
		
		
		PlayersFinder test = new PlayersFinder();
		String[] photo = {  "11111", 
							"1AAA1", 
							"1A1A1", 
							"1AAA1", 
							"11111"};
		java.awt.Point[] x = test.findPlayers(photo , 1, 3);
		java.awt.Point[] y = new java.awt.Point[2];
		y[0] = new java.awt.Point(5, 5);
		y[1] = new java.awt.Point(5, 5);
		int s = 1;
		for (int i = 0; i < 2; i++) {
			if (!x[i].equals(y[i])) {
				s = 0;
				assertEquals(0, 1);
				break;
			}
		}
		if(s == 1) {
			assertEquals(1, 1);
		}
		
		
		
		PlayersFinder test1 = new PlayersFinder();
		String[] photo1 = { "33JUBU33",
							"3U3O4433",
							"O33P44NB",
							"PO3NSDP3",
							"VNDSD333",
							"OINFD33X"};
		x = test1.findPlayers(photo1 , 3, 16);
		y = new java.awt.Point[3];
		y[0] = new java.awt.Point(4, 5);
		y[1] = new java.awt.Point(13, 9);
		y[2] = new java.awt.Point(14, 2);
		s = 1;
		for (int i = 0; i < 2; i++) {
			if (!x[i].equals(y[i])) {
				s = 0;
				assertEquals(0, 1);
				break;
			}
		}
		if(s == 1) {
			assertEquals(1, 1);
		}
		
		
		
		PlayersFinder test3 = new PlayersFinder();
		String[] photo3 = { "8D88888J8L8E888",
							"88NKMG8N8E8JI88",
							"888NS8EU88HN8EO",
							"LUQ888A8TH8OIH8",
							"888QJ88R8SG88TY",
							"88ZQV88B88OUZ8O",
							"FQ88WF8Q8GG88B8",
							"8S888HGSB8FT8S8",
							"8MX88D88888T8K8",
							"8S8A88MGVDG8XK8",
							"M88S8B8I8M88J8N",
							"8W88X88ZT8KA8I8",
							"88SQGB8I8J88W88",
							"U88H8NI8CZB88B8",
							"8PK8H8T8888TQR8"};
		x = test3.findPlayers(photo3 , 8, 9);
		y = new java.awt.Point[19];
		y[0] = new java.awt.Point(1,17);
		y[1] = new java.awt.Point(3, 3);
		y[2] = new java.awt.Point(3, 10);
		y[3] = new java.awt.Point(3, 25);
		y[4] = new java.awt.Point(5, 21);
		y[5] = new java.awt.Point(8, 17);
		y[6] = new java.awt.Point(9, 2);
		y[7] = new java.awt.Point(10, 9);
		y[8] = new java.awt.Point(12, 23);
		y[9] = new java.awt.Point(17, 16);
		y[10] = new java.awt.Point(18, 3);
		y[11] = new java.awt.Point(18, 11);
		y[12] = new java.awt.Point(18, 28);
		y[13] = new java.awt.Point(22, 20);
		y[14] = new java.awt.Point(23, 26);
		y[15] = new java.awt.Point(24, 15);
		y[16] = new java.awt.Point(27, 2);
		y[17] = new java.awt.Point(28, 26);
		y[18] = new java.awt.Point(29, 16);
		s = 1;
		for (int i = 0; i < 19; i++) {
			if (!x[i].equals(y[i])) {
				s = 0;
				assertEquals(0, 1);
				break;
			}
		}
		if(s == 1) {
			assertEquals(1, 1);
		}
		
		
		
		PlayersFinder test4 = new PlayersFinder();
		String[] photo4 = null;
		x = test4.findPlayers(photo4 , 3, 16);
		assertEquals(null, x);
		
		
		
		PlayersFinder test5 = new PlayersFinder();
		String[] photo5 = {};
		x = test5.findPlayers(photo5 , 3, 16);
		assertEquals(null, x);
		
		
		
		PlayersFinder test2 = new PlayersFinder();
		String[] photo2 = { "44444H44S4",
							"K444K4L444",
							"4LJ44T44XH",
							"444O4VIF44",
							"44C4D4U444",
							"4V4Y4KB4M4",
							"G4W4HP4O4W",
							"4444ZDQ4S4",
							"4BR4Y4A444",
							"4G4V4T4444"};
		x = test2.findPlayers(photo2 , 4, 16);
		y = new java.awt.Point[6];
		y[0] = new java.awt.Point(3, 8);
		y[1] = new java.awt.Point(4, 16);
		y[2] = new java.awt.Point(5, 4);
		y[3] = new java.awt.Point(16, 3);
		y[4] = new java.awt.Point(16, 17);
		y[5] = new java.awt.Point(17, 9);
		s = 1;
		for (int i = 0; i < 6; i++) {
			if (!x[i].equals(y[i])) {
				s = 0;
				assertEquals(0, 1);
				break;
			}
		}
		if(s == 1) {
			assertEquals(1, 1);
		}
	}
}
