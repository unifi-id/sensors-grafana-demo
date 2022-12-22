#!/bin/bash
chmod +x build.sh
./build.sh

docker-compose down

sudo chown -R "$USER" docker
docker-compose up -d --build --force-recreate
