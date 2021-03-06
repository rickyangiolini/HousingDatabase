import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.*;
import java.util.Scanner;

public class Selection extends Connect {
    Scanner scan=new Scanner(System.in);
    Scanner scanString=new Scanner(System.in);
    String format = "\u2503%1$-18s\u2503%2$-18s\u2503%3$-18s\u2503%4$-18s\u2503%5$-18s\u2503%6$-18s\u2503%7$-18s\u2503%8$-18s\u2503%9$-18s\u2503\n";


//    public void showTables(){
//        try {
//
//
//            String format = "\u2503%1$-25s\u2503\n";
//            DatabaseMetaData md = con.getMetaData();
//            ResultSet rs = md.getTables(null, null, "%", null);
//            System.out.format(format, "+++++++++++++++++++++++++");
//            System.out.format(format, "Housing Database Tables");
//            System.out.format(format, "+++++++++++++++++++++++++");
//
//            while (rs.next()) {
//                System.out.format(format,rs.getString(3));
//                System.out.format(format, "-------------------------");
//
//            }
//        }catch (SQLException e){
//
//        }
//
//
//    }

    public void selectForSale() {
        System.out.println("Would you like to filter your selection?");
        System.out.println("1 Yes, 2 No");
        int filter=scan.nextInt();
        if(filter==2) {

            try {
//                StringBuilder s=new StringBuilder();
                PreparedStatement p = con.prepareStatement("SELECT * FROM ForSale");
                ResultSet r = p.executeQuery();
                ResultSetMetaData rm = r.getMetaData();

                String col1 = rm.getColumnName(1);
                String col2 = rm.getColumnName(2);
                String col3 = rm.getColumnName(3);
                String col4 = rm.getColumnName(4);
                String col5 = rm.getColumnName(5);
                String col6 = rm.getColumnName(6);
                String col7 = rm.getColumnName(7);
                String col8= rm.getColumnName(8);
                String col9=rm.getColumnName(9);

                System.out.println("");
                System.out.format(format, "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++","++++++++++++++++++","++++++++++++++++++","++++++++++++++++++");
                System.out.format(format, col1, col2, col3, col4, col5, col6, col7, col8, col9);
                System.out.format(format, "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++","++++++++++++++++++","++++++++++++++++++","++++++++++++++++++");
//                s.append(col1);
//                s.append(',');
//                s.append(col2);
//                s.append(',');
//                s.append(col3);
//                s.append(',');
//                s.append(col4);
//                s.append(',');
//                s.append(col5);
//                s.append(',');
//                s.append(col6);
//                s.append(',');
//                s.append(col7);
//                s.append(',');
//                s.append(col8);
//                s.append(',');
//                s.append('\n');

                while (r.next()) {
                    System.out.format(format, r.getInt(1),r.getInt(2), r.getString(3), r.getString(4), r.getLong(5), r.getDouble(6), r.getInt(7), r.getDouble(8), r.getDouble(9));
                    System.out.format(format, "------------------", "------------------", "------------------", "------------------", "------------------", "------------------","------------------","------------------","------------------");
//                    s.append(r.getInt(1));
//                    s.append(',');
//                    s.append(r.getInt(2));
//                    s.append(',');
//                    s.append(r.getString(3));
//                    s.append(',');
//                    s.append(r.getString(4));
//                    s.append(',');
//                    s.append(r.getLong(5));
//                    s.append(',');
//                    s.append(r.getDouble(6));
//                    s.append(',');
//                    s.append(r.getInt(7));
//                    s.append(',');
//                    s.append(r.getFloat(8));
//                    s.append(',');
//                    s.append(r.getDouble(9));
//                    s.append(',');
//                    s.append('\n');

                }
                System.out.println("Would you like to export this data to a CSV file press 1 to export press 2 to continue without exporting?");
                int csv=scan.nextInt();
                if(csv==1){
                    //ask user for what file they would like to export to

                    //PrintWriter pw=new PrintWriter(new File("test.csv"));
                    //pw.write(s.toString());
                    //pw.close();

                    System.out.println("Exported");
                }else{
                    System.out.println("Not exported");
                }


            } catch (SQLException r) {

//            }catch (FileNotFoundException r){

            }

        }else if(filter==1){

            System.out.println("What would you like to filter faculty by?");
            System.out.println("1-ID, 2-Address, 3-City, 4-Zip Code, 5-Size, 6-# of Bedrooms, 7-# of Bathrooms, 8-Price");
            int filter2=scan.nextInt();
            if(filter2==1){
                try {
                    PreparedStatement p = con.prepareStatement("SELECT * FROM ForSale WHERE ForSaleID=?");
                    System.out.println("Enter the ID to filter by.");
                    int id=scan.nextInt();
                    p.setInt(1,id);
                    ResultSet r = p.executeQuery();
                    ResultSetMetaData rm = r.getMetaData();

                    String col1 = rm.getColumnName(1);
                    String col2 = rm.getColumnName(2);
                    String col3 = rm.getColumnName(3);
                    String col4 = rm.getColumnName(4);
                    String col5 = rm.getColumnName(5);
                    String col6 = rm.getColumnName(6);
                    String col7 = rm.getColumnName(7);
                    String col8= rm.getColumnName(8);
                    String col9=rm.getColumnName(9);



                    System.out.println("");
                    System.out.format(format, "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++","++++++++++++++++++","++++++++++++++++++","++++++++++++++++++");
                    System.out.format(format, col1, col2, col3, col4, col5, col6, col7, col8, col9);
                    System.out.format(format, "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++","++++++++++++++++++","++++++++++++++++++","++++++++++++++++++");

                    while (r.next()) {
                        System.out.format(format, r.getInt(1),r.getInt(2), r.getString(3), r.getString(4), r.getLong(5), r.getDouble(6), r.getInt(7), r.getDouble(8), r.getDouble(9));
                        System.out.format(format, "------------------", "------------------", "------------------", "------------------", "------------------", "------------------","------------------","------------------","------------------");

                    }


                } catch (SQLException r) {

                }

            }else if(filter2==2){
                try {
                    PreparedStatement p = con.prepareStatement("SELECT * FROM ForSale WHERE Address LIKE ?");
                    System.out.println("Enter the Address to filter by.");
                    String add=scanString.nextLine();
                    p.setString(1,add+'%');
                    ResultSet r = p.executeQuery();
                    ResultSetMetaData rm = r.getMetaData();

                    String col1 = rm.getColumnName(1);
                    String col2 = rm.getColumnName(2);
                    String col3 = rm.getColumnName(3);
                    String col4 = rm.getColumnName(4);
                    String col5 = rm.getColumnName(5);
                    String col6 = rm.getColumnName(6);
                    String col7 = rm.getColumnName(7);
                    String col8= rm.getColumnName(8);
                    String col9=rm.getColumnName(9);



                    System.out.println("");
                    System.out.format(format, "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++","++++++++++++++++++","++++++++++++++++++","++++++++++++++++++");
                    System.out.format(format, col1, col2, col3, col4, col5, col6, col7, col8, col9);
                    System.out.format(format, "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++","++++++++++++++++++","++++++++++++++++++","++++++++++++++++++");

                    while (r.next()) {
                        System.out.format(format, r.getInt(1),r.getInt(2), r.getString(3), r.getString(4), r.getLong(5), r.getDouble(6), r.getInt(7), r.getDouble(8), r.getDouble(9));
                        System.out.format(format, "------------------", "------------------", "------------------", "------------------", "------------------", "------------------","------------------","------------------","------------------");

                    }


                } catch (SQLException r) {

                }

            }else if(filter2==3){
                try {
                    PreparedStatement p = con.prepareStatement("SELECT * FROM ForSale WHERE City=?");
                    System.out.println("Enter the City to filter by.");
                    String city=scanString.nextLine();
                    p.setString(1,city);
                    ResultSet r = p.executeQuery();
                    ResultSetMetaData rm = r.getMetaData();

                    String col1 = rm.getColumnName(1);
                    String col2 = rm.getColumnName(2);
                    String col3 = rm.getColumnName(3);
                    String col4 = rm.getColumnName(4);
                    String col5 = rm.getColumnName(5);
                    String col6 = rm.getColumnName(6);
                    String col7 = rm.getColumnName(7);
                    String col8= rm.getColumnName(8);
                    String col9=rm.getColumnName(9);



                    System.out.println("");
                    System.out.format(format, "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++","++++++++++++++++++","++++++++++++++++++","++++++++++++++++++");
                    System.out.format(format, col1, col2, col3, col4, col5, col6, col7, col8, col9);
                    System.out.format(format, "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++","++++++++++++++++++","++++++++++++++++++","++++++++++++++++++");

                    while (r.next()) {
                        System.out.format(format, r.getInt(1),r.getInt(2), r.getString(3), r.getString(4), r.getLong(5), r.getDouble(6), r.getInt(7), r.getDouble(8), r.getDouble(9));
                        System.out.format(format, "------------------", "------------------", "------------------", "------------------", "------------------", "------------------","------------------","------------------","------------------");

                    }


                } catch (SQLException r) {

                }

            }else if(filter2==4){
                try {
                    PreparedStatement p = con.prepareStatement("SELECT * FROM ForSale WHERE ZipCode=?");
                    System.out.println("Enter the ZipCode to filter by.");
                    long zcode=scan.nextInt();
                    p.setLong(1,zcode);
                    ResultSet r = p.executeQuery();
                    ResultSetMetaData rm = r.getMetaData();

                    String col1 = rm.getColumnName(1);
                    String col2 = rm.getColumnName(2);
                    String col3 = rm.getColumnName(3);
                    String col4 = rm.getColumnName(4);
                    String col5 = rm.getColumnName(5);
                    String col6 = rm.getColumnName(6);
                    String col7 = rm.getColumnName(7);
                    String col8= rm.getColumnName(8);
                    String col9=rm.getColumnName(9);



                    System.out.println("");
                    System.out.format(format, "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++","++++++++++++++++++","++++++++++++++++++","++++++++++++++++++");
                    System.out.format(format, col1, col2, col3, col4, col5, col6, col7, col8, col9);
                    System.out.format(format, "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++","++++++++++++++++++","++++++++++++++++++","++++++++++++++++++");

                    while (r.next()) {
                        System.out.format(format, r.getInt(1),r.getInt(2), r.getString(3), r.getString(4), r.getLong(5), r.getDouble(6), r.getInt(7), r.getDouble(8), r.getDouble(9));
                        System.out.format(format, "------------------", "------------------", "------------------", "------------------", "------------------", "------------------","------------------","------------------","------------------");

                    }


                } catch (SQLException r) {

                }


            }else if(filter2==5){
                try {
                    PreparedStatement p = con.prepareStatement("SELECT * FROM ForSale WHERE Size=?");
                    System.out.println("Enter the Size (sqft) to filter by.");
                    double sz=scan.nextInt();
                    p.setDouble(1,sz);
                    ResultSet r = p.executeQuery();
                    ResultSetMetaData rm = r.getMetaData();

                    String col1 = rm.getColumnName(1);
                    String col2 = rm.getColumnName(2);
                    String col3 = rm.getColumnName(3);
                    String col4 = rm.getColumnName(4);
                    String col5 = rm.getColumnName(5);
                    String col6 = rm.getColumnName(6);
                    String col7 = rm.getColumnName(7);
                    String col8= rm.getColumnName(8);
                    String col9=rm.getColumnName(9);



                    System.out.println("");
                    System.out.format(format, "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++","++++++++++++++++++","++++++++++++++++++","++++++++++++++++++");
                    System.out.format(format, col1, col2, col3, col4, col5, col6, col7, col8, col9);
                    System.out.format(format, "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++","++++++++++++++++++","++++++++++++++++++","++++++++++++++++++");

                    while (r.next()) {
                        System.out.format(format, r.getInt(1),r.getInt(2), r.getString(3), r.getString(4), r.getLong(5), r.getDouble(6), r.getInt(7), r.getDouble(8), r.getDouble(9));
                        System.out.format(format, "------------------", "------------------", "------------------", "------------------", "------------------", "------------------","------------------","------------------","------------------");

                    }

                } catch (SQLException r) {

                }

            }else if(filter2==6){
                try {
                    PreparedStatement p = con.prepareStatement("SELECT * FROM ForSale WHERE Bedrooms=?");
                    System.out.println("Enter the number of Bedrooms to filter by.");
                    int bed=scan.nextInt();
                    p.setInt(1,bed);
                    ResultSet r = p.executeQuery();
                    ResultSetMetaData rm = r.getMetaData();

                    String col1 = rm.getColumnName(1);
                    String col2 = rm.getColumnName(2);
                    String col3 = rm.getColumnName(3);
                    String col4 = rm.getColumnName(4);
                    String col5 = rm.getColumnName(5);
                    String col6 = rm.getColumnName(6);
                    String col7 = rm.getColumnName(7);
                    String col8= rm.getColumnName(8);
                    String col9=rm.getColumnName(9);



                    System.out.println("");
                    System.out.format(format, "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++","++++++++++++++++++","++++++++++++++++++","++++++++++++++++++");
                    System.out.format(format, col1, col2, col3, col4, col5, col6, col7, col8, col9);
                    System.out.format(format, "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++","++++++++++++++++++","++++++++++++++++++","++++++++++++++++++");

                    while (r.next()) {
                        System.out.format(format, r.getInt(1),r.getInt(2), r.getString(3), r.getString(4), r.getLong(5), r.getDouble(6), r.getInt(7), r.getDouble(8), r.getDouble(9));
                        System.out.format(format, "------------------", "------------------", "------------------", "------------------", "------------------", "------------------","------------------","------------------","------------------");

                    }


                } catch (SQLException r) {

                }


            }else if(filter2==7){
                try {
                    PreparedStatement p = con.prepareStatement("SELECT * FROM ForSale WHERE Bathrooms=?");
                    System.out.println("Enter the number of Bathrooms to filter by.");
                    float bath=scan.nextInt();
                    p.setFloat(1,bath);
                    ResultSet r = p.executeQuery();
                    ResultSetMetaData rm = r.getMetaData();

                    String col1 = rm.getColumnName(1);
                    String col2 = rm.getColumnName(2);
                    String col3 = rm.getColumnName(3);
                    String col4 = rm.getColumnName(4);
                    String col5 = rm.getColumnName(5);
                    String col6 = rm.getColumnName(6);
                    String col7 = rm.getColumnName(7);
                    String col8= rm.getColumnName(8);
                    String col9=rm.getColumnName(9);



                    System.out.println("");
                    System.out.format(format, "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++","++++++++++++++++++","++++++++++++++++++","++++++++++++++++++");
                    System.out.format(format, col1, col2, col3, col4, col5, col6, col7, col8, col9);
                    System.out.format(format, "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++","++++++++++++++++++","++++++++++++++++++","++++++++++++++++++");

                    while (r.next()) {
                        System.out.format(format, r.getInt(1),r.getInt(2), r.getString(3), r.getString(4), r.getLong(5), r.getDouble(6), r.getInt(7), r.getDouble(8), r.getDouble(9));
                        System.out.format(format, "------------------", "------------------", "------------------", "------------------", "------------------", "------------------","------------------","------------------","------------------");

                    }


                } catch (SQLException r) {

                }

            }else if(filter2==8){
                try {
                    PreparedStatement p = con.prepareStatement("SELECT * FROM ForSale WHERE Price=?");
                    System.out.println("Enter the Price to filter by.");
                    double price=scan.nextInt();
                    p.setDouble(1,price);
                    ResultSet r = p.executeQuery();
                    ResultSetMetaData rm = r.getMetaData();

                    String col1 = rm.getColumnName(1);
                    String col2 = rm.getColumnName(2);
                    String col3 = rm.getColumnName(3);
                    String col4 = rm.getColumnName(4);
                    String col5 = rm.getColumnName(5);
                    String col6 = rm.getColumnName(6);
                    String col7 = rm.getColumnName(7);
                    String col8= rm.getColumnName(8);
                    String col9=rm.getColumnName(9);



                    System.out.println("");
                    System.out.format(format, "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++","++++++++++++++++++","++++++++++++++++++","++++++++++++++++++");
                    System.out.format(format, col1, col2, col3, col4, col5, col6, col7, col8, col9);
                    System.out.format(format, "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++","++++++++++++++++++","++++++++++++++++++","++++++++++++++++++");

                    while (r.next()) {
                        System.out.format(format, r.getInt(1),r.getInt(2), r.getString(3), r.getString(4), r.getLong(5), r.getDouble(6), r.getInt(7), r.getDouble(8), r.getDouble(9));
                        System.out.format(format, "------------------", "------------------", "------------------", "------------------", "------------------", "------------------","------------------","------------------","------------------");

                    }


                } catch (SQLException r) {

                }

            }else {
                System.out.println("Not a valid option please choose again");
                selectForSale();
            }







        }else {
            System.out.println("Not a valid option please choose again");
            selectForSale();
        }
    }
    public void selectForRent() {
        System.out.println("Would you like to filter your selection?");
        System.out.println("1 Yes, 2 No");
        int filter=scan.nextInt();
        if(filter==2) {

            try {
                PreparedStatement p = con.prepareStatement("SELECT * FROM ForRent");
                ResultSet r = p.executeQuery();
                ResultSetMetaData rm = r.getMetaData();

                String col1 = rm.getColumnName(1);
                String col2 = rm.getColumnName(2);
                String col3 = rm.getColumnName(3);
                String col4 = rm.getColumnName(4);
                String col5 = rm.getColumnName(5);
                String col6 = rm.getColumnName(6);
                String col7 = rm.getColumnName(7);
                String col8= rm.getColumnName(8);
                String col9=rm.getColumnName(9);



                System.out.println("");
                System.out.format(format, "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++","++++++++++++++++++","++++++++++++++++++","++++++++++++++++++");
                System.out.format(format, col1, col2, col3, col4, col5, col6, col7, col8, col9);
                System.out.format(format, "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++","++++++++++++++++++","++++++++++++++++++","++++++++++++++++++");

                while (r.next()) {
                    System.out.format(format, r.getInt(1),r.getInt(2), r.getString(3), r.getString(4), r.getLong(5), r.getDouble(6), r.getInt(7), r.getDouble(8), r.getDouble(9));
                    System.out.format(format, "------------------", "------------------", "------------------", "------------------", "------------------", "------------------","------------------","------------------","------------------");

                }


            } catch (SQLException r) {

            }
        }else if(filter==1){

            System.out.println("What would you like to filter faculty by?");
            System.out.println("1-ID, 2-Address, 3-City, 4-Zip Code, 5-Size, 6-# of Bedrooms, 7-# of Bathrooms, 8-Price");
            int filter2=scan.nextInt();
            if(filter2==1){
                try {
                    PreparedStatement p = con.prepareStatement("SELECT * FROM ForRent WHERE ForRentID=?");
                    System.out.println("Enter the ID to filter by.");
                    int id=scan.nextInt();
                    p.setInt(1,id);
                    ResultSet r = p.executeQuery();
                    ResultSetMetaData rm = r.getMetaData();

                    String col1 = rm.getColumnName(1);
                    String col2 = rm.getColumnName(2);
                    String col3 = rm.getColumnName(3);
                    String col4 = rm.getColumnName(4);
                    String col5 = rm.getColumnName(5);
                    String col6 = rm.getColumnName(6);
                    String col7 = rm.getColumnName(7);
                    String col8= rm.getColumnName(8);
                    String col9=rm.getColumnName(9);



                    System.out.println("");
                    System.out.format(format, "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++","++++++++++++++++++","++++++++++++++++++","++++++++++++++++++");
                    System.out.format(format, col1, col2, col3, col4, col5, col6, col7, col8, col9);
                    System.out.format(format, "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++","++++++++++++++++++","++++++++++++++++++","++++++++++++++++++");

                    while (r.next()) {
                        System.out.format(format, r.getInt(1),r.getInt(2), r.getString(3), r.getString(4), r.getLong(5), r.getDouble(6), r.getInt(7), r.getDouble(8), r.getDouble(9));
                        System.out.format(format, "------------------", "------------------", "------------------", "------------------", "------------------", "------------------","------------------","------------------","------------------");

                    }


                } catch (SQLException r) {

                }

            }else if(filter2==2){
                try {
                    PreparedStatement p = con.prepareStatement("SELECT * FROM ForRent WHERE Address LIKE ?");
                    System.out.println("Enter the Address to filter by.");
                    String add=scanString.nextLine();
                    p.setString(1,add+'%');
                    ResultSet r = p.executeQuery();
                    ResultSetMetaData rm = r.getMetaData();

                    String col1 = rm.getColumnName(1);
                    String col2 = rm.getColumnName(2);
                    String col3 = rm.getColumnName(3);
                    String col4 = rm.getColumnName(4);
                    String col5 = rm.getColumnName(5);
                    String col6 = rm.getColumnName(6);
                    String col7 = rm.getColumnName(7);
                    String col8= rm.getColumnName(8);
                    String col9=rm.getColumnName(9);



                    System.out.println("");
                    System.out.format(format, "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++","++++++++++++++++++","++++++++++++++++++","++++++++++++++++++");
                    System.out.format(format, col1, col2, col3, col4, col5, col6, col7, col8, col9);
                    System.out.format(format, "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++","++++++++++++++++++","++++++++++++++++++","++++++++++++++++++");

                    while (r.next()) {
                        System.out.format(format, r.getInt(1),r.getInt(2), r.getString(3), r.getString(4), r.getLong(5), r.getDouble(6), r.getInt(7), r.getDouble(8), r.getDouble(9));
                        System.out.format(format, "------------------", "------------------", "------------------", "------------------", "------------------", "------------------","------------------","------------------","------------------");

                    }


                } catch (SQLException r) {

                }

            }else if(filter2==3){
                try {
                    PreparedStatement p = con.prepareStatement("SELECT * FROM ForRent WHERE City=?");
                    System.out.println("Enter the City to filter by.");
                    String city=scanString.nextLine();
                    p.setString(1,city);
                    ResultSet r = p.executeQuery();
                    ResultSetMetaData rm = r.getMetaData();

                    String col1 = rm.getColumnName(1);
                    String col2 = rm.getColumnName(2);
                    String col3 = rm.getColumnName(3);
                    String col4 = rm.getColumnName(4);
                    String col5 = rm.getColumnName(5);
                    String col6 = rm.getColumnName(6);
                    String col7 = rm.getColumnName(7);
                    String col8= rm.getColumnName(8);
                    String col9=rm.getColumnName(9);



                    System.out.println("");
                    System.out.format(format, "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++","++++++++++++++++++","++++++++++++++++++","++++++++++++++++++");
                    System.out.format(format, col1, col2, col3, col4, col5, col6, col7, col8, col9);
                    System.out.format(format, "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++","++++++++++++++++++","++++++++++++++++++","++++++++++++++++++");

                    while (r.next()) {
                        System.out.format(format, r.getInt(1),r.getInt(2), r.getString(3), r.getString(4), r.getLong(5), r.getDouble(6), r.getInt(7), r.getDouble(8), r.getDouble(9));
                        System.out.format(format, "------------------", "------------------", "------------------", "------------------", "------------------", "------------------","------------------","------------------","------------------");

                    }


                } catch (SQLException r) {

                }

            }else if(filter2==4){
                try {
                    PreparedStatement p = con.prepareStatement("SELECT * FROM ForRent WHERE ZipCode=?");
                    System.out.println("Enter the ZipCode to filter by.");
                    long zcode=scan.nextInt();
                    p.setLong(1,zcode);
                    ResultSet r = p.executeQuery();
                    ResultSetMetaData rm = r.getMetaData();

                    String col1 = rm.getColumnName(1);
                    String col2 = rm.getColumnName(2);
                    String col3 = rm.getColumnName(3);
                    String col4 = rm.getColumnName(4);
                    String col5 = rm.getColumnName(5);
                    String col6 = rm.getColumnName(6);
                    String col7 = rm.getColumnName(7);
                    String col8= rm.getColumnName(8);
                    String col9=rm.getColumnName(9);



                    System.out.println("");
                    System.out.format(format, "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++","++++++++++++++++++","++++++++++++++++++","++++++++++++++++++");
                    System.out.format(format, col1, col2, col3, col4, col5, col6, col7, col8, col9);
                    System.out.format(format, "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++","++++++++++++++++++","++++++++++++++++++","++++++++++++++++++");

                    while (r.next()) {
                        System.out.format(format, r.getInt(1),r.getInt(2), r.getString(3), r.getString(4), r.getLong(5), r.getDouble(6), r.getInt(7), r.getDouble(8), r.getDouble(9));
                        System.out.format(format, "------------------", "------------------", "------------------", "------------------", "------------------", "------------------","------------------","------------------","------------------");

                    }


                } catch (SQLException r) {

                }


            }else if(filter2==5){
                try {
                    PreparedStatement p = con.prepareStatement("SELECT * FROM ForRent WHERE Size=?");
                    System.out.println("Enter the Size (sqft) to filter by.");
                    double sz=scan.nextInt();
                    p.setDouble(1,sz);
                    ResultSet r = p.executeQuery();
                    ResultSetMetaData rm = r.getMetaData();

                    String col1 = rm.getColumnName(1);
                    String col2 = rm.getColumnName(2);
                    String col3 = rm.getColumnName(3);
                    String col4 = rm.getColumnName(4);
                    String col5 = rm.getColumnName(5);
                    String col6 = rm.getColumnName(6);
                    String col7 = rm.getColumnName(7);
                    String col8= rm.getColumnName(8);
                    String col9=rm.getColumnName(9);



                    System.out.println("");
                    System.out.format(format, "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++","++++++++++++++++++","++++++++++++++++++","++++++++++++++++++");
                    System.out.format(format, col1, col2, col3, col4, col5, col6, col7, col8, col9);
                    System.out.format(format, "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++","++++++++++++++++++","++++++++++++++++++","++++++++++++++++++");

                    while (r.next()) {
                        System.out.format(format, r.getInt(1),r.getInt(2), r.getString(3), r.getString(4), r.getLong(5), r.getDouble(6), r.getInt(7), r.getDouble(8), r.getDouble(9));
                        System.out.format(format, "------------------", "------------------", "------------------", "------------------", "------------------", "------------------","------------------","------------------","------------------");

                    }

                } catch (SQLException r) {

                }

            }else if(filter2==6){
                try {
                    PreparedStatement p = con.prepareStatement("SELECT * FROM ForRent WHERE Bedrooms=?");
                    System.out.println("Enter the number of Bedrooms to filter by.");
                    int bed=scan.nextInt();
                    p.setInt(1,bed);
                    ResultSet r = p.executeQuery();
                    ResultSetMetaData rm = r.getMetaData();

                    String col1 = rm.getColumnName(1);
                    String col2 = rm.getColumnName(2);
                    String col3 = rm.getColumnName(3);
                    String col4 = rm.getColumnName(4);
                    String col5 = rm.getColumnName(5);
                    String col6 = rm.getColumnName(6);
                    String col7 = rm.getColumnName(7);
                    String col8= rm.getColumnName(8);
                    String col9=rm.getColumnName(9);



                    System.out.println("");
                    System.out.format(format, "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++","++++++++++++++++++","++++++++++++++++++","++++++++++++++++++");
                    System.out.format(format, col1, col2, col3, col4, col5, col6, col7, col8, col9);
                    System.out.format(format, "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++","++++++++++++++++++","++++++++++++++++++","++++++++++++++++++");

                    while (r.next()) {
                        System.out.format(format, r.getInt(1),r.getInt(2), r.getString(3), r.getString(4), r.getLong(5), r.getDouble(6), r.getInt(7), r.getDouble(8), r.getDouble(9));
                        System.out.format(format, "------------------", "------------------", "------------------", "------------------", "------------------", "------------------","------------------","------------------","------------------");

                    }


                } catch (SQLException r) {

                }


            }else if(filter2==7){
                try {
                    PreparedStatement p = con.prepareStatement("SELECT * FROM ForRent WHERE Bathrooms=?");
                    System.out.println("Enter the number of Bathrooms to filter by.");
                    float bath=scan.nextInt();
                    p.setFloat(1,bath);
                    ResultSet r = p.executeQuery();
                    ResultSetMetaData rm = r.getMetaData();

                    String col1 = rm.getColumnName(1);
                    String col2 = rm.getColumnName(2);
                    String col3 = rm.getColumnName(3);
                    String col4 = rm.getColumnName(4);
                    String col5 = rm.getColumnName(5);
                    String col6 = rm.getColumnName(6);
                    String col7 = rm.getColumnName(7);
                    String col8= rm.getColumnName(8);
                    String col9=rm.getColumnName(9);



                    System.out.println("");
                    System.out.format(format, "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++","++++++++++++++++++","++++++++++++++++++","++++++++++++++++++");
                    System.out.format(format, col1, col2, col3, col4, col5, col6, col7, col8, col9);
                    System.out.format(format, "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++","++++++++++++++++++","++++++++++++++++++","++++++++++++++++++");

                    while (r.next()) {
                        System.out.format(format, r.getInt(1),r.getInt(2), r.getString(3), r.getString(4), r.getLong(5), r.getDouble(6), r.getInt(7), r.getDouble(8), r.getDouble(9));
                        System.out.format(format, "------------------", "------------------", "------------------", "------------------", "------------------", "------------------","------------------","------------------","------------------");

                    }


                } catch (SQLException r) {

                }

            }else if(filter2==8){
                try {
                    PreparedStatement p = con.prepareStatement("SELECT * FROM ForRent WHERE Price=?");
                    System.out.println("Enter the Price to filter by.");
                    double price=scan.nextInt();
                    p.setDouble(1,price);
                    ResultSet r = p.executeQuery();
                    ResultSetMetaData rm = r.getMetaData();

                    String col1 = rm.getColumnName(1);
                    String col2 = rm.getColumnName(2);
                    String col3 = rm.getColumnName(3);
                    String col4 = rm.getColumnName(4);
                    String col5 = rm.getColumnName(5);
                    String col6 = rm.getColumnName(6);
                    String col7 = rm.getColumnName(7);
                    String col8= rm.getColumnName(8);
                    String col9=rm.getColumnName(9);



                    System.out.println("");
                    System.out.format(format, "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++","++++++++++++++++++","++++++++++++++++++","++++++++++++++++++");
                    System.out.format(format, col1, col2, col3, col4, col5, col6, col7, col8, col9);
                    System.out.format(format, "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++", "++++++++++++++++++","++++++++++++++++++","++++++++++++++++++","++++++++++++++++++");

                    while (r.next()) {
                        System.out.format(format, r.getInt(1),r.getInt(2), r.getString(3), r.getString(4), r.getLong(5), r.getDouble(6), r.getInt(7), r.getDouble(8), r.getDouble(9));
                        System.out.format(format, "------------------", "------------------", "------------------", "------------------", "------------------", "------------------","------------------","------------------","------------------");

                    }


                } catch (SQLException r) {

                }

            }else {
                System.out.println("Not a valid option please choose again");
                selectForRent();
            }







        }else {
            System.out.println("Not a valid option please choose again");
            selectForRent();
        }
    }

    public void avgPriceForSalePerCity(){
        try {
            System.out.println("Please enter the city in which you would like to see the average price of houses for sale.");
            String city = scanString.nextLine();
            PreparedStatement p = con.prepareStatement("SELECT City, AVG(Price) as AverageHousePrice FROM forsale WHERE City=? GROUP BY City");
            p.setString(1,city);
            ResultSet r=p.executeQuery();
            ResultSetMetaData rm = r.getMetaData();
            String col1 = rm.getColumnName(1);
            String col2 = rm.getColumnName(2);
            String format ="\u2503%1$-20s\u2503%2$-20s\u2503\n";
            System.out.println("");
            System.out.format(format, "++++++++++++++++++++", "++++++++++++++++++++");
            System.out.format(format, col1, col2);
            System.out.format(format, "++++++++++++++++++++", "++++++++++++++++++++");
            while (r.next()){
                System.out.format(format, r.getString(1),r.getDouble(2));
                System.out.format(format, "--------------------", "--------------------");
            }

        }catch (SQLException e){

        }


    }
    public void avgPriceForRentPerCity(){
        try {
            System.out.println("Please enter the city in which you would like to see the average price of houses for rent.");
            String city = scanString.nextLine();
            PreparedStatement p = con.prepareStatement("SELECT City, AVG(Price) as AverageHousePrice FROM forrent WHERE City=? GROUP BY City");
            p.setString(1,city);
            ResultSet r=p.executeQuery();
            ResultSetMetaData rm = r.getMetaData();
            String col1 = rm.getColumnName(1);
            String col2 = rm.getColumnName(2);
            String format ="\u2503%1$-20s\u2503%2$-20s\u2503\n";
            System.out.println("");
            System.out.format(format, "++++++++++++++++++++", "++++++++++++++++++++");
            System.out.format(format, col1, col2);
            System.out.format(format, "++++++++++++++++++++", "++++++++++++++++++++");
            while (r.next()){
                System.out.format(format, r.getString(1),r.getDouble(2));
                System.out.format(format, "--------------------", "--------------------");
            }

        }catch (SQLException e){

        }

    }





}
