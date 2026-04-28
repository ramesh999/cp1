
To Build and Run

mvn clean package -DskipTests

docker build -t cp1-app:latest .

docker run -p 8080:8080 cp1-app:latest