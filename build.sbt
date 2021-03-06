name := "emailcheckerweb"

version := "1.0"

lazy val `emailcheckerweb` = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq( jdbc , anorm , cache , ws,
  "dnsjava" % "dnsjava" % "2.1.6",
  "it.alese" %% "email-checker" % "0.2"
)

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )

packageArchetype.java_application
