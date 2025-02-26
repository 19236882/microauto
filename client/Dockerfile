FROM maven:3.8.4-openjdk-17 AS builder

# Copie du fichier pom.xml et téléchargement des dépendances pour éviter de télécharger à chaque modification du code
COPY pom.xml /app/
WORKDIR /app
RUN mvn dependency:go-offline

# Copie du code source et construction du jar
COPY src /app/src
RUN mvn clean package -DskipTests

# Crée une image finale plus légère avec OpenJDK
FROM openjdk:17-jdk-slim

# Copie du jar construit
COPY --from=builder /app/target/client-0.0.1-SNAPSHOT.jar app.jar

# Commande d'exécution
ENTRYPOINT ["java", "-jar", "app.jar"]


