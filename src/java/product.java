
import java.sql.*;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;



@ManagedBean(name="obj")
@SessionScoped
public class product
{
   private String name;
   private String qty;
   private String price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
   
    public String add() throws SQLException    {
    System.out.println("product inserted");
    System.out.println(name +" "+ qty + " " + price);
   
    
    String url="jdbc:derby://localhost:1527/jsf1";
	String uname="root";
	String pass="root";
	
	Connection con = DriverManager.getConnection(url,uname,pass);
	Statement st=con.createStatement();
        st.executeUpdate("insert into product(NAME,QTY,PRICE) values('"+name+"','"+qty+"','"+price+"')");
           con.close();
              
    return "success";
    }
}
