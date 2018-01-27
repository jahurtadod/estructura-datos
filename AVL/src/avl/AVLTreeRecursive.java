package avl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Trabajo - Estructura de Datos
 *
 * @author jahurtado
 * @param <T>
 */
public class AVLTreeRecursive<T extends Comparable<T>> {

    public Node root = null; // Se crea la raiz del arbol

    private int nodeCount = 0; // El numero de nodos en el arbol

    private final Node TOKEN = new Node(null); // Nodo vacio

    // Return la altura del arbol
    public int height() {
        if (root == null) {
            return 0;
        }
        return root.height;
    }

    // Return el numero de nodos del arbol
    public int size() {
        return nodeCount;
    }

    // Comprueba si el arbol esta vacío
    public boolean isEmpty() {
        return size() == 0;
    }

    // Comprueba si el valor ya esta en el arbol
    public boolean contains(T value) {

        Node node = root;
        while (node != null) {
            // Compara el valor a buscar con el del nodo actual
            int cmp = value.compareTo(node.value);
            if (cmp < 0) {
                node = node.left;
            } else if (cmp > 0) {
                node = node.right;
            } else {
                return true;
            }
        }
        return false;
    }

    // Se inserta un nuevo nodo 
    public String insert(T value) {
        Node newRoot = insert(root, value);
        boolean insertedNode = (newRoot != TOKEN);
        if (insertedNode) {
            nodeCount++;
            root = newRoot;
            return "";
        }
        return "Valor no insertado (Repetido)";
    }

    /**
     * Inserta un valor en el arbol
     *
     * @param node la raiz actual
     * @param value el valor a ingresar
     * @return Node la raiz nueva o anterior
     */
    private Node insert(Node node, T value) {

        if (node == null) { // Caso base
            return new Node(value);
        }

        // Compare el nuevo valor con el valor del nodo
        int cmp = value.compareTo(node.value);

        // Inserta el nuevo nodo en el subarbol izquierdo.
        if (cmp < 0) {
            Node newNode = insert(node.left, value);
            if (newNode == TOKEN) {
                return TOKEN;
            }
            node.left = newNode;

            // Inserta el nuevo nodo en el subarbol derecho.
        } else if (cmp > 0) {
            Node newNode = insert(node.right, value);
            if (newNode == TOKEN) {
                return TOKEN;
            }
            node.right = newNode;

            // Return 'TOKEN' por que el valor ya se encontraba en el arbol.
        } else {
            return TOKEN;
        }

        // Actualiza la actura y el factor de equilibrio
        update(node);

        // Equilibra el arbol
        return equilibrar(node);
    }

    // Actualiza la actura y el factor de equilibrio de un nodo
    private void update(Node node) {

        int leftNodeHeight = (node.left == null) ? -1 : node.left.height;
        int rightNodeHeight = (node.right == null) ? -1 : node.right.height;

        // Se actualiza la altura del nodo
        node.height = 1 + Math.max(leftNodeHeight, rightNodeHeight);

        // Se actualiza el factor de equilibrio
        node.bf = rightNodeHeight - leftNodeHeight;

    }

    // Vuelva a equilibrar un nodo si su factor de equilibrio es +2 o -2.
    private Node equilibrar(Node node) {

        if (node.bf == -2) {

            // Left-Left case.
            if (node.left.bf <= 0) {
                return leftLeftCase(node);

                // Left-Right case.
            } else {
                return leftRightCase(node);
            }

        } else if (node.bf == +2) {

            // Right-Right case.
            if (node.right.bf >= 0) {
                return rightRightCase(node);

                // Right-Left case.
            } else {
                return rightLeftCase(node);
            }
        }

        // El nodo tiene un factor de equilibrio de 0, +1 o -1, lo cual está bien.
        return node;
    }

    private Node leftLeftCase(Node node) {
        return rightRotation(node);
    }

    private Node leftRightCase(Node node) {
        node.left = leftRotation(node.left);
        return leftLeftCase(node);
    }

    private Node rightRightCase(Node node) {
        return leftRotation(node);
    }

    private Node rightLeftCase(Node node) {
        node.right = rightRotation(node.right);
        return rightRightCase(node);
    }

    private Node leftRotation(Node node) {
        Node newParent = node.right;
        node.right = newParent.left;
        newParent.left = node;
        update(node);
        update(newParent);
        return newParent;
    }

    private Node rightRotation(Node node) {
        Node newParent = node.left;
        node.left = newParent.right;
        newParent.right = node;
        update(node);
        update(newParent);
        return newParent;
    }

    // Se elimina un valor del arbol
    public String eliminar(T value) {
        Node newRoot = eliminar(root, value);
        boolean eliminarNode = (newRoot != TOKEN) || (newRoot == null);
        if (eliminarNode) {
            root = newRoot;
            nodeCount--;
            return "Eliminacion Completa\n";
        }
        return  "Error (ELemento no encontrado)\n";
    }

    /**
     * Elimina un valor que se encuentre en el arbol
     *
     * @param node la raiz actual
     * @param value el valor a eliminar
     * @return Node la raiz nueva o anterior
     */
    private Node eliminar(Node node, T value) {

        // Return un nodo vacio cuando no se encontro el valor a eliminar
        if (node == null) {
            return TOKEN;
        }

        int cmp = value.compareTo(node.value);

        if (cmp < 0) { // Izquierda
            Node newLeftNode = eliminar(node.left, value);
            if (newLeftNode == TOKEN) {
                return TOKEN;
            }
            node.left = newLeftNode;

        } else if (cmp > 0) { // Derecha
            Node newRightNode = eliminar(node.right, value);
            if (newRightNode == TOKEN) {
                return TOKEN;
            }
            node.right = newRightNode;

        } else { // se encuentra el valor a eliminar

            // Si no tiene subarbol izquierdo o si no tiene ningun subarbol
            if (node.left == null) {
                return node.right;

                // Si no tiene subarbol derecho
            } else if (node.right == null) {
                return node.left;

                // Cuando el nodo posee los dos subarboles
            } else {

                // Choose to remove from left subtree
                if (node.left.height > node.right.height) {

                    // Cambia el valor a eliminar por su sucesor (el mayor de los menores)
                    T successorValue = findMax(node.left);
                    node.value = successorValue;

                    // Eliminamos al nodo que tomo la posicion del valor a eliminar
                    Node replacement = eliminar(node.left, successorValue);
                    if (replacement == TOKEN) {
                        return TOKEN;
                    }
                    node.left = replacement;

                } else {

                    // Cambia el valor a eliminar por su sucesor (el menor de los mayores)
                    T successorValue = findMin(node.right);
                    node.value = successorValue;

                    // Eliminamos al nodo que tomo la posicion del valor a eliminar
                    Node replacement = eliminar(node.right, successorValue);
                    if (replacement == TOKEN) {
                        return TOKEN;
                    }
                    node.right = replacement;
                }
            }
        }

        // Actualiza la actura y el factor de equilibrio
        update(node);

        // Equilibra el arbol
        return equilibrar(node);
    }

    // Busca el menor de los mayores
    private T findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.value;
    }

    // Busca el mayor de los menores
    private T findMax(Node node) {
        while (node.right != null) {
            node = node.right;
        }
        return node.value;
    }

    public void imprimir() {
        print(this.root);
    }

    public interface PrintableNode {

        /**
         * Obtiene el subartbol izquierdo
         *
         * @return
         */
        PrintableNode getLeft();

        /**
         * Obtiene el subartbol derecho
         *
         * @return
         */
        PrintableNode getRight();

        /**
         * Obtiene el valor del Nodo
         *
         * @return
         */
        String getText();
    }

    /**
     * Imprime el arbol
     *
     * @param root raiz del arbol
     */
    public static void print(PrintableNode root) {

        List<List<String>> lines = new ArrayList<>();

        List<PrintableNode> level = new ArrayList<>();
        List<PrintableNode> next = new ArrayList<>();

        level.add(root);

        int nn = 1;

        int ancho = 0;

        while (nn != 0) {
            List<String> line = new ArrayList<>();

            nn = 0;

            for (PrintableNode n : level) {
                if (n == null) {
                    line.add(null);

                    next.add(null);
                    next.add(null);
                } else {
                    String a = n.getText();
                    line.add(a);
                    if (a.length() > ancho) {
                        ancho = a.length();
                    }

                    next.add(n.getLeft());
                    next.add(n.getRight());

                    if (n.getLeft() != null) {
                        nn++;
                    }
                    if (n.getRight() != null) {
                        nn++;
                    }
                }
            }

            if (ancho % 2 == 1) {
                ancho++;
            }

            lines.add(line);

            List<PrintableNode> tmp = level;
            level = next;
            next = tmp;
            next.clear();
        }

        int perpiece = lines.get(lines.size() - 1).size() * (ancho + 4);
        for (int i = 0; i < lines.size(); i++) {

            List<String> line = lines.get(i);
            int hpw = (int) Math.floor(perpiece / 2f) - 1;

            if (i > 0) {
                for (int j = 0; j < line.size(); j++) {

                    // Division del nodo
                    char c = ' ';
                    if (j % 2 == 1) {
                        if (line.get(j - 1) != null) {
                            c = (line.get(j) != null) ? '┴' : '┘';
                        } else {
                            if (j < line.size() && line.get(j) != null) {
                                c = '└';
                            }
                        }
                    }
                    System.out.print(c);

                    // Lineas y espacios
                    if (line.get(j) == null) {
                        for (int k = 0; k < perpiece - 1; k++) {
                            System.out.print(" ");
                        }
                    } else {

                        for (int k = 0; k < hpw; k++) {
                            System.out.print(j % 2 == 0 ? " " : "─");
                        }
                        System.out.print(j % 2 == 0 ? "┌" : "┐");
                        for (int k = 0; k < hpw; k++) {
                            System.out.print(j % 2 == 0 ? "─" : " ");
                        }
                    }
                }
                System.out.println();
            }

            // La linea de los valores
            for (int j = 0; j < line.size(); j++) {

                String f = line.get(j);
                if (f == null) {
                    f = "";
                }
                int gap1 = (int) Math.ceil(perpiece / 2f - f.length() / 2f);
                int gap2 = (int) Math.floor(perpiece / 2f - f.length() / 2f);

                // a number
                for (int k = 0; k < gap1; k++) {
                    System.out.print(" ");
                } // Cambiar Color
                System.out.print("\u001B[37m" + f); // Imprime el valor del nodo
                for (int k = 0; k < gap2; k++) {
                    System.out.print(" ");
                }
            }
            System.out.println(); // Salto de nivel
            perpiece /= 2; // Se divide la la nueva linea a la mita
        }
    }

    class Node implements PrintableNode {

        int bf; // Factor de balance
        T value; // El valor del nodo
        int height; // La altura del nodo

        // Los hijos del nodo    
        Node left, right;

        public Node(T value) {
            this.value = value;
        }

        @Override
        public PrintableNode getLeft() {
            return left;
        }

        @Override
        public PrintableNode getRight() {
            return right;
        }

        @Override
        public String getText() {
            return String.valueOf(value);
        }
    }

    public static void main(String[] args) {
        AVLTreeRecursive<Integer> tree = new AVLTreeRecursive<>();

        Scanner input = new Scanner(System.in);
        int opt;

        do {
            System.out.print(menuPrincipal());
            opt = input.nextInt();

            switch (opt) {
                case 1:
                    System.out.print("Ingrese el valor del Nuevo Nodo : ");
                    System.out.println(tree.insert(input.nextInt()));
                    break;
                case 2:
                    System.out.print("Ingrese el valor del Nodo a Eliminar : ");
                    System.out.println(tree.eliminar(input.nextInt()));
                    break;
                case 3:
                    for (int i = 0; i < 22; i++) {
                        tree.insert((int) (Math.random() * 100));
                    }
                    break;
                case 4:
                    tree = new AVLTreeRecursive<>();
                    break;

            }
            tree.imprimir();
        } while (opt != 0);
        System.out.println("Finalizando........");
    }

    public static String menuPrincipal() {
        // Menu principal
        return String.format(
                "\n\t\tMENU - ARBOLES AVL\n"
                + "\tINGRESE EL NUMERO DE LA OPCION\n"
                + "1. Ingresar Nodo \t- Ingresando valor\n"
                + "2. Eliminar Nodo \t- Ingresando valor\n"
                + "3. Arbol Generado \t- Aleatoreamente\n"
                + "4. Limpiar arbol \t- Elimina todos los elementos\n"
                + "0. Salir...\n"
                + (char) 27 + "[37m----> "); // Cambiar color
    }
}