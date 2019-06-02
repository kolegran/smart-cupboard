docker pull kolegran/smart-cupboard-backend
docker pull kolegran/smart-cupboard-front-end

docker rm -f smart-cupboard-pg smart-cupboard-backend smart-cupboard-front-end mosquitto-broker
docker network remove smart-cupboard-net

docker network create smart-cupboard-net

docker run -d -v /root/data-smart-cupboard:/var/lib/postgresql/data -p 5435:5432 -e POSTGRES_DB=smart-cupboard --network smart-cupboard-net --name smart-cupboard-pg postgres
docker run -d --network smart-cupboard-net -p 8080:8080 -e DB_HOST=smart-cupboard-pg -e DB_PORT=5432 -e MQTT_HOST=mosquitto-broker -e MQTT_PORT=1883 --name smart-cupboard-backend kolegran/smart-cupboard-backend:latest

docker run -d --network smart-cupboard-net -e "VIRTUAL_HOST=smart-cupboard.kolegran.com" -e "LETSENCRYPT_HOST=smart-cupboard.kolegran.com" --name smart-cupboard-front-end kolegran/smart-cupboard-front-end
docker run -d --network smart-cupboard-net -p 80:80 -p 443:443 -v /root/nginx/certs:/etc/nginx/certs -v /root/nginx/vhost.d:/etc/nginx/vhost.d -v /usr/share/nginx/html -v /var/run/docker.sock:/tmp/docker.sock:ro --name nginx-proxy jwilder/nginx-proxy
docker run -d --network smart-cupboard-net --volumes-from nginx-proxy -v /var/run/docker.sock:/var/run/docker.sock:ro --name nginx-proxy-letsencrypt jrcs/letsencrypt-nginx-proxy-companion

docker run -it -p 1883:1883 -p 9001:9001 --name=mosquitto-broker --network smart-cupboard-net toke/mosquitto
