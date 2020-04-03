package eg.edu.alexu.csd.datastructure.stack;

/**
 * this class is an evaluator that can convert from infix expression to postfix
 * and evaluate the postfix expressions
 * @author Elmeniawy
 *
 */

public class ExpressionEvaluator implements IExpressionEvaluator {

	@Override
	public String infixToPostfix(String expression) {
		if (expression == null || expression.length() == 0) {
			throw new NullPointerException("Empty expression");
		}
		Boolean open = true, clse = true;
		for (int i = 0; i < expression.length(); i++) {
			if (open &&expression.charAt(i) == '(') {
				expression = expression.replace('(' + "", " ( ");
				open = false;
			}
			if (clse && expression.charAt(i) == ')') {
				expression = expression.replace(')' + "", " ) ");
				i++;
				clse = false;
			}
		}
		String[] in = expression.split(" ");
		String out = new String();
		Stack operation = new Stack();
		Stack weight = new Stack(0);
		int len = in.length;
		Boolean start = true, zxz = true, xzx = false;
		for (int i = 0; i < len; i++) {
			if (in[i].length() != 0) {
				int w = getWeight(in[i]);
				if (in[i].length() == 1 && w > 0) {
					if (w > (int)weight.peek()) {
						if (in[i].charAt(0) == '(') {
							weight.push(0);
							operation.push('(');
							xzx = false;
						} else if (in[i].charAt(0) == ')') {
							if (xzx) {
								weight.pop();
								while ((char)operation.peek() != '(') {
									out += " " + operation.pop();
									if (operation.isEmpty()) {
										throw new NullPointerException("Unclosed group");
									}
								}
								operation.pop();
							} else {
								throw new NullPointerException("Invalid syntax");
							}
						} else {
							if (!zxz) {
								operation.push(in[i].charAt(0));
								weight.edit(w);
								zxz = true;
								xzx = true;
							} else {
								throw new RuntimeException("Invalid syntax");
							}
							
						}
					} else {
						if (!zxz) {
							out += " " + operation.pop();
							operation.push(in[i].charAt(0));
							weight.edit(w);
							zxz = true;
							xzx = true;
						} else {
							throw new RuntimeException("Invalid syntax");
						}
					}
				} else {
					if (zxz) {
						if (in[i].charAt(0) == '-') {
							if (start) {
								out += "0 ";
							} else {
								out += " 0 ";
							}
							out += in[i].substring(1) + " -";
						} else {
							if (!start) {
								out += " ";
							}
							out += in[i];
						}
						start = false;
						zxz = false;
						xzx = true;
					} else {
						throw new RuntimeException("Invalid syntax");
					}
				}
			}
		}
		while (!operation.isEmpty()) {
			out += " " + operation.pop();
		}
		return out;
	}

	@Override
	public int evaluate(String expression) {
		if (expression == null || expression.length() == 0) {
			throw new NullPointerException("Empty expression");
		}
		String[] in = expression.split(" ");
		int out, len = in.length;
		Stack operands = new Stack();
		for (int i = 0; i < len; i++) {
			int choose = Choose(in[i]);
			if (choose == 0) {
				throw new RuntimeException("Invalid syntax");
			} else if (choose == 1) {
				operands.push(Double.parseDouble(in[i]));
			} else {
				if (operands.size() < 2) {
					throw new RuntimeException("Invalid syntax");
				}
				double second  = (double)operands.pop();
				double first = (double) operands.pop();
				switch(choose) {
				case 2:
					operands.push(first + second);
					break;
				case 3:
					operands.push(first - second);
					break;
				case 4:
					operands.push(first * second);
					break;
				case 5:
					if (second == 0) {
						throw new RuntimeException("Invalid syntax");
					}
					operands.push(first / second);
					break;
				}
			}
		}
		if (operands.size() != 1) {
			throw new RuntimeException("Error");
		}
		out = (int) Math.round((double)operands.pop());
		return out;
	}
	
	/**
	 * Method to define the weight of the operator 
	 * to define when the program will print operators
	 * 
	 * @param s the part of the original expression 
	 * @return the weight of operator or zero if it is not operator
	 */
	public int getWeight(String s) {
		char c = s.charAt(0);
		if (c == '+' || c == '-') {
			return 1;
		} else if (c == '*' || c == '/') {
			return 2;
		} else if (c == '(' || c == ')') {
			return 3;
		}
		return 0;
	}
	/**
	 * Method to define the operator or it is a number
	 * @param s the part of the original expression 
	 * @return the number of operator, 1 if it is a number or 0 if it is an invalid input
	 */
	public int Choose(String s) {
		if (s.length() == 1) {
			if (s.charAt(0) == '+') {
				return 2;
			} else if (s.charAt(0) == '-') {
				return 3;
			} else if (s.charAt(0) == '*') {
				return 4;
			} else if (s.charAt(0) == '/') {
				return 5;
			}
		}
		try {
			Integer.parseInt(s);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

}
