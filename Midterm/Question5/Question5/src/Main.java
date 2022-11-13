public class Main {
    public static void main(String[] args) {
       int[] arr = {0,7,24,24,44,123,342};
       int[] values = {24,0,5,44};
       int[] output = getStartOfEachValues(arr, values);
       for(int i = 0; i < output.length; i++){
           System.out.print(output[i] + ", ");
       }

    }

    // arr = [0,0,0,0,0,1,1,1,1,2,2,5,5,5,8,9,10,11]
    // values = [1,4,5,10]
    // output = [5, -1, 12, 17]
    private static int[] getStartOfEachValues(int[] arr, int[] values){
        int[] indexes = new int[values.length];
        int low = 0;
        int high = arr.length - 1;
        for(int i = 0; i < indexes.length; i++){
            indexes[i] = -1;
        }

        for(int i = 0; i < values.length; i++){
            int currVal = values[i];
            low = 0;
            high = arr.length - 1;
            while(low <= high){
                int mid = (high - low)/2 + low;
                if(arr[mid] < currVal){
                    low = mid+1;
                }else if(arr[mid] > currVal){
                    high = mid-1;
                }else{
                    int temp = mid;
                    while(temp >= 0 && arr[temp] == currVal){
                            temp--;

                    }
                    indexes[i] = temp + 1;
                    break;
                }
            }
        }

        return indexes;
    }
}