public class Queue implements QueueInterface {
    QueueNode head; //[cite: 3]
    QueueNode tail; //[cite: 3]
    int size = 0; //[cite: 3]
    boolean isPriorityQueue; //[cite: 3]

    public Queue(boolean isPriorityQueue) {
        this.isPriorityQueue = isPriorityQueue;
        this.head = null;
        this.tail = null;
    }
    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    @Override
    public Object extract() {
        if (isEmpty()) {
            return null;
        }
        Object extractedData = head.object;
        head = head.next;

        if (head == null) {
            tail = null; // Si la cola quedó vacía, limpiamos también el tail
        }
        size--;
        return extractedData;
    }
    @Override
    public boolean insert(Object object) {
        QueueNode newNode = new QueueNode(object);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
        return true;
    }
    @Override
    public boolean insert(Object object, int prioridad) {
        // Si no es una cola de prioridad, hacemos una inserción normal
        if (!isPriorityQueue) {
            return insert(object);
        }
        QueueNode newNode = new QueueNode(object, prioridad);

        // Si está vacía o el nuevo nodo tiene mayor prioridad (número menor = más prioridad)
        if (isEmpty() || head.priority > prioridad) {
            newNode.next = head;
            head = newNode;
            if (tail == null) {
                tail = newNode;
            }
        } else {
            // Recorremos la estructura para buscar el punto exacto de inserción
            QueueNode current = head;
            while (current.next != null && current.next.priority <= prioridad) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
            // Si insertamos al final, actualizamos el tail
            if (newNode.next == null) {
                tail = newNode;
            }
        }
        size++;
        return true;
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public boolean search(Object object) {
        QueueNode current = head;
        while (current != null) {
            if (current.object.equals(object)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        QueueNode current = head;
        while (current != null) {
            sb.append(current.object.toString());
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}