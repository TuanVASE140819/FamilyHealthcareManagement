/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuanva.services;

import tuanva.daos.RegistrationServerImpl;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class rmiServer {
    public static void main(String[] args) {
        String serviceName = "rmi://localhost:1098/RegistrationServerImpl";
        RegistrationServerImpl server;
        try {
            server = new RegistrationServerImpl();
            LocateRegistry.createRegistry(1098);
            //register the name of service
            Naming.rebind(serviceName, server);
            System.out.println("Service " + serviceName + " is running.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "can't connect with rmi");
        }
    }
}
