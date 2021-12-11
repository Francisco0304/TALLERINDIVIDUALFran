package view;

import controller.Control;
import model.Invoice;

import javax.swing.*;
import java.util.ConcurrentModificationException;
import java.util.Scanner;

public class Runner {

    static public void main( String ... args ) {
      new Control().initialMenu();

     }
}