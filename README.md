[![JanusGraph logo](janusgraph.png)](https://janusgraph.org/)

JanusGraph是一个高度可扩展的[图形数据库](https://en.wikipedia.org/wiki/Graph_database)
优化了存储和查询具有数十亿顶点和边的大型图
分布在多机器集群上。JanusGraph是一个事务性数据库
可以支持数千个并发用户，复杂的遍历和分析性的图查询。

# 版本

[TinkerPop](https://tinkerpop.apache.org/docs/current/upgrade/#_tinkerpop_upgrade_information): 3.7.0

JDK：JAVA 11

Jabusgraph: 1.0.0

# 项目修改点

1、去掉了es 7.17版本以下 **/索引名/_mapping/字段名** 这种设置方式。

2、去掉了es 索引数据时候的 **include_type_name** 参数

3、去掉了es 7.17版本以下的**type**支持。

4、增加了opensearch的支持。

5、停用了编译打包时候，连接Docker创建镜像的功能。

6、连接Cassandra 增加了超时时间。

# 安装

## 1、安装包解压即可。修改配置。

## 2、启动

**如果要再前台运行程序。可以进入目录后执行如下命令：**

```
./bin/janusgraph-server.sh console ./conf/gremlin-server/gremlin-server-cql-es.yaml
```

**janusgraph-server.sh 就是启动 janusgraph的服务，console 就是前台运行，第二个参数就是加载配置文件。**

**如果后台守护进程执行，把console修改为start即可，例子如下：**

```
./bin/janusgraph-server.sh start ./conf/gremlin-server/gremlin-server-cql-opensearch.yaml
```

## 3、启动 gremlin

## 4、连接 janusgraph 服务

```
gremlin> :remote connect tinkerpop.server conf/remote.yaml
9月 19, 2023 2:19:35 下午 org.yaml.snakeyaml.internal.Logger warn
警告: Failed to find field for org.apache.tinkerpop.gremlin.driver.Settings.serializers
14:19:35 INFO  org.apache.tinkerpop.gremlin.driver.Connection.<init> - Created new connection for ws://localhost:8182/gremlin
14:19:35 INFO  org.apache.tinkerpop.gremlin.driver.Connection.<init> - Created new connection for ws://localhost:8182/gremlin
14:19:35 INFO  org.apache.tinkerpop.gremlin.driver.ConnectionPool.<init> - Opening connection pool on Host{address=localhost/127.0.0.1:8182, hostUri=ws://localhost:8182/gremlin} with core size of 2
==>Configured localhost/127.0.0.1:8182
gremlin>
```

**remote.yaml 文件就在conf文件夹下，里边修改指定服务IP即可。如文件里的IP配置为localhost默认启动的是本地模式。**

# 配置

**不同配置找对应的配置文件，都是在 conf/ 目录下。以下配置为索引到Opensearch，存储到Cassandra**

## 1、存储

```
storage.backend=cql
storage.hostname=127.0.0.1
storage.cql.keyspace=sanguo
storage.cql.local-datacenter=datacenter1
```

## 2、索引配置

**X** 为索引名称配置。默认值为**search**

```
index.[X].backend=opensearch
index.[X].hostname=127.0.0.1
index.[X].index-name=sanguosha
```

**这三项必须配置一致。**

# Building JanusGraph

**要求:**

* **Java 8**
* **Maven 3**

**不执行测试进行构建:**

```
mvn clean install -DskipTests=true
```

**使用默认测试构建:**

```
mvn clean install
```

**使用默认加上TinkerPop测试构建:**

```
mvn clean install -Dtest.skip.tp=false
```

**只使用TinkerPop测试来构建:**

```
mvn clean install -Dtest.skip.tp=false -DskipTests=true
```

**建立分发包:**

```
mvn clean install -Pjanusgraph-release -Dgpg.skip=true -DskipTests=true
```

**这个命令生成分发包到 **`janusgraph-dist/target/janusgraph-$VERSION.zip`.**
**详情请参阅 [here](janusgraph-dist/README.md#building-zip-archives)
