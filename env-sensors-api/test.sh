docker-compose down
docker-compose -f docker-compose.test.yml up -d

sleep 3

mvn clean test
docker-compose down
