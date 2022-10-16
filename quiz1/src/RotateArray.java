public class RotateArray {

    public int[] rotateArrayByK(int[] arr, int k){
        int length = arr.length;
        int start = length - k%length;
        int[] newarr = new int[length];
        int index = 0;
        while(start < length){
            newarr[index++] = arr[start++];
        }
        int init = 0;
        while(init < start){
            newarr[index++] = arr[init++];
        }
        return newarr;
    }
}
