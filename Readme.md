## Catalog Management System using Cassandra

## Introduction
This project is basically an attempt to implement a catalog management system based on Cassandra, as the database.
I have tried to apply my learnings in Cassandra into a live project which is implemented on Java 8. 


The project is divided into three modules:
- Product - It contains catalog attributes of product.
- Listings - It contains the pricing and stock details of the products sold by seller.
A seller may sell multiple products and multiple products may be sold by a seller.
- Persistence - It contains the connector to connect to the cassandra cluster to perform operations

This project is a Maven based module. To interact with cassandra , I usedthe datastax cassandra-driver.
All cql methods have a corresponding method in java-driver.

You can use Cassandra Cluster Manager to manage your clusters. The cluster needs to be up before this code can be run.

You can use Homebrew or pip to install ccm.

Some basic ccm commands:
- To create network interface alias on loopback nodes for MACos
  - sudo ifconfig lo0 alias 127.0.0.*
- to create a cluster with passwordAuthentication and 5 nodes 
  - ccm create "ClusterName" -v "version of Cassandra" -n 5 -s —pwd-auth 
    - n -> number of nodes in the cluster
    - you can create the cluster even without authentication credentials, just avoid the -s flag
    
- To start cluster
    - ccm start
- To list all clusters
    - ccm list

- To display the status of the nodes in cluster
    - ccm status

- To stop the cluster
    - ccm stop

- To display information of node node 1 in the cluster
    - ccm node1 show

- To remove the cluster
    - ccm remove
    
    



