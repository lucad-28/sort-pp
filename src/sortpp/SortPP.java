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
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresara los numeros manualmente (S/N): ");
        String manualInput = scanner.nextLine();

        String[] numbers = null;
        int [] originalArray = null;
        if (manualInput.equalsIgnoreCase("S")) {
            System.out.println("Ingrese los numeros a ordenar:");
            String input = scanner.nextLine();
            numbers = input.split(" ");
            originalArray = new int[numbers.length];
            for (int i = 0; i < numbers.length; i++) {
                originalArray[i] = Integer.parseInt(numbers[i]);
            }
        } else {
            System.out.println("Ingrese la cantidad de numeros a generar: ");
            int n = scanner.nextInt();
            scanner.nextLine();
            originalArray = new int[n];
            originalArray = randomNumbers(n);
            StringBuilder numbersString = new StringBuilder("Numeros generados: ");
            for (int num : originalArray) {
                numbersString.append(num).append(" ");
            }
            System.out.println(numbersString.toString());
        }

        System.out.println("Mostrar el arreglo resultante (S/N): ");
        String showArray = scanner.nextLine();

        int[] array = originalArray.clone();
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

        array = originalArray.clone();

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

    public static int[] randomNumbers(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = (int) (Math.random() * 100);
        }
        return array;
    }
    
}
