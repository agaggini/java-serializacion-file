package com.company;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ArrayList<Cliente> clientes = new ArrayList<>();

        Telefono telefono1 = new Telefono("4588754", "223", "549");
        Telefono telefono2 = new Telefono("155478598", "2234", "548");
        List<Telefono> telefonos = new ArrayList<Telefono>();
        telefonos.add(telefono1);
        telefonos.add(telefono2);
        Domicilio domicilio1 = new Domicilio("Calle Falsa", 123);
        Cliente cliente1 = new Cliente("Pepe", "Luis", 55, domicilio1, telefonos);

        Telefono telefono3 = new Telefono("4588754", "223", "549");
        Telefono telefono4 = new Telefono("155478598", "2234", "548");
        List<Telefono> telefonos2 = new ArrayList<Telefono>();
        telefonos2.add(telefono3);
        telefonos2.add(telefono4);
        Domicilio domicilio2 = new Domicilio("Calle Falsa", 123);
        Cliente cliente2 = new Cliente("Pepe Dos", "Luis", 55, domicilio2, telefonos2);

        String path = "C:\\Users\\DELL\\Desarrollo\\UTN\\Prog3\\Manejo de Archivos - Serializacion\\files\\";

        clientes.add(cliente1);
        clientes.add(cliente2);

        try {
            // Escritura
            FileOutputStream fileOutputStream = new FileOutputStream(path + "miarchivo.txt");
            ObjectOutputStream objOutputStream = new ObjectOutputStream(fileOutputStream);
            objOutputStream.writeObject(cliente1);
            objOutputStream.writeObject(cliente2);
            objOutputStream.close();

            clientes.clear();
            System.out.println(clientes.size());

            //Lectura Serializable
            FileInputStream fileInputStream = new FileInputStream(path + "miarchivo.txt");
            ObjectInputStream objInputStream = new ObjectInputStream(fileInputStream);
            Object aux = objInputStream.readObject();
            while(aux != null) {
                System.out.println("OBJECTINPUTSTREAM:\n" + aux.toString());
                aux = objInputStream.readObject();
            }
            objInputStream.close();

//            for (Cliente x : myObjects) {
//                System.out.println(x.toString());
//            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No se pudo leer/escribir el archivo: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
