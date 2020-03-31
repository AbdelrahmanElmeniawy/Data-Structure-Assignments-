package eg.edu.alexu.csd.datastructure.linkedList.cs70_cs39;

public class PolynomialSolver implements IPolynomialSolver{
	
	DLinkedList A = new DLinkedList();
	DLinkedList B = new DLinkedList();
	DLinkedList C = new DLinkedList();
	DLinkedList R = new DLinkedList();
	Boolean flag=true, flag2 = false;
	
	@Override
	public void setPolynomial(char poly, int[][] terms) {
		DLinkedList temp;
		temp = choose(poly);
		if(!temp.isEmpty()) {
			temp.clear();
		}
		if (terms != null && terms.length != 0) {
			Terms term;
			for (int i = 0; i < terms.length; i++) {
				term = new Terms();
				term.coef = terms[i][0];
				term.expon = terms[i][1];
				
				addelements(term, temp);
				
			}
			if (temp.size() == 0) {
				term = new Terms();
				term.coef = 0;
				term.expon = 0;
				temp.add(term);
			}
		} else {
			throw new NullPointerException();
		}
	}

	@Override
	public String print(char poly) {
		String out = new String();
		DLinkedList temp;
		flag2 = true;
		temp = choose(poly);
		flag2 = false;
		if (temp.getHead() != null) {
			DNode current = temp.getHead(); 
			for (int i = 0; i < temp.size(); i++) {
				Terms t = (Terms) current.item;
				if (i != 0) {
					out = out.concat(" + ");
				}
				if(t.expon == 0) {
					out = out.concat(String.valueOf(t.coef));
				}
				else if (t.expon == 1) {
					out = out.concat(String.valueOf(t.coef) + "x");
				} else {
					out = out.concat(String.valueOf(t.coef) + "x^" + String.valueOf(t.expon));
				}
				current = current.next;
			}
			return out;
		} else {
			throw new NullPointerException();
		}
	}

	@Override
	public void clearPolynomial(char poly) {
		DLinkedList temp = new DLinkedList();
		temp = choose(poly);
		temp.clear();
	}
	
	@Override
	public float evaluatePolynomial(char poly, float value) {
		float ans = 0;
		DLinkedList temp = new DLinkedList();
		temp = choose(poly);
		if (temp.getHead() != null) {
			DNode current = temp.getHead();
			for (int i = 0; i < temp.size(); i++) {
				Terms t = (Terms) current.item;
				ans += t.coef * Math.pow(value, t.expon);
				current = current.next;
			}
			return ans;
		} else {
			throw new NullPointerException();
		}
	}

	@Override
	public int[][] add(char poly1, char poly2) {
		
		DLinkedList temp1 = new DLinkedList();
		DLinkedList temp2 = new DLinkedList();
		temp1 = choose(poly1);
		temp2 = choose(poly2);
		if (temp1.getHead() != null && temp2.getHead() != null) {
			
			if (flag==false) {
			DLinkedList.copy(R ,temp1, -1);	
			}else {
			DLinkedList.copy(R ,temp1, 1);
			}
			
			DNode current = temp2.getHead();
			Terms term;
			for (int i = 0; i < temp2.size(); i++) {    
				term = (Terms) current.item;
				Terms t = new Terms();
				t.coef = term.coef;
				t.expon = term.expon;
				addelements(t, R);
				current = current.next;
			}
			if (R.size() == 0) {
				term = new Terms();
				term.coef = 0;
				term.expon = 0;
				R.add(term);
			}
			flag=true;
			return convert(R);
		} else {
			flag=true;
			throw new NullPointerException();
		}
	}

	@Override
	public int[][] subtract(char poly1, char poly2) {
		
	flag=false;
		 
	return	this.add(poly2, poly1);
	
	}

	@Override
	public int[][] multiply(char poly1, char poly2) {
		DLinkedList temp1 = new DLinkedList();
		DLinkedList temp2 = new DLinkedList();
		temp1 = choose(poly1);
		temp2 = choose(poly2);
		if(temp1.getHead() !=null && temp2.getHead() != null) {
			if(!R.isEmpty()) {
				R.clear();
			}
			DNode current1 = temp1.getHead();
			Terms term1;
			for(int i=1;i<=temp1.size();i++) {
				DNode current2 = temp2.getHead();
				Terms term2;
				term1 = (Terms) current1.item;
				for(int j=1;j<=temp2.size();j++) {
					term2 = (Terms) current2.item;
					Terms t = new Terms();
					t.expon = term1.expon + term2.expon;
					t.coef = term1.coef * term2.coef;
					addelements(t, R);
					current2 = current2.next;
				}
				current1 = current1.next;
			}
			if (R.size() == 0) {
				term1 = new Terms();
				term1.coef = 0;						
				term1.expon = 0;
				R.add(term1);
			}
			return convert(R);
		}else {
			throw new NullPointerException();
		}
	}
	
	public int[][] convert(DLinkedList X){
		int length = X.size();
		int[][] arr = new int[length][2];
		DNode current = X.getHead();
		for (int i = 0; i < length; i++) {
			Terms t = (Terms) current.item;
			arr[i][0] = t.coef;
			arr[i][1] = t.expon;
			current = current.next;
		}
		return arr;
	}
	
	public void addelements(Terms term, DLinkedList temp) {
		if (term.coef != 0) {
			if (temp.getHead() == null) {
				temp.add(term);
			}else {
				DNode current = temp.getHead();
				Boolean taken = false;
				for (int j = 1, length = temp.size(); j <= length; j++) {
					Terms t = (Terms) current.item;
					if (t.expon == term.expon) {
						t.coef += term.coef;
						if (t.coef != 0) {
							current.item = t;
						} else {
							temp.remove(j);
						}
						taken = true;
						break;
					}
					if (term.expon > t.expon) {
						temp.add(j, term);
						taken = true;
						break;
					}
					current = current.next;
				}
				if (!taken) {
					temp.add(term);
				}
			}	
		}
	}
	
	public DLinkedList choose (char poly) {
		DLinkedList temp = new DLinkedList();
		switch (poly){
			case 'A' :
				temp = A;
				break;
			case 'B' :
				temp = B;
				break;
			case 'C' :
				temp = C;
				break;
			case 'R' :
				if (flag2) {
					temp = R;
				} else {
					temp = null;
				}
				break;
			default:
				temp = null;
		}
		return temp;
	}
	
	
}
