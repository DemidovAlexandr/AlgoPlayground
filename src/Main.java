public class Main {
    public static void main(String[] args) {
        //Дан массив из нулей и единиц.
        // Нужно определить, какой максимальный по длине подинтервал единиц можно получить, удалив ровно один элемент массива.

        RangeOfOnes rangeOfOnes = new RangeOfOnes();

        //int[] arr = {0, 1, 1, 0, 0, 1, 1, 1, 0, 1};
        //int[] arr = {0, 0, 1, 1, 1, 0, 1, 1, 0, 0};
        int[] arr = {1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 1};

        System.out.println(rangeOfOnes.findRange(arr));
        System.out.println(rangeOfOnes.findMaxConsecutiveOnes(arr));
    }
}