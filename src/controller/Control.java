package controller;

import exceptions.ValueException;
import jdk.nashorn.internal.scripts.JO;
import model.*;
import view.View;

import javax.swing.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Control {
    private View view;
    private ListProduct listProduct;
    private Order order;
    private Product product;
    private Invoice invoice;
    private int contAcc;
    private int init;
    ListProduct listado;
    ListProduct.Product p;
    ListProduct.Product v;


    public Control() {
        view = new View();
        //product = new Product();
        order = new Order();
        //listProduct = new ListProduct();
        invoice = new Invoice();
        contAcc = 0;
        init = 0;
        listado = new ListProduct(1, "Mercado");
    }

    public void initialMenu() {
        boolean check = true;
        //initialStock();
        int option = 0;
        int optionCheck = 0;
        int contAcc = 0;
        while ( option == 0) {
            try {
                option = view.optionMenu();
            } catch (Exception e) {
                view.showMessageErr("Acción inválida");
            }
            switch ( option ) {
                case 1:
                    //handlingAccount();
                    generateInvoice();
                    break;
                case 2:
                    if(init == 0){
                        JOptionPane.showMessageDialog(null,"No ha generado ninguna factura previamente");
                        option = 0;
                    }else{
                        showSolds();
                        option = 0;
                    }
                    break;
                case 3:
                    try {
                        optionCheck = view.menuCheckBook();
                    } catch (Exception e){
                        view.showMessageErr("No es válido");
                    }
                    if (optionCheck == 1){
                        newQuantityProducts();
                        optionCheck = 0;
                    }else{
                        actualQuantityProducts();
                        optionCheck = 0;
                    }
                    break;
                case 4:
                    option = 1;
            }
        }
    }

    private void generateInvoice() {
        order.setNameClient(view.readString("Ingrese nombre del cliente", "Ingreso de datos"));
        typeOfPay();
        int options = 0;
        while (options == 0) {
            try {
                int select = Integer.parseInt(JOptionPane.showInputDialog(null, "Seleccion de compras\n" + "\nSeleccione la categoria que desee comprar\n" +
                        "[1] Viveres\n" +
                        "[2] Aseo\n" +
                        "[3] Licores\n" +
                        "[4] Abarrotes\n" +
                        "[5] Salir\n", "Menu Inicio", JOptionPane.QUESTION_MESSAGE));

                if (select < 1 || select > 5)
                    view.showMessageErr("Digito invalido");
                switch (select) {
                    case 1:
                        // listado = new ListProduct(1, "Viveres");
                        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite el ID del producto comprado [Rango entre 1000 - 1999]", "ID", JOptionPane.INFORMATION_MESSAGE));
                        if (listado.checkLimit(id, 1000, 2000) == 0){
                            JOptionPane.showMessageDialog(null, "Numero Id Fuera de rango, debe ser un valor entre 1000 y 1999");
                        }else{
                        if(listado.getID(id) == 0){
                            JOptionPane.showMessageDialog(null,"Numero Id No localizado");
                        }else{
                            for (int i = 0; i < listado.getProducts().size(); i++) {
                                if (listado.getProducts().get(i).getId() == id) {
                                    JOptionPane.showMessageDialog(null, "ID: " + listado.getProducts().get(i).getId() +
                                            "\nProducto: " + listado.getProducts().get(i).getName() +
                                            "\nPrecio Unitario: " + listado.getProducts().get(i).getUnitValue() +
                                            "\nUnidades restantes: " + listado.getProducts().get(i).getExistingQuantity());
                                    JOptionPane.showMessageDialog(null,"Producto agregado");
                                    listado.salesUnits(listado.getProducts().get(i).getId());
                                }
                            }
                            contAcc++;
                        }
                     }
                    break;
                case 2:
                    int id2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite el ID del producto comprado [Rango entre 2000 - 2999] ", "ID", JOptionPane.INFORMATION_MESSAGE));
                    if (listado.checkLimit(id2, 2000, 3000) == 0){
                        JOptionPane.showMessageDialog(null, "Numero Id Fuera de rango, debe ser un valor entre 2000 y 2999");
                    }else{
                        if(listado.getID(id2) == 0){
                            JOptionPane.showMessageDialog(null,"Numero Id No localizado");
                        }else{
                            for (int i = 0; i < listado.getProducts().size(); i++) {
                                if (listado.getProducts().get(i).getId() == id2) {
                                    JOptionPane.showMessageDialog(null, "ID: " + listado.getProducts().get(i).getId() +
                                            "\nProducto: " + listado.getProducts().get(i).getName() +
                                            "\nPrecio Unitario: " + listado.getProducts().get(i).getUnitValue() +
                                            "\nUnidades:" + listado.getProducts().get(i).getExistingQuantity());

                                }
                            }
                            contAcc++;
                        }
                    }
                    break;
                case 3:
                    int id3 = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite el ID del producto comprado [Rango entre 3000 - 3999]", "ID", JOptionPane.INFORMATION_MESSAGE));
                    if (listado.checkLimit(id3, 3000, 4000) == 0){
                        JOptionPane.showMessageDialog(null, "Numero Id Fuera de rango, debe ser un valor entre 3000 y 3999");
                    }else{
                        if(listado.getID(id3) == 0){
                            JOptionPane.showMessageDialog(null,"Numero Id No localizado");
                        }else{
                            for (int i = 0; i < listado.getProducts().size(); i++) {
                                if (listado.getProducts().get(i).getId() == id3) {
                                    JOptionPane.showMessageDialog(null, "ID: " + listado.getProducts().get(i).getId() +
                                            "\nProducto: " + listado.getProducts().get(i).getName() +
                                            "\nPrecio Unitario: " + listado.getProducts().get(i).getUnitValue() +
                                            "\nUnidades:" + listado.getProducts().get(i).getExistingQuantity());
                                }
                            }
                            contAcc++;
                        }
                    }
                    break;
                case 4:
                    int id4 = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite el ID del producto comprado [Rango entre 4000 - 4999]", "ID", JOptionPane.INFORMATION_MESSAGE));
                    if (listado.checkLimit(id4, 4000, 5000) == 0){
                        JOptionPane.showMessageDialog(null, "Numero Id Fuera de rango, debe ser un valor entre 4000 y 4999");
                    }else{
                        if(listado.getID(id4) == 0){
                            JOptionPane.showMessageDialog(null,"Numero Id No localizado");
                        }else{
                            for (int i = 0; i < listado.getProducts().size(); i++) {
                                if (listado.getProducts().get(i).getId() == id4) {
                                    JOptionPane.showMessageDialog(null, "ID: " + listado.getProducts().get(i).getId() +
                                            "\nProducto: " + listado.getProducts().get(i).getName() +
                                            "\nPrecio Unitario: " + listado.getProducts().get(i).getUnitValue() +
                                            "\nUnidades:" + listado.getProducts().get(i).getExistingQuantity());
                                    listado.salesUnits(listado.getProducts().get(i).getId());
                                }
                            }
                            contAcc++;
                        }
                    }
                    break;
                case 5:
                    if(contAcc == 0){
                        JOptionPane.showMessageDialog(null,"No se eligio ningun producto, factura no generada");
                        options += 1;
                        initialMenu();
                    }else {
                        JOptionPane.showMessageDialog(null,"Factura generada en la opcion [2] Detalle factura");
                        init = 1;
                        options += 1;
                        initialMenu();
                    }
            }
            } catch (Exception e) {
                view.showMessageErr("Acción inválida");
            }

        }

    }

    private void deletUnits(){


    }

    private void showSolds() {
        /*ArrayList total = new ArrayList(12);
        for(int i = 0; i < 12; i++){
            for(int j = 0; i < 12; j++){
               // total.get(i) == invoice.getProducts();
            }
        }*/

        JOptionPane.showMessageDialog(null," ---FACTURA---\n"+
                "Nombre: "+ order.getNameClient()+
                "\nFecha: "+ LocalDateTime.now()+
                "\nTipo de pago: "+ order.getPayType()+
                "\nCantidad Productos Comprados: "+ contAcc);
    }

    private void newQuantityProducts(){
        int option1 = 0;
        int cont = 1;
        double value = 0;
        String name = "";
        int quantity = 0;
        while (option1 == 0) {
            try {
                int select = Integer.parseInt(JOptionPane.showInputDialog(null, "Agregar Productos\n" + "\nSeleccione la categoria\n" +
                        "[1] Viveres\n" +
                        "[2] Aseo\n" +
                        "[3] Licores\n" +
                        "[4] Abarrotes\n", "Menu Inicio", JOptionPane.QUESTION_MESSAGE));
                if (select < 1 || select > 5)
                    view.showMessageErr("Digito invalido");
                switch (select) {
                    case 1:
                        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite el ID del producto a agregar [Rango entre 1000 - 1999]", "ID", JOptionPane.INFORMATION_MESSAGE));
                        if (listado.checkLimit(id, 1000, 2000) == 0){
                            JOptionPane.showMessageDialog(null, "Numero Id Fuera de rango, debe ser un valor entre 1000 y 1999");
                        }else {
                            if (listado.noRepeats(id) == 0) {
                                JOptionPane.showMessageDialog(null, "Numero Id ya agregado");
                            } else {
                                name = JOptionPane.showInputDialog(null, "Digite el nombre del producto");
                                value = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite el precio del producto"));
                                quantity = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite la cantidad de unidades a registrar"));
                                p = listado.new Product(id, name, value, quantity);
                                listado.addProduct(p);

                                int options = Integer.parseInt(JOptionPane.showInputDialog(null, "\n¿Desea agregar mas productos?\n" +
                                        "[1] Si\n" + "[2] No"));
                                if (options == 1) {
                                    option1 = 0;
                                } else {
                                    option1 = 1;
                                    initialMenu();
                                }
                            }
                        }
                        break;
                    case 2:
                        id = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite el ID del producto a agregar [Rango entre 2000 - 2999]", "ID", JOptionPane.INFORMATION_MESSAGE));
                        if (listado.checkLimit(id, 2000, 3000) == 0){
                            JOptionPane.showMessageDialog(null, "Numero Id Fuera de rango, debe ser un valor entre 2000 y 2999");
                        }else {
                            if (listado.noRepeats(id) == 0) {
                                JOptionPane.showMessageDialog(null, "Numero Id ya agregado");
                            } else {
                                name = JOptionPane.showInputDialog(null, "Digite el nombre del producto");
                                value = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite el precio del producto"));
                                quantity = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite la cantidad de unidades a registrar"));
                                p = listado.new Product(id, name, value, quantity);
                                listado.addProduct(p);

                                int options = Integer.parseInt(JOptionPane.showInputDialog(null, "\n¿Desea agregar mas productos?\n" +
                                        "[1] Si\n" + "[2] No"));
                                if (options == 1) {
                                    option1 = 0;
                                } else {
                                    option1 = 1;
                                    initialMenu();
                                }
                            }
                        }
                        break;
                    case 3:
                        id = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite el ID del producto a agregar [Rango entre 3000 - 3999]", "ID", JOptionPane.INFORMATION_MESSAGE));
                        if (listado.checkLimit(id, 3000, 4000) == 0){
                            JOptionPane.showMessageDialog(null, "Numero Id Fuera de rango, debe ser un valor entre 3000 y 3999");
                        }else {
                            if (listado.noRepeats(id) == 0) {
                                JOptionPane.showMessageDialog(null, "Numero Id ya agregado");
                            } else {
                                name = JOptionPane.showInputDialog(null, "Digite el nombre del producto");
                                value = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite el precio del producto"));
                                quantity = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite la cantidad de unidades a registrar"));
                                p = listado.new Product(id, name, value, quantity);
                                listado.addProduct(p);

                                int options = Integer.parseInt(JOptionPane.showInputDialog(null, "\n¿Desea agregar mas productos?\n" +
                                        "[1] Si\n" + "[2] No"));
                                if (options == 1) {
                                    option1 = 0;
                                } else {
                                    option1 = 1;
                                    initialMenu();
                                }
                            }
                        }
                        break;
                    case 4:
                        id = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite el ID del producto a agregar [Rango entre 4000 - 4999]", "ID", JOptionPane.INFORMATION_MESSAGE));
                        if (listado.checkLimit(id, 4000, 5000) == 0){
                            JOptionPane.showMessageDialog(null, "Numero Id Fuera de rango, debe ser un valor entre 4000 y 4999");
                        }else {
                            if (listado.noRepeats(id) == 0) {
                                JOptionPane.showMessageDialog(null, "Numero Id ya agregado");
                            } else {
                                name = JOptionPane.showInputDialog(null, "Digite el nombre del producto");
                                value = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite el precio del producto"));
                                quantity = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite la cantidad de unidades a registrar"));
                                p = listado.new Product(id, name, value, quantity);
                                listado.addProduct(p);

                                int options = Integer.parseInt(JOptionPane.showInputDialog(null, "\n¿Desea agregar mas productos?\n" +
                                        "[1] Si\n" + "[2] No"));
                                if (options == 1) {
                                    option1 = 0;
                                } else {
                                    option1 = 1;
                                    initialMenu();
                                }
                            }
                        }
                        break;
                }
            } catch (Exception e) {
                view.showMessageErr("Dato erroneo");
                option1 =0;
            }
        }
    }

    private void actualQuantityProducts(){
        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite el ID del producto a buscar ", "ID", JOptionPane.INFORMATION_MESSAGE));
        if(listado.getID(id) == 0){
                JOptionPane.showMessageDialog(null,"Numero Id No registrado");
            }else{
                for (int i = 0; i < listado.getProducts().size(); i++) {
                    if (listado.getProducts().get(i).getId() == id) {
                        JOptionPane.showMessageDialog(null, "ID: " + listado.getProducts().get(i).getId() +
                                "\nProducto: " + listado.getProducts().get(i).getName() +
                                "\nPrecio Unitario: " + listado.getProducts().get(i).getUnitValue() +
                                "\nUnidades:" + listado.getProducts().get(i).getExistingQuantity());
                        listado.salesUnits(listado.getProducts().get(i).getId());
                    }
                }
        }
    }

    private void typeOfPay(){
        int option1 = 0;
        while (option1 == 0) {
            try {
                order.setPayType(Integer.parseInt(JOptionPane.showInputDialog(null, "¿Como desea pagar\n" +
                        "[1] Efectivo\n" +
                        "[2] Tarjeta\n")));
                if (order.getPayType() < 1 || order.getPayType() > 2)
                    view.showMessageErr("Digito invalido");
                if (order.getPayType() == 1 || order.getPayType() == 2)
                    option1 = 1;
            } catch (Exception e) {
                view.showMessageErr("Dato erroneo");
            }
        }
    }

   /* private void initialStock(){
      //  listado = new ListProduct(1, "Viveres");
        v = listado.new Product(1000, "Pan Bimbo", 7300, 23);
        listado.addProduct(v);
        v = listado.new Product(1001, "Coca Cola", 5600, 23);
        listado.addProduct(v);
        v = listado.new Product(1002, "Salsa Tomate", 4300, 23);
        listado.addProduct(v);
        v = listado.new Product(1003, "Atun", 5000, 23);
        listado.addProduct(v);
        //listado = new ListProduct(2, "Aseo");
        p = listado.new Product(2000, "Suavitel", 7000, 23);
        listado.addProduct(p);
        p = listado.new Product(2001, "Ariel", 10000, 23);
        listado.addProduct(p);
        p = listado.new Product(2002, "Clorox", 12200, 23);
        listado.addProduct(p);
        p = listado.new Product(2003, "Mr Musculo", 9000, 23);
        listado.addProduct(p);
        //listado = new ListProduct(3, "Licores");
        p = listado.new Product(3000, "Jack Daniels", 24000, 23);
        listado.addProduct(p);
        p = listado.new Product(3001, "Chivas Regal", 32000, 23);
        listado.addProduct(p);
        p = listado.new Product(3002, "Red Label", 23000, 23);
        listado.addProduct(p);
        p = listado.new Product(3003, "Aileys", 30000, 23);
        listado.addProduct(p);
        //listado = new ListProduct(4, "Abarrotes");
        p = listado.new Product(4000, "Pekitas", 1300, 23);
        listado.addProduct(p);
        p = listado.new Product(4001, "Chocorramo", 2300, 23);
        listado.addProduct(p);
        p = listado.new Product(4002, "Tutti Frutti", 3500, 23);
        listado.addProduct(p);
        p = listado.new Product(4003, "Mini Chips", 1000, 23);
        listado.addProduct(p);

    }*/
}