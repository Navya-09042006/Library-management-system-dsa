import java.util.Scanner;
public class Library {
    static class Book {
        int id;
        String name;
        String author;
        boolean isIssued;
        Book next;
        Book(int id, String name, String author) {
            this.id = id;
            this.name = name;
            this.author = author;
            this.isIssued = false;
            this.next = null;
        }
    }
    static Book head = null;
    static Scanner sc = new Scanner(System.in);
    static void addBook() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Book Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Author Name: ");
        String author = sc.nextLine();

        Book newBook = new Book(id, name, author);

        if (head == null) {
            head = newBook;
        } else {
            Book temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newBook;
        }

        System.out.println("Book added successfully!\n");
    }

    static void viewBooks() {
        if (head == null) {
            System.out.println("No books available.\n");
            return;
        }
        System.out.println("\nLibrary Books:");
        Book temp = head;
        while (temp != null) {
            String status = temp.isIssued ? "Issued" : "Available";
            System.out.println(
                "ID: " + temp.id +
                ", Name: " + temp.name +
                ", Author: " + temp.author +
                ", Status: " + status
            );
            temp = temp.next;
        }
        System.out.println();
    }
    static void issueBook() {
        if (head == null) {
            System.out.println("Library is empty.\n");
            return;
        }

        System.out.print("Enter Book ID to borrow: ");
        int id = sc.nextInt();

        Book temp = head;
        while (temp != null) {
            if (temp.id == id) {
                if (!temp.isIssued) {
                    temp.isIssued = true;
                    System.out.println("Book borrowed successfully!\n");
                } else {
                    System.out.println("Book already borrowed.\n");
                }
                return;
            }
            temp = temp.next;
        }

        System.out.println("Book not found.\n");
    }
    static void returnBook() {
        if (head == null) {
            System.out.println("Library is empty.\n");
            return;
        }

        System.out.print("Enter Book ID to return: ");
        int id = sc.nextInt();

        Book temp = head;
        while (temp != null) {
            if (temp.id == id) {
                if (temp.isIssued) {
                    temp.isIssued = false;
                    System.out.println("Book returned successfully!\n");
                } else {
                    System.out.println("Book was not borrowed.\n");
                }
                return;
            }
            temp = temp.next;
        }

        System.out.println("Book not found.\n");
    }
    static void deleteBook() {
        if (head == null) {
            System.out.println("Library is empty.\n");
            return;
        }
        System.out.print("Enter Book ID to delete: ");
        int id = sc.nextInt();
        if (head.id == id) {
            head = head.next;
            System.out.println("Book deleted successfully!\n");
            return;
        }
        Book prev = head;
        Book curr = head.next;
        while (curr != null) {
            if (curr.id == id) {
                prev.next = curr.next;
                System.out.println("Book deleted successfully!\n");
                return;
            }
            prev = curr;
            curr = curr.next;
        }

        System.out.println("Book not found.\n");
    }
    public static void main(String[] args) {

        while (true) {
            System.out.println("===== Library Management System =====");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Delete Book");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> addBook();
                case 2 -> viewBooks();
                case 3 -> issueBook();
                case 4 -> returnBook();
                case 5 -> deleteBook();
                case 6 -> {
                    System.out.println("Thank you! Exiting...");
                    System.exit(0);
                                }
                default -> System.out.println("Invalid choice!\n");
            }
        }
    }
}
