/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuanva.daos;

import tuanva.dtos.RegistrationDTO;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class RegistrationDAO implements Serializable{

    public RegistrationDAO() {
        super();
    }

    

    public static ArrayList<RegistrationDTO> readFile(String fName){
        ArrayList<RegistrationDTO> listReg = new ArrayList<>();
        FileReader fr = null;
        BufferedReader bf = null;
        try {
            fr = new FileReader(fName);//read
            bf = new BufferedReader(fr);//readline
            String details;
            while((details = bf.readLine()) != null){
                StringTokenizer stk = new StringTokenizer(details, ",");
                boolean gender = false;
                String registrationID = stk.nextToken();
                String fullname = stk.nextToken();
                Integer age = Integer.parseInt(stk.nextToken());
                String temp = stk.nextToken();
                if(temp.equalsIgnoreCase("Male")){
                    gender = true;
                }else if(temp.equalsIgnoreCase("Female")){
                    gender = false;
                }
                String email = stk.nextToken();
                String phone = stk.nextToken();
                String address = stk.nextToken();
                Integer numberOfMember = Integer.parseInt(stk.nextToken());
                Integer numberOfChildren = Integer.parseInt(stk.nextToken());
                Integer numberOfAdults = Integer.parseInt(stk.nextToken());
                listReg.add(new RegistrationDTO(registrationID, fullname, age, gender, email, phone, address, numberOfMember, numberOfChildren, numberOfAdults));
            }
        } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "can't connect with rmi or file not exists");
        }finally{
            try {
                bf.close();
                fr.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
        return listReg;
    }
    
    public static void writeFile(String fName, ArrayList<RegistrationDTO> listReg){
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(fName);
            for (RegistrationDTO x : listReg) {
                pw.println(x.print());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "file not exists");
        }finally{
            pw.close();
        }
    }
    
    public static void sortAscending(ArrayList<RegistrationDTO> list) {
        Collections.sort(list, new Comparator<RegistrationDTO>() {
            @Override
            public int compare(RegistrationDTO o1, RegistrationDTO o2) {
                return o1.getFullname().compareToIgnoreCase(o2.getFullname());
            }
        });
    }
    
    public static void sortDescending(ArrayList<RegistrationDTO> list) {
        Collections.sort(list, new Comparator<RegistrationDTO>() {
            @Override
            public int compare(RegistrationDTO o1, RegistrationDTO o2) {
                return o2.getFullname().compareToIgnoreCase(o1.getFullname());
            }
        });
    }

}
