/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuanva.daos;

import tuanva.dtos.RegistrationDTO;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class RegistrationServerImpl extends UnicastRemoteObject implements RegistrationInterface{
    
    private final String filename = "FamilyHealthCareManagement.txt";
    
    //constructor
    public RegistrationServerImpl() throws RemoteException{
        
    }

    @Override
    public boolean createRegistration(RegistrationDTO dto) throws RemoteException {
        try {
            ArrayList<RegistrationDTO> list;
            list = fileDAO.readFile(filename);
            if(list.add(dto)){
                fileDAO.writeFile(filename, list);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public RegistrationDTO findByRegistrationID(String id) throws RemoteException {
        try {
            ArrayList<RegistrationDTO> list = fileDAO.readFile(filename);
            for (RegistrationDTO x: list) {
                if(x.getRegistrationID().equalsIgnoreCase(id)){
                    return x;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<RegistrationDTO> findAllRegistration() throws RemoteException {
        try {
            ArrayList<RegistrationDTO> list = fileDAO.readFile(filename);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean removeRegistration(String id) throws RemoteException {
        try {
            ArrayList<RegistrationDTO> list = fileDAO.readFile(filename);
            for(int i = 0; i < list.size(); i++){
                if(list.get(i).getRegistrationID().equalsIgnoreCase(id)){
                    list.remove(i);
                    fileDAO.writeFile(filename, list);
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateRegistration(RegistrationDTO dto) throws RemoteException {
        ArrayList<RegistrationDTO> list = fileDAO.readFile(filename);
        String id = dto.getRegistrationID();
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).getRegistrationID().equals(id)) {
                list.get(i).setRegistrationID(dto.getRegistrationID());
                list.get(i).setFullname(dto.getFullname());
                list.get(i).setAge(dto.getAge());
                list.get(i).setGender(dto.isGender());
                list.get(i).setEmail(dto.getEmail());
                list.get(i).setPhone(dto.getPhone());
                list.get(i).setAddress(dto.getAddress());
                list.get(i).setNumberOfMember(dto.getNumberOfMember());
                list.get(i).setNumberOfChildren(dto.getNumberOfChildren());
                list.get(i).setNumberOfAdults(dto.getNumberOfAdults());
                fileDAO.writeFile(filename, list);
                return true;
            }
        }
        return false;
    }  

}
