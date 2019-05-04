package offer;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 两个队列实现栈  先入后出
 */
public class Offer9_2 {
    static Queue<String> queue1 = new LinkedBlockingQueue<String>();
    static Queue<String> queue2 = new LinkedBlockingQueue<String>();

    public static void main(String[] args) {
        queue1.offer("xl");
        queue1.offer("xa");
        queue1.offer("xb");
        queue1.offer("xc");
        queue1.offer("xd");
        System.out.println(Offer9_2.deleteHead());
        System.out.println(Offer9_2.deleteHead());
        System.out.println(Offer9_2.deleteHead());
        System.out.println(Offer9_2.deleteHead());

    }

    private static String deleteHead() {
        if (queue2.isEmpty()) {
            int count = queue1.size();
            for (int i = 0; i < count - 1; i++) {
                queue2.offer(queue1.poll());
            }
            return queue1.poll();
        } else {
            int count = queue2.size();
            for (int i = 0; i < count - 1; i++) {
                queue1.offer(queue2.poll());
            }
            return queue2.poll();
        }


    }
}
