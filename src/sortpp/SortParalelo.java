/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sortpp;
import java.util.concurrent.RecursiveAction;

public class SortParalelo extends RecursiveAction {
    private final int[] _array;
    private final int _begin;
    private final int _end;
    private final int _threshold;

    public SortParalelo(int[] array, int threshold, int begin, int end) {
        _array = array;
        _threshold = threshold;
        _begin = begin;
        _end = end;
    }

    public void sort(){
        for (int i = _begin; i < _end; i++) {
            for (int j = i + 1; j < _end; j++) {
                if (_array[i] > _array[j]) {
                    int temp = _array[i];
                    _array[i] = _array[j];
                    _array[j] = temp;
                }
            }
        }
    }

    public void printArray() {
        for (int i = _begin; i < _end; i++) {
            System.out.print(_array[i] + " ");
        }
        System.out.println();
    }

    @Override
    protected void compute() {
        if ((_end - _begin) < _threshold) {
            sort();
        } else {
            int mid = (_begin + _end) / 2;
            SortParalelo leftTask = new SortParalelo(_array, _threshold, _begin, mid);
            SortParalelo rightTask = new SortParalelo(_array, _threshold, mid, _end);
            invokeAll(leftTask, rightTask);
        }
    }
}
