public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        int num = 7;
        int x = 0;
        int [] numbers = new int[num];
        for (int i = 1; i < num + 1; i++) {

            numbers[x] = i;
            x++;
        }
        for (int i : numbers) {
            System.out.print(i + " ");
        }
    }
}