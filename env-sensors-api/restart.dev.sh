docker-compose down
docker-compose -f docker-compose.dev.yml run -p 5432:5432 -d unifi-env-sensors-db

mvn clean package -DskipTests
docker-compose down

sudo chown -R $USER docker
docker-compose -f docker-compose.dev.yml up -d --build --force-recreate
#docker-compose up -d --build --force-recreate

docker logs unifi-env-sensors-api -f
