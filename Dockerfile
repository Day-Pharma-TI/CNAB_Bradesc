FROM eclipse-temurin:17-jdk

# Instala bibliotecas nativas necessárias para AWT/Swing
RUN apt-get update && apt-get install -y libxext6 libxrender1 libxtst6 libxi6 && rm -rf /var/lib/apt/lists/*

# Define a pasta de trabalho dentro do container
WORKDIR /app

# Copia o arquivo .jar gerado pelo build
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

# Expõe a porta que a API vai rodar
EXPOSE 8080

# Garante que o Java rode em modo headless
CMD ["java", "-Djava.awt.headless=true", "-jar", "app.jar"]
