package sortpp;
import java.util.Scanner;

/**
 *
 * @author Aldair Rivera
 */
public class SortPP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Ingrese los numeros a ordenar:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] numbers = input.split(" ");
        int[] array = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            array[i] = Integer.parseInt(numbers[i]);
        }

        System.out.println("Mostrar el arreglo resultante (S/N): ");
        String showArray = scanner.nextLine();

        // Insert a clock to calculate sort duration
        long startTime = System.currentTimeMillis();
        System.out.println("====== Ordenamiento Secuencial");
        SortSecuencial sorter = new SortSecuencial(array);
        sorter.sort();
        long endTime = System.currentTimeMillis();

        if (showArray.equalsIgnoreCase("S")) {
            System.out.println("Numeros ordenados:");
            sorter.printArray();
        }

        System.out.println("Duracion del ordenamiento secuencial: " + (endTime - startTime) + " ms");

        for (int i = 0; i < numbers.length; i++) {
            array[i] = Integer.parseInt(numbers[i]);
        }

        System.out.println("====== Ordenamiento Paralelo");
        System.out.println("Ingrese la cantidad de hilos a emplear: ");
        int numThreads = scanner.nextInt();

        // Insert a clock to calculate sort duration
        startTime = System.currentTimeMillis();
        SortParalelo parallelSorter = new SortParalelo(array, numThreads, 0, array.length);
        parallelSorter.sort();
        endTime = System.currentTimeMillis();

        if (showArray.equalsIgnoreCase("S")) {
            System.out.println("Numeros ordenados:");
            parallelSorter.printArray();
        }

        System.out.println("Duracion del ordenamiento paralelo: " + (endTime - startTime) + " ms");
        scanner.close();
    }
    
}
