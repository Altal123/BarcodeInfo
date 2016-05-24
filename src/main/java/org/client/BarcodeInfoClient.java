package org.client;

import org.apache.commons.io.FileUtils;
import org.barcode.*;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;


public class BarcodeInfoClient {

    private static String filePath = "d:\\myparcel_log.txt"; //файл с логами посылок
    private static Map<String, String> currentParcelsStatus = new LinkedHashMap<String, String>(); //key - ID , value - parcel status
    private static List<String> statusFromFile; //инфа о статусе посылок, прочитанная с файла логами посылок
    private static JFrame frmOpt;  //dummy JFrame

    public static void main(String[] args) {

        File parcelFile = new File(filePath); //ссылка на файл c посылками

        try {
            if (!parcelFile.exists()) parcelFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int hashCode = 0;
        //все строки в файле помещаем в коллекцию строк. Каждая строка имеет вид: "Parcel`s ID>current status"
        try {
            statusFromFile = FileUtils.readLines(parcelFile);
            hashCode = statusFromFile.hashCode();

        } catch (IOException e) {
            e.printStackTrace();
        }

        //формируем мап-коллекцию currentParcelsStatus с текущим статусом посылок
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
            //сравниваем полученную мап-коллекцию с коллекцией строк, полученную из файла
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
                            //файл некорректный,т.к. аргументов !=2 а значит обнуляем файл
                            createFile(parcelFile);
                        }
                    }
                    else{
                        //файл некорректный и не содержит символов разделителя ">", т.е. обнуляем файл
                        createFile(parcelFile);
                    }

                    //Строка с ID найдена - проверяем статус посылки и если изменился - обновляем его + выводим на экран
                    if (entry.getKey().equalsIgnoreCase(key)) {
                        exist = true;
                        if (!entry.getValue().equalsIgnoreCase(value)) {
                            itr.set(key + ">" + entry.getValue());
                            showMessage("Position of the parcel was changed!","Parcel Id: " + key + "\n" + entry.getValue());

                        } else continue;
                    }
                }
                //Строки с ID в коллекции, полученной с файла нет - добавляем инфу о посылке в коллекцию
                if (!exist){
                    itr.add(entry.getKey() + ">" + entry.getValue());
                    showMessage("Current position of the parcel", "Parcel Id: " + entry.getKey() + "\n" + entry.getValue());

                }
            }
        } else {
            //файл был пустой, а значит заполняем коллекцию инфой с текущим статусом посылок.
            itr = statusFromFile.listIterator();
            for (Map.Entry<String, String> entry : currentParcelsStatus.entrySet()) {
                showMessage("Current position of the parcel", "Parcel Id: " + entry.getKey() + "\n" + entry.getValue());
                itr.add(entry.getKey() + ">" + entry.getValue());
            }
        }

        //Записываем инфу о текущем статусе посылкок в файл, только если коллекция была изменена
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

        //добавляем инфу со статусом посылок в мап-коллекцию
        currentParcelsStatus.put(response.getBarcode(), response.getEventdescription());
    }
}
