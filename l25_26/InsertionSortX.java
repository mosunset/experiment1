class InsertionSortX {
    private int[] sort_array;

    private InsertionSortX(){}
    public InsertionSortX(int[] sort_array){
        this.sort_array = sort_array;
    }

    public void insertionSortX(){
        int in, out, temp;
        for(out = 1; out < this.sort_array.length; out++){
            temp = this.sort_array[out];
            in = out;
            while(in >0 && this.sort_array[in - 1] > temp){
                this.sort_array[in] = this.sort_array[in - 1];
                in--;
            }
            this.sort_array[in] = temp;
            // 経過を表示 SortTest.display();
        }
    }
}
