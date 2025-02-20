import java.util.Arrays;

public class Heap {
    
    // Min Heap
    private static class MinHeap {
        private int[] heap;
        private int size;
        private int capacity;

        public MinHeap(int capacity) {
            this.capacity = capacity;
            this.size = 0;
            this.heap = new int[capacity];
        }

        private int parent(int i) { return (i - 1) / 2; }
        private int leftChild(int i) { return 2 * i + 1; }
        private int rightChild(int i) { return 2 * i + 2; }

        private void ensureCapacity() {
            if (size == capacity) {
                heap = Arrays.copyOf(heap, capacity * 2);
                capacity *= 2;
            }
        }

        public void insert(int key) {
            ensureCapacity();
            heap[size] = key;
            size++;
            heapifyUp(size - 1);
        }

        public int extractMin() {
            if (size == 0) throw new IllegalStateException("Heap is empty");
            int min = heap[0];
            heap[0] = heap[size - 1];
            size--;
            heapifyDown(0);
            return min;
        }

        public void delete(int key) {
            int i;
            for (i = 0; i < size; i++) {
                if (heap[i] == key) break;
            }
            if (i == size) throw new IllegalStateException("Key not found in the heap");
            heap[i] = heap[size - 1];
            size--;
            heapifyDown(i);
        }

        private void heapifyUp(int i) {
            while (i != 0 && heap[parent(i)] > heap[i]) {
                swap(i, parent(i));
                i = parent(i);
            }
        }

        private void heapifyDown(int i) {
            int smallest = i;
            int left = leftChild(i);
            int right = rightChild(i);

            if (left < size && heap[left] < heap[smallest]) smallest = left;
            if (right < size && heap[right] < heap[smallest]) smallest = right;

            if (smallest != i) {
                swap(i, smallest);
                heapifyDown(smallest);
            }
        }

        private void swap(int i, int j) {
            int temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }

        public void display() {
            if (size == 0) {
                System.out.println("Heap is empty");
                return;
            }
            displayHeap(0, 0);
            System.out.println();
        }

        private void displayHeap(int index, int indent) {
            if (index < size) {
                displayHeap(rightChild(index), indent + 4);
                if (indent > 0) {
                    for (int i = 0; i < indent - 2; i++) {
                        System.out.print(" ");
                    }
                    System.out.print(" -- ");
                }
                System.out.println(heap[index]);
                displayHeap(leftChild(index), indent + 4);
            }
        }
    }

    // Max Heap
    private static class MaxHeap {
        private int[] heap;
        private int size;
        private int capacity;

        public MaxHeap(int capacity) {
            this.capacity = capacity;
            this.size = 0;
            this.heap = new int[capacity];
        }

        private int parent(int i) { return (i - 1) / 2; }
        private int leftChild(int i) { return 2 * i + 1; }
        private int rightChild(int i) { return 2 * i + 2; }

        private void ensureCapacity() {
            if (size == capacity) {
                heap = Arrays.copyOf(heap, capacity * 2);
                capacity *= 2;
            }
        }

        public void insert(int key) {
            ensureCapacity();
            heap[size] = key;
            size++;
            heapifyUp(size - 1);
        }

        public int extractMax() {
            if (size == 0) throw new IllegalStateException("Heap is empty");
            int max = heap[0];
            heap[0] = heap[size - 1];
            size--;
            heapifyDown(0);
            return max;
        }

        public void delete(int key) {
            int i;
            for (i = 0; i < size; i++) {
                if (heap[i] == key) break;
            }
            if (i == size) throw new IllegalStateException("Key not found in the heap");
            heap[i] = heap[size - 1];
            size--;
            heapifyDown(i);
        }

        private void heapifyUp(int i) {
            while (i != 0 && heap[parent(i)] < heap[i]) {
                swap(i, parent(i));
                i = parent(i);
            }
        }

        private void heapifyDown(int i) {
            int largest = i;
            int left = leftChild(i);
            int right = rightChild(i);

            if (left < size && heap[left] > heap[largest]) largest = left;
            if (right < size && heap[right] > heap[largest]) largest = right;

            if (largest != i) {
                swap(i, largest);
                heapifyDown(largest);
            }
        }

        private void swap(int i, int j) {
            int temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }

        public void display() {
            if (size == 0) {
                System.out.println("Heap is empty");
                return;
            }
            displayHeap(0, 0);
            System.out.println();
        }

        private void displayHeap(int index, int indent) {
            if (index < size) {
                displayHeap(rightChild(index), indent + 4);
                if (indent > 0) {
                    for (int i = 0; i < indent - 2; i++) {
                        System.out.print(" ");
                    }
                    System.out.print(" -- ");
                }
                System.out.println(heap[index]);
                displayHeap(leftChild(index), indent + 4);
            }
        }
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(10);
        MaxHeap maxHeap = new MaxHeap(10);

        minHeap.insert(3);
        minHeap.insert(1);
        minHeap.insert(6);
        minHeap.insert(5);
        minHeap.insert(9);
        minHeap.insert(8);

        maxHeap.insert(3);
        maxHeap.insert(1);
        maxHeap.insert(6);
        maxHeap.insert(5);
        maxHeap.insert(9);
        maxHeap.insert(8);

        System.out.println("Min Heap:");
        minHeap.display();

        System.out.println("Max Heap:");
        maxHeap.display();

        minHeap.delete(6);
        maxHeap.delete(6);

        System.out.println("Min Heap after deleting 6:");
        minHeap.display();

        System.out.println("Max Heap after deleting 6:");
        maxHeap.display();
    }
}


/*

Min Heap:
   -- 6
       -- 8
1
       -- 9
   -- 3
       -- 5

Max Heap:
   -- 8
       -- 3
9
       -- 5
   -- 6
       -- 1

Min Heap after deleting 6:
   -- 8
1
       -- 9
   -- 3
       -- 5

Max Heap after deleting 6:
   -- 8
9
       -- 3
   -- 5
       -- 1





*/
