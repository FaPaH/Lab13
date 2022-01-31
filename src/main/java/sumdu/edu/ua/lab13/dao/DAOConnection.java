package sumdu.edu.ua.lab13.dao;

import jdk.nashorn.internal.runtime.regexp.RegExp;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOConnection {

    private static DAOConnection INSTANCE = null;
    private Connection connection;
    private List<String> dataList = new ArrayList<>();


    private String url;
    private String driver;
    private String sourceName;
    private String username;
    private String password;

    private DAOConnection(){
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("src/main/resources/dataSource.xml"));

            NodeList datasource = document.getDocumentElement().getElementsByTagName("datasource");

            for (int i = 0; i < datasource.getLength(); i++) {
                NodeList data = datasource.item(i).getChildNodes();
                for (int j = 0; j < data.getLength(); j++) {
                    Node params = data.item(j);
                    String param = params.getTextContent().replaceAll("\\s", "");
                    dataList.add(param);
//                    System.out.println(param);
                }
            }

            sourceName = dataList.get(1);
            url = dataList.get(3);
            driver = dataList.get(5);
            username = dataList.get(7);
            password = dataList.get(9);

//            System.out.println(dataList);

        } catch (ParserConfigurationException | SAXException | IOException e){
            e.printStackTrace();
            System.out.println("ERROR: Check input file name");
        }
    }

    public static DAOConnection getInstance(){
        if (INSTANCE == null){
            INSTANCE = new DAOConnection();
            return INSTANCE;
        }
        return INSTANCE;
    }

    public void connect(){
        try{
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            System.out.println("Exception in connect");
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        connect();
        return connection;
    }
}
