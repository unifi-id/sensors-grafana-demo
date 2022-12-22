FROM nginx:1.23.0-alpine

WORKDIR /usr/src/app
COPY docker/nginx/nginx.conf /etc/nginx/nginx.conf
COPY dist /usr/share/nginx/html
