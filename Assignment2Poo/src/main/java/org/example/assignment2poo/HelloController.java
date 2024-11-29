package org.example.assignment2poo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class HelloController {
    @FXML
    private Button Button;

    @FXML
    private TextArea TextArea;

    @FXML
    private TextField countryTxt;



    @FXML
    protected void APICall(ActionEvent event) {
        int a=199;
        int b=200;
        try {
            URL url = new URL("http://universities.hipolabs.com/search?country="+countryTxt.getText());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            int responseCode = conn.getResponseCode();
            if (responseCode != 200){
                throw new RuntimeException("ocurrio un error "+ responseCode);
            }else{
                StringBuilder infostring = new StringBuilder();
                Scanner sc = new Scanner(url.openStream());

                while(sc.hasNext()){
                    infostring.append(sc.nextLine());

                }
                for(int i=0; i<=15;i++){
                    infostring.replace(a,b,"\n");
                    a+=194;
                    b+=194;
                }
                sc.close();
                TextArea.setText(String.valueOf(infostring));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}