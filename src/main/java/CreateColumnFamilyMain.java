
import com.datastax.driver.core.Session;
import persistence.Connector;

public class CreateColumnFamilyMain {

    public static void main(String[] args) {

        String keyspaceName = "cataloguemanagementsystem";
        String columnFamilyName = "listings";
        createColumnFamily(keyspaceName,columnFamilyName);
        Connector.close();

    }

    public static void createColumnFamily(String keyspaceName, String columnFamily){
        //building the query to create a column family
        Session sessions = Connector.getSession();
        System.out.println("logged keyspace: " + sessions.getLoggedKeyspace());

        //change keyspace
        String changeKeySpaceeQuery = "USE " + keyspaceName;
        //execute the command
        sessions.execute(changeKeySpaceeQuery);
        //pring current keyspace
        System.out.println("loggedKeySpace: " + sessions.getLoggedKeyspace());

        String query = "CREATE COLUMNFAMILY " +columnFamily+ "("+
                "listingId varchar,"+
                "sellerId Varchar,"+
                "skuId varchar,"+
                "productId varchar,"+
                "mrp int,"+
                "ssp int,"+
                "sla int,"+
                "stock int,"+
                "title text,"+
                "PRIMARY KEY (productId, listingId));";
        System.out.println(query);

        //execute the query
        sessions.execute(query);
    }

}
