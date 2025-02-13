NAME_IMAGE=lab-a01-app-bff-payment
NAME_REPO=williamreges

echo "Docker RUN Local Network HOST"
docker run -p 8100:8100 \
--net=host \
--name ${NAME_REPO}/${NAME_IMAGE} \
--rm ${NAME_REPO}/${NAME_IMAGE}

