public abstract class TemplateMethodBubbleSort {
    public void sort(Integer[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            for (int j = i + 1; j < list.length; j++) {
                if (!numbersInCorrectOrder(list[i], list[j])) {
                    swap(list, i, j);
                }
            }
        }
    }

    private void swap(Integer[] arr, int i, int j) {
        Integer aux = arr[i];
        arr[i] = arr[j];
        arr[j] = aux;
    }

    abstract boolean numbersInCorrectOrder(Integer i1, Integer i2);
}
