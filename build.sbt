name := """play-java"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.11"

libraryDependencies += javaJdbc
libraryDependencies += cache
libraryDependencies += javaWs
libraryDependencies += javaJpa.exclude("org.hibernate.javax.persistence", "hibernate-jpa-2.0-api")

libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.36"

libraryDependencies += "org.hibernate" % "hibernate-entitymanager" % "4.3.0.Final"

routesGenerator := InjectedRoutesGenerator