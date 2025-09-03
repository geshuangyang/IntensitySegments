package ge.shuangyang;

/**
 * 基于链表实现，每个节点表示强度左右区间
 * 如题，强度区间左闭右开
 *
 * @author geshuangyang
 * @date 2025/09/02
 */
public class IntensitySegments {

    private Node first;


    /**
     * 强度叠加
     *
     * @param from
     * @param to
     * @param amount
     */
    public void add(int from, int to, int amount) {

        insertInterval(from, true);
        insertInterval(to, false);

        updateIntensity(from, to, amount, true);

    }

    /**
     * 强度设置
     *
     * @param from
     * @param to
     * @param amount
     */
    public void set(int from, int to, int amount) {
        insertInterval(from, true);
        insertInterval(to, false);

        updateIntensity(from, to, amount, false);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        Node current = first;
        boolean start = false;
        while (current != null) {
            if (start || current.intensity != 0) {
                sb.append("[").append(current.interval).append(",").append(current.intensity).append("]");
                start = true;
            }

            if (current.next != null && current.intensity == 0 && current.next.intensity == 0) {
                break;
            }

            current = current.next;
        }

        return "[" + sb + "]";
    }

    /**
     * 插入区间节点，如果add，左节点按前序重叠区间强度初始化
     *
     * @param interval
     * @param isFrom
     */
    private void insertInterval(int interval, boolean isFrom) {
        Node head = new Node();
        head.next = this.first;

        Node cur = head;

        for (; ; cur = cur.next) {
            if (cur.next == null || interval < cur.next.interval) {
                Node node = new Node();
                node.interval = interval;

                if (isFrom) {
                    node.intensity = cur.intensity;
                }

                node.next = cur.next;
                cur.next = node;
                break;
            }

            if (interval == cur.next.interval) {
                break;
            }
        }

        first = head.next;
    }

    /**
     * 更新segment intensity
     *
     * @param from
     * @param to
     * @param amount
     * @param add
     */
    private void updateIntensity(int from, int to, int amount, boolean add) {

        Node cur = first;
        while (cur != null) {

            if (from <= cur.interval && cur.interval < to) {
                if (add) {
                    cur.intensity += amount;
                } else {
                    cur.intensity = amount;
                }
            }

            cur = cur.next;
        }

    }


    private static class Node {
        private int interval = Integer.MIN_VALUE;
        private int intensity = 0;
        private Node next = null;
    }
}
