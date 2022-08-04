package ss4_class_object.exercise.StopWatch;

import java.util.Arrays;

public class MainStopWatch {
    public static void main(String[] args) {
        int[] array = new int[100000];
        ClassStopWatch stopWatch = new ClassStopWatch();

        System.out.println("Time start: " + stopWatch.start());

        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.floor(Math.random() * array.length));
        }
        Arrays.sort(array);

        System.out.println("Array is: "+ Arrays.toString(array));

        System.out.println("Time end: "+stopWatch.stop());

        System.out.println("Elapsed time: "+stopWatch.getElapsedTime()+"");
    }
}
