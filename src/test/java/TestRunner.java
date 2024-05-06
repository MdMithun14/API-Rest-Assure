import com.github.javafaker.Faker;
import io.restassured.path.json.JsonPath;
import org.apache.commons.configuration.ConfigurationException;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestRunner extends SetUp{
  @Test (priority = 1)
    public void dologin() throws ConfigurationException, IOException {

        userController userController= new userController();
        userController.dologin("salman@roadtocareer.net","1234");
    }
    @Test(priority = 2)
    public void createUser() throws IOException, ConfigurationException {
        userController userController = new userController();
        Faker faker = new Faker();
        String name = faker.name().fullName();
        String email =faker.name().firstName()+ "@gamil.com";
        String password ="1234";
        String phone_number ="01567"+Utils.genarateRandom(100000,999999);
        String nid = "123456789";
        String role = "Agent";
        userModel model = new userModel();
        model.setName(name);
        model.setEmail(email);
        model.setPassword(password);
        model.setPhone_number(phone_number);
        model.setNid(nid);
        model.setRole(role);
       JsonPath jsonObj = userController.createUser(model);
        String agentAccount = jsonObj.get("user.phone_number");
        int UserId =  jsonObj.get("user.id");
        Utils.setEnvironment("UserId",String.valueOf(UserId));
        Utils.setEnvironment("agentAccount",agentAccount);
    }
    @Test (priority = 4)
    public void createCustomer() throws IOException, ConfigurationException {
        userController userController = new userController();
        Faker faker = new Faker();
        String name = faker.name().fullName();
        String email =faker.name().firstName()+ "@gmail.com";
        String password ="1234";
        String phone_number ="01567"+Utils.genarateRandom(100000,999999);
        String nid = "123456789";
        String role = "Customer";
        userModel model = new userModel();
        model.setName(name);
        model.setEmail(email);
        model.setPassword(password);
        model.setPhone_number(phone_number);
        model.setNid(nid);
        model.setRole(role);
        JsonPath jsonObj = userController.createUser(model);
        String customerPhone= jsonObj.get("user.phone_number");
        int UserId =  jsonObj.get("user.id");
        Utils.setEnvironment("UserId",String.valueOf(UserId));
        Utils.setEnvironment("customerPhone",customerPhone);
    }
// @Test(priority = 3 )
    public void searchUser() throws IOException {
        userController userController = new userController();
        userController.searchUser(prop.getProperty("marchentAccount"));
    }
    @Test(priority = 3)
    public void depositeMoneytoAgent() throws IOException {
        String from_account = "System";
        String to_account = prop.getProperty("agentAccount");
        String amount = "10000";

        userController userController = new userController();
        userModel model = new userModel();
        model.setFrom_account(from_account);
        model.setTo_account(to_account);
        model.setAmount(amount);
        JsonPath jsonObj = userController.depositToAgent(model);

    }
    @Test (priority = 5)
    public void depositeMoneytoCustomer() throws IOException {
        String from_account = prop.getProperty("agentAccount");
        String to_account = prop.getProperty("customerPhone");
        String amount = "1500";
        userController userController = new userController();
        userModel model = new userModel();
        model.setFrom_account(from_account);
        model.setTo_account(to_account);
        model.setAmount(amount);
        JsonPath jsonObj = userController.depositToAgent(model);

    }
    @Test (priority = 6)
    public void  withdrawfromAgent() throws IOException {
      String from_account= prop.getProperty("customerPhone");
      String to_account = prop.getProperty("agentAccount");
      String amount="100";
      userController userController = new userController();
      userModel model = new userModel();
      model.setFrom_account(from_account);
      model.setTo_account(to_account);
      model.setAmount(amount);
      JsonPath jsonObj = userController.withdrawfromAgent(model);


    }
    @Test (priority = 7)
    public void createSeccustomer() throws IOException, ConfigurationException {
      userController userController = new userController();
      Faker faker = new Faker();

      String name = faker.name().fullName();
      String email = faker.name().firstName()+"@gmail.com";
      String password = "1234";
      String phone_number = "01306"+Utils.genarateRandom(100000, 999999);
      String nid = "123456789";
      String role = "Customer";
      userModel model = new userModel();
      model.setName(name);
      model.setEmail(email);
      model. setPassword(password);
      model.setPhone_number(phone_number);
      model.setRole(role);
      model. setNid(nid);
    JsonPath jsonObj =   userController.createUser(model);
        String  secondCustomer = jsonObj.get("user.phone_number");
        Utils.setEnvironment("secondCustomer",secondCustomer);
    }

    @Test (priority = 8)
    public void sendMoneysecUser() throws IOException {
      userController userController = new userController();
      String from_account = prop.getProperty("customerPhone");
      String to_account = prop.getProperty("secondCustomer");
      String amount = "400";
      userModel model = new userModel();
      model .setFrom_account(from_account);
      model.setTo_account(to_account);
      model.setAmount(amount);
        JsonPath jsonObj = userController.sendMoneysecondUser(model);
    }
    @Test (priority = 9)
    public void paymentToMarcent() throws IOException {
      userController userController = new userController();
      String from_account = prop.getProperty("customerPhone");
      String to_account = prop.getProperty("marchentAccount");
      String amount  = "10";
      userModel model = new userModel();
      model.setFrom_account(from_account);
      model.setTo_account(to_account);
      model.setAmount(amount);
        JsonPath jsonObj = userController.paymentMarcent(model);
    }
    @Test (priority = 10)
    public  void seeBalance() throws IOException {
      userController userController = new userController();
        userController.seeBalance(prop.getProperty("marchentAccount"));
    }
  // @Test (priority = 11)
    public void creatMarcent() throws IOException {
      userController userController = new userController();
      Faker faker = new Faker();
      String name = faker.name().fullName();
      String email = faker.name().firstName()+"@gmail.com";
      String password = "1234";
      String phone_number= "01686606905";
      String nid = "123456789";
      String role="Merchant";
      userModel model = new userModel();
      model.setName(name);
      model.setEmail(email);
      model.setPassword(password);
      model.setPhone_number(phone_number);
      model.setNid(nid);
      model.setRole(role);
      JsonPath jsonObj = userController.createUser(model);
    }

}
