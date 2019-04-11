docker rm -f smart-cupboard-pg smart-cupboard-backend
docker network remove smart-cupboard-net

docker network create smart-cupboard-net

docker pull smart-cupboard-backend

docker run -d -v /root/data-smart-cupboard:/var/lib/postgresql/data -p 5435:5432 -e POSTGRES_DB=smart-cupboard --network smart-cupboard-net --name smart-cupboard-pg postgres
docker run -d --network smart-cupboard-net -p 8080:8080 -e DB_HOST=smart-cupboard-pg -e DB_PORT=5432 --name smart-cupboard-backend kolegran/smart-cupboard-backend:latest