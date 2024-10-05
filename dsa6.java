package dsa6;
import java.util.Scanner;

class Node {

    int data;
    Node prev;
    Node next;

    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList {

    Node head;

    DoublyLinkedList() {
        this.head = null;
    }

    void insertFront(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    void insertBack(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
        }
    }

    void insertBefore(int targetData, int data) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        while (temp != null && temp.data != targetData) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Node with data " + targetData + " not found.");
            return;
        }
        Node newNode = new Node(data);
        newNode.next = temp;
        newNode.prev = temp.prev;
        if (temp.prev != null) {
            temp.prev.next = newNode;
        } else {
            head = newNode;
        }
        temp.prev = newNode;
    }

    void insertAfter(int targetData, int data) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        while (temp != null && temp.data != targetData) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Node with data " + targetData + " not found.");
            return;
        }
        Node newNode = new Node(data);
        newNode.prev = temp;
        newNode.next = temp.next;
        if (temp.next != null) {
            temp.next.prev = newNode;
        }
        temp.next = newNode;
    }

    void delete(int targetData) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        while (temp != null && temp.data != targetData) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Node with data " + targetData + " not found.");
            return;
        }
        if (temp.prev != null) {
            temp.prev.next = temp.next;
        } else {
            head = temp.next;
        }
        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }
    }

    void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + (temp.next != null ? " <-> " : "\n"));
            temp = temp.next;
        }
    }
}

public class dsa6 {

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        Scanner scanner = new Scanner(System.in);
        

        while (true) {
            System.out.println("1. Insert at the front");
            System.out.println("2. Insert at the back");
            System.out.println("3. Insert before an element");
            System.out.println("4. Insert after an element");
            System.out.println("5. Delete an element");
            System.out.println("6. Display the list");
            System.out.println("7. Exit");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter the value to insert at the front: ");
                    int dataFront = scanner.nextInt();
                    dll.insertFront(dataFront);
                    break;
                case 2:
                    System.out.print("Enter the value to insert at the back: ");
                    int dataBack = scanner.nextInt();
                    dll.insertBack(dataBack);
                    break;
                case 3:
                    System.out.print("Enter the value before which to insert: ");
                    int targetDataBefore = scanner.nextInt();
                    System.out.print("Enter the value to insert: ");
                    int dataBefore = scanner.nextInt();
                    dll.insertBefore(targetDataBefore, dataBefore);
                    break;
                case 4:
                    System.out.print("Enter the value after which to insert: ");
                    int targetDataAfter = scanner.nextInt();
                    System.out.print("Enter the value to insert: ");
                    int dataAfter = scanner.nextInt();
                    dll.insertAfter(targetDataAfter, dataAfter);
                    break;
                case 5:
                    System.out.print("Enter the value to delete: ");
                    int targetDataDelete = scanner.nextInt();
                    dll.delete(targetDataDelete);
                    break;
                case 6:
                    dll.display();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}

