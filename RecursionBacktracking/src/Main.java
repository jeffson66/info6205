public class Main {
    public static void main(String[] args){
        generateBinarySequence(3);
    }
    private static void generateBinarySequence(int size){
        if(size <= 0){
            return;
        }

        int[] result = new int[size];
        int current = 0;
        generateBinarySequence(result, current);
    }

    private static void generateBinarySequence(int[] result, int current){
        if(current == result.length){
            printArray(result);
            return;
        }

        for(int i = 0; i < 2; i++){
            result[current] = i;
            generateBinarySequence(result, current+1);
        }
    }

    private static void printArray(int[] arr){
        for(int i: arr){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
