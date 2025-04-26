/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sortpp;

public class SortSecuencial {
    private final int[] _array;

    public SortSecuencial(int[] _array) {
        this._array = _array;
    }

    public void sort() {
        for (int i = 0; i < _array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < _array.length; j++) {
                if (_array[j] < _array[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap the found minimum element with the first element
            int temp = _array[minIndex];
            _array[minIndex] = _array[i];
            _array[i] = temp;
        }
    }

    public void printArray() {
        for (int i = 0; i < _array.length; i++) {
            System.out.print(_array[i] + " ");
        }
        System.out.println();
    }
}
