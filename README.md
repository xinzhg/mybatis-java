mybatis-java {#welcome}
=====================
Please install **Gradlet** first, and add **GRADLE_HOME/bin** to your **PATH** environment variable.

> *Offical Gradle UserGuide* : **http://www.gradle.org/docs/1.7/userguide/installation.html**

----------

Documents
---------

#### <i class="icon-file"></i> 0_initProject.bat

This script will generates files that are used by the Eclipse IDE, thus making it possible to import the project into Eclipse (File - Import... - Existing Projects into Workspace)

#### <i class="icon-file"></i> 1_codegen.bat

This script will call the gradle task to generate mybatis mapper and model from database.
Code generation configuration is src/resources/ant_mybatisConfig.xml, you can configure your database connections and mapping table in here.