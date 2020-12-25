package com.company;

public class Heap {

    private Integer[] heap;
    private int currentPosition = -1;

    public Heap(int size){
        this.heap = new Integer[size];
    }

    public void insert(int item){

        if (isFull()){
            throw new RuntimeException("Heap is Full....");
        }

        this.heap[++currentPosition] = item;
        fixUp(currentPosition);

    }

    private void fixUp(int index) {

        int parentIndex = (index - 1) / 2;

        while(parentIndex >= 0 && this.heap[parentIndex] < this.heap[index]){
            int temp = this.heap[index];
            this.heap[index] = this.heap[parentIndex];
            this.heap[parentIndex] = temp;
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    public int getMax(){
        int result = this.heap[0];

        this.heap[0] = this.heap[currentPosition--];
        this.heap[currentPosition+1] = null;

        fixDown(0, -1);
        return result;
    }


    private void fixDown(int index, int upto) {

        if (upto < 0) upto = currentPosition;

        while(index <= upto){

            int leftChild = 2 * index + 1;
            int rightChild = 2 * index + 2;

            if (leftChild <= upto){
                int childToSwap;
                if (rightChild > upto){
                    childToSwap = leftChild;
                }else{
                    childToSwap = (heap[leftChild] > heap[rightChild] ? leftChild : rightChild);
                }

                if (heap[index] < heap[childToSwap]){
                    int temp = heap[index];
                    heap[index] = heap[childToSwap];
                    heap[childToSwap] = temp;
                }else{
                    break;
                }

                index = childToSwap;
            }else{
                break;
            }
        }
    }

    public void heapSort(){

        for (int i = 0; i <= currentPosition; i++){

            int temp = heap[0];
            System.out.print(temp+ " -> ");
            heap[0] = heap[currentPosition-i];
            heap[currentPosition-i] = temp;
            fixDown(0, currentPosition-i-1);
        }
        System.out.println();
    }

    private boolean isFull() {
        return this.currentPosition == this.heap.length;
    }

}
