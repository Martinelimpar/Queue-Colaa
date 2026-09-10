public class Main {
    public static void main(String[] args) {
        System.out.println("=== PRUEBA DE COLA NORMAL (FIFO) ====");
        Queue normalQueue = new Queue(false);
        normalQueue.insert("Tarea 1");
        normalQueue.insert("Tarea 2");
        normalQueue.insert("Tarea 3");
        System.out.println("Cola actual: " + normalQueue.toString());
        System.out.println("Tamaño: " + normalQueue.size());
        System.out.println("Extrayendo: " + normalQueue.extract());
        System.out.println("Extrayendo: " + normalQueue.extract());
        System.out.println("Cola después de extraer: " + normalQueue.toString());

        System.out.println("\n=== PRUEBA DE COLA DE PRIORIDAD ====");
        // Usar números menores para indicar mayor prioridad
        Queue priorityQueue = new Queue(true);

        priorityQueue.insert("Prioridad baja", 10);
        priorityQueue.insert("Prioridad alta", 1);
        priorityQueue.insert("Prioridad media", 5);
        priorityQueue.insert("Urgencia extrema", 0);

        System.out.println("Cola de prioridad ordenada: " + priorityQueue.toString());
        System.out.println("Buscando 'Prioridad media': " + priorityQueue.search("Prioridad media"));
        System.out.println("Buscando 'Inexistente': " + priorityQueue.search("Inexistente"));
        System.out.println("Extrayendo (debe salir la mayor prioridad primero): " + priorityQueue.extract());
        System.out.println("Extrayendo: " + priorityQueue.extract());
        System.out.println("Cola de prioridad restante: " + priorityQueue.toString());
        priorityQueue.clear();
        System.out.println("¿La cola está vacía tras limpiarla?: " + priorityQueue.isEmpty());
    }
}
