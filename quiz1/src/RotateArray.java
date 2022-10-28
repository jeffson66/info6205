public class RotateArray {

    public static int[] rotateArrayByK(int[] arr, int k){
        int length = arr.length;
        int start = length - k%length;
        int[] newarr = new int[length];
        int index = 0;
        int mark = start;
        while(start < length){
            newarr[index++] = arr[start++];
        }
        int init = 0;
        while(init < mark){
            newarr[index++] = arr[init++];
        }
        return newarr;
    }
}
