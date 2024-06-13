package composite;

import java.util.ArrayList;
import java.util.List;

//Component interface
interface MenuComponent {
 void printMenu();
 void addComponent(MenuComponent component);
 void removeComponent(MenuComponent component);
}

//Leaf class
class MenuItem implements MenuComponent {
 private String name;
 private double price;

 public MenuItem(String name, double price) {
     this.name = name;
     this.price = price;
 }

 @Override
 public void printMenu() {
     System.out.println("Menu Item: " + name + ", Price: $" + price);
 }

 @Override
 public void addComponent(MenuComponent component) {
     // Do nothing, as MenuItem is a leaf node
 }

 @Override
 public void removeComponent(MenuComponent component) {
     // Do nothing, as MenuItem is a leaf node
 }
}

//Composite class
class Menu implements MenuComponent {
 private List<MenuComponent> menuComponents = new ArrayList<>();
 private String name;

 public Menu(String name) {
     this.name = name;
 }

 @Override
 public void printMenu() {
     System.out.println("\n" + name.toUpperCase());
     for (MenuComponent component : menuComponents) {
         component.printMenu();
     }
 }

 @Override
 public void addComponent(MenuComponent component) {
     menuComponents.add(component);
 }

 @Override
 public void removeComponent(MenuComponent component) {
     menuComponents.remove(component);
 }
}


public class CompositePatternExample2 {
	public static void main(String[] args) {
        Menu mainMenu = new Menu("Main Menu");

        Menu beveragesMenu = new Menu("Beverages");
        beveragesMenu.addComponent(new MenuItem("Coffee", 2.99));
        beveragesMenu.addComponent(new MenuItem("Tea", 1.99));

        Menu foodMenu = new Menu("Food");
        foodMenu.addComponent(new MenuItem("Sandwich", 5.99));
        foodMenu.addComponent(new MenuItem("Salad", 4.99));

        mainMenu.addComponent(beveragesMenu);
        mainMenu.addComponent(foodMenu);

        mainMenu.printMenu();
    }
}
