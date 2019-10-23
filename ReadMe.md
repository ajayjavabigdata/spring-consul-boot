This is a Spring boot application having consul for reading and storing the configuration.
It gives you feature to refresh properties with new value without restaring application.
You can configure refresh dealy time 


Install Consul::
Go to https://www.consul.io/downloads.html and for windows 64 version select  windows 64 and download it.
unzip the downloaded software to a folder
go to the folder using cmd and cd command 
and run the below commands for consul agenet

consul agent -server -bootstrap-expect=1 -data-dir=consul-data -ui -bind=127.0.0.1

Verify this by ui http://localhost:8500/ui/

open new command prompt from same path

consul kv put config/spring-consul-boot/testkey testvalue

Save the below as a json file e.g. kv.json
[
  {
    "key": "config/spring-consul-boot/testkey",
    "value": "dGVzdFZhbHVl"
  },
  {
    "key": "config/testApplication/testkey2",
    "value": "dGVzdFZhbHVls"
  }
]

consul kv import @{cosul local directory path}\kv.json

create a yml file spring-boot-consul.yml as below 

spring:
  application:
    name: spring-boot-consul
test:
  host: 127.0.0.1:9042,127.0.0.2:9042
  user: my_user
  password: my_pass
  pooling:
    maxThread: 10
    timeout: 50
  keyspace:
    name: test_keyspace
    readConsistency: ONE
    writeConsistency: ONE



consul kv put config/spring-consul-boot/data @spring-boot-consul.yml

Run the spring boot application

Program OutPut log::

** test.host: 127.0.0.1:9042,127.0.0.2:9042
** test.user: my_user
** test.password: my_pass

go to UI
http://localhost:8500/ui/ and check key value


change pssword to my_pass1 and run the below commmand again

consul kv put config/spring-consul-boot/data @spring-boot-consul.yml 

check application log to see the refresh  event for the property update

Program OutPut log::

2019-10-23 13:09:19.390  INFO 16072 --- [TaskScheduler-1] o.s.c.e.event.RefreshEventListener       : Refresh keys changed: [test.password]

