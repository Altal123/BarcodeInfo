package org.client;

import org.apache.commons.io.FileUtils;
import org.barcode.*;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;


public class BarcodeInfoClient {

    private static String filePath = "d:\\Sasha\\myparcel_log.txt"; //���� � ������ �������
    private static Map<String, String> currentParcelsStatus = new LinkedHashMap<String, String>(); //key - ID , value - parcel status
    private static List<String> statusFromFile; //���� � ������� �������, ����������� � ����� ������ �������


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

        //��������� ���-��������� � ������� �������� �������
        if (args.length > 0){
            for (String d:args){
                barCodeInfo(d);
            }
        } else {
            System.out.println("Please add the required list of parcel`s!");
            System.exit(-1);
        }

//        barCodeInfo("342erfegf");
//        barCodeInfo("wedwdw222");

        ListIterator<String> itr;
        String temp, key, value;
        boolean exist;
        if (!statusFromFile.isEmpty()) {
            //���������� ���������� ���-��������� � ���������� �����, ���������� �� �����
            for (Map.Entry<String, String> entry : currentParcelsStatus.entrySet()) {
                itr = statusFromFile.listIterator();
                exist = false;
                while (itr.hasNext()) {
                    temp = itr.next();
                    key = temp.split(">")[0];
                    value = temp.split(">")[1];

                    //������ � ID ������� - ��������� ������ ������� � ���� ��������� - ��������� ��� + ������� �� �����
                    if (entry.getKey().equalsIgnoreCase(key)) {
                        exist = true;
                        if (!entry.getValue().equalsIgnoreCase(value)) {
                            itr.set(key + ">" + entry.getValue());
                            JOptionPane.showMessageDialog(null, "Parcel Id: " + key
                                    + "\n" + entry.getValue(), "Position of the parcel was changed!", JOptionPane.INFORMATION_MESSAGE);
                        } else continue;
                    }
                }
                //������ � ID � ���������, ���������� � ����� ��� - ��������� ���� � ������� � ���������
                if (!exist) itr.add(entry.getKey() + ">" + entry.getValue());
            }
        } else {
            //����-���� ��� ������, � ������ ��������� ��������� ����� � ������� ������� �������.
            itr = statusFromFile.listIterator();
            for (Map.Entry<String, String> entry : currentParcelsStatus.entrySet()) {
                JOptionPane.showMessageDialog(null, "Parcel Id: " + entry.getKey()
                        + "\n" + entry.getValue(), "Current position of the parcel", JOptionPane.INFORMATION_MESSAGE);

                itr.add(entry.getKey() + ">" + entry.getValue());
            }
        }

        //���������� ���� � ������� ������� �������� � ����, ������ ���� ��������� ���� ��������
        if (statusFromFile.hashCode() != hashCode) {

            try {
                if (parcelFile.exists()) parcelFile.delete();
                parcelFile.createNewFile();

                FileUtils.writeLines(parcelFile, statusFromFile);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    private static void barCodeInfo(String id) {
        BarcodeStatistic service = new BarcodeStatistic();

        BarcodeStatisticSoap barInfo = service.getBarcodeStatisticSoap();

        BarcodeInfoService response = barInfo.getBarcodeInfo("fcc8d9e1-b6f9-438f-9ac8-b67ab44391dd", id, Culture.UK);

        //��������� ���� �� �������� ������� � ���-���������
        currentParcelsStatus.put(response.getBarcode(), response.getEventdescription()+ "wede");

    }
}
