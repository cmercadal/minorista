# minorista

Esta API Rest está construida con jdk11 y maven3.9.
Para construir en local:
`mvn package`

Para correr los tests:
`mvn test`

Contiene un Jenkinsfile que ejecuta las acciones previas, levanta un reporte en Sonarqube y manda notificaciones a Slack en el canal de #test con los resultados del build.
