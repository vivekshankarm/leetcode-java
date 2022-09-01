
public class M_ContainsMaxWater {
	public int maxArea(int[] height) {
		int i = 0;
		int j = height.length - 1;
		int water = 0;
		
		while (i < j) {
			water = Math.max(water, (j-i)*(Math.min(height[i], height[j])));
			if (height[i] < height[j])
				i++;
			else
				j--;
		}		
		return water;
	}
	public static void main(String[] arg) {
		M_ContainsMaxWater sol = new M_ContainsMaxWater();
		int [] x = {1,8,6,2,5,4,8,3,7};
		int [] y = {2,3,4,5,18,17,6};
		int [] z = {1,2,4,3};
		System.out.println(sol.maxArea(x));
		System.out.println(sol.maxArea(y));
		System.out.println(sol.maxArea(z));
	}
}
