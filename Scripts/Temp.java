public class Temp {
    public static void main(String[] args) {
	int j = 0;
	int upperLimit = 10000;
        for (int i = 0; i <= upperLimit; i++) {
	    j = j + i;
        }
	System.out.println("The answer is: " + j);
	j = (upperLimit)*(upperLimit + 1) / 2;
	System.out.println("The faster answer is: " + j);
    }
}
