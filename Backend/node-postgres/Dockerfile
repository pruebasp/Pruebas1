FROM ubuntu
WORKDIR /app
RUN apt-get update
RUN apt-get install nodejs -y
RUN apt-get install npm -y

COPY src/ src/
COPY config/ config/
COPY package.json package.json

RUN npm install
ENTRYPOINT ["node","src/index.js"]