docker pull kolegran/smart-cupboard-backend

docker rm -f smart-cupboard-pg smart-cupboard-backend
docker network remove smart-cupboard-net

docker network create smart-cupboard-net

docker run -it -p 1883:1883 -p 9001:9001 --name=mosquitto-broker --network smart-cupboard-net toke/mosquitto

docker run -d -v /root/data-smart-cupboard:/var/lib/postgresql/data -p 5435:5432 -e POSTGRES_DB=smart-cupboard --network smart-cupboard-net --name smart-cupboard-pg postgres
docker run -d --network smart-cupboard-net -p 8080:8080 -e DB_HOST=smart-cupboard-pg -e DB_PORT=5432 -e MQTT_HOST=mosquitto-broker -e MQTT_PORT=1883 --name smart-cupboard-backend kolegran/smart-cupboard-backend:latest