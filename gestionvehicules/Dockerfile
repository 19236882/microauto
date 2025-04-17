
FROM maven:3.8.4-openjdk-17

# Copie du jar construit
COPY  target/gestionvehicules-0.0.1-SNAPSHOT.jar app.jar

# Commande d'exécution
ENTRYPOINT ["java", "-jar", "app.jar"]
