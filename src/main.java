import entity.Address;
import entity.Manager;
import org.apache.log4j.Logger;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        final Logger logger = Logger.getLogger(main.class);
        //org.apache.log4j.BasicConfigurator.configure();
        Address a1 = new Address("1","1","1",1,1);
        Address a2 = new Address("2","2","2",2,2);
        Address a3 = new Address("3","3","3",3,3);
        ArrayList list = new ArrayList();
        logger.info("Objects created and added to list");
        Manager manager = new Manager(list);
        manager.add(a1);
        manager.add(a2);
        manager.add(a3);
        manager.saveAddress();
        logger.info("List was saved to file");
        ArrayList list2 = (ArrayList) manager.loadAddress();
        for(Object item : list2) {
            System.out.println(item);
        }
        logger.info("List was read from file");
    }
}
