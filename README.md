# redis-connect-gemfire-function
Gemfire function for initial/batch load of Redis Connect Gemfire connector.

## Getting Started

### Requirements

* Java 11
* Maven 3

### Building the Project

Build the entire project using the maven package command.

````bash
~/redis-connect-gemfire-function$ mvn clean package
````

## Deploy

Deploy the generated gemfire function jar artifact e.g.

```bash
~/pivotal-gemfire-9.15.1/bin$ ./gfsh
    _________________________     __
   / _____/ ______/ ______/ /____/ /
  / /  __/ /___  /_____  / _____  /
 / /__/ / ____/  _____/ / /    / /
/______/_/      /______/_/    /_/    9.15.1

Monitor and Manage VMware Tanzu GemFire
gfsh>version
9.15.1


gfsh>deploy --jar=./redis-connect-gemfire-function-0.10.2.jar

Deploying files: redis-connect-gemfire-function-0.10.2.jar
Total file size is: 0.00MB

Continue?  (Y/n): Y
Member  |                    JAR                    | JAR Location
------- | ----------------------------------------- | --------------------------------------------------------------------------------------------------
server1 | redis-connect-gemfire-function-0.10.2.jar | /home/virag/gemfire/vmware-gemfire-9.15.1/bin/server1/redis-connect-gemfire-function-0.10.2.v1.jar
server2 | redis-connect-gemfire-function-0.10.2.jar | /home/virag/gemfire/vmware-gemfire-9.15.1/bin/server2/redis-connect-gemfire-function-0.10.2.v1.jar

gfsh>list deployed
Member  |                    JAR                    | JAR Location
------- | ----------------------------------------- | --------------------------------------------------------------------------------------------------
server1 | redis-connect-gemfire-function-0.10.2.jar | /home/virag/gemfire/vmware-gemfire-9.15.1/bin/server1/redis-connect-gemfire-function-0.10.2.v1.jar
server2 | redis-connect-gemfire-function-0.10.2.jar | /home/virag/gemfire/vmware-gemfire-9.15.1/bin/server2/redis-connect-gemfire-function-0.10.2.v1.jar

gfsh>list functions
Member  | Function
------- | -------------------
server1 | redis-connect-query
server2 | redis-connect-query
```