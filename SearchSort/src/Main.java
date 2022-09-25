
public class Main {
    public static void main(String[] args){
//        //O(n^2)
//        int[] arr1 = {6,5,3,1,8,7,2,4};
//        bubbleSort(arr1);
//        printArray(arr1);
//
//        int[] arr2 = {6,5,3,1,8,7,2,4};
//        selectionSort(arr2);
//        printArray(arr2);
//
//        //O(nlogn)
//        int[] arr3 = {6,5,3,1,8,7,2,4};
//        mergeSort(arr3);
//        printArray(arr3);

        //best and average case O(nlogn), worst case O(n^2) if the array is already sorted
//        int[] arr4 = {6,5,3,1,8,7,2,4};
//        quickSort(arr4);
//        printArray(arr4);

        //find kth largest element
//        int[] arr5 = {6,5,3,1,8,7,2,4};
//        int kth = findKthLargest(arr5,3);
//        System.out.println(kth);
        //work well when range is small, and values are repeated;
//        int[] arr6 = {1,1,1,3,4,1,5,6,7,2,3,4,2,3,5,0,9,2,3,4};
//        countSort(arr6,10);
//        printArray(arr6);

//        int[] arr2 = {-1,1,1,0,0,-1,1,0,1,0,-1,-1,0};
//        dutchFlag(arr2, 0);
//        printArray(arr2);

//        int[] arr3 = {5,5,5,5,2,3,5,7,8};
//        int major = findMajorityElement(arr3);
//        System.out.println(major);

//          int[] arr4 = {1,2,3,4,5,6};
//          rotateArray(arr4,8);
//          printArray(arr4);
        int[] arr5 = {1,3,5,7,9};
        int[] arr6 = {2,4,6,8,10};
        int[] result = mergeTwoSortedArrays(arr5,arr6);
        printArray(result);

    }


    private static void printArray(int[] arr){
        System.out.print("[");
        for(int i: arr){
            System.out.print(i+", ");
        }
        System.out.print("]");
    }

    private static void swap(int[] arr, int i, int j){
        if(arr == null || arr.length <=1){
            return;
        }
        if(i<0 || j <0 || i>=arr.length || j>=arr.length){
            return;
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void bubbleSort(int[] arr){
        for(int i = 0; i < arr.length-1; i++){
            for(int j = i+1; j < arr.length; j++){
                if(arr[j] < arr[i]){
                    swap(arr, i, j);
                }
            }
        }
    }

    private static void selectionSort(int[] arr){
        for(int i = 0; i < arr.length-1; i++){
            int minIndex = i;
            for(int j = i+1; j < arr.length; j++){
                if(arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }

            if(minIndex != i){
                swap(arr,minIndex,i);
            }
        }
    }

    private static void mergeSort(int[] arr){
        mergeSort(arr, 0, arr.length-1);

    }

    private static void mergeSort(int[] arr, int low, int high){
        if(low >= high){
            return;
        }
        int mid = low + (high - low)/2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1, high);
        merge(arr, low, high);
    }

    private static void merge(int[] arr, int low, int high){
        int[] temp = new int[high-low+1];
        int mid = low + (high-low)/2;
        int i = low;
        int j = mid+1;
        int index = 0;
        while(i <= mid && j <= high) {
            if (arr[i] < arr[j]) {
                temp[index++] = arr[i++];
            } else {
                temp[index++] = arr[j++];
            }
        }
        while(i <= mid){
            temp[index++] = arr[i++];
        }

        while(j <= high){
            temp[index++] = arr[j++];
        }

        i = low;
        for(int val: temp){
            arr[i++] = val;
        }
    }

    public static void quickSort(int[] arr){
        quickSort(arr, 0, arr.length-1);
    }

    private static void quickSort(int[] arr, int low, int high){
        if(low < high){
            int position = partition(arr, low, high); //find correct position for the pivot
            quickSort(arr, low, position-1);
            quickSort(arr, position+1, high);

        }
    }

    private static int partition(int[] arr, int low, int high){
        int pivot = arr[high]; //always the last element
        int wall = low - 1;
        for(int i = low; i < high; i++){
            if(arr[i] < pivot){
                wall++;
                swap(arr,i,wall);
            }
        }
        wall++;
        swap(arr, wall, high);
        return wall;
    }

    public static int findKthLargest(int[] arr, int k){
        if(arr == null || arr.length == 0 || k < 0|| k>arr.length){
            return Integer.MIN_VALUE;
        }
        return findKthLargest(arr, 0, arr.length-1,k);
    }
    private static int findKthLargest(int[] arr, int low, int high, int k){
        if(low<=high){
            int position = partition(arr,low, high);
            if(position == arr.length - k){
                return arr[position];
            }else if(position < arr.length - k){
                return findKthLargest(arr, position+1, high, k);
            }else{
                return findKthLargest(arr, low, position-1, k);
            }
        }
        return Integer.MIN_VALUE;
    }

    private static void countSort(int[] arr, int RANGE){
        int[] countArr = new int[RANGE];
        for(int j: arr){
            countArr[j]++;
        }

        int index = 0;
        for(int i = 0; i < RANGE; i++){
            while(countArr[i] > 0){
                arr[index++] = i;
                countArr[i]--;
            }
        }
    }


    //use when there are only three values in the array, and we know the mid value(pivot) of this array.
    private static void dutchFlag(int[] arr, int pivot){
        if(arr == null || arr.length <=1){
            return;
        }
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;
        while(mid < high){
            if(arr[mid] == pivot){
                mid++;
            }else if(arr[mid] < pivot){
                swap(arr, mid, low);
                mid++;
                low++;
            }else{
                swap(arr, mid, high);
                high--;
            }
        }
    }

    public static int findMajorityElement(int[] arr){
        if(arr == null || arr.length == 0){
            return Integer.MIN_VALUE;
        }

        int majorityElement = arr[0];
        int count = 1;
        for(int i = 1; i< arr.length; i++){
            if(arr[i] == majorityElement){
                count++;
            }else{
                count--;
                if(count == 0){
                    majorityElement = arr[i];
                    count = 1;
                }
            }
        }

        count = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == majorityElement){
                count++;
            }
        }
        if(count > arr.length/2){
            return majorityElement;
        }else{
            return Integer.MIN_VALUE;
        }
    }

    private static void rotateArray(int[] arr, int k){
        if(arr == null || arr.length <= 1 || k <= 1){
            return;
        }
        k = k%arr.length;
        reverseArray(arr,0, arr.length-1);
        reverseArray(arr, 0, k-1);
        reverseArray(arr, k, arr.length-1);
    }

    private static void reverseArray(int[] arr, int start, int end){
        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    private static int[] mergeTwoSortedArrays(int[] arr1, int[] arr2){
        int[] result = new int[arr1.length + arr2.length];
        int ptr1 = 0;
        int ptr2 = 0;
        int ptr = 0;
        while(ptr1 < arr1.length && ptr2 < arr2.length){
           if(arr1[ptr1] < arr2[ptr2]){
               result[ptr++] = arr1[ptr1++];
           }else{
               result[ptr++] = arr2[ptr2++];
           }
        }
        while(ptr1 < arr1.length){
            result[ptr++] = arr1[ptr1++];
        }
        while(ptr2 < arr2.length){
            result[ptr++] = arr2[ptr2++];
        }

        return result;
    }

}
