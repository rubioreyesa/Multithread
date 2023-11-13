import com.sun.tools.javac.Main;

import java.util.ArrayList;
import java.util.List;

public class ThreadingApp {
    private List<Integer> theList = new ArrayList<>();
    public void addElements(int num){
        for (int i = 0; i< num; i++){
            theList.add(i);
            System.out.println(this.theList.size());
        }
    }

    public static void main(String[] args) {
        ThreadingApp threadingApp = new ThreadingApp();
        Thread thread = new Thread(()->{threadingApp.addElements(10_000);});
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e){
            System.out.println("Something went wrong.");
        }
    }
    public ThreadingApp(){
        Thread thread2 = new Thread(()->{this.addElements(10_000);});
        thread2.start();
    }
}
