# Building JanusGraph

要求:

* Java 8
* Maven 3

不执行测试进行构建:

```
mvn clean install -DskipTests=true
```

使用默认测试构建:

```
mvn clean install
```

使用默认加上TinkerPop测试构建:

```
mvn clean install -Dtest.skip.tp=false
```

只使用TinkerPop测试来构建:

```
mvn clean install -Dtest.skip.tp=false -DskipTests=true
```

建立分发包:

```
mvn clean install -Pjanusgraph-release -Dgpg.skip=true -DskipTests=true
```

这个命令生成分发包到 `janusgraph-dist/target/janusgraph-$VERSION.zip`.
详情请参阅 [here](janusgraph-dist/README.md#building-zip-archives)

## 为JanusGraph Server构建Docker镜像

我们将Docker构建移会主仓库, 参见 `janusgraph-dist/docker`. 你可以使用default命令来构建分发归档文件,也可以构建Docker镜像.

```
mvn clean install -Pjanusgraph-release -Dgpg.skip=true -DskipTests=true
```

## Building on Eclipse IDE

注意，这只是经过测试在 Eclipse Neon.2 Release (4.6.2) 与 m2e (1.7.0.20160603-1933) 并且 m2e-wtp (1.3.1.20160831-1005) plugin.

不执行测试进行构建:

1. 右键单击你的项目 -> "Run As..." -> "Run Configurations..."
2. 在 "Goals", 使用 `install` 填充
3. 选择选项 `Update Snapshots` 和 `Skip Tests`
4. 点击 "Run" 之前, 确保 Eclipse 知道 `JAVA_HOME` 在哪里. 在同一窗口, 转到 "Environment" 选项并点击 "New".
5. 在"Name:"下, 添加 `JAVA_HOME`.
6. 在"Value:"下, 添加 `java`所在路径.
7. 点击 "OK"
8. 然后点击 "Run"

要在你的环境中查找Java二进制文件,根据操作系统运行相应命令:

* Linux/macOS: `which java`
* Windows: `for %i in (java.exe) do @echo. %~$PATH:i`

## Building documentation

### 更新文档

您可以检查实际版本的配置参考.因此,你必须运行以下命令:

```bash
mvn --quiet clean install -DskipTests=true -pl janusgraph-doc -am
```

### 构建文档所需的依赖项

MkDocs 需要安装,以便在本地构建和提供文档.

1. 安装`python3` 和 `pip3` (最新版本的pip)
   * 也可以查看安装指南 [material-mkdocs](https://squidfunk.github.io/mkdocs-material/getting-started/)
2. 安装要求 `pip3 install -r requirements.txt`

### Build and serve documentation

1. 在本地构建一个测试版本使用命令 `mkdocs build`
2. 要在本地提供文档,请使用命令 `mkdocs serve`
