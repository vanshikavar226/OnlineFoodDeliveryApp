package com.gla;
import java.util.ArrayList;
import java.util.Scanner;

    class Food {
        int id;
        String name;
        double price;

        Food(int id, String name, double price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }

        void display() {
            System.out.println(id + ". " + name + " - Rs. " + price);
        }
    }

    class CartItem {
        Food food;
        int quantity;

        CartItem(Food food, int quantity) {
            this.food = food;
            this.quantity = quantity;
        }

        double getTotal() {
            return food.price * quantity;
        }
    }

    public class OnlineFoodDelivery {
        static Scanner sc = new Scanner(System.in);

        static ArrayList<Food> menu = new ArrayList<>();
        static ArrayList<CartItem> cart = new ArrayList<>();

        static void initializeMenu() {
            menu.add(new Food(1, "Pizza", 250));
            menu.add(new Food(2, "Burger", 120));
            menu.add(new Food(3, "Pasta", 180));
            menu.add(new Food(4, "Sandwich", 100));
            menu.add(new Food(5, "French Fries", 90));
            menu.add(new Food(6, "Biryani", 220));
        }

        static void showMenu() {
            System.out.println("\n===== FOOD MENU =====");

            for (Food food : menu) {
                food.display();
            }
        }

        static void searchFood() {
            System.out.print("Enter food name to search: ");
            String name = sc.nextLine().toLowerCase();

            boolean found = false;

            for (Food food : menu) {
                if (food.name.toLowerCase().contains(name)) {
                    food.display();
                    found = true;
                }
            }

            if (!found) {
                System.out.println("Food item not found!");
            }
        }

        static void addToCart() {
            showMenu();

            System.out.print("Enter food ID: ");
            int id = sc.nextInt();

            System.out.print("Enter quantity: ");
            int quantity = sc.nextInt();
            sc.nextLine();

            if (quantity <= 0) {
                System.out.println("Quantity must be greater than zero!");
                return;
            }

            Food selectedFood = null;

            for (Food food : menu) {
                if (food.id == id) {
                    selectedFood = food;
                    break;
                }
            }

            if (selectedFood == null) {
                System.out.println("Invalid food ID!");
                return;
            }

            boolean found = false;

            for (CartItem item : cart) {
                if (item.food.id == id) {
                    item.quantity += quantity;
                    found = true;
                    break;
                }
            }

            if (!found) {
                cart.add(new CartItem(selectedFood, quantity));
            }

            System.out.println("Food added to cart successfully!");
        }

        static void viewCart() {
            if (cart.isEmpty()) {
                System.out.println("\nYour cart is empty!");
                return;
            }

            System.out.println("\n===== YOUR CART =====");

            double total = 0;

            for (CartItem item : cart) {
                double amount = item.getTotal();

                System.out.println(
                        item.food.name
                                + " | Quantity: " + item.quantity
                                + " | Amount: Rs. " + amount
                );

                total += amount;
            }

            System.out.println("-------------------------");
            System.out.println("Total Bill: Rs. " + total);
        }

        static void removeFromCart() {
            if (cart.isEmpty()) {
                System.out.println("Your cart is empty!");
                return;
            }

            viewCart();

            System.out.print("Enter food ID to remove: ");
            int id = sc.nextInt();
            sc.nextLine();

            for (int i = 0; i < cart.size(); i++) {
                if (cart.get(i).food.id == id) {
                    cart.remove(i);
                    System.out.println("Item removed from cart!");
                    return;
                }
            }

            System.out.println("Item not found in cart!");
        }

        static void placeOrder() {
            if (cart.isEmpty()) {
                System.out.println("Your cart is empty!");
                return;
            }

            System.out.print("Enter your name: ");
            String customerName = sc.nextLine();

            System.out.print("Enter delivery address: ");
            String address = sc.nextLine();

            System.out.println("\n===== ORDER CONFIRMATION =====");
            System.out.println("Customer: " + customerName);
            System.out.println("Address: " + address);

            viewCart();

            System.out.println("\nOrder placed successfully!");
            System.out.println("Thank you for ordering with us!");

            cart.clear();
        }

        public static void main(String[] args) {
            initializeMenu();

            int choice;

            do {
                System.out.println("\n===== ONLINE FOOD DELIVERY =====");
                System.out.println("1. View Food Menu");
                System.out.println("2. Search Food");
                System.out.println("3. Add Food to Cart");
                System.out.println("4. View Cart");
                System.out.println("5. Remove Item from Cart");
                System.out.println("6. Place Order");
                System.out.println("7. Exit");

                System.out.print("Enter your choice: ");
                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        showMenu();
                        break;

                    case 2:
                        searchFood();
                        break;

                    case 3:
                        addToCart();
                        break;

                    case 4:
                        viewCart();
                        break;

                    case 5:
                        removeFromCart();
                        break;

                    case 6:
                        placeOrder();
                        break;

                    case 7:
                        System.out.println("Thank you! Visit again.");
                        break;

                    default:
                        System.out.println("Invalid choice! Try again.");
                }

            } while (choice != 7);

            sc.close();
        }
    }