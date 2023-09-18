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

3、增加了opensearch的支持。

4、停用了编译打包时候，连接Docker创建镜像的功能。
