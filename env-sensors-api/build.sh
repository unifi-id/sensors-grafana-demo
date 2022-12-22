docker-compose down
docker-compose -f docker-compose.test.yml up -d

sleep 3

mvn clean install -DskipTests
docker-compose down
