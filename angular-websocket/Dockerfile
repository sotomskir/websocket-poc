FROM node:8-alpine as builder
WORKDIR /build
COPY package.json yarn.lock /build/
RUN yarn install
COPY . /build/
RUN node_modules/.bin/ng build --prod --build-optimizer

FROM nginx:alpine
COPY nginx/default.conf /etc/nginx/conf.d/
RUN rm -rf /usr/share/nginx/html/*
COPY --from=builder /build/dist /usr/share/nginx/html
CMD ["nginx", "-g", "daemon off;"]
