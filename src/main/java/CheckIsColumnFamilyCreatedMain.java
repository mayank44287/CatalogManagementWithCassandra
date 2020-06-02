import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.KeyspaceMetadata;
import com.datastax.driver.core.Session;
import persistence.Connector;

import java.util.List;

/**
 * checks if column family exists
 */

public class CheckIsColumnFamilyCreatedMain {
    public static void main(String[] args) {

        String keyspaceName = "cataloguemanagementsystem";
        String columnFamilyName = "listings";
        checkIfColumnFamilyCreated(keyspaceName, columnFamilyName);

        Connector.close();
        System.out.println("Closing the connection");
    }

    public static void checkIfColumnFamilyCreated(String keyspace, String cfName){
        //get session
        Session session = Connector.getSession();
        // get cluster
        Cluster cluster = session.getCluster();
        // get all keyspaces in cluster
        List<KeyspaceMetadata> keyspaceMetadatas = cluster.getMetadata().getKeyspaces();
        if(keyspaceMetadatas != null ){
            // iterate over keyspaces
            for(KeyspaceMetadata keyspaceMetadata : keyspaceMetadatas){
                if(keyspace.equals(keyspaceMetadata.getName())) {
                    if (keyspaceMetadata.getTable(cfName) != null) {
                        System.out.println("Column Family :"+cfName + " exists in keyspace :"+keyspace);
                        return;
                    }
                }

            }
        }
        System.out.println("Column Family :"+cfName + " doesnt exist");;
    }

}
