public class ArrayFunReverseIt {


    public static void main(String[] args) {
        int[] arrayForward = {1, 2, 3, 4, 5};

        System.out.println("Array forward:");
        for (int element : arrayForward) {
            System.out.println(element);
        }

        int[] reversed = new int[arrayForward.length];

        for (int i = 0; i < arrayForward.length; i++) {

            // length - (i + 1) is the n-th to last element
            // so when i = 0, it would be the last element
            // when i = 3, it would be the fourth to last element since i=3 is the 4th element
            reversed[i] = arrayForward[arrayForward.length - (i + 1)];
        }

        System.out.println("Array reversed:");
        for (int element : reversed) {
            System.out.println(element);
        }
    }
}


