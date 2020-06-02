package persistence;

import com.datastax.driver.core.*;

public class Connector {

    private static String host = "localhost";
    private static int port = 9042;
    private static String clusterName = "easybuy";
    private static int MAX_CONNECTIONS = 100;
    private static int CORE_CONNECTIONS = 25;

    private static Cluster cluster;
    private static Session session;


    /**
     * returns singleton session object
     */

    public static Session getSession(){
        //configuring the connection pool
        PoolingOptions poolingOptions = new PoolingOptions();
        //number of maximum connections
        poolingOptions.setMaxConnectionsPerHost(HostDistance.LOCAL, MAX_CONNECTIONS);
        //number of minimum connections that this host will be allotted
        poolingOptions.setCoreConnectionsPerHost(HostDistance.LOCAL, CORE_CONNECTIONS);

        cluster = Cluster.builder().
                addContactPoint(host).
                withPort(port).
                withPoolingOptions(poolingOptions).
                withClusterName(clusterName).
                build();

        final Metadata metadata = cluster.getMetadata();
        System.out.println("connected to cluster: " + metadata.getClusterName());
        session = cluster.connect();

        return session;
    }

    public static void close(){cluster.close();}

    private static void printHostNames(Metadata metadata){
        for (final Host host : metadata.getAllHosts()){
            System.out.println("Datacenter: "+ host.getDatacenter() + "host: " + host.getAddress() + "rack: " + host.getRack());

        }
    }
}
