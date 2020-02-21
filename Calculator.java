
public class Calculator implements ICalculator{
	public int add(int x, int y) {
		try {
			return x + y;
		}
		catch (Exception e)
		{
			System.out.println("the following error occured: " + e.getMessage());
			return 404;
		}
	}
	public float divide(int x, int y) throws RuntimeException{
		try
		{
			float ans = (float) x / y;
			if (ans == 0) {
				ans = Math.abs(ans);
			}
			return ans;
		}
		catch (Exception e)
		{
			System.out.println("the following error occured: " + e.getMessage());
			return 404;
		}
	}
}
