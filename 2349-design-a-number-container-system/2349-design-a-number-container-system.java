import java.util.*;

class NumberContainers {

    private Map<Integer, Integer> indexToNumber;
    private Map<Integer, PriorityQueue<Integer>> numberToIndices;

    public NumberContainers() {
        indexToNumber = new HashMap<>();
        numberToIndices = new HashMap<>();
    }

    public void change(int index, int number) {
        indexToNumber.put(index, number);
        numberToIndices
            .computeIfAbsent(number, k -> new PriorityQueue<>())
            .offer(index);
    }

    public int find(int number) {
        PriorityQueue<Integer> heap = numberToIndices.get(number);
        if (heap == null) return -1;

        while (!heap.isEmpty()) {
            int idx = heap.peek();
            if (indexToNumber.get(idx) == number) {
                return idx;
            }
            heap.poll(); // stale index
        }

        return -1;
    }
}
