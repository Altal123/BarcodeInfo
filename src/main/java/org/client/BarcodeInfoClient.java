package org.client;

import org.apache.commons.io.FileUtils;
import org.barcode.*;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;


public class BarcodeInfoClient {

    private static String filePath = "d:\\myparcel_log.txt"; //���� � ������ �������
    private static Map<String, String> currentParcelsStatus = new LinkedHashMap<String, String>(); //key - ID , value - parcel status
    private static List<String> statusFromFile; //���� � ������� �������, ����������� � ����� ������ �������
    private static JFrame frmOpt;  //dummy JFrame

    public static void main(String[] args) {

        File parcelFile = new File(filePath); //������ �� ���� c ���������

        try {
            if (!parcelFile.exists()) parcelFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int hashCode = 0;
        //��� ������ � ����� �������� � ��������� �����. ������ ������ ����� ���: "Parcel`s ID>current status"
        try {
            statusFromFile = FileUtils.readLines(parcelFile);
            hashCode = statusFromFile.hashCode();

        } catch (IOException e) {
            e.printStackTrace();
        }

        //��������� ���-��������� currentParcelsStatus � ������� �������� �������
        if (args.length > 0){
            for (String d:args){
                barCodeInfo(d);
            }
        } else {

            showMessage("Warning!","Please add the required list of parcel`s!" );
            System.exit(-1);
        }

        ListIterator<String> itr;
        String temp;
        String key = null;
        String value = null;
        boolean exist;
        if (!statusFromFile.isEmpty()) {
            //���������� ���������� ���-��������� � ���������� �����, ���������� �� �����
            for (Map.Entry<String, String> entry : currentParcelsStatus.entrySet()) {
                itr = statusFromFile.listIterator();
                exist = false;
                while (itr.hasNext()) {
                    temp = itr.next();

                    if (temp.contains(">")){
                        if(temp.split(">").length == 2){
                            key = temp.split(">")[0];
                            value = temp.split(">")[1];
                        }
                        else{
                            //���� ������������,�.�. ���������� !=2 � ������ �������� ����
                            createFile(parcelFile);
                        }
                    }
                    else{
                        //���� ������������ � �� �������� �������� ����������� ">", �.�. �������� ����
                        createFile(parcelFile);
                    }

                    //������ � ID ������� - ��������� ������ ������� � ���� ��������� - ��������� ��� + ������� �� �����
                    if (entry.getKey().equalsIgnoreCase(key)) {
                        exist = true;
                        if (!entry.getValue().equalsIgnoreCase(value)) {
                            itr.set(key + ">" + entry.getValue());
                            showMessage("Position of the parcel was changed!","Parcel Id: " + key + "\n" + entry.getValue());

                        } else continue;
                    }
                }
                //������ � ID � ���������, ���������� � ����� ��� - ��������� ���� � ������� � ���������
                if (!exist){
                    itr.add(entry.getKey() + ">" + entry.getValue());
                    showMessage("Current position of the parcel", "Parcel Id: " + entry.getKey() + "\n" + entry.getValue());

                }
            }
        } else {
            //���� ��� ������, � ������ ��������� ��������� ����� � ������� �������� �������.
            itr = statusFromFile.listIterator();
            for (Map.Entry<String, String> entry : currentParcelsStatus.entrySet()) {
                showMessage("Current position of the parcel", "Parcel Id: " + entry.getKey() + "\n" + entry.getValue());
                itr.add(entry.getKey() + ">" + entry.getValue());
            }
        }

        //���������� ���� � ������� ������� �������� � ����, ������ ���� ��������� ���� ��������
        if (statusFromFile.hashCode() != hashCode) {

            try {
                createFile(parcelFile);

                FileUtils.writeLines(parcelFile, statusFromFile);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    public static void createFile(File parcelFile){

        try {
            if (parcelFile.exists()) parcelFile.delete();
            parcelFile.createNewFile();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void showMessage(String topic, String body) {

        //if (frmOpt == null) {
            frmOpt = new JFrame();
        //}
        frmOpt.setLocationRelativeTo(null);
        frmOpt.setAlwaysOnTop(true);
        frmOpt.setVisible(true); // show main frame

        JOptionPane.showMessageDialog(frmOpt, body, topic, JOptionPane.INFORMATION_MESSAGE);

        frmOpt.dispose();
    }

    private static void barCodeInfo(String id) {
        BarcodeStatistic service = new BarcodeStatistic();

        BarcodeStatisticSoap barInfo = service.getBarcodeStatisticSoap();

        BarcodeInfoService response = barInfo.getBarcodeInfo("fcc8d9e1-b6f9-438f-9ac8-b67ab44391dd", id, Culture.UK);

        //��������� ���� �� �������� ������� � ���-���������
        currentParcelsStatus.put(response.getBarcode(), response.getEventdescription());
    }
}
